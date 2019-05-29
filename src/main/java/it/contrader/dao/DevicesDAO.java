package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Devices;
import it.contrader.model.User;

public class DevicesDAO {
	private final String QUERY_ALL = "select * from devices";
	private final String QUERY_INSERT = "insert into users (model, owner_id) values (?,?)";
	private final String QUERY_READ = "select * from users where dev_id=?";
    private final String QUERY_UPDATE = "UPDATE users SET dev_id=? , model=?, owner_id=? WHERE dev_id=?";
	private final String QUERY_DELETE = "delete from user where dev_id=?";
	
	public List<Devices> getAllDevices() {
		List<Devices> devicesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Devices devices;
			while (resultSet.next()) {
				int devId = resultSet.getInt("dev_id");
				String model = resultSet.getString("model");
				int owner = resultSet.getInt("owner_id");
				devices = new Devices(devId,model,owner);
				devicesList.add(devices);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devicesList;
	}
	
	public boolean insertDevices(Devices devices) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, devices.getModel());
			preparedStatement.setInt(2, devices.getOwner());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	
	public Devices readDevices(int devId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, devId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String model = resultSet.getString("model");
			int owner = resultSet.getInt("owner_id");

			Devices devices = new Devices(devId, model, owner);

			return devices;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}
	
	public boolean updateDevices(Devices devicesToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (devicesToUpdate.getDevId() == 0)
			return false;

		Devices devicesRead = readDevices(devicesToUpdate.getDevId());
		if (!devicesRead.equals(devicesToUpdate)) {
			try {
				// Fill the userToUpdate object
				/*if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}*/
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, devicesToUpdate.getModel());
				preparedStatement.setInt(2, devicesToUpdate.getOwner());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}
	
	public boolean deleteDevices(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
