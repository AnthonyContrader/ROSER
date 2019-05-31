package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.dto.UserDTO;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Devices;
import it.contrader.model.Doctor;
import it.contrader.model.User;

public class DoctorDAO {
	
	private final String QUERY_ALL = "select * from users WHERE  user_type='user'";
	private final String QUERY_INSERT = "insert into users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id=?";
    private final String QUERY_UPDATE = "UPDATE users SET user_name=? , user_surname=?, user_user=?, user_pass=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from users where user_id=?";
	private final String QUERY_MATCH = " UPDATE devices SET owner_id=? WHERE user_name=?";
	private final String QUERY_DISMATCH = " UPDATE devices SET owner_id=? WHERE dev_id=? ";

	public DoctorDAO() {
		
	}
	
	public List<User> getAllPatient(){
		List<User> userList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int doctorId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String password = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				//if(!state) {
					user = new User (doctorId,username,usertype, name, surname, password, state);
				//}else {
					//user = new User(userId,username,usertype, name, surname, password, true);
			//	}
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return userList;
	}
	public boolean insertUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//user_name, user_surname, user_user, user_pass, user_type, user_state
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUsertype());
			preparedStatement.setBoolean(6, user.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
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
			//int userId = resultSet.getInt("user_id");
			String name = resultSet.getString("user_name");
			String username = resultSet.getString("user_user");
			String usertype = resultSet.getString("user_type");
			String surname = resultSet.getString("user_surname");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");

			User user = new User(userId, username, usertype , name,  surname, password, state);
			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		//"UPDATE users SET user_name=? , user_surname=?, user_user=? WHERE user_id=?"
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
		//"UPDATE users SET user_name=? , user_surname=?, user_user=? WHERE user_id=?"
					
				preparedStatement.setString(1, userToUpdate.getName());
				preparedStatement.setString(2, userToUpdate.getSurname());
				preparedStatement.setString(3, userToUpdate.getUsername());
				preparedStatement.setString(4, userToUpdate.getPassword());
				
				preparedStatement.setInt(5, userToUpdate.getUserId());
				
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
	
	public boolean matchDevices (User user , Devices device) {
		//" UPDATE devices SET owner_id=? WHERE user_name=?"
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_MATCH);
			preparedStatement.setInt(1,user.getUserId());
			preparedStatement.setString(2 , user.getName());
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	public boolean dismatchDevices (Devices device) {
		//" UPDATE devices SET owner_id=? WHERE user_name=?"
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DISMATCH);
			preparedStatement.setInt(1,0);
			preparedStatement.setInt(2 , device.getDevId());
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
