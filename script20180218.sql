CREATE DATABASE  IF NOT EXISTS `coinsite` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `coinsite`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: coinsite
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `coin`
--

DROP TABLE IF EXISTS `coin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `series_id` int(11) NOT NULL,
  `release_date` varchar(50) NOT NULL,
  `designer` varchar(50) NOT NULL,
  `minted_by` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `image_address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `coin_image_address_uindex` (`image_address`),
  KEY `series_id` (`series_id`),
  CONSTRAINT `coin_ibfk_1` FOREIGN KEY (`series_id`) REFERENCES `series` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin`
--

LOCK TABLES `coin` WRITE;
/*!40000 ALTER TABLE `coin` DISABLE KEYS */;
INSERT INTO `coin` VALUES (2,'50th Anniversary of the United Nations Organizatio',3,'1996-12-27','A.Zimenko, D.Belitsky','The Royal Mint, London,Great Britain','Coins are round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. ','http://www.nbrb.by/CoinsBanknotes/images?id=522'),(3,'75th Anniversary of the Banking system',3,'1997-02-18','T.Radivilko','The Mint of Poland PLC., Warsaw, Poland','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated.','http://www.nbrb.by/CoinsBanknotes/images?id=530'),(4,'Test coin',40,'1998-09-09','test','test','test','test');
/*!40000 ALTER TABLE `coin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coin_description`
--

DROP TABLE IF EXISTS `coin_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coin_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coin_id` int(11) NOT NULL,
  `metal_id` int(11) NOT NULL,
  `denomination` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `diameter` float DEFAULT NULL,
  `mintage` int(11) DEFAULT NULL,
  `image_obverse` varchar(100) NOT NULL,
  `image_reverse` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `image_obverse` (`image_obverse`),
  UNIQUE KEY `image_reverse` (`image_reverse`),
  KEY `coin_id` (`coin_id`),
  KEY `metal_id` (`metal_id`),
  CONSTRAINT `coin_description_ibfk_1` FOREIGN KEY (`coin_id`) REFERENCES `coin` (`id`),
  CONSTRAINT `coin_description_ibfk_2` FOREIGN KEY (`metal_id`) REFERENCES `metal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin_description`
--

LOCK TABLES `coin_description` WRITE;
/*!40000 ALTER TABLE `coin_description` DISABLE KEYS */;
INSERT INTO `coin_description` VALUES (1,2,1,1,28.28,38.61,40000,'http://www.nbrb.by/CoinsBanknotes/images?id=524','http://www.nbrb.by/CoinsBanknotes/images?id=526'),(2,2,2,1,30.57,38.61,20000,'http://www.nbrb.by/CoinsBanknotes/images?id=520','http://www.nbrb.by/CoinsBanknotes/images?id=522'),(3,2,3,1,8.71,22.05,5000,'http://www.nbrb.by/CoinsBanknotes/images?id=512','http://www.nbrb.by/CoinsBanknotes/images?id=514'),(4,3,2,20,31.1,39,2000,'http://www.nbrb.by/CoinsBanknotes/images?id=528','http://www.nbrb.by/CoinsBanknotes/images?id=530');
/*!40000 ALTER TABLE `coin_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `coindescription_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `coin_description_id` (`coindescription_id`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`coindescription_id`) REFERENCES `coin_description` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,1,1,2),(2,2,1,3);
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Republic of Belarus'),(2,'Republic of Kazakhstan'),(5,'Republic of Lithuania'),(3,'Russian Federation');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metal`
--

DROP TABLE IF EXISTS `metal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metal`
--

