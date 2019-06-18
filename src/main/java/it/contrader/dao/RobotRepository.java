package it.contrader.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.contrader.model.Robot;

public interface RobotRepository extends CrudRepository<Robot, Integer> {

	public Robot findRobotByRobotModel(String robotModel);
	/*public User findUserByUserUserAndUserPass(String username,String password);
	public List<User> findAllByUserUser(String username);*/
	
	@Modifying
	@Query(value = "UPDATE robot c SET c.robot_owner_name = '', c.robot_owner_surname = '' WHERE c.id = :robotId", nativeQuery=true)
	public void disMatch(@Param("robotId") int robotId);
	
	//Robot save(Robot persisted);
	
	/*@Transactional
		@Query(value="SELECT * FROM user WHERE user_user=?1 AND user_pass=?2", nativeQuery = true)
	public User findUserByUsernameAndPassword(@RequestParam("username")String username,@RequestParam("password")String password);
	
	@Transactional
	@Query(value="SELECT * FROM user WHERE user_type =?1",nativeQuery =true)
	public List<User> findAllByType(@RequestParam("doctor")String userType);*/
	
}