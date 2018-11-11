-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: myrupee
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(50) NOT NULL,
  `msisdn` varchar(50) NOT NULL,
  `profile_name` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `account_type` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `birth_country_code` varchar(3) NOT NULL,
  `created_on` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_number_unique` (`account_number`),
  UNIQUE KEY `profile_name_unique` (`profile_name`),
  UNIQUE KEY `msisdn_unique` (`msisdn`),
  UNIQUE KEY `email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (10,'9703779308','9703779308','KapilKumar','manikanta','challa','C_SAVINGS','PENDING','mani.challa1990@gmail.com','IND','2018-11-11 23:41:10'),(12,'8703779308','8703779308','Manichalla','manikanta','challa','C_SAVINGS','PENDING','kapil.challa1990@gmail.com','IND','2018-11-11 23:47:58');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_auth_info`
--

DROP TABLE IF EXISTS `account_auth_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_auth_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `super_pin_md5` varchar(50) NOT NULL,
  `created_on` datetime NOT NULL,
  `expired_on` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auth_account_id` (`account_id`),
  CONSTRAINT `fk_auth_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_auth_info`
--

LOCK TABLES `account_auth_info` WRITE;
/*!40000 ALTER TABLE `account_auth_info` DISABLE KEYS */;
INSERT INTO `account_auth_info` VALUES (1,10,'KAP97037793','','2018-11-11 23:41:10','2018-11-11 23:41:10'),(2,12,'MAN87037793','8cb2237d0679ca88db6464eac60da96345513964','2018-11-11 23:47:58','2018-12-16 23:53:21');
/*!40000 ALTER TABLE `account_auth_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_balance_info`
--

DROP TABLE IF EXISTS `account_balance_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_balance_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currency_code` varchar(3) NOT NULL,
  `balance` decimal(12,2) NOT NULL DEFAULT '0.00',
  `description` varchar(300) DEFAULT NULL,
  `created_on` datetime NOT NULL,
  `virtual_card` varchar(50) NOT NULL,
  `wallet_status` varchar(30) NOT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_balance_account_id` (`account_id`),
  CONSTRAINT `fk_balance_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_balance_info`
--

LOCK TABLES `account_balance_info` WRITE;
/*!40000 ALTER TABLE `account_balance_info` DISABLE KEYS */;
INSERT INTO `account_balance_info` VALUES (1,'INR',23000.00,'INR - C_SAVINGS','2018-11-11 23:41:10','1000-6545-4424-0417','PENDING',10),(2,'INR',23000.00,'INR - C_SAVINGS','2018-11-11 23:47:58','1000-6193-5796-3433','PENDING',12);
/*!40000 ALTER TABLE `account_balance_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_holder_address`
--

DROP TABLE IF EXISTS `account_holder_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_holder_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(50) NOT NULL,
  `building_no` varchar(50) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `district` varchar(100) NOT NULL,
  `landmark` varchar(50) DEFAULT NULL,
  `address_type` varchar(50) NOT NULL,
  `state` varchar(100) NOT NULL,
  `created_on` datetime NOT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_account_id` (`account_id`),
  CONSTRAINT `fk_address_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_holder_address`
--

LOCK TABLES `account_holder_address` WRITE;
/*!40000 ALTER TABLE `account_holder_address` DISABLE KEYS */;
INSERT INTO `account_holder_address` VALUES (1,'HSR','2784','560102','Bangalore','Sector1-HighLander Showroom','Present','PENDING','2018-11-11 23:41:10',10),(2,'HSR','2784','560102','Bangalore','Sector1-HighLander Showroom','Present','PENDING','2018-11-11 23:47:58',12);
/*!40000 ALTER TABLE `account_holder_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_holder_idinfo`
--

DROP TABLE IF EXISTS `account_holder_idinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_holder_idinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idnumber` varchar(50) NOT NULL,
  `country_code` varchar(3) NOT NULL,
  `issued_date` datetime NOT NULL,
  `expired_date` datetime NOT NULL,
  `issued_place` varchar(100) NOT NULL,
  `created_on` datetime NOT NULL,
  `idtype` varchar(50) NOT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_IDInfo_account_id` (`account_id`),
  CONSTRAINT `fk_IDInfo_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_holder_idinfo`
--

LOCK TABLES `account_holder_idinfo` WRITE;
/*!40000 ALTER TABLE `account_holder_idinfo` DISABLE KEYS */;
INSERT INTO `account_holder_idinfo` VALUES (1,'M95347','IND','2010-10-27 17:28:23','2022-10-27 17:28:23','Vizag','2018-11-11 23:41:10','Passport',10),(2,'M95347','IND','2010-10-27 17:28:23','2022-10-27 17:28:23','Vizag','2018-11-11 23:47:58','Passport',12);
/*!40000 ALTER TABLE `account_holder_idinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `num` int(11) NOT NULL,
  `position` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team_id` (`team_id`),
  CONSTRAINT `fk_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,1,'Lionel Messi',10,'Forward'),(2,1,'Andreas Inniesta',8,'Midfielder'),(3,1,'Pique',3,'Defender'),(4,1,'Xavi Hernandez',6,'Midfielder'),(5,1,'Xavi Hernandez',6,'Midfielder');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'Barcelona');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12  0:12:58
