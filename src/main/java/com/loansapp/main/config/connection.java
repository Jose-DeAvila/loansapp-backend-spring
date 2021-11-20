package com.loansapp.main.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

	static Connection conn;
    public static void main(String[] args) {
    	try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/loansapp?user=root&password=3005560374xD*");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static Connection getConn() {
		return conn;
	}
}
