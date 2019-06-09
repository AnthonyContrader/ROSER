package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Robot;
import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class RobotDAO {
	private final String GET_ALL_ROBOT = "SELECT * FROM robot";
	private final String GET_ALL_USER = "SELECT * FROM users WHERE user_type = 'robot'";
	private final String QUERY_LOGIN = "SELECT * FROM users WHERE user_user=? AND user_pass=?";
	private final String QUERY_INSERT_USER = "INSERT INTO users (user_name, user_surname,user_user,user_pass,user_type,user_state) VALUE (?,?,?,?,?,?)"; 
	private final String QUERY_INSERT_ROBOT = "INSERT INTO robot (robot_model, robot_owner_name, robot_owner_surname) VALUE (?,?,?)";
	private final String QUERY_DELETE_USER = "DELETE FROM users WHERE user_user=?";
	private final String QUERY_DELETE_ROBOT = "DELETE FROM robot WHERE robot_model=?";
	private final String QUERY_READ = "SELECT * FROM users INNER JOIN robot ON user_user = robot_model WHERE robot_model=?";
	private final String QUERY_MATCH ="UPDATE robot SET robot_owner_name=?, robot_owner_surname=? WHERE robot_model=?";
	private final String QUERY_DISMATCH ="UPDATE robot SET robot_owner_name=' ', robot_owner_surname=' ' WHERE robot_model=?";
	
	private final String QUERY_READ_LOG = "SELECT * FROM sensordata WHERE robot_model = ?";
	private final String QUERY_INSERT_LOG = "INSER INTO (robot_model,patient_name,patientsurname,decibel,face_express,humidity,data_date) VALUE (?,?,?,?,?,?,?)";
	
	public List<Robot> getAllRobot() {

		final List<Robot> robotList = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL_ROBOT);
			
			final Statement statementDue = connection.createStatement();
			final ResultSet resultSetDue = statementDue.executeQuery(GET_ALL_USER);
			Robot robot = null;
			while (resultSet.next()) {
				resultSetDue.next();
				String robotName = resultSetDue.getString("user_name");
				String robotSurname = resultSetDue.getString("user_surname");
				String robotPassword = resultSetDue.getString("user_pass");
				String robotModel = resultSet.getString("robot_model");
				String robotOwnerSurname = resultSet.getString("robot_owner_surname");
				String robotOwnerName = resultSet.getString("robot_owner_name");
				int robotId = resultSet.getInt("robot_id");
				robot = new Robot(robotId,robotName, robotSurname, robotPassword, robotModel, robotOwnerName, robotOwnerSurname);
				robotList.add(robot);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return robotList;
	}
	
	public boolean insertRobot(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_USER);
			preparedStatement.setString(1, robot.getRobotName());
			preparedStatement.setString(2, robot.getRobotSurname());
			preparedStatement.setString(3, robot.getRobotModel());
			preparedStatement.setString(4, robot.getPassword());
			preparedStatement.setString(5, "robot");
			preparedStatement.setBoolean(6, true);
			preparedStatement.execute();
			
			
			//robot_model, robot_owner_name, robot_owner_surname) VALUE (?,?,?)
			preparedStatement = connection.prepareStatement(QUERY_INSERT_ROBOT);
			preparedStatement.setString(1, robot.getRobotModel());
			preparedStatement.setString(2, robot.getRobotOwnerName());
			preparedStatement.setString(3, robot.getRobotSurname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}	
	
	public boolean deleteRobot(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_USER);
			preparedStatement.setString(1, robot.getRobotModel());
			preparedStatement.execute();
			
			preparedStatement = connection.prepareStatement(QUERY_DELETE_ROBOT);
			preparedStatement.setString(1, robot.getRobotModel());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
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

	public Robot readRobot(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Robot robotRead= null;
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setString(1, robot.getRobotModel());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int robotId = resultSet.getInt("robot_id");
			String robotName = resultSet.getString("user_name");
			String robotSurname = resultSet.getString("user_surname");
			String robotPassword = resultSet.getString("user_pass");
			String robotModel = resultSet.getString("robot_model");
			String robotOwnerName = resultSet.getString("robot_owner_name");
			String robotOwnerSurname = resultSet.getString("robot_owner_surname");
			robotRead = new Robot(robotId, robotName, robotSurname, robotPassword, robotModel,robotOwnerName,robotOwnerSurname);
			return robotRead;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean matchUsers(Users user, Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_MATCH);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserSurname());
			preparedStatement.setString(3, robot.getRobotModel());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean disMatchUsers(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DISMATCH);
			preparedStatement.setString(1, robot.getRobotModel());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public Robot readRobot(String robotModel) {
		//SELECT * FROM users INNER JOIN robot ON user_user = robot_model WHERE robot_model=?
		Robot robotRead = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setString(1, robotModel);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			//String robotOwnerName, String robotOwnerSurname
			
			String robotName = resultSet.getString("user_name");
			String robotSurname = resultSet.getString("user_surname");
			String robotPassword = resultSet.getString("user_pass");
			String robotModelRead = resultSet.getString("robot_model");
			String robotOnwerName = resultSet.getString("robot_owner_name");
			String robotOwnerSurname = resultSet.getString("robot_owner_surname");
			
			robotRead = new Robot(robotName, robotSurname, robotPassword, robotModelRead, robotOnwerName,robotOwnerSurname);
			
			return robotRead;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public Robot readlog(Robot robot, String data) {
		Robot robotWithData = robot;
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_LOG);
			preparedStatement.setString(1, robot.getRobotModel());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			robotWithData.setDecibel(Integer.parseInt(resultSet.getString("deciblel")));
			robotWithData.setFaceexpress(Integer.parseInt(resultSet.getString("deciblel")));
			robotWithData.setHumidity(Integer.parseInt(resultSet.getString("deciblel")));
			robotWithData.setData(data);
			
			return robotWithData;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public boolean insertData(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_LOG);
			preparedStatement.setString(1, robot.getRobotModel());
			preparedStatement.setString(2, robot.getRobotOwnerName());
			preparedStatement.setString(3, robot.getRobotOwnerSurname());
			preparedStatement.setString(4, Integer.toString(robot.getDecibel()));
			preparedStatement.setString(5, Integer.toString(robot.getFaceexpress()));
			preparedStatement.setString(6, Integer.toString(robot.getHumidity()));
			preparedStatement.setString(7, robot.getData());
			
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
