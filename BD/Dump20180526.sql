-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sube
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `colectivo`
--

DROP TABLE IF EXISTS `colectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colectivo` (
  `idcolectivo` int(11) NOT NULL,
  `linea` varchar(25) NOT NULL,
  `numero` int(11) NOT NULL,
  `ramal` varchar(25) NOT NULL,
  PRIMARY KEY (`idcolectivo`),
  CONSTRAINT `fk_colectivo_1` FOREIGN KEY (`idcolectivo`) REFERENCES `transporte` (`idtransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colectivo`
--

LOCK TABLES `colectivo` WRITE;
/*!40000 ALTER TABLE `colectivo` DISABLE KEYS */;
INSERT INTO `colectivo` VALUES (233,'100',2,'1'),(236,'100',2,'1'),(239,'100',2,'1'),(242,'100',2,'1'),(245,'100',2,'1');
/*!40000 ALTER TABLE `colectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datosfuncionales`
--

DROP TABLE IF EXISTS `datosfuncionales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datosfuncionales` (
  `idDatosFuncionales` int(11) NOT NULL AUTO_INCREMENT,
  `precioMinimoColectivo` double DEFAULT NULL,
  `precioMinimoTren` double DEFAULT NULL,
  `precioMinimoSubte` double DEFAULT NULL,
  `precioMaximoColectivo` double DEFAULT NULL,
  `precioMaximoTren` double DEFAULT NULL,
  `precioTramo1Colectivo` double DEFAULT NULL,
  `precioTramo2Colectivo` double DEFAULT NULL,
  `precioTramo3Colectivo` double DEFAULT NULL,
  `precioTramo4Colectivo` double DEFAULT NULL,
  `precioTramo5Colectivo` double DEFAULT NULL,
  `saldoMaximo` double DEFAULT NULL,
  `saldoMaximoNegativo` double DEFAULT NULL,
  `tiempoRedSube` double DEFAULT NULL,
  `precioEstudiantilColectivo` double DEFAULT NULL,
  `precioEstudiantilSubte` double DEFAULT NULL,
  `precioEstudiantilTren` double DEFAULT NULL,
  `precioAsignacionColectivo` double DEFAULT NULL,
  `precioAsignacionSubte` double DEFAULT NULL,
  `precioAsignacionTren` double DEFAULT NULL,
  `porcentajeDescuentoEtapa1` double DEFAULT NULL,
  `porcentajeDescuentoEtapa2` double DEFAULT NULL,
  PRIMARY KEY (`idDatosFuncionales`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosfuncionales`
--

LOCK TABLES `datosfuncionales` WRITE;
/*!40000 ALTER TABLE `datosfuncionales` DISABLE KEYS */;
INSERT INTO `datosfuncionales` VALUES (1,10,3,7.5,12,6,9,9.25,9.5,9.75,10,800,-20,2,0.550000011920929,0.550000011920929,0.550000011920929,0.550000011920929,0,0.550000011920929,0.5,0.75);
/*!40000 ALTER TABLE `datosfuncionales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacion`
--

DROP TABLE IF EXISTS `estacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacion` (
  `idEstacion` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion`
--

LOCK TABLES `estacion` WRITE;
/*!40000 ALTER TABLE `estacion` DISABLE KEYS */;
INSERT INTO `estacion` VALUES (1,'Llavallol'),(2,'Temperley'),(3,'Lanus'),(4,'Constitucion');
/*!40000 ALTER TABLE `estacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionseccion`
--

DROP TABLE IF EXISTS `estacionseccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionseccion` (
  `idEstacion1` int(11) NOT NULL,
  `idEstacion2` int(11) NOT NULL,
  `idSeccion` int(11) NOT NULL,
  PRIMARY KEY (`idEstacion1`,`idSeccion`,`idEstacion2`),
  KEY `fk_estacion_has_seccion_seccion1_idx` (`idSeccion`),
  KEY `fk_estacion_has_seccion_estacion1_idx` (`idEstacion1`),
  KEY `idEstacion2_idx` (`idEstacion2`),
  CONSTRAINT `fk_estacion_has_seccion_estacion1` FOREIGN KEY (`idEstacion1`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estacion_has_seccion_seccion1` FOREIGN KEY (`idSeccion`) REFERENCES `seccion` (`idSeccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idEstacion2` FOREIGN KEY (`idEstacion2`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionseccion`
--

LOCK TABLES `estacionseccion` WRITE;
/*!40000 ALTER TABLE `estacionseccion` DISABLE KEYS */;
INSERT INTO `estacionseccion` VALUES (1,2,1),(1,3,2),(1,4,3),(2,3,1),(2,4,2),(3,4,1);
/*!40000 ALTER TABLE `estacionseccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `esTarifaSocial` bit(1) NOT NULL DEFAULT b'0',
  `esTarifaEstudiantil` bit(1) NOT NULL DEFAULT b'0',
  `idSube` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `dni` int(11) NOT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `fk_persona_usuario1_idx` (`idusuario`),
  KEY `fk_persona_sube_idx` (`idSube`),
  CONSTRAINT `fk_persona_sube` FOREIGN KEY (`idSube`) REFERENCES `sube` (`idSube`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Nicolas','Goday','\0','\0',1,1,0),(2,'Nicolas','Goday','','',NULL,NULL,33401014),(3,'Nicolas','Goday','','',NULL,NULL,33401020);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccion` (
  `idSeccion` int(11) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`idSeccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,2.75),(2,4),(3,5.5);
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sube`
--

DROP TABLE IF EXISTS `sube`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sube` (
  `idSube` int(11) NOT NULL AUTO_INCREMENT,
  `numeroSube` int(16) NOT NULL,
  `saldo` double NOT NULL,
  `idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSube`),
  KEY `idPersona_idx` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sube`
--

LOCK TABLES `sube` WRITE;
/*!40000 ALTER TABLE `sube` DISABLE KEYS */;
INSERT INTO `sube` VALUES (1,1234,711.25,1);
/*!40000 ALTER TABLE `sube` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subte`
--

DROP TABLE IF EXISTS `subte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subte` (
  `idsubte` int(11) NOT NULL,
  `linea` varchar(5) NOT NULL,
  PRIMARY KEY (`idsubte`),
  CONSTRAINT `fk_subte_1` FOREIGN KEY (`idsubte`) REFERENCES `transporte` (`idtransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subte`
--

LOCK TABLES `subte` WRITE;
/*!40000 ALTER TABLE `subte` DISABLE KEYS */;
INSERT INTO `subte` VALUES (231,'A'),(234,'A'),(237,'A'),(240,'A'),(243,'A');
/*!40000 ALTER TABLE `subte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminalcolectivo`
--

DROP TABLE IF EXISTS `terminalcolectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminalcolectivo` (
  `idterminalcolectivo` int(11) NOT NULL AUTO_INCREMENT,
  `linea` varchar(45) DEFAULT NULL,
  `ramal` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idterminalcolectivo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminalcolectivo`
--

LOCK TABLES `terminalcolectivo` WRITE;
/*!40000 ALTER TABLE `terminalcolectivo` DISABLE KEYS */;
INSERT INTO `terminalcolectivo` VALUES (22,'100','1',2),(23,'100','2',3),(24,'100','3',4),(25,'295','Cordoba',5),(26,'295','Madariaga',6),(27,'295','Magan',7),(28,'299','A',8),(29,'299','B',9);
/*!40000 ALTER TABLE `terminalcolectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminalsubte`
--

DROP TABLE IF EXISTS `terminalsubte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminalsubte` (
  `idterminalSubte` int(11) NOT NULL AUTO_INCREMENT,
  `letra` char(1) DEFAULT NULL,
  PRIMARY KEY (`idterminalSubte`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminalsubte`
--

LOCK TABLES `terminalsubte` WRITE;
/*!40000 ALTER TABLE `terminalsubte` DISABLE KEYS */;
INSERT INTO `terminalsubte` VALUES (16,'A'),(17,'B'),(18,'C'),(19,'D'),(20,'E'),(21,'H');
/*!40000 ALTER TABLE `terminalsubte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminaltren`
--

DROP TABLE IF EXISTS `terminaltren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminaltren` (
  `idterminaltren` int(11) NOT NULL AUTO_INCREMENT,
  `linea` varchar(45) DEFAULT NULL,
  `ramal` varchar(45) DEFAULT NULL,
  `estacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idterminaltren`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminaltren`
--

LOCK TABLES `terminaltren` WRITE;
/*!40000 ALTER TABLE `terminaltren` DISABLE KEYS */;
INSERT INTO `terminaltren` VALUES (5,'Roca','Ezeiza','Constitucion'),(6,'Roca','Ezeiza','Irigoyen'),(7,'Roca','Ezeiza','Avellaneda'),(8,'Roca','Ezeiza','Gerli'),(9,'Roca','Ezeiza','Lanus'),(10,'Roca','Ezeiza','Escalada'),(11,'Roca','Ezeiza','Banfield'),(12,'Roca','Ezeiza','Lomas de Zamora'),(13,'Roca','Ezeiza','Temperley'),(14,'Roca','Ezeiza','LLavallol'),(15,'Roca','Ezeiza','Turdera');
/*!40000 ALTER TABLE `terminaltren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transporte`
--

DROP TABLE IF EXISTS `transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transporte` (
  `idtransporte` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idtransporte`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(19),(20),(21),(22),(23),(24),(25),(26),(27),(28),(29),(30),(31),(32),(33),(34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(45),(46),(47),(48),(49),(50),(51),(52),(53),(54),(55),(56),(57),(58),(59),(60),(61),(62),(63),(64),(65),(66),(67),(68),(69),(70),(71),(72),(73),(74),(75),(76),(77),(78),(79),(80),(81),(82),(83),(84),(85),(86),(87),(88),(89),(90),(91),(92),(93),(94),(95),(96),(97),(98),(99),(100),(101),(102),(103),(104),(105),(106),(107),(108),(109),(110),(111),(112),(113),(114),(115),(116),(117),(118),(119),(120),(121),(122),(123),(124),(125),(126),(127),(128),(129),(130),(131),(132),(133),(134),(135),(136),(137),(138),(139),(140),(141),(142),(143),(144),(145),(146),(147),(148),(149),(150),(151),(152),(153),(154),(155),(156),(157),(158),(159),(160),(161),(162),(163),(164),(165),(166),(167),(168),(169),(170),(171),(172),(173),(174),(175),(176),(177),(178),(180),(181),(182),(183),(184),(185),(186),(187),(188),(189),(190),(191),(192),(193),(194),(195),(196),(197),(198),(199),(200),(201),(202),(203),(204),(205),(206),(207),(208),(209),(210),(211),(212),(213),(214),(215),(216),(217),(218),(219),(220),(221),(222),(223),(224),(225),(226),(227),(228),(229),(230),(231),(232),(233),(234),(235),(236),(237),(238),(239),(240),(241),(242),(243),(244),(245);
/*!40000 ALTER TABLE `transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tren`
--

DROP TABLE IF EXISTS `tren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tren` (
  `idtren` int(11) NOT NULL,
  `linea` varchar(20) NOT NULL,
  `ramal` varchar(20) NOT NULL,
  `estacionOrigen` varchar(20) NOT NULL,
  `estacionDestino` varchar(20) NOT NULL,
  `fechaHoraSalida` datetime DEFAULT NULL,
  PRIMARY KEY (`idtren`),
  CONSTRAINT `fk_tren_1` FOREIGN KEY (`idtren`) REFERENCES `transporte` (`idtransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tren`
--

LOCK TABLES `tren` WRITE;
/*!40000 ALTER TABLE `tren` DISABLE KEYS */;
INSERT INTO `tren` VALUES (230,'Roca','Ezeiza','Constitucion','Irigoyen',NULL),(232,'Roca','Ezeiza','Constitucion','Irigoyen',NULL),(235,'Roca','Ezeiza','Constitucion','Irigoyen',NULL),(238,'Roca','Ezeiza','Constitucion','Irigoyen',NULL),(241,'Roca','Ezeiza','Constitucion','Irigoyen',NULL),(244,'Roca','Ezeiza','Constitucion','Irigoyen','2018-05-25 17:24:29');
/*!40000 ALTER TABLE `tren` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`idusuario`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje` (
  `idviaje` int(11) NOT NULL AUTO_INCREMENT,
  `tarifa` double NOT NULL,
  `fechaYHora` datetime DEFAULT NULL,
  `idSube` int(11) NOT NULL,
  `idtransporte` int(11) NOT NULL,
  PRIMARY KEY (`idviaje`,`idSube`,`idtransporte`),
  KEY `idTransporte_idx` (`idtransporte`),
  KEY `fk_viajes_sube_idx` (`idSube`),
  CONSTRAINT `fk_viajes_sube` FOREIGN KEY (`idSube`) REFERENCES `sube` (`idSube`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_viajes_transporte1` FOREIGN KEY (`idtransporte`) REFERENCES `transporte` (`idtransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (214,7.5,'2018-05-25 17:05:16',1,231),(215,2,'2018-05-25 17:05:17',1,232),(216,4.5,'2018-05-25 17:05:17',1,233),(217,3.75,'2018-05-25 17:08:27',1,234),(218,2,'2018-05-25 17:08:27',1,235),(219,4.5,'2018-05-25 17:08:28',1,236),(220,3.75,'2018-05-25 17:11:41',1,237),(221,2,'2018-05-25 17:12:26',1,238),(222,4.5,'2018-05-25 17:15:33',1,239),(223,3.75,'2018-05-25 17:15:57',1,240),(224,2,'2018-05-25 17:15:57',1,241),(225,4.5,'2018-05-25 17:15:58',1,242),(226,3.75,'2018-05-25 17:24:29',1,243),(227,2,'2018-05-25 17:24:29',1,244),(228,4.5,'2018-05-25 17:24:29',1,245);
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-26 19:05:58
