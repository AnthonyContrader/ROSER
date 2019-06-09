package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import it.contrader.model.Robot;
import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class UsersDAO {
	
	private final String GET_ALL = "select * from users";
	private final String QUERY_INSERT = "INSERT INTO users (user_name, user_surname, user_user, user_pass, user_type, user_state) VALUE (?,?,?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE user_id = ?";
	private final String QUERY_UPDATE = "UPDATE users SET user_name=?, user_surname=?, user_user=?, user_pass=?, user_type=?, user_state=? WHERE user_id=?";
	private final String QUERY_LOGIN = "SELECT * FROM users WHERE user_user=? AND user_pass=?";
	private final String QUERY_READ = "SELECT * FROM users WHERE user_id=?";
	
	public Users login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		Users user = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			resultSet.next();
			user = new Users(resultSet.getInt("user_id"),resultSet.getString("user_name"), resultSet.getString("user_surname"),
					resultSet.getString("user_user"), resultSet.getString("user_pass"), resultSet.getString("user_type"),
					resultSet.getBoolean("user_state"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<Users> getAllUsers() {

		final List<Users> users = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				users.add(new Users(resultSet.getInt("user_id"),resultSet.getString("user_name"), resultSet.getString("user_surname"),
						resultSet.getString("user_user"), resultSet.getString("user_pass"), resultSet.getString("user_type"),
						resultSet.getBoolean("user_state")));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean insertUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, users.getUserName());
			preparedStatement.setString(2, users.getUserSurname());
			preparedStatement.setString(3, users.getUserUser());
			preparedStatement.setString(4, users.getUserPassword());
			preparedStatement.setString(5, users.getUserType());
			preparedStatement.setBoolean(6, users.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

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

	public boolean updateUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, users.getUserName());
			preparedStatement.setString(2, users.getUserSurname());
			preparedStatement.setString(3, users.getUserUser());
			preparedStatement.setString(4, users.getUserPassword());
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
	
	public Users readUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Users userRead= null;
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, users.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			/*
			 * String userSurname, String userUser, String userPassword, String userType, boolean userState*/
			int userId = resultSet.getInt("user_id");
			String userName = resultSet.getString("user_name");
			String userSurname = resultSet.getString("user_surname");
			String userUser = resultSet.getString("user_user");
			String userPassword = resultSet.getString("user_pass");
			String userType = resultSet.getString("user_type");
			boolean userState = resultSet.getBoolean("user_state");
			userRead = new Users(userId,userName,userSurname,userUser,userPassword,userType,userState);
			return userRead;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}
}
