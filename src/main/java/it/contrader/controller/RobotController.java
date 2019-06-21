package it.contrader.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.RobotDTO;
import it.contrader.dto.SensordataDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.RobotService;
import it.contrader.service.SensordataService;
import it.contrader.service.TherapyService;


/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/robot")
@CrossOrigin(origins = "http://localhost:4200")
public class RobotController extends AbstractController<RobotDTO>{
	
	@Autowired
	private SensordataService senS;
	@Autowired
	private RobotService robS;
	
	private int decibel;
	private int faceExpress;
	private int humidity;
	
	@PostMapping("/parameters")
	public SensordataDTO getParameter(@RequestBody UserDTO robot ) {
		this.decibel = getRandomValue();
		this.faceExpress = getRandomValue();
		this.humidity = getRandomValue();
		String data = getData();
		String robotModel = robot.getUsername();
		RobotDTO robotInfo = robS.findByModel(robot.getUsername());
		String ownerName = robotInfo.getOwnername();
		String ownerSurname = robotInfo.getOwnersurname();
		SensordataDTO sensorIns = new SensordataDTO ();
		sensorIns.setDataDate(data);
		sensorIns.setDecibel(decibel);
		sensorIns.setFaceExpress(faceExpress);
		sensorIns.setHumidity(humidity);
		sensorIns.setPatientName(ownerName);
		sensorIns.setPatientName(ownerSurname);
		sensorIns.setRobotModel(robotModel);
		senS.insert(sensorIns);
		
		return sensorIns;
		
	}
	
	public String getData() {
		String dataStr = "";
		Date data = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		dataStr = format.format(data);
		return dataStr;
	}
	@PostMapping("/getMedia")
	public List<String> getMedia(@RequestBody SensordataDTO sensorData){
		
		int media = (sensorData.getHumidity()+sensorData.getDecibel()+sensorData.getFaceExpress())/3;
		
		List<String> tmpUrl = new ArrayList<String>();
		if(media>0 && media<4) {
			tmpUrl.add("0_3.png");
			tmpUrl.add("SAD");
		}
		else if(media>3 && media<7) {
			tmpUrl.add("4_6.png");
			tmpUrl.add("NORMAL");
		}
		else {
			tmpUrl.add("7_9.png");
			tmpUrl.add("HAPPY");
		}
		return tmpUrl;
	}
	private int getRandomValue() {
		Random r = new Random();
		return r.nextInt(9)+1;
	}
}