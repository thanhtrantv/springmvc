-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cafedb
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `iditem` varchar(5) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('it1','Cocacola',10),('it2','Cafe Den',8),('it3','cafe Sua',10),('it4','Cam',15);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `idorder` varchar(5) NOT NULL,
  `idtable` int(11) DEFAULT NULL,
  `iduser` varchar(10) DEFAULT NULL,
  `sum` decimal(10,2) DEFAULT NULL,
  `idstatus` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`idorder`),
  KEY `iduser_idx` (`iduser`),
  KEY `idtable_idx` (`idtable`),
  KEY `idstatus_idx` (`idstatus`),
  KEY `idstatus_idx1` (`idstatus`),
  KEY `idstatus_idx2` (`idstatus`),
  CONSTRAINT `idstatus1` FOREIGN KEY (`idstatus`) REFERENCES `status` (`idstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idtable` FOREIGN KEY (`idtable`) REFERENCES `table` (`idtable`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('001',1,'user1',66.00,'DTT'),('0010',3,'user1',28.00,'DTT'),('0011',3,'user1',10.00,'DTT'),('0012',4,'user1',10.00,'DTT'),('0013',4,'user1',10.00,'DTT'),('0014',1,'user1',25.00,'DTT'),('0015',2,'user1',48.00,'DTT'),('0016',3,'user1',10.00,'DTT'),('0017',1,'user1',35.00,'DTT'),('0018',1,'user1',23.00,'DTT'),('0019',2,'user1',15.00,'DTT'),('002',2,'user1',58.00,'DTT'),('0020',1,'user1',40.00,'DTT'),('0021',2,'user1',30.00,'DTT'),('0022',4,'user1',8.00,'DTT'),('0023',1,'user1',38.00,'CTT'),('003',3,'user2',106.00,'DTT'),('004',1,'user2',74.00,'DTT'),('005',3,NULL,0.00,'CTT'),('006',3,'user1',8.00,'DTT'),('007',2,'user1',18.00,'DTT'),('008',1,'user1',30.00,'DTT'),('009',3,'user1',10.00,'DTT');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `iditem` varchar(5) NOT NULL,
  `time` datetime DEFAULT NULL,
  `idorder` varchar(5) NOT NULL,
  `idstatus` varchar(5) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`iditem`,`idorder`),
  KEY `idstatus_idx` (`idstatus`),
  KEY `idorder_idx` (`idorder`),
  CONSTRAINT `iditem` FOREIGN KEY (`iditem`) REFERENCES `item` (`iditem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idorder` FOREIGN KEY (`idorder`) REFERENCES `order` (`idorder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idstatus` FOREIGN KEY (`idstatus`) REFERENCES `status` (`idstatus`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES ('it1',NULL,'001','CL',3),('it1',NULL,'0010','CL',1),('it1',NULL,'0012','CL',1),('it1',NULL,'0014','CL',1),('it1',NULL,'0017','CL',1),('it1',NULL,'002','CL',4),('it1',NULL,'0020','CL',1),('it1',NULL,'0021','CL',1),('it1',NULL,'0023','CL',1),('it1',NULL,'003','CL',2),('it1',NULL,'004','CL',3),('it1',NULL,'007','CL',1),('it1',NULL,'008','CL',1),('it2',NULL,'001','DL',2),('it2',NULL,'0010','CL',1),('it2',NULL,'0015','CL',1),('it2',NULL,'0018','CL',1),('it2',NULL,'002','CL',1),('it2',NULL,'0022','CL',1),('it2',NULL,'0023','CL',1),('it2',NULL,'003','CL',2),('it2',NULL,'004','CL',3),('it2',NULL,'006','CL',1),('it2',NULL,'007','CL',1),('it3',NULL,'001','CL',2),('it3',NULL,'0010','CL',1),('it3',NULL,'0011','CL',1),('it3',NULL,'0013','CL',1),('it3',NULL,'0015','CL',1),('it3',NULL,'0016','CL',1),('it3',NULL,'0017','CL',1),('it3',NULL,'002','CL',1),('it3',NULL,'0021','CL',2),('it3',NULL,'0023','CL',2),('it3',NULL,'003','CL',7),('it3',NULL,'004','CL',2),('it3',NULL,'008','CL',2),('it3',NULL,'009','CL',1),('it4',NULL,'0014','CL',1),('it4',NULL,'0015','CL',2),('it4',NULL,'0017','CL',1),('it4',NULL,'0018','CL',1),('it4',NULL,'0019','CL',1),('it4',NULL,'0020','CL',2);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `idRole` varchar(45) NOT NULL,
  `namerole` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('BB','Boi Ban'),('PC','Pha che'),('QL','Quan ly');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `idstatus` varchar(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES ('CL','Chua lam'),('CTT','Chua Thanh Toan'),('DG','Da Giao'),('DL','Dang lam'),('DTT','Da Thanh Toan'),('LX','Lam xong');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table`
--

DROP TABLE IF EXISTS `table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table` (
  `idtable` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table`
--

LOCK TABLES `table` WRITE;
/*!40000 ALTER TABLE `table` DISABLE KEYS */;
INSERT INTO `table` VALUES (1,'b1'),(2,'a1'),(3,'a2'),(4,'a1');
/*!40000 ALTER TABLE `table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` varchar(10) NOT NULL,
  `idrole` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  KEY `idrole_idx` (`idrole`),
  CONSTRAINT `idrole` FOREIGN KEY (`idrole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1',NULL,NULL,NULL,NULL),('user1','BB','test@gmail.com','123','Nguyen Van A'),('user2','PC','test1@gmail.com','123','Nguyen Thi B'),('user3','QL','test2@gmail.com','123','Nguyen Van C');
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

-- Dump completed on 2018-03-31 14:29:29
