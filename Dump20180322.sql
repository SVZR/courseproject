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
  `name` varchar(70) NOT NULL,
  `series_id` int(11) NOT NULL,
  `release_date` varchar(50) NOT NULL,
  `designer` varchar(50) NOT NULL,
  `minted_by` varchar(50) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `series_id` (`series_id`),
  CONSTRAINT `coin_ibfk_1` FOREIGN KEY (`series_id`) REFERENCES `series` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin`
--

LOCK TABLES `coin` WRITE;
/*!40000 ALTER TABLE `coin` DISABLE KEYS */;
INSERT INTO `coin` VALUES (2,'50th Anniversary of the United Nations Organization',3,'1996-12-27','A.Zimenko, D.Belitsky','The Royal Mint, London,Great Britain','Coins are round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. '),(3,'75th Anniversary of the Banking system',3,'1997-02-18','T.Radivilko','The Mint of Poland PLC., Warsaw, Poland','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated.'),(4,'Test coin',40,'1998-09-09','test','test','test'),(6,'100th Anniversary of belarusian Trade union movement',3,'2004-11-16','S.Zaskevich, G.Maximov','The Mint of Poland PLC., Warsaw, Poland','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated.Obverse: within the circular geometric ornament – the relief of the State Coat of Arms of the Republic of Belarus; beneath – year of issue and alloy standard; inscriptions along the rim – at the top: \"РЭСПУБЛIКА–БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom: \"ДВАЦЦАЦЬ РУБЛЁЎ\" (TWENTY ROUBLES). Reverse: at the background of Belarussian map – relief effigy of a populous column, which symbolizes mass trade union movement. On the flag – emblem of the Belarussian Federation of trade unions \"ФПБ\"; to the left from the column – relief effigy of the Palace of trade unions in Minsk; beneath – inscription \"100 ГОД\" (100 YEARS); within a circle at the top – inscription \"ПРАФСАЮЗНАМУ РУХУ БЕЛАРУСІ\" (BELARUSSIAN TRADE UNION MOVEMENT).'),(7,'Ilya Repin',3,'2009-07-15','O.Novosiolova','The Mint of Poland PLC., Warsaw, Poland','The coin is rectangular in shape with a raised rim on the obverse and the reverse. The coin’s edge is not reeded. Obverse: in the centre — fragments of painting \"Autumn Bouquet\" by Russian painter Ilya Repin which are reproduced with the help of pad-printing technique; in the top left-hand part — the relief image of the State Coat of Arms of the Republic of Belarus and a circumferential inscription: РЭСПУБЛIКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS), beneath — denomination: 20 РУБЛЁЎ (20 RUBLES), alloy standard, and trademark of The Mint of Poland PLC. Reverse: on the left — the relief image of the self-portrait of Ilya Repin, beneath — an inscription \"I. РЭПIН\" (I. REPIN) and the years of his birth and death 1844—1930; on the right — the image of the Museum-Estate of Ilya Repin in Zdravniovo (Belarus, Vitebsk region), beneath — the image of a palette and brushes reproduced with the help of pad-printing technique.'),(8,'60th Anniversary of Victory',5,'2005-04-25','S.Nekrasova','CJSC \"Lithuanian Mint\", Vilnius, Lithuania','Coins are round. The rim is raised on both sides of the coin. The edge of the coins is corrugated. Obverse: at the top – the relief of the State Coat of Arms of the Republic of Belarus; in the center – the relief of the order of the Victory (enamel of red and blue color on silver coin); beneath: year of issue, silver coin – fine silver alloy standard; inscriptions along the rim: at the top – \"РЭСПУБЛІКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom – \" ПЯЦЬДЗЕСЯТ РУБЛЁЎ\" (FIFTY ROUBLES) on the silver coin and \" АДЗІН РУБЕЛЬ \" (ONE ROUBLE) on the copper–nickel coin. Reverse: in the center – three conventionalized arrows aimed at the star, which form sectors: in the upper one – a flapping banner, in the left one – laurel frond and inscription in two lines \"60 ГОД\" \"60 YEARS\", in the right one – salute; a moire ribbon, which joins sectors, passes the field of the coin.'),(9,'The Victory',5,'2005-04-25','S.V.Necrasova','The Mint of Poland PLC., Warsaw, Poland','Coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: at the top – the relief of the State Coat of Arms of the Republic of Belarus; in the center – the relief of the order of the Victory with pad–printing of red and blue colors; beneath: year of issue, fine silver alloy standard; inscriptions along the rim: at the top – \"РЭСПУБЛІКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom – \"ДВАЦЦАЦЬ РУБЛЁЎ\" (TWENTY ROUBLES). Reverse: in the center – dates \"1945–2005\"; at the bottom – moire medal ribbon; in the right–hand part – soviet warriors raising the flag of Victory on the roof of the Reichstag.'),(10,'The Amerigo Vespucci',9,'2010-04-19','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round in shape with a raised rim on the obverse and the reverse. The coins’ edge is grained. Obverse: at the top – the relief of the State Coat of Arms of the Republic of Belarus (in the center) and a circumferential inscription: РЭСПУБЛIКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS); in the center – the stylized image of the wind rose (the silver coin features a hologram thereon) against the background of a navigation sea chart; at the bottom –circumferential inscriptions: 20 РУБЛЁЎ (20 RUBLES) on the silver coin and 1 РУБЕЛЬ (1 RUBLE) on the copper–nickel one, the year of issue (and the alloy standard and the trademark of the Mint of Poland PLC. on the silver coin). Reverse: in the center – the image of The Amerigo Vespucci – one of the biggest sailing ships in the world – against the background of the sea and the coastline; on the left – the side view of the reduced image of the ship; and at the bottom – an inscription AMERIGO VESPUCCI.'),(11,'The Constitution',9,'2010-11-10','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round in shape with a raised rim on the obverse and the reverse. The coins’ edge is grained. Obverse: at the top – the relief image of the State Coat of Arms of the Republic of Belarus and a circumferential inscription: РЭСПУБЛІКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS); in the center – the stylized image of the wind rose against the background of a navigation sea chart (on the silver coin the wind rose is performed as a hologram); at the bottom – the denomination: 20 РУБЛЁЎ (20 RUBLES) on the silver coin and 1 РУБЕЛЬ (1 RUBLE) on the copper-nickel one and the year of issue to the left of the denomination (and the alloy standard and the trademark of the Mint of Poland PLC. to the right of the denomination on the silver coin). Reverse: in the center – the image of The Constitution – one of the oldest sailing ships in the world – against the background of the sea and the coastline; on the left – the side view of the reduced image of the ship; and at the bottom – an inscription: CONSTITUTION.'),(12,'The Sedov',9,'2008-12-29','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round in shape with the raised rim on the obverse and the reverse. The coins’ edge is grained. Obverse: at the top – the relief image of the State Coat of Arms of the Republic of Belarus (in the center) and a circumferential inscription: РЭСПУБЛIКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS); in the center of the coins against the background of the nautical chart – the stylized image of the wind rose (the silver coin bears a hologram); at the bottom – an inscription: 20 РУБЛЁЎ (20 RUBLES) on the silver coin and 1 РУБЕЛЬ (1 RUBLE) on the copper–nickel coin; and on the left – the year of issue (in the right–hand part of the silver coin there are: alloy standard and trademark of the Mint of Poland PLC). Reverse: on the left – the image of one of the biggest and fastest sailing vessels in the world – The Sedov – against the background of a seascape; on the right – the diminished image of the ship (outboard profile); and beneath – an inscription: СЕДОВ (THE SEDOV) in original lettering.'),(13,'The Dar Pomorza',9,'2009-10-05','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round in shape with a raised rim on the obverse and the reverse. The coins’ edge is grained. Obverse: at the top — the relief image of the State Coat of Arms of the Republic of Belarus in the center and a circumferential inscription: РЭСПУБЛIКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS); in the center — the stylized image of the wind rose (the silver coin features a hologram thereon) against the background of the navigation sea chart; and a circumferential inscription: at the bottom — 20 РУБЛЁЎ (20 RUBLES) on the silver coin and 1 РУБЕЛЬ (1 RUBLE) on the copper-nickel coin; to the left — the year of issue (the alloy standard and trademark of The Mint of Poland PLC. shown in the right-hand part of the silver coin). Reverse: in the center — the representation of the Dar Pomorza, the longest sailing ship in the world, against the background of the seascape, on the left — the reduced image of this sailing ship (outboard profile); beneath — an inscription: DAR POMORZA in the original.'),(14,'The Cutty Sark',9,'2011-03-23','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: at the top – the relief of the State Coat of Arms of the Republic of Belarus and inscription \"РЭСПУБЛIКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS); in the center at the background of navigation sea chart the stylized image of wind rose, with raised hologram on the silver coin; beneath – face value \"20 РУБЛЁЎ\" (20 ROUBLES) – on silver coin and \"1 РУБЕЛЬ\" (1 ROUBLE) – on copper–nickel coin; on the left - year of issue, (on silver coin – alloy standard and corporate (commercial) mark of Mint of Poland. Reverse: in the center – at the background of the sea landscape is singular surviving tea clipper in the world for today \"The Cutty Sark\", beneath – reduced image of this ship (side view); on the right – the inscription \"The Cutty Sark\".'),(15,'The Krusenstern',9,'2011-09-27','D.Surajewska, S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round in shape with a raised rim on the obverse and the reverse. The coins’ edge is grained. Obverse: at the top – the relief image of the State Coat of Arms of the Republic of Belarus and a circumferential inscription: РЭСПУБЛІКА БЕЛАРУСЬ (THE REPUBLIC OF BELARUS); in the center – the stylized image of the wind rose (on the silver coin the wind rose is performed as a hologram) against the background of a navigation sea chart; at the bottom – the denomination: 20 РУБЛЁЎ (20 RUBLES) on the silver coin and 1 РУБЕЛЬ (1 RUBLE) on the copper-nickel one and the year of issue to the left of the denomination (and the alloy standard and the trademark of the Mint of Poland PLC. to the right of the denomination on the silver coin). Reverse: in the center – the image of The Krusenstern – one of the most swift-sailing ships in the world – against the background of the sea landscape; beneath – the side view of the reduced image of the ship; and at the bottom – an inscription: KRUSENSTERN.'),(16,'Polotsk',27,'1998-10-21','T.Radivilko','Moscow Mint of Goznak, Moscow, Russia','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: within the circular geometric ornament – the relief of the State Coat of Arms of the Republic of Belarus; beneath – year of issue, silver coin – fine silver content and alloy standard; inscriptions along the rim – on top: \"РЭСПУБЛIКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom: \"ДВАЦЦАЦЬ РУБЛЁЎ\" (TWENTY ROUBLES) on the silver coin and \"АД3IН РУБЕЛЬ\" (ONE ROUBLE) on the copper–nickel coin. Reverse: in the center – the relief of the layout of Polotsk based on a 16th century engravement, in the top right–hand part – the city\'s coat of arms of the 16th–18th centuries; inscriptions along the rim: \"ПОЛАЦК\" (POLATSK) and \"ГАРАДЫ БЕЛАРУСI\" (BELARUSIAN CITIES).'),(17,'Minsk',27,'1999-01-04','T.Radivilko','Moscow Mint of Goznak, Moscow, Russia','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: within the circular geometric ornament – the relief of the State Coat of Arms of the Republic of Belarus; beneath – year of issue, silver coin – fine silver content and alloy standard; inscriptions along the rim – on top: \"РЭСПУБЛIКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom: \"ДВАЦЦАЦЬ РУБЛЁЎ\" (TWENTY ROUBLES) on the silver coin and \"АД3IН РУБЕЛЬ\" (ONE ROUBLE) on the copper–nickel coin. Reverse: in the center in the background – the relief of the gate of the Minsk castle (12th century) reconstructed by Yu.A. Zayats; in the foreground – the relief of the Roman–Catholic Cathedral and a tower with a chiming clock in Cathedral Square (early 20–th century): in the top right–hand part – the city\'s coat of arms; inscriptions along the rim: \"MIHCK\" (MINSK) and \"ГАРАДЫ БЕЛАРУСI\" (BELARUSIAN CITIES).'),(18,'Vitebsk',27,'2000-06-20','T.Radivilko','Moscow Mint of Goznak, Moscow, Russia','The coin is round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: within the circular geometric ornament – the relief of the State Coat of Arms of the Republic of Belarus; beneath – year of issue, silver coin – fine silver content and alloy standard; inscriptions along the rim – on top: \"РЭСПУБЛIКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), at the bottom: \"ДВАЦЦАЦЬ РУБЛЁЎ\" (TWENTY ROUBLES) on the silver coin and \"АД3IН РУБЕЛЬ\" (ONE ROUBLE) on the copper–nickel coin. Reverse: in the top left–hand part – the city\'s coat of arms; in the bottom left–hand in the background the relief of the Blagoveschenskaya church; in the bottom right–hand in the background the relief of the city hall;inscriptions along the rim: \"ВIТЕБСК\" (VITEBSK) and \"ГАРАДЫ БЕЛАРУСI\" (BELARUSIAN CITIES).'),(19,'Republican Alpine Skiing Center Silichy',35,'2006-09-28','S.Nekrasova','The Mint of Poland PLC., Warsaw, Poland','The coins are round. The rim is raised on both sides of the coin. The edge of the coin is corrugated. Obverse: in the centre – the relief of the skier descending from the mountain, and the inscription: \"СІЛІЧЫ\" (Silichy), at the top the State Coat of Arms of the Republic of Belarus and inscriptions along the rim at the top – \"РЭСПУБЛІКА БЕЛАРУСЬ\" (REPUBLIC OF BELARUS), beneath: year of issue, fine gold and silver alloy standard and face value \"200 РУБЛЁЎ\" (200 ROUBLES) – on gold coin, \"20 РУБЛЁЎ\" (20 ROUBLES) – on silver coin and \"1 РУБЕЛЬ\" (1 ROUBLE) – on copper–nickel coin; Reverse: in the center – relief image of panorama of the Ski center; inscriptions along the rim: \"РЭСПУБЛІКАНСКІ ГАРНАЛЫЖНЫ ЦЭНТР\" (\"REPUBLIC MOUNTAIN–SKIER CENTER\".'),(20,'test coin name',47,'2000-09-09','test designer','test minted by','test coin description text');
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin_description`
--

