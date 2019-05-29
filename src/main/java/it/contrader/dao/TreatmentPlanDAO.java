package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.TreatmentPlan;

public class TreatmentPlanDAO {
	private final String QUERY_ALL = "select * from treatment_plan";
	private final String QUERY_INSERT = "insert into treatment_plan (plan_description, plan_start, plan_end, user_id) values (?,?,?,?)";
	private final String QUERY_READ = "select * from treatment_plan where plan_id=?";
    private final String QUERY_UPDATE = "UPDATE treatment_plan SET plan_id=? , plan_description=?, plan_start=? , plan_end=?, user_id=?, WHERE plan_id=?";
	private final String QUERY_DELETE = "delete from treatment_plan where plan_id=?";
	
	public List<TreatmentPlan> getAllTreatmentPlan() {
		List<TreatmentPlan> treatmentPlanList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			TreatmentPlan treatmentPlan;
			while (resultSet.next()) {
				int planId = resultSet.getInt("plan_id");
				String description = resultSet.getString("plan_description");
				int userId = resultSet.getInt("user_id");
				String start = resultSet.getString("plan_start");
				String end = resultSet.getString("plan_start");
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				
				Date planStart = null;
				try {
					planStart = formatter.parse(start);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date planEnd = null;
				try {
					planEnd = formatter.parse(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				treatmentPlan = new TreatmentPlan(planId,description,planStart,planEnd,userId);
				treatmentPlanList.add(treatmentPlan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentPlanList;
	}
	
	public boolean insertTreatmentPlan(TreatmentPlan treatmentPlan) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//plan_id, plan_description, plan_start, plan_end, user_id
			preparedStatement.setString(1, treatmentPlan.getPlanDescription());
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			String planStar = formatter.format(treatmentPlan.getPlanStart());
			preparedStatement.setString(2, planStar);
			
			String planEnd = formatter.format(treatmentPlan.getPlanEnd());
			preparedStatement.setString(3, planEnd);
			
			preparedStatement.setInt(4, treatmentPlan.getUserId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public TreatmentPlan readTreatmentPlan(int planId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, planId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String description = resultSet.getString("plan_description");
			int userId = resultSet.getInt("user_id");
			String start = resultSet.getString("plan_start");
			String end = resultSet.getString("plan_start");
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			Date planStart = null;
			try {
				planStart = formatter.parse(start);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date planEnd = null;
			try {
				planEnd = formatter.parse(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			TreatmentPlan treatmentPlan = new TreatmentPlan(planId, description, planStart, planEnd, userId);

			return treatmentPlan;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateTreatmentPlan(TreatmentPlan treatmentPlanToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (treatmentPlanToUpdate.getPlanId() == 0)
			return false;

		TreatmentPlan treatmentPlanRead = readTreatmentPlan(treatmentPlanToUpdate.getPlanId());
		if (!treatmentPlanRead.equals(treatmentPlanToUpdate)) {
			try {
				// Fill the userToUpdate object
				/*if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}*/
				
				// Update the user
				
				// plan_description=?, plan_start=? , plan_end=?, user_id=?
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				
				preparedStatement.setString(1, treatmentPlanRead.getPlanDescription());
				
				SimpleDateFormat formatter = new SimpleDateFormat("gg-MM-yyyy");
				
				String planStart = formatter.format(treatmentPlanToUpdate.getPlanStart());
				preparedStatement.setString(2, planStart);
				
				String planEnd = formatter.format(treatmentPlanToUpdate.getPlanStart());
				preparedStatement.setString(3, planEnd);
				
				preparedStatement.setInt(4, treatmentPlanRead.getUserId());
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

	public boolean deleteTreatmentPlan(Integer id) {
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
