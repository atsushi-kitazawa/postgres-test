package com.example.jpa.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.rules.ExternalResource;

public class DatabaseResouce extends ExternalResource {

	List<String> tables = new ArrayList<>();
	
	public DatabaseResouce(List<String> tables) {
		this.tables = tables;
	}

	protected void before() throws Exception {
		String URL = "jdbc:postgresql://127.0.0.1:15432/postgres";
		String USER = "postgres";
		String PASS = null;
		String DELETE_SQL = "delete from ";

		PreparedStatement ps = null;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);) {
			for(String table : tables) {
				ps = conn.prepareStatement(DELETE_SQL + table);
				ps.executeUpdate();
			}
		} finally {
			ps.close();
		}
	}

	protected void after() {
	}
}
