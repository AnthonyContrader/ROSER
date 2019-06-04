package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserDAO {

	private final String QUERY_ALL = "select * from users where user_type='doctor'";
	private final String QUERY_INSERT = "insert into users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id=?";
    private final String QUERY_UPDATE = "UPDATE users SET user_name=? , user_surname=?, user_user=? , user_pass=?, user_type=?, user_state=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from users where user_id=?";
	private final String QUERY_LOGIN = "select * from users where user_user=? and user_pass=?";

	public UserDAO() {}

	public User login(String username, String password) 
	{
		
		// User( int userId , String username, String usertype , String name , String surname ,String password , boolean userState)

		Connection connection = ConnectionSingleton.getInstance();
		User user = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String passWord = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				
				user = new User(userId,userName,usertype, name, surname, passWord, state);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(user.toString());
		return user;
	}
	
	public List<UserDTO> getAllUser() {
		List<UserDTO> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			UserDTO user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String password = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				//if(!state) {
				//String name,String surname,String username,String password,String usertype,boolean userState
					//user = new User(userId,username,usertype, name, surname, password, state);
				user = new UserDTO(name,surname,username,password,usertype,state);
				//}else {
					//user = new User(userId,username,usertype, name, surname, password, true);
			//	}
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insertUser(User user) {
		Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//user_id, user_name, user_surname, user_user, user_pass, user_type, user_state
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUsertype());
			preparedStatement.setBoolean(6, user.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public User readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String username = resultSet.getString("user_user");
			String usertype = resultSet.getString("user_type");
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");

			User user = new User(userId, username, usertype, name, surname, password, state);
			return user;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updateUser(User userToUpdate) {
		Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readUser(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getName() == null || userToUpdate.getName().equals("")) 
					userToUpdate.setName(userRead.getName());
				
				if (userToUpdate.getSurname() == null || userToUpdate.getSurname().equals("")) 
					userToUpdate.setSurname(userRead.getSurname());
				
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) 
					userToUpdate.setUsername(userRead.getUsername());
				
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) 
					userToUpdate.setPassword(userRead.getPassword());
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) 
					userToUpdate.setUsertype(userRead.getUsertype());
				//if (userToUpdate.isUserState() == false) 
					//userToUpdate.setUserState(userRead.isUserState());
						
					
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
		
					
				preparedStatement.setString(1, userToUpdate.getName());
				preparedStatement.setString(2, userToUpdate.getSurname());
				preparedStatement.setString(3, userToUpdate.getUsername());
				preparedStatement.setString(4, userToUpdate.getPassword());
				preparedStatement.setString(5, userToUpdate.getUsertype());
				preparedStatement.setBoolean(6, userToUpdate.isUserState());
				preparedStatement.setInt(7, userToUpdate.getUserId());
				
				System.out.println(preparedStatement);
				
				int a = preparedStatement.executeUpdate();
				
				if (a > 0) {
					return true;
				}
				else {
					connection.close();
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deleteUser(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

