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
				
				int decibel = getValue();
				robot.setDecibel(decibel);
				
				int faceExpress = getValue();
				System.out.println("Ho prelevato: " + faceExpress +" come valore face");
				robot.setFaceexpress(faceExpress);
				
				int humidity = getValue();
				robot.setHumidity(humidity);
				
				String data = getData();
				robot.setData(data);
				robotService.insertData(robot);
				
				int media = (decibel+humidity+faceExpress)/3;
				
				String url = getUrl(media);
				
				request.setAttribute("url", url);
				getServletContext().getRequestDispatcher("/postInsertData.jsp").forward(request, response);
				break;
		}
	}
	
	public void showLogs(HttpServletRequest request, HttpServletResponse response){
	}
	
	public int getValue() {
		Random r = new Random();
		return r.nextInt(9)+1;
	}
	
	public String getData() {
		String dataStr = "";
		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dataStr = format.format(data);
		return dataStr;
	}
	
	public String getUrl(int media) {
		String url = "";
		if(media>0 && media<4) {
			url = "src/sadDog.png";
		}else if(media>3 && media<7) {
			url = "src/ThinkingDog.png";
		}else if(media>6 && media<11) {
			url = "src/HappyDog.png";
		}
		return url;
	}
}
