package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class UsersDAO {
	private final String GET_ALL = "select * from users";
	private final String QUERY_INSERT = "INSERT INTO users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE id = ?";
	private final String QUERY_UPDATE = "UPDATE users SET user_name = ?, user_surname = ?, user_user = ?, user_pass = ?, user_type = ?, user_state = ? WHERE id = ?";
	private final String QUERY_LOGIN = "SELECT * FROM users WHERE user_user=?";
	
	public Users login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		Users utente = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(0, username);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.getString("password").equals(password)) {
				resultSet.next();
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

	public List<Users> getAllUsers() {

		final List<Users> users = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_user");
				String userType = resultSet.getString("user_type");
				String user = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String pass = resultSet.getString("user_pass");
				boolean userState = resultSet.getBoolean("user_state");
				users.add(new Users(userId, userName, userType, name, surname, pass, userState));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	// Inserimento

	public boolean insertUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getSurname());
			preparedStatement.setString(3, users.getUserName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getUserType());
			preparedStatement.setBoolean(6, users.isUserState());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella una chat
	public boolean deleteUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, users.getUserId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// Modifica Chat

	public boolean updateUsers(Users users) {
		//UPDATE users SET user_type = ?, user_state = ? WHERE id = ?
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, users.getName());
			preparedStatement.setString(2, users.getSurname());
			preparedStatement.setString(3, users.getUserName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getUserType());
			preparedStatement.setBoolean(6, users.isUserState());
			preparedStatement.setInt(7, users.getUserId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
}
