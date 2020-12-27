package com.designpatterns.creational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {

	private static volatile DatabaseSingleton instance = null;
	private static volatile Connection conn = null;

	private DatabaseSingleton() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (null != conn) {
			throw new RuntimeException("Use getConnection() method to create.");
		}
		
		if (null != instance) {
			throw new RuntimeException("Use getInstance() method to create.");
		}
	}

	public static DatabaseSingleton getInstance() {
		if (null == instance) {
			synchronized (DatabaseSingleton.class) {
				if (null == instance) {
					instance = new DatabaseSingleton();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		if (null == conn) {
			synchronized (DatabaseSingleton.class) {
				if (null == conn) {
					try {
						String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
						conn = DriverManager.getConnection(dbUrl) ;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}

}
