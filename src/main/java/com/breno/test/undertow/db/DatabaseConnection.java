package com.breno.test.undertow.db;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class DatabaseConnection {

	private final static DataSource dataSource;

	static {
		dataSource = configureDatasource();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	private static DataSource configureDatasource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:jtds:sqlserver://localhost:1433/dbTest;SendStringParametersAsUnicode=false");
		config.setUsername("usrTest");
		config.setPassword("test123");
		config.setMinimumIdle(2);
		config.setMaximumPoolSize(20);
		config.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		config.setConnectionTimeout(30000);
		config.setConnectionTestQuery("SELECT 1");
		config.addDataSourceProperty("cachePrepStmts", "true");

		return new HikariDataSource(config);
	}

}
