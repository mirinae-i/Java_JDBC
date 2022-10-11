package com.mirinae.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Connect implements Connectable {

	@Override
	public void checkConn() {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection conn = DriverManager.getConnection(DB_URL, ID, PW)) {
				System.out.println("Connection Successful");
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void select() {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection conn = DriverManager.getConnection(DB_URL, ID, PW)) {
				final String SQL_QUERY = "SELECT * FROM member";
				PreparedStatement ps = conn.prepareStatement(SQL_QUERY);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String uid = rs.getString("uid");
					String name = rs.getString("name");
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					System.out.println("UID : " + uid + ", Name : " + name + ", ID : " + id + ", PW : " + pw);
				}
				if (rs != null) {					
					rs.close();
				}
				if (ps != null) {					
					ps.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(String name, String id, String pw) {
		try {
			Class.forName(JDBC_DRIVER);
			try (Connection conn = DriverManager.getConnection(DB_URL, ID, PW)) {
				final String SQL_QUERY = "INSERT INTO member(name, id, pw) VALUES (?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(SQL_QUERY);
				ps.setString(1, name);
				ps.setString(2, id);
				ps.setString(3, pw);
				ps.executeUpdate();
				System.out.println("Insert Successful");
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
}
