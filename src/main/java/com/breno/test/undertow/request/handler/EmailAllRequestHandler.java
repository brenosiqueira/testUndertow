package com.breno.test.undertow.request.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.breno.test.undertow.db.DatabaseConnection;

public class EmailAllRequestHandler implements HttpHandler {
	
	private final DatabaseConnection databaseConnection = new DatabaseConnection();;

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {

			QueryRunner run = new QueryRunner(databaseConnection.getDataSource());
			JSONArray array = run.query("SELECT id, address FROM email", new ResultSetHandler<JSONArray>(){
					@Override
				public JSONArray handle(ResultSet resultSet) throws SQLException {
					JSONArray array = new JSONArray(); 
					while(resultSet.next()){
						JSONObject row = new JSONObject();
						row.put("id", resultSet.getInt(1));
						row.put("address", resultSet.getString(2));
						array.add(row);
					}
					return array;
				}});

			exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
			exchange.getResponseSender().send(array.toJSONString());
	}

}