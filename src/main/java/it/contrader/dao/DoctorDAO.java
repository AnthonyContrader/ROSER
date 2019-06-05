package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.dto.DoctorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Doctor;
import it.contrader.model.User;

public class DoctorDAO {

	private final String QUERY_ALL = "select * from users where user_type='doctor'";
	private final String QUERY_INSERT = "insert into users (user_name, user_surname, user_user, user_pass, user_type, user_state) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id=?";
    private final String QUERY_UPDATE = "UPDATE users SET user_name=? , user_surname=?, user_user=? , user_pass=?, user_type=?, user_state=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from users where user_id=?";
	private final String QUERY_LOGIN = "select * from users where user_user=? and user_pass=?";

	public DoctorDAO() {}

	public Doctor login(String username, String password) 
	{
		
		// User( int userId , String username, String usertype , String name , String surname ,String password , boolean userState)

		Connection connection = ConnectionSingleton.getInstance();
		Doctor doctor = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();
			
			while (resultSet.next()) {
				int doctorId = resultSet.getInt("doctor_id");
				String userName = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String passWord = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				
				doctor = new Doctor(doctorId,userName,usertype, name, surname, passWord, state);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(user.toString());
		return doctor;
	}
	
	public List<DoctorDTO> getAllDoctor() {
		List<DoctorDTO> doctorList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			DoctorDTO doctor;
			while (resultSet.next()) {
				int doctorId = resultSet.getInt("doctor_id");
				String username = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String password = resultSet.getString("user_pass");
				boolean state = resultSet.getBoolean("user_state");
				//if(!state) {
				//String name,String surname,String username,String password,String usertype,boolean userState
					//user = new User(userId,username,usertype, name, surname, password, state);
				doctor = new DoctorDTO(name,surname,username,password,usertype,state);
				//}else {
					//user = new User(userId,username,usertype, name, surname, password, true);
			//	}
				doctorList.add(doctor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorList;
	}

	public boolean insertDoctor(Doctor doctor) {
		Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//user_id, user_name, user_surname, user_user, user_pass, user_type, user_state
			preparedStatement.setString(1, doctor.getName());
			preparedStatement.setString(2, doctor.getSurname());
			preparedStatement.setString(3, doctor.getUsername());
			preparedStatement.setString(4, doctor.getPassword());
			preparedStatement.setString(5, doctor.getUsertype());
			preparedStatement.setBoolean(6, doctor.isUserState());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Doctor readDoctor(int doctorId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String username = resultSet.getString("user_user");
			String usertype = resultSet.getString("user_type");
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String password = resultSet.getString("user_pass");
			boolean state = resultSet.getBoolean("user_state");

			Doctor doctor= new Doctor(doctorId, username, usertype, name, surname, password, state);
			return doctor;
		} catch (SQLException e) {
			it.contrader.utils.GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean updateDoctor(Doctor doctorToUpdate) {
		Connection connection = it.contrader.utils.ConnectionSingleton.getInstance();

		// Check if id is present
		if (doctorToUpdate.getDoctorId() == 0)
			return false;

		Doctor doctorRead = readDoctor(doctorToUpdate.getDoctorId());
		if (!doctorRead.equals(doctorToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (doctorToUpdate.getName() == null || doctorToUpdate.getName().equals("")) 
					doctorToUpdate.setName(doctorRead.getName());
				
				if (doctorToUpdate.getSurname() == null || doctorToUpdate.getSurname().equals("")) 
					doctorToUpdate.setSurname(doctorRead.getSurname());
				
				if (doctorToUpdate.getUsername() == null ||doctorToUpdate.getUsername().equals("")) 
					doctorToUpdate.setUsername(doctorRead.getUsername());
				
				if (doctorToUpdate.getPassword() == null || doctorToUpdate.getPassword().equals("")) 
					doctorToUpdate.setPassword(doctorRead.getPassword());
				
				if (doctorToUpdate.getUsertype() == null || doctorToUpdate.getUsertype().equals("")) 
					doctorToUpdate.setUsertype(doctorRead.getUsertype());
				//if (userToUpdate.isUserState() == false) 
					//userToUpdate.setUserState(userRead.isUserState());
						
					
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
		
					
				preparedStatement.setString(1, doctorToUpdate.getName());
				preparedStatement.setString(2, doctorToUpdate.getSurname());
				preparedStatement.setString(3, doctorToUpdate.getUsername());
				preparedStatement.setString(4, doctorToUpdate.getPassword());
				preparedStatement.setString(5, doctorToUpdate.getUsertype());
				preparedStatement.setBoolean(6, doctorToUpdate.isUserState());
				preparedStatement.setInt(7, doctorToUpdate.getDoctorId());
				
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

	public boolean deleteDoctor(int id) {
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
