-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: farmacy_inventory_db
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_info` (
  `acc_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicin_id` int(11) DEFAULT NULL,
  `mrp_price` float DEFAULT NULL,
  `sale_price` float DEFAULT NULL,
  `pro_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`acc_id`),
  KEY `medicin_id_fk_ai_idx` (`medicin_id`),
  CONSTRAINT `medicin_id_fk_ai` FOREIGN KEY (`medicin_id`) REFERENCES `medicin_info` (`medicin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--

LOCK TABLES `account_info` WRITE;
/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` VALUES (1,1,650,690,'OK');
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cutomer_info`
--

DROP TABLE IF EXISTS `cutomer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cutomer_info` (
  `cus_id` int(11) NOT NULL,
  `cus_name` varchar(45) DEFAULT NULL,
  `cus_contact` varchar(45) NOT NULL,
  `cus_email` varchar(45) NOT NULL,
  PRIMARY KEY (`cus_id`),
  UNIQUE KEY `cus_email_UNIQUE` (`cus_email`),
  UNIQUE KEY `cus_contact_UNIQUE` (`cus_contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cutomer_info`
--

LOCK TABLES `cutomer_info` WRITE;
/*!40000 ALTER TABLE `cutomer_info` DISABLE KEYS */;
INSERT INTO `cutomer_info` VALUES (1,'Azmol','01936835834','azmol@gmail.com'),(2,'fdsf','01936825724','test@test.test');
/*!40000 ALTER TABLE `cutomer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_info`
--

DROP TABLE IF EXISTS `login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_info` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_info`
--

LOCK TABLES `login_info` WRITE;
/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicin_info`
--

DROP TABLE IF EXISTS `medicin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicin_info` (
  `medicin_id` int(11) NOT NULL,
  `medicin_name` varchar(45) NOT NULL,
  `group_name` varchar(45) NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`medicin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicin_info`
--

LOCK TABLES `medicin_info` WRITE;
/*!40000 ALTER TABLE `medicin_info` DISABLE KEYS */;
INSERT INTO `medicin_info` VALUES (1,'ACE','Paracitamol','Square'),(2,'Napa','Paracitamol','Incepta'),(3,'Ace Plus++','Paracitamol','Square'),(5,'Cvit','Vitamin C+','Amature'),(6,'Locectil Pwoder','Omiprajol','Square');
/*!40000 ALTER TABLE `medicin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchas_medicin_details`
--

DROP TABLE IF EXISTS `purchas_medicin_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchas_medicin_details` (
  `puchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `medicin_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `mrp_rate` float DEFAULT NULL,
  `puchase_date` date DEFAULT NULL,
  `manu_date` date DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `from_whose` varchar(45) DEFAULT 'Company',
  PRIMARY KEY (`puchase_id`),
  KEY `medicin_id_fk_pmd_idx` (`medicin_id`),
  CONSTRAINT `medicin_id_fk_pmd` FOREIGN KEY (`medicin_id`) REFERENCES `medicin_info` (`medicin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchas_medicin_details`
--

LOCK TABLES `purchas_medicin_details` WRITE;
/*!40000 ALTER TABLE `purchas_medicin_details` DISABLE KEYS */;
INSERT INTO `purchas_medicin_details` VALUES (1,1,100,150,'2000-01-01','2016-05-12','2016-05-12','Company'),(2,2,100,200,'2000-01-01','3916-02-01','3916-02-01','asda'),(3,6,50,250,'2000-01-01','2000-01-01','2000-01-01','Company'),(4,5,120,200,'2000-01-01','2000-01-01','2000-01-01','Company');
/*!40000 ALTER TABLE `purchas_medicin_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_details`
--

DROP TABLE IF EXISTS `sales_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_details` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `medicin_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `sale_price` float DEFAULT NULL,
  `due_price` float DEFAULT '0',
  `sale_status` varchar(45) DEFAULT 'Paid',
  PRIMARY KEY (`sale_id`),
  KEY `cus_id_fk_sd_idx` (`cus_id`),
  KEY `medicin_id_fk_sd_idx` (`medicin_id`),
  CONSTRAINT `cus_id_fk_sd` FOREIGN KEY (`cus_id`) REFERENCES `cutomer_info` (`cus_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `medicin_id_fk_sd` FOREIGN KEY (`medicin_id`) REFERENCES `medicin_info` (`medicin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_details`
--

LOCK TABLES `sales_details` WRITE;
/*!40000 ALTER TABLE `sales_details` DISABLE KEYS */;
INSERT INTO `sales_details` VALUES (1,1,1,5,50,0,'Paid'),(2,1,1,10,50,0,'Paid'),(3,1,1,10,350,0,'Paid');
/*!40000 ALTER TABLE `sales_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-19  9:54:44
