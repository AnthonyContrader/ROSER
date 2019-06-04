package it.contrader.utils;

//import main.controller.GestoreEccezioni;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;


public class ConnectionSingleton {


    private static Connection connection = null;


    private ConnectionSingleton() {
    }


    public static Connection getInstance() {
        if (connection == null) {
            try {
             //  Properties properties = new Properties();
                String vendor="mysql";
                String driver="com.mysql.jdbc.Driver"; 
                String host="localhost";
                String port="3306";
                String dbName="contrader_java_roser";
                String username="root";
                String password ="root";
               // Class c = Class.forName(driver);
                System.out.println("Ho caricato: " + dbName);
                String myUrl = "jdbc:" + vendor + "://" + host + ":" + port + "/" + dbName;
                System.out.println("Ho caricato: " + myUrl);
                DriverManagerDataSource dataSource = new DriverManagerDataSource(myUrl, username, password);
                dataSource.setDriverClassName(driver);
                connection = dataSource.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