LOCK TABLES `metal` WRITE;
/*!40000 ALTER TABLE `metal` DISABLE KEYS */;
INSERT INTO `metal` VALUES (1,'Copper–nickel'),(3,'Gold'),(2,'Silver');
/*!40000 ALTER TABLE `metal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collection_id` int(11) NOT NULL,
  `cost` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_coin_description_id` (`collection_id`),
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`collection_id`) REFERENCES `collection` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,1,240);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `theme_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `theme_id` (`theme_id`),
  CONSTRAINT `series_ibfk_1` FOREIGN KEY (`theme_id`) REFERENCES `theme` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (3,'Belarus And The World Community',1),(4,'The 60th Anniversary of Liberation of the Republic of Belarus from the nazi invaders',1),(5,'The 60th Anniversary of Victory in the Great Patriotic war',1),(6,'Tales of the World’s Nations',1),(7,'Slavs\' Family Traditions',1),(8,'Orthodox Saints',1),(9,'Sailing Ships',1),(10,'Signs of the Zodiac',1),(11,'The Three Musketeers',1),(12,'Alexander Pushkin\'s Fairy Tales',1),(13,'Operation Bagration',1),(14,'Orthodox Churches',1),(15,'World of Sculpture Series',1),(16,'Orthodox Wonder-working Icons Series',1),(17,'Belarus\'s International Festivals Series',1),(18,'Magic of Dance',1),(19,'The Solar System Series',1),(20,'Chinese Calendar',1),(21,'Signs of the Zodiac. 2013',1),(22,'Orthodox Saints’ Lives Series',1),(23,'Zodiac Horoscope',1),(24,'Orthodox Saints. 2013',1),(25,'Skaryna’s Way',1),(26,'Belarussian History And Culture',2),(27,'Belarusian Cities',2),(28,'Belarusian Architectural Monuments',2),(29,'Belarusian Festivals and Rites',2),(30,'Strengthening and Defending the State',2),(31,'Belarusian Folk Legends',2),(32,'Belarusian Folk Trades and Crafts',2),(33,'Belarus\' Faiths Series',2),(34,'Belts of Slutsk',2),(35,'Sports',3),(36,'Olympic Belarus',3),(37,'Protection Of The Environment',4),(38,'Belarusian National Parks and Nature Reserves',4),(39,'Belarusian Nature Reserves',4),(40,'Bird of the Year',4),(41,'Horses',4),(42,'Belarusian Flowers',4),(43,'Beauty of Flowers',4),(44,'Butterflies',4),(45,'Revived Plants',4),(46,'My country Belarus',5);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `theme_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'BELARUS AND THE WORLD COMMUNITY',1),(2,'BELARUSIAN HISTORY AND CULTURE',1),(3,'SPORTS',1),(4,'PROTECTION OF THE ENVIRONMENT',1),(5,'MY COUNTRY BELARUS',1);
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `useremail` varchar(50) NOT NULL,
  `userpassword` varchar(50) NOT NULL,
  `role` varchar(15) NOT NULL,
  `userLogin` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_useremail_uindex` (`useremail`),
  UNIQUE KEY `user_userLogin_uindex` (`userLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'TestUser','test@test.by','test','USER','TestUser1','TestUserLastName1'),(2,'TestUser2','test2@test.by','test2','USER','TestUser2','TestUserLastName2'),(3,'TestUser3','test3@test.by','test3','USER','TestUser3','TestUserLastName3'),(4,'TestUser4','test4@test.by','test4','USER','TestUser4','TestUserLastName4'),(5,'TestUser5','test5@test.by','test5','USER','TestUser5','TestUserLastName5'),(6,'TestUser6','test6@test.by','test6','USER','TestUser6','TestUserLastName6'),(7,'TestUser7','test7@test.by','test7','USER','TestUser7','TestUserLastName7'),(8,'TestUser8','test8@test.by','test8','USER','TestUser8','TestUserLastName8'),(9,'TestUser9','test9@test.by','test9','USER','TestUser9','TestUserLastName9\n'),(10,'TestUser10','test10@test.by','test10','USER','TestUser10','TestUserLastName10'),(11,'TestUser11','test11@test.by','test11','USER','TestUser11','TestUserLastName11'),(12,'TestUser12','test12@test.by','test12','USER','TestUser12','TestUserLastName12'),(14,'TestUser13','test13@test.by','test13','MODERATOR','TestUser13','TestUserLastName13'),(15,'TestUser14','test14@test.by','test14','ADMINISTRATOR','TestUser14','TestUserLastName14');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-19  2:37:23
