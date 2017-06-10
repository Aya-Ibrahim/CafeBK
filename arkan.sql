CREATE DATABASE  IF NOT EXISTS `arkancafe` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `arkancafe`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: arkancafe
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `addition`
--

DROP TABLE IF EXISTS `addition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addition` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT,
  `add_name` varchar(50) NOT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addition`
--

LOCK TABLES `addition` WRITE;
/*!40000 ALTER TABLE `addition` DISABLE KEYS */;
INSERT INTO `addition` VALUES (1,'سكر',NULL,NULL),(2,'ملح',NULL,NULL);
/*!40000 ALTER TABLE `addition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafe_table`
--

DROP TABLE IF EXISTS `cafe_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cafe_table` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(25) NOT NULL,
  `empty` tinyint(1) NOT NULL,
  `lastOrder` int(11) DEFAULT NULL,
  PRIMARY KEY (`table_id`),
  KEY `lastOrder_idx` (`lastOrder`),
  CONSTRAINT `lastOrder` FOREIGN KEY (`lastOrder`) REFERENCES `order` (`order_id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafe_table`
--

LOCK TABLES `cafe_table` WRITE;
/*!40000 ALTER TABLE `cafe_table` DISABLE KEYS */;
INSERT INTO `cafe_table` VALUES (3,'one',1,NULL),(4,'two',0,2);
/*!40000 ALTER TABLE `cafe_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `tab_id` int(11) NOT NULL,
  `game_name` varchar(100) NOT NULL,
  `base_unit` varchar(25) NOT NULL,
  `base_price` decimal(10,3) NOT NULL,
  `isActive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`game_id`),
  KEY `tab_id` (`tab_id`),
  CONSTRAINT `game_ibfk_1` FOREIGN KEY (`tab_id`) REFERENCES `tab` (`tab_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,4,'بينج بونج','ساعه',10.000,1),(2,4,'بلاى استيشن','ساعه',20.000,1);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_line`
--

DROP TABLE IF EXISTS `game_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game_line` (
  `gameLine_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `game_Id` int(11) NOT NULL,
  `price` decimal(10,3) NOT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `period` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`gameLine_id`),
  KEY `order_id` (`order_id`,`game_Id`),
  KEY `service_id` (`game_Id`),
  CONSTRAINT `gameLine_game_fk` FOREIGN KEY (`game_Id`) REFERENCES `game` (`game_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `game_line_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_line`
--

LOCK TABLES `game_line` WRITE;
/*!40000 ALTER TABLE `game_line` DISABLE KEYS */;
INSERT INTO `game_line` VALUES (2,2,1,20.000,NULL,NULL,2.000),(3,2,2,10.000,NULL,NULL,1.000);
/*!40000 ALTER TABLE `game_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `ing_id` int(11) NOT NULL AUTO_INCREMENT,
  `ing_name` varchar(50) NOT NULL,
  `available_Qty` int(11) NOT NULL,
  `base_price` int(11) NOT NULL,
  `base_unit_id` int(11) NOT NULL,
  `threshold` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ing_id`),
  KEY `base_unit_id` (`base_unit_id`),
  CONSTRAINT `ingredient_ibfk_1` FOREIGN KEY (`base_unit_id`) REFERENCES `unit` (`unit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL,
  `service_id` int(11) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `price` decimal(10,3) NOT NULL,
  PRIMARY KEY (`item_id`),
  KEY `cat_id` (`service_id`),
  CONSTRAINT `service_fk` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'شاى ',1,1,1,1.500),(2,'شاى فتله ',1,0,2,2.000),(3,'قهوه ',1,0,3,3.000),(4,'شيشه تفاح',2,1,1,10.000);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_has_addition`
--

DROP TABLE IF EXISTS `item_has_addition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_has_addition` (
  `item_addition_Id` int(11) NOT NULL AUTO_INCREMENT,
  `item_item_id` int(11) NOT NULL,
  `addition_add_id` int(11) NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_addition_Id`),
  KEY `fk_item_has_addition_addition1_idx` (`addition_add_id`),
  KEY `fk_item_has_addition_item1_idx` (`item_item_id`),
  CONSTRAINT `fk_item_has_addition_addition1` FOREIGN KEY (`addition_add_id`) REFERENCES `addition` (`add_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_has_addition_item1` FOREIGN KEY (`item_item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_has_addition`
--

LOCK TABLES `item_has_addition` WRITE;
/*!40000 ALTER TABLE `item_has_addition` DISABLE KEYS */;
INSERT INTO `item_has_addition` VALUES (1,1,1,NULL,NULL),(2,2,1,NULL,NULL),(3,3,1,NULL,NULL);
/*!40000 ALTER TABLE `item_has_addition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_ingredient`
--

DROP TABLE IF EXISTS `item_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_ingredient` (
  `item_ingredient_Id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `ing_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`item_ingredient_Id`),
  KEY `unit_id` (`unit_id`),
  KEY `item_id` (`item_id`),
  KEY `item_ingredient_ibfk_2` (`ing_id`),
  CONSTRAINT `item_ingredient_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_ingredient_ibfk_2` FOREIGN KEY (`ing_id`) REFERENCES `ingredient` (`ing_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `item_ingredient_ibfk_3` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_ingredient`
--

LOCK TABLES `item_ingredient` WRITE;
/*!40000 ALTER TABLE `item_ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `voucher_number` varchar(25) NOT NULL,
  `order_Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `table_id` int(11) NOT NULL,
  `is_closed` tinyint(1) NOT NULL,
  `closedDate` datetime DEFAULT NULL,
  `cashier_id` int(11) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `table_id` (`table_id`,`cashier_id`),
  KEY `cashier_id` (`cashier_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `cafe_table` (`table_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`cashier_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (2,'4242','2017-06-03 13:09:01',4,0,NULL,NULL,'NEW');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline`
--

DROP TABLE IF EXISTS `orderline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderline` (
  `orderline_Id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(25) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderline_Id`),
  KEY `item_id` (`item_id`,`order_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `orderline_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderline_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline`
--

LOCK TABLES `orderline` WRITE;
/*!40000 ALTER TABLE `orderline` DISABLE KEYS */;
INSERT INTO `orderline` VALUES (6,1,2,'2017-06-03 13:11:44','NEW',5,1),(7,3,2,'2017-06-03 13:11:44','NEW',10,1),(8,4,2,'2017-06-03 20:00:09','NEW',10,1);
/*!40000 ALTER TABLE `orderline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderline_addition`
--

DROP TABLE IF EXISTS `orderline_addition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderline_addition` (
  `order_addition_id` int(11) NOT NULL AUTO_INCREMENT,
  `addition_id` int(11) NOT NULL,
  `orderLine_id` int(11) NOT NULL,
  `quantity` decimal(10,0) NOT NULL,
  PRIMARY KEY (`order_addition_id`),
  KEY `addition_id` (`addition_id`,`orderLine_id`),
  KEY `orderLine_id` (`orderLine_id`),
  CONSTRAINT `orderline_addition_ibfk_1` FOREIGN KEY (`addition_id`) REFERENCES `item_has_addition` (`item_addition_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderline_addition_ibfk_2` FOREIGN KEY (`orderLine_id`) REFERENCES `orderline` (`orderline_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderline_addition`
--

LOCK TABLES `orderline_addition` WRITE;
/*!40000 ALTER TABLE `orderline_addition` DISABLE KEYS */;
INSERT INTO `orderline_addition` VALUES (1,1,6,4),(2,3,7,2);
/*!40000 ALTER TABLE `orderline_addition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(50) NOT NULL,
  `tab_id` int(11) NOT NULL,
  PRIMARY KEY (`service_id`),
  KEY `tab_id` (`tab_id`),
  CONSTRAINT `service_ibfk_1` FOREIGN KEY (`tab_id`) REFERENCES `tab` (`tab_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'مشروبات',2),(2,'ركن الشيشه',3);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab`
--

DROP TABLE IF EXISTS `tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab` (
  `tab_id` int(11) NOT NULL AUTO_INCREMENT,
  `tab_name` varchar(50) NOT NULL,
  PRIMARY KEY (`tab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab`
--

LOCK TABLES `tab` WRITE;
/*!40000 ALTER TABLE `tab` DISABLE KEYS */;
INSERT INTO `tab` VALUES (2,'مشروبات'),(3,'ركن الشيشه'),(4,'الالعاب');
/*!40000 ALTER TABLE `tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `tx_id` int(11) NOT NULL AUTO_INCREMENT,
  `ing_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `quantity` decimal(10,0) NOT NULL,
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tx_id`),
  KEY `ing_id` (`ing_id`),
  KEY `fk_transaction_orders1_idx` (`order_id`),
  CONSTRAINT `fk_transaction_orders1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`ing_id`) REFERENCES `ingredient` (`ing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tx_adjustment`
--

DROP TABLE IF EXISTS `tx_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tx_adjustment` (
  `adjustment_id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_ing_id` int(11) NOT NULL,
  `added_qty` decimal(10,0) NOT NULL,
  PRIMARY KEY (`adjustment_id`),
  KEY `fk_tx_adjustment_ingredient1_idx` (`ingredient_ing_id`),
  CONSTRAINT `fk_tx_adjustment_ingredient1` FOREIGN KEY (`ingredient_ing_id`) REFERENCES `ingredient` (`ing_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tx_adjustment`
--

LOCK TABLES `tx_adjustment` WRITE;
/*!40000 ALTER TABLE `tx_adjustment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tx_adjustment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit` (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_unit_id` int(11) NOT NULL,
  `unit_name` varchar(50) NOT NULL,
  `conversion` int(11) NOT NULL,
  PRIMARY KEY (`unit_id`),
  KEY `base_unit_id` (`base_unit_id`),
  CONSTRAINT `unit_ibfk_1` FOREIGN KEY (`base_unit_id`) REFERENCES `unit` (`unit_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2017-06-10 13:10:34
