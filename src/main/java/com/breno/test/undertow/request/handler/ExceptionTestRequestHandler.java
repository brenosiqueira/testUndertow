package com.breno.test.undertow.request.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class ExceptionTestRequestHandler implements HttpHandler {
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		throw new Exception("Quero ver se vai cair o processo!");	
	}
}
