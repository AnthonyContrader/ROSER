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
}
