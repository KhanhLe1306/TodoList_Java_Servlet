package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class DBUtil {
	
	public static List<Todo> getTodos() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Todo> lists = new ArrayList<>();
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Lists";
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();		
			while(rs.next()) {
				String title = rs.getString("title");
				String done = rs.getString("done");
				System.out.println(title + " : " + done);
				lists.add(new Todo(title, done));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return lists;
	}

	public static void insertTodo(String title, String done) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String insertSQL = "insert into Lists values (\"" + title + "\",\"" + done + "\")";
			System.out.println(insertSQL);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