LOCK TABLES `coin_description` WRITE;
/*!40000 ALTER TABLE `coin_description` DISABLE KEYS */;
INSERT INTO `coin_description` VALUES (1,2,1,1,28.28,38.61,40000,'http://www.nbrb.by/CoinsBanknotes/images?id=524','http://www.nbrb.by/CoinsBanknotes/images?id=526'),(2,2,2,1,30.57,38.61,20000,'http://www.nbrb.by/CoinsBanknotes/images?id=520','http://www.nbrb.by/CoinsBanknotes/images?id=522'),(3,2,3,1,8.71,22.05,5000,'http://www.nbrb.by/CoinsBanknotes/images?id=512','http://www.nbrb.by/CoinsBanknotes/images?id=514'),(4,3,2,20,31.1,39,2000,'http://www.nbrb.by/CoinsBanknotes/images?id=528','http://www.nbrb.by/CoinsBanknotes/images?id=530'),(5,6,2,20,33.63,38.61,1500,'http://www.nbrb.by/CoinsBanknotes/images/?id=617','http://www.nbrb.by/CoinsBanknotes/images/?id=619'),(6,7,2,20,28.28,40,15000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1841','http://www.nbrb.by/CoinsBanknotes/images/?id=1843'),(7,8,2,50,67.25,50,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=725','http://www.nbrb.by/CoinsBanknotes/images/?id=727'),(8,8,3,1,16,33,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=729','http://www.nbrb.by/CoinsBanknotes/images/?id=731'),(9,9,2,20,28.28,26.16,12000,'http://www.nbrb.by/CoinsBanknotes/images/?id=745','http://www.nbrb.by/CoinsBanknotes/images/?id=747'),(10,10,2,20,28.28,38.61,7000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2077','http://www.nbrb.by/CoinsBanknotes/images/?id=2079'),(11,10,3,1,13.16,32,4000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2081','http://www.nbrb.by/CoinsBanknotes/images/?id=2083'),(12,11,2,20,28.28,38.61,7000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2224','http://www.nbrb.by/CoinsBanknotes/images/?id=2226'),(13,11,3,1,13.16,32,3000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2228','http://www.nbrb.by/CoinsBanknotes/images/?id=2230'),(14,12,2,20,28.28,38.61,25000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1726','http://www.nbrb.by/CoinsBanknotes/images/?id=1728'),(15,12,3,1,13.16,32,7000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1730','http://www.nbrb.by/CoinsBanknotes/images/?id=1732'),(16,13,2,20,28.28,38.61,25000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1869','http://www.nbrb.by/CoinsBanknotes/images/?id=1871'),(17,13,3,1,13.16,32,5000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1873','http://www.nbrb.by/CoinsBanknotes/images/?id=1875'),(18,14,2,20,28.28,38.61,7000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2357','http://www.nbrb.by/CoinsBanknotes/images/?id=2359'),(19,14,3,1,13.16,32,3000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2361','http://www.nbrb.by/CoinsBanknotes/images/?id=2363'),(20,15,2,20,28.28,38.61,7000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2575','http://www.nbrb.by/CoinsBanknotes/images/?id=2577'),(21,15,3,1,13.16,32,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=2579','http://www.nbrb.by/CoinsBanknotes/images/?id=2581'),(22,16,2,20,33.62,39,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=961','http://www.nbrb.by/CoinsBanknotes/images/?id=963'),(23,16,3,1,14.35,33,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=965','http://www.nbrb.by/CoinsBanknotes/images/?id=967'),(24,17,2,20,33.62,39,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=969','http://www.nbrb.by/CoinsBanknotes/images/?id=971'),(25,17,3,1,14.35,33,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=973','http://www.nbrb.by/CoinsBanknotes/images/?id=975'),(26,18,2,20,33.62,39,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=977','http://www.nbrb.by/CoinsBanknotes/images/?id=979'),(27,18,3,1,14.35,33,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=981','http://www.nbrb.by/CoinsBanknotes/images/?id=983'),(28,19,1,100,34.56,38.61,2000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1315','http://www.nbrb.by/CoinsBanknotes/images/?id=1317'),(29,19,2,20,33.63,38.61,5000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1319','http://www.nbrb.by/CoinsBanknotes/images/?id=1321'),(30,19,3,1,13.16,32,5000,'http://www.nbrb.by/CoinsBanknotes/images/?id=1323','http://www.nbrb.by/CoinsBanknotes/images/?id=1325');
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
  `sale` varchar(50) NOT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `coin_description_id` (`coindescription_id`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`coindescription_id`) REFERENCES `coin_description` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
INSERT INTO `collection` VALUES (1,1,1,0,'FORSALE',NULL),(3,1,3,2,'NOTFORSALE',NULL),(4,1,2,4,'NOTFORSALE',150),(5,1,6,2,'FORSALE',2),(6,18,10,2,'FORSALE',200),(7,18,11,1,'FORSALE',100),(8,1,26,1,'NOTFORSALE',200),(9,16,16,3,'NOTFORSALE',120);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Republic of Belarus'),(2,'Republic of Kazakhstan'),(5,'Republic of Lithuania'),(11,'Republic of Poland'),(3,'Russian Federation'),(10,'Test Country');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fromUser_id` int(11) NOT NULL,
  `messageText` text NOT NULL,
  `timeStamp` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `messages_id_uindex` (`id`),
  KEY `user_id` (`user_id`),
  KEY `fromUser_id` (`fromUser_id`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`fromUser_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,18,1,'test message','2018-03-20 01:07:26'),(2,1,18,'reply test message','2018-03-20 01:07:58'),(3,18,1,'another answer','2018-03-20 01:09:11'),(4,1,16,'text','2018-03-20 21:00:46');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `news_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'NEWS TEXT ONE'),(2,'NEWS TEXT TWO');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (3,'Belarus And The World Community',1),(4,'The 60th Anniversary of Liberation of the Republic of Belarus from the nazi invaders',1),(5,'The 60th Anniversary of Victory in the Great Patriotic war',1),(6,'Tales of the World’s Nations',1),(7,'Slavs\' Family Traditions',1),(8,'Orthodox Saints',1),(9,'Sailing Ships',1),(10,'Signs of the Zodiac',1),(11,'The Three Musketeers',1),(12,'Alexander Pushkin\'s Fairy Tales',1),(13,'Operation Bagration',1),(14,'Orthodox Churches',1),(15,'World of Sculpture Series',1),(16,'Orthodox Wonder-working Icons Series',1),(17,'Belarus\'s International Festivals Series',1),(18,'Magic of Dance',1),(19,'The Solar System Series',1),(20,'Chinese Calendar',1),(21,'Signs of the Zodiac. 2013',1),(22,'Orthodox Saints’ Lives Series',1),(23,'Zodiac Horoscope',1),(24,'Orthodox Saints. 2013',1),(25,'Skaryna’s Way',1),(26,'Belarussian History And Culture',2),(27,'Belarusian Cities',2),(28,'Belarusian Architectural Monuments',2),(29,'Belarusian Festivals and Rites',2),(30,'Strengthening and Defending the State',2),(31,'Belarusian Folk Legends',2),(32,'Belarusian Folk Trades and Crafts',2),(33,'Belarus\' Faiths Series',2),(34,'Belts of Slutsk',2),(35,'Sports',3),(36,'Olympic Belarus',3),(37,'Protection Of The Environment',4),(38,'Belarusian National Parks and Nature Reserves',4),(39,'Belarusian Nature Reserves',4),(40,'Bird of the Year',4),(41,'Horses',4),(42,'Belarusian Flowers',4),(43,'Beauty of Flowers',4),(44,'Butterflies',4),(45,'Revived Plants',4),(46,'My country Belarus',5),(47,'test series',6);
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
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `theme_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'BELARUS AND THE WORLD COMMUNITY',1,NULL),(2,'BELARUSIAN HISTORY AND CULTURE',1,NULL),(3,'SPORTS',1,NULL),(4,'PROTECTION OF THE ENVIRONMENT',1,NULL),(5,'MY COUNTRY BELARUS',1,NULL),(6,'test1',10,2),(9,'test theme',10,0);
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
  `userEmail` varchar(50) NOT NULL,
  `userPassword` varchar(100) NOT NULL,
  `role` varchar(15) NOT NULL,
  `userLogin` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_useremail_uindex` (`userEmail`),
  UNIQUE KEY `user_userLogin_uindex` (`userLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kiryl','admin@test.by','$2a$10$XIvTfkuXHHv3RJgGz5HpHO6WmX07ZtunPXlcKUK5d0.YpnM1IPpc2','ADMINISTRATOR','admin','Hrybouski'),(6,'TestUser6','test6@test.by','test6','USER','TestUser6','TestUserLastName6'),(7,'TestUser7','test7@test.by','test7','USER','TestUser7','TestUserLastName7'),(8,'TestUser8','test8@test.by','test8','USER','TestUser8','TestUserLastName8'),(9,'TestUser9','test9@test.by','test9','USER','TestUser9','TestUserLastName9\n'),(11,'TestUser11','test11@test.by','test11','USER','TestUser11','TestUserLastName11'),(12,'TestUser12','test12@test.by','test12','USER','TestUser12','TestUserLastName12'),(14,'TestUser13','moderator@test.by','moderator','MODERATOR','moderator','TestUserLastName13'),(15,'TestUser14','test14@test.by','test14','ADMINISTRATOR','TestUser14','TestUserLastName14'),(16,'User','user@test.by','$2a$10$yn2q3nl4wJ88KAxoyShXYehAHz28dJy0ljstUmXxYNjFmremFOHBu','USER','user','Test'),(18,'Ruslan','ruslan@test.by','$2a$10$op1j2ikE9xNPfgyv5VMuOejzhOfYxPrVvvW6cdqiRylfSnEgzEggq','MODERATOR','moder','Papina'),(21,'TestNameName','t@t.by','$2a$10$cD.W/9eBq6ljyr45BvyWSOxYjAWLGoB5NZCcRz1pRDvicjxjI04c2','USER','testLogin','TestNameName');
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

-- Dump completed on 2018-03-22 15:39:52
