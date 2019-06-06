package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Doctor;
import it.contrader.model.Robot;
import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class AdminDAO {
	private final String GET_ALL = "select * from users WHERE user_type = 'doctor'";
	private final String QUERY_ALL_ROBOT = "SELECT * FROM users WHERE user_type = 'robot'";
	private final String QUERY_INSERT = "INSERT INTO users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM users WHERE user_id=?";
	private final String QUERY_DELETE_ROBOT = "DELETE users,robot FROM users INNER JOIN robot ON users.user_user=robot.robot_model WHERE user_user = ? AND robot_model = ?";
	private final String QUERY_UPDATE = "UPDATE users SET user_name = ?, user_surname = ?, user_user = ?, user_pass = ?, user_type = ?, user_state = ? WHERE user_id = ?";
	private final String QUERY_READ = "SELECT * FROM users WHERE user_id = ?";
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

	public List<Doctor> getAllDoctor() {

		final List<Doctor> doctor = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				int doctorId = resultSet.getInt("user_id");
				String userName = resultSet.getString("user_user");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String pass = resultSet.getString("user_pass");
				boolean userState = resultSet.getBoolean("user_state");
				doctor.add(new Doctor(doctorId, userName, "doctor", name, surname, pass, userState));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return doctor;
	}
	
public List<Robot> getAllRobot(){
		
		final List<Robot> robot = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();
		
		
		try {
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(QUERY_ALL_ROBOT);
			while (resultSet.next()){
				int robotId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String password = resultSet.getString("user_pass");
				String type = resultSet.getString("user_type");
				boolean state = resultSet.getBoolean("user_state");
				//int robotId,String name,String surname,String username,String password,boolean state
				robot.add(new Robot(robotId,name,surname,username,password,type,state));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return robot;
	}
	// Inserimento

	public boolean insertDoctor(Doctor doctor) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, doctor.getName());
			preparedStatement.setString(2, doctor.getSurname());
			preparedStatement.setString(3, doctor.getUserName());
			preparedStatement.setString(4, doctor.getPassword());
			preparedStatement.setString(5, doctor.getUserType());
			preparedStatement.setBoolean(6, doctor.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean insertRobot(Robot robot) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, robot.getName());
			preparedStatement.setString(2, robot.getSurname());
			preparedStatement.setString(3, robot.getUsername());
			preparedStatement.setString(4, robot.getPassword());
			preparedStatement.setString(5, robot.getType());
			preparedStatement.setBoolean(6, robot.isState());
			System.out.println(robot.getSurname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella una chat
	public boolean delete(int doctorId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, doctorId);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean deleteRobot(String robotModel) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_ROBOT);
			preparedStatement.setString(1, robotModel);
			preparedStatement.setString(2, robotModel);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	
	public Doctor readDoctor(int doctorId) {
		Doctor doctor = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String userName = resultSet.getString("user_user");
			String type = resultSet.getString("user_type");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");
			doctor = new Doctor(doctorId, userName, type, name, surname, password,state);
			return doctor;
		}catch(SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}
	
	public Robot readRobot(int robotId) {
		Robot robot = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, robotId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String userName = resultSet.getString("user_user");
			String type = resultSet.getString("user_type");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");
			//int robotId,String name,String surname,String username,String password,String type,boolean state
			robot = new Robot(robotId, name,surname,userName,password,type,state);
			return robot;
		}catch(SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	// Modifica Chat

	public boolean updateDoctor(Doctor doctor) {
		//UPDATE users SET user_type = ?, user_state = ? WHERE id = ?
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, doctor.getName());
			preparedStatement.setString(2, doctor.getSurname());
			preparedStatement.setString(3, doctor.getUserName());
			preparedStatement.setString(4, doctor.getPassword());
			preparedStatement.setString(5, doctor.getUserType());
			preparedStatement.setBoolean(6, doctor.isUserState());
			preparedStatement.setInt(7, doctor.getDoctorId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	
	public boolean updateRobot(Robot robot) {
		//UPDATE users SET user_type = ?, user_state = ? WHERE id = ?
		
		System.out.println(robot);
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, robot.getName());
			preparedStatement.setString(2, robot.getSurname());
			preparedStatement.setString(3, robot.getUsername());
			preparedStatement.setString(4, robot.getPassword());
			preparedStatement.setString(5, robot.getType());
			preparedStatement.setBoolean(6, robot.isState());
			preparedStatement.setInt(7, robot.getRobotId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
		
}
