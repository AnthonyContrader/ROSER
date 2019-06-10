package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.RobotConverter;
import it.contrader.converter.UsersConverter;
import it.contrader.dao.RobotDAO;
import it.contrader.dao.UsersDAO;
import it.contrader.dto.RobotDTO;
import it.contrader.dto.UsersDTO;
import it.contrader.model.Robot;

public class RobotService {

	private final RobotDAO robotDAO;
	private final UsersDAO usersDAO;

	public RobotService() {
		this.robotDAO = new RobotDAO();
		this.usersDAO = new UsersDAO();
	}
	
	//Tutti i metodi presenti sotto richiamano i metodi del DAO
	//E' neccessario usare i service dato che sono il livello più alto e non si può accedere direttamente al dao
	//e utilizzerano oggetti DTO che verrano convertiti con le classi Converter che restituira degli oggi del package Model
	//che verrano poi usati come parametri nei metodi del DAO
	
	public UsersDTO getUserByUsernameAndPasword(String username, String password) {
		return UsersConverter.toDTO(usersDAO.login(username, password));
	}
	
	public List<RobotDTO> getAllRobot() {
		List<Robot> robotList = robotDAO.getAllRobot(); //Preleviamo dal DAO la lista degli utenti che ha come ritorno List<Users>
		List<RobotDTO> listDTO = new ArrayList<>();     //Creiamo una lista di tipo List<UsersDTO> dato che ai livelli
		                                                //superiori si opera con gli oggetti DTO
		
		//Popoliamo la lista List<UsersDTO> usando la lista List<Users>
		for(Robot robot: robotList) {
			listDTO.add(RobotConverter.toDTO(robot));
		}

		return listDTO;
	}
	
	public boolean deleteRobot (RobotDTO robotDTO) {
		return this.robotDAO.deleteRobot(RobotConverter.toEntity(robotDTO));
	}
	
	public boolean insertUsers (RobotDTO robotDTO) {
		return this.robotDAO.insertRobot(RobotConverter.toEntity(robotDTO));
	}
	
	public boolean matchUsers(UsersDTO userDTO, RobotDTO robotDTO) {
		return this.robotDAO.matchUsers(UsersConverter.toEntity(userDTO),RobotConverter.toEntity(robotDTO));
	}
	
	public boolean disMatchUsers(RobotDTO robotDTO) {
		return this.robotDAO.disMatchUsers(RobotConverter.toEntity(robotDTO));
	}
	
	public RobotDTO readRobot(String robotModel) {
		return RobotConverter.toDTO(this.robotDAO.readRobot(robotModel));
	}
	
	public boolean insertData(RobotDTO robotDTO) {
		return this.robotDAO.insertData(RobotConverter.toEntity(robotDTO));
	}
	
	public Robot readlog(RobotDTO robotDTO, String data) {
		return this.robotDAO.readlog(RobotConverter.toEntity(robotDTO), data);
	}
}
