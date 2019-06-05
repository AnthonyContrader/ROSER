package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;

public class UsersDAO {


	private final String QUERY_LOGIN = "SELECT * FROM users WHERE user_user=?";
	public Users login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		Users utente = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if(resultSet.getString("user_pass").equals(password)) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_user");
				String userType = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String pass = resultSet.getString("user_pass");
				boolean userState = resultSet.getBoolean("user_state");
				utente = new Users(userId, userName, userType, name, surname, pass, userState);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}
}
