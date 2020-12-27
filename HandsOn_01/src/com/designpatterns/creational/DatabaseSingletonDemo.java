package com.designpatterns.creational;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSingletonDemo {

	public static void main(String[] args) {

		DatabaseSingleton instance = DatabaseSingleton.getInstance();
		
		Connection conn = instance.getConnection();
		
		Statement st;
		
		try {
			st = conn.createStatement();
			int count = st.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20),"
					+" City VARCHAR(20))");
			System.out.println("Table created.");
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
