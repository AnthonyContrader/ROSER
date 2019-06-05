package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Robot;
import it.contrader.model.Users;

public class DoctorDAO {

	private final String QUERY_ALL = "select * from users WHERE user_type='user'";
	private final String QUERY_ALL_ROBOT = "select * from users WHERE user_type='robot'";
	private final String QUERY_INSERT = "insert into users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id=?";
    private final String QUERY_UPDATE = "UPDATE users SET user_name=? , user_surname=?, user_user=? , user_pass=?, user_type=?, user_state=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from users where user_id=?";
	private final String QUERY_LOGIN = "select * from users where user_user=? and user_pass=?";
	private final String QUERY_MATCH = "UPDATE robot SET robot_owner_name = ?, robot_owner_surname = ? WHERE robot_model = ?";

	public DoctorDAO() {}

	public Users login(String username, String password) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		Users user = null;
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
				
				user = new Users(userId,userName,usertype, name, surname, passWord, state);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<Users> getAllPatient() {
		final List<Users> userList = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String password = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				userList.add(new Users(userId,name,surname,username,password,usertype,state));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public boolean insertPatient(Users user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUserType());
			preparedStatement.setBoolean(6, user.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Users readPatient(int patientId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, patientId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String username = resultSet.getString("user_user");
			String usertype = resultSet.getString("user_type");
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");

			Users user= new Users(patientId, username, usertype, name, surname, password, state);
			return user;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updatePatient(Users userToUpdate) {
		Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();
		if (userToUpdate.getUserId() == 0)
			return false;

		Users userRead = readPatient(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getName() == null || userToUpdate.getName().equals("")) 
					userToUpdate.setName(userRead.getName());
				
				if (userToUpdate.getSurname() == null || userToUpdate.getSurname().equals("")) 
					userToUpdate.setSurname(userRead.getSurname());
				
				if (userToUpdate.getUserName() == null ||userToUpdate.getUserName().equals("")) 
					userToUpdate.setUserName(userRead.getUserName());
				
				if (userToUpdate.getPassword() == null || userToUpdate.getPassword().equals("")) 
					userToUpdate.setPassword(userRead.getPassword());
				
				if (userToUpdate.getUserType() == null || userToUpdate.getUserType().equals("")) 
					userToUpdate.setUserType(userRead.getUserType());
				//if (userToUpdate.isUserState() == false) 
					//userToUpdate.setUserState(userRead.isUserState());
						
					
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
		
					
				preparedStatement.setString(1, userToUpdate.getName());
				preparedStatement.setString(2, userToUpdate.getSurname());
				preparedStatement.setString(3, userToUpdate.getUserName());
				preparedStatement.setString(4, userToUpdate.getPassword());
				preparedStatement.setString(5, userToUpdate.getUserType());
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

	public boolean deletePatient(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, userId);
			int n = preparedStatement.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Robot> getAllRobot(){
		
		final List<Robot> robot = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();
		
		
		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(QUERY_ALL_ROBOT);
			while (resultSet.next()){
				int robotId = resultSet.getInt("robot_id");
				String model = resultSet.getString("robot_model");
				String ownerName = resultSet.getString("robot_owenr_name");
				String ownerSurname = resultSet.getString("rovot_owner_surname");
				String userName = resultSet.getString("robot_user");
				String password = resultSet.getString("robot_password");
				robot.add(new Robot(robotId,model,ownerName,ownerSurname,userName,password));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return robot;
	}
	
	public boolean matchRobot(Users user, Robot robot){
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement statement = connection.prepareStatement(QUERY_MATCH);
			//UPDATE robot SET robot_owner_name = ?, robot_owner_surname = ? WHERE robot_model = ?
			statement.setString(1,user.getName());
			statement.setString(2, user.getSurname());
			statement.setString(3, robot.getRobotModel());
			
			int a = statement.executeUpdate();
			
			if (a > 0) {
				return true;
			}
			else {
				connection.close();
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean disMatchRobot(Robot robot){
		final Connection connection = ConnectionSingleton.getInstance();
		try {
			final PreparedStatement statement = connection.prepareStatement(QUERY_MATCH);
			//UPDATE robot SET robot_owner_name = ?, robot_owner_surname = ? WHERE robot_model = ?
			statement.setString(1,"");
			statement.setString(2,"");
			statement.setString(3, robot.getRobotModel());
			
			int a = statement.executeUpdate();
			
			if (a > 0) {
				return true;
			}
			else {
				connection.close();
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
	
