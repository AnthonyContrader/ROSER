package it.contrader.servlets.robot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.RobotDTO;
import it.contrader.service.RobotService;

/**
 * Servlet implementation class Robot
 */
public class RobotServlet extends HttpServlet {
	private RobotDTO robot = new RobotDTO();
	private final RobotService robotService = new RobotService();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {
			case "ReadParameter":
				String robotModel= request.getParameter("robot");
				robot = robotService.readRobot(robotModel);
				robot.setDecibel(getValue());
				robot.setFaceexpress(getValue());
				robot.setHumidity(getValue());
				robot.setData(getData());
				robotService.insertData(robot);
				break;
				//robot_model,patient_name,patientsurname,decibel,face_express,humidity,data_date
		}
	}
	
	public void showLogs(HttpServletRequest request, HttpServletResponse response){
	}
	
	public int getValue() {
		Random r = new Random();
		return r.nextInt(9);
	}
	
	public String getData() {
		String dataStr = "";
		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dataStr = format.format(data);
		return dataStr;
	}
}
