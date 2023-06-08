package com.example.demo.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

public class DataBaseAdapter {

	@Autowired
	Environment env;
	
	protected Connection getJDBConnection() throws SQLException {
		return DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
	}
	
	protected CallableStatement getCallableStatement(Connection connection, String sql) throws SQLException {
		return connection.prepareCall(sql);
	}
	
}
