package it.contrader.controller;

import java.util.Date;
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
	
	@PostMapping("/parameters")
	public SensordataDTO getParameter(@RequestBody UserDTO robot ) {
		int decibel = (new Random()).nextInt(34);
		int faceExpress = (new Random()).nextInt(34);
		int humidity = (new Random()).nextInt(34);
		Date currentDate = new Date();
		String robotModel = robot.getUsername();
		RobotDTO robotInfo = robS.findByModel(robot.getUsername());
		String ownerName = robotInfo.getOwnername();
		String ownerSurname = robotInfo.getOwnersurname();
		SensordataDTO sensorIns = new SensordataDTO ();
		sensorIns.setDataDate(currentDate);
		sensorIns.setDecibel(decibel);
		sensorIns.setFaceExpress(faceExpress);
		sensorIns.setHumidity(humidity);
		sensorIns.setPatientName(ownerName);
		sensorIns.setPatientName(ownerSurname);
		sensorIns.setRobotModel(robotModel);
		senS.insert(sensorIns);
		
		return sensorIns;
		
	}
	
}