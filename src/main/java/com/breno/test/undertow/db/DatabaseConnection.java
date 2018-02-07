package com.breno.test.undertow.db;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class DatabaseConnection {

	private static final DataSource dataSource;

	static {
		dataSource = configureDatasource();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	private static DataSource configureDatasource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(System.getProperty("db.url", "jdbc:jtds:sqlserver://localhost:1433/dbTest;SendStringParametersAsUnicode=false"));
		config.setUsername(System.getProperty("db.user","usrTest"));
		config.setPassword(System.getProperty("db.pass","test123"));
		config.setMinimumIdle(Integer.parseInt(System.getProperty("min.idle", "2")));
		config.setMaximumPoolSize(Integer.parseInt(System.getProperty("max.pool", "20")));
		config.setDriverClassName(System.getProperty("db.driver.class.name","net.sourceforge.jtds.jdbc.Driver"));
		config.setConnectionTimeout(30000);
		config.setConnectionTestQuery(System.getProperty("db.query.verify","SELECT 1"));
		//config.addDataSourceProperty("cachePrepStmts", "true");

		return new HikariDataSource(config);
	}

}
