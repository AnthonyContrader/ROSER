CREATE DATABASE  IF NOT EXISTS `contrader_java_roser` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `contrader_java_roser`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: contrader_java_roser
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_pass` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `user_type` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  `user_state` bool COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Insert all users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

/*
LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
*/

DROP TABLE IF EXISTS `devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `devices` (
  `dev_id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `owner_id` int(11)  NOT NULL,
  PRIMARY KEY (`dev_id`),
   KEY `owner_id_fk_idx` (`owner_id`),
   CONSTRAINT `owner_id_fk_idx` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `treatment_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `treatment_plan` (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `plan_start` datetime COLLATE utf8_unicode_ci NOT NULL,
  `plan_end` datetime COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`plan_id`),
  KEY `user_id_fk_idx` (`user_id`),
  CONSTRAINT `user_id_fk_idx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-19 11:25:37
INSERT INTO USERS VALUES(NULL,"Michele","Verdi","michele01","ciao123","u",1);
INSERT INTO USERS VALUES(NULL,"Roberto","Rossi","roberto02","ciao123","m",1);
INSERT INTO USERS VALUES(NULL,"Giovanna","Bianchi","giovanna03","ciao123","m",1);
INSERT INTO USERS VALUES(NULL,"Luigi","Neri","luigi04","ciao123","u",1);
INSERT INTO DEVICES VALUES(NULL, "SAFX2",1);
INSERT INTO DEVICES VALUES(NULL, "3DFBT",4);
INSERT INTO TREATMENT_PLAN VALUES(NULL,"Piano terapeutico 01",'2019-05-29 09:00','2019-06-29 09:00',1);
INSERT INTO TREATMENT_PLAN VALUES(NULL,"Piano terapeutico 02",'2019-04-15 08:10','2019-06-30 23:00',4);

/* Query che mostra i dati anagrafici del paziente dato id del devices */
SELECT USERS.USER_NAME AS NOME, USERS.USER_SURNAME AS COGNOME
FROM USERS INNER JOIN DEVICES ON USERS.USER_ID = DEVICES.OWNER_ID
WHERE DEVICES.DEV_ID=1;

/* Query che mostra il modello del device dato l'id dell'utente */
SELECT DEVICES.MODEL
FROM USERS INNER JOIN DEVICES ON USERS.USER_ID = DEVICES.OWNER_ID
WHERE USERS.USER_ID=1;

/* Query che mostra il piano terapetico dato l'id dell'utente */ 
SELECT TREATMENT_PLAN.PLAN_DESCRIPTION AS DESCRIZIONE, TREATMENT_PLAN.PLAN_START AS DATA_DI_INIZIO, TREATMENT_PLAN.PLAN_END DATA_DI_FINE
FROM USERS INNER JOIN TREATMENT_PLAN ON USERS.USER_ID = TREATMENT_PLAN.USER_ID
WHERE USERS.USER_ID = 1;
