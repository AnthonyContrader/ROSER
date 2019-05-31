package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            
            //Change view according userType
            String[] userType= loginService.login(nomeUtente, password);
           // System.out.println("TIPO: "+userType[0]+" Stato: "+ userType[1]);
            
            if(userType[0]==null)
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
            
            if (userType[0].equals("admin"))
                MainDispatcher.getInstance().callView("HomeAdmin", request);
            
            if (userType[0].equals("user"))
            	MainDispatcher.getInstance().callView("Patient", request);
            
            if (userType[0].equals("doctor"))
            {
            	if(userType[1].equals("1"))     //se è abilitato il dottore accette alla sua view    		
            	MainDispatcher.getInstance().callView("HomeDoctor", request);
            	
            	if(userType[1].equals("0")) //se non è abilitato ritorna al login
            	{
            		System.out.println("Your Account is DISABLE!");
            		MainDispatcher.getInstance().callAction("Login", "doControl", request);          		
            	}
            }
           
        }
        else MainDispatcher.getInstance().callView("Login", null);

    }
}
