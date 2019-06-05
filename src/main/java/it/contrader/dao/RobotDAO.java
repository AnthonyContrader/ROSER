package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.RobotDTO;
import it.contrader.model.Robot;
import it.contrader.utils.ConnectionSingleton;

public class RobotDAO {

	private final String QUERY_ALL = "select * from robot where robot_model='mod1'";
	private final String QUERY_INSERT = "insert into robot (robot_model, robot_username, robot_password, robot_owner_name, robot_owner_surname) values (?,?,?,?,?)";
	private final String QUERY_READ = "select * from robot where robot_id=?";
    private final String QUERY_UPDATE = "UPDATE robot SET robot_model=? , robot_username=?, robot_password=? , robot_owner_name=?, robot_owner_surname=? WHERE robot_id=?";
	private final String QUERY_DELETE = "delete from robot where robot_id=?";
	private final String QUERY_LOGIN = "select * from robot where robot_username=? and robot_password=?";
	
	public RobotDAO() {}
	
	public Robot login(String username, String password) {
		Robot robot=null;
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				int robotId = resultSet.getInt("robot_id");
				String robotModel = resultSet.getString("robot_model");
				String robotUsername = resultSet.getString("robot_username");
				String robotPassword = resultSet.getString("robot_password");
				String ownerName = resultSet.getString("robot_owner_name");
				String ownerSurname = resultSet.getString("robot_owner_surname");
				
				robot = new Robot(robotId,robotModel,robotUsername, robotPassword, ownerName, ownerSurname);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return robot;
	}
	public List<RobotDTO> getAllRobot() {
		List<RobotDTO> robotList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			RobotDTO robot;
			while (resultSet.next()) {
				int robotId = resultSet.getInt("robot_id");
				String robotModel = resultSet.getString("robot_model");
				String robotUsername = resultSet.getString("robot_username");
				String robotPassword = resultSet.getString("robot_password");
				String ownerName = resultSet.getString("robot_owner_name");
				String ownerSurname = resultSet.getString("robot_owner_surname");
				//if(!state) {
				//String name,String surname,String username,String password,String usertype,boolean userState
					//user = new User(userId,username,usertype, name, surname, password, state);
				robot = new RobotDTO(robotId,robotModel,robotUsername, robotPassword, ownerName, ownerSurname);
				//}else {
					//user = new User(userId,username,usertype, name, surname, password, true);
			//	}
				robotList.add(robot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return robotList;
		}

		public boolean insertRobot(Robot robot) {
			Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
				//user_id, user_name, user_surname, user_user, user_pass, user_type, user_state
				preparedStatement.setString(1, robot.getRobot_model());
				preparedStatement.setString(2, robot.getRobot_username());
				preparedStatement.setString(3, robot.getRobot_password());
				preparedStatement.setString(4, robot.getRobot_owner_name());
				preparedStatement.setString(5, robot.getRobot_owner_surname());
				preparedStatement.execute();
				return true;
			} catch (SQLException e) {
				it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}

		}

		public Robot readRobot(int robotId) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
				preparedStatement.setInt(1, robotId);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				
				String robotModel = resultSet.getString("robot_model");
				String robotUsername = resultSet.getString("robot_username");
				String robotPassword = resultSet.getString("robot_password");
				String ownerName = resultSet.getString("robot_owner_name");
				String ownerSurname = resultSet.getString("robot_owner_surname");

				Robot robot = new Robot(robotId, robotModel, robotUsername, robotPassword, ownerName, ownerSurname);
				return robot;
			} catch (SQLException e) {
				it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
				return null;
			}
		}

		public boolean updateRobot(Robot robotToUpdate) {
			Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();

			// Check if id is present
			if (robotToUpdate.getRobot_id() == 0)
				return false;

			Robot robotRead = readRobot(robotToUpdate.getRobot_id());
			if (!robotRead.equals(robotToUpdate)) {
			try {
					// Fill the userToUpdate object
				if (robotToUpdate.getRobot_model() == null || robotToUpdate.getRobot_model().equals("")) 
					robotToUpdate.setRobot_model(robotRead.getRobot_model());
				
				if (robotToUpdate.getRobot_username() == null || robotToUpdate.getRobot_username().equals("")) 
					robotToUpdate.setRobot_username(robotRead.getRobot_username());
					
				if (robotToUpdate.getRobot_password() == null || robotToUpdate.getRobot_password().equals("")) 
					robotToUpdate.setRobot_password(robotRead.getRobot_password());
					
				if (robotToUpdate.getRobot_owner_name() == null || robotToUpdate.getRobot_owner_name().equals("")) 
					robotToUpdate.setRobot_owner_name(robotRead.getRobot_owner_name());
			
				if (robotToUpdate.getRobot_owner_surname() == null || robotToUpdate.getRobot_owner_surname().equals("")) 
					robotToUpdate.setRobot_owner_surname(robotRead.getRobot_owner_surname());
					//if (userToUpdate.isUserState() == false) 
						//userToUpdate.setUserState(userRead.isUserState());
							
						
					// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			
						
				preparedStatement.setString(1, robotToUpdate.getRobot_model());
				preparedStatement.setString(2, robotToUpdate.getRobot_username());
				preparedStatement.setString(3, robotToUpdate.getRobot_password());
				preparedStatement.setString(4, robotToUpdate.getRobot_owner_name());
				preparedStatement.setString(5, robotToUpdate.getRobot_owner_surname());
				preparedStatement.setInt(6, robotToUpdate.getRobot_id());
					
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

	public boolean deleteRobot(int id) {
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
