package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		final String URL = "jdbc:postgresql://127.0.0.1:15432/postgres";
		final String USER = "postgres";
		final String PASS = null;
		final String SQL = "select * from test.t1;";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement ps = conn.prepareStatement(SQL)) {

			//ps.setInt(1, 2);
			//ps.setString(2, "tanaka");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					System.out.println(
							rs.getInt("id") + " " + rs.getString("name"));
				}
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("処理が完了しました");
		}
	}
}
