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
INSERT INTO `colectivo` VALUES (562,'100',3,'2'),(573,'100',3,'2'),(575,'100',3,'2'),(577,'100',3,'2');
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
INSERT INTO `datosfuncionales` VALUES (1,9,3,7.5,10.75,6.25,9,9.25,9.5,10.25,10.75,1000,-20,2,1,1,1,0.55,0.55,0.55,0.5,0.75);
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
INSERT INTO `estacionseccion` VALUES (1,2,1),(2,3,1),(3,4,1),(1,3,2),(2,4,2),(1,4,3);
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
  KEY `fk_sube_person_idx` (`idSube`),
  CONSTRAINT `fk_sube_person` FOREIGN KEY (`idSube`) REFERENCES `sube` (`idSube`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Nicolas','Goday','\0','\0',1,1,0),(2,'Nicolas','Fiasche','\0','',2,1,1),(3,'Pablo','De Lafore','','\0',3,1,2),(4,'Agustin','Gutierrez','','',4,1,3),(17,'Harry','Potter','','',5,NULL,2032323),(18,'Dominic','Thiem','','\0',8,NULL,12232323),(19,'Pedro','Sanchez','','\0',6,NULL,33333);
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
  `primerViajeRedSube` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSube`),
  KEY `fk_ultimoViaje_sube_idx` (`primerViajeRedSube`),
  CONSTRAINT `fk_ultimoViaje_sube` FOREIGN KEY (`primerViajeRedSube`) REFERENCES `viaje` (`idviaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sube`
--

LOCK TABLES `sube` WRITE;
/*!40000 ALTER TABLE `sube` DISABLE KEYS */;
INSERT INTO `sube` VALUES (1,1234,524.4375,1,73),(2,1235,83.25,2,70),(3,2222,92.5,3,71),(4,3333,100,4,74),(5,6666,233,17,NULL),(6,7777,492.5,19,75),(7,8888,0,NULL,NULL),(8,9999,-7.5,18,76),(9,12344323,0,NULL,NULL);
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
INSERT INTO `subte` VALUES (558,'A'),(559,'C'),(560,'A'),(563,'B'),(564,'A'),(565,'A'),(566,'C'),(567,'A'),(568,'A'),(569,'A'),(570,'A'),(571,'B'),(574,'B'),(576,'D'),(578,'A'),(579,'A'),(580,'A'),(581,'A'),(582,'A'),(583,'A'),(584,'A'),(585,'A'),(586,'A'),(587,'A'),(588,'B'),(589,'A'),(590,'A'),(591,'A'),(592,'C'),(593,'A'),(594,'A'),(595,'A'),(596,'A'),(597,'A'),(598,'A'),(599,'A'),(600,'A'),(601,'A'),(602,'B');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='	';
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminaltren`
--

LOCK TABLES `terminaltren` WRITE;
/*!40000 ALTER TABLE `terminaltren` DISABLE KEYS */;
INSERT INTO `terminaltren` VALUES (5,'Roca','Ezeiza','Constitucion'),(9,'Roca','Ezeiza','Lanus'),(13,'Roca','Ezeiza','Temperley'),(14,'Roca','Ezeiza','Llavallol');
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
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (503),(504),(505),(506),(507),(508),(509),(510),(511),(512),(513),(514),(515),(516),(517),(518),(519),(520),(521),(522),(523),(524),(525),(526),(527),(528),(529),(530),(531),(532),(533),(534),(535),(536),(537),(538),(539),(540),(541),(542),(543),(544),(545),(546),(547),(548),(549),(550),(551),(552),(553),(554),(555),(556),(557),(558),(559),(560),(561),(562),(563),(564),(565),(566),(567),(568),(569),(570),(571),(572),(573),(574),(575),(576),(577),(578),(579),(580),(581),(582),(583),(584),(585),(586),(587),(588),(589),(590),(591),(592),(593),(594),(595),(596),(597),(598),(599),(600),(601),(602);
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
INSERT INTO `tren` VALUES (561,'Roca','Ezeiza','Lanus','Llavallol','2018-06-08 21:27:33'),(572,'Roca','Ezeiza','Constitucion','Llavallol','2018-06-09 00:47:02');
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
  `administrador` bit(1) DEFAULT b'0',
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
  CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`idusuario`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (18,'domThi','222','');
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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (55,7.5,'2018-06-07 21:51:11',1,558),(56,7.5,'2018-06-08 21:27:03',1,560),(57,2,'2018-06-08 21:27:24',1,561),(58,2.3125,'2018-06-08 21:27:52',1,562),(59,1.875,'2018-06-08 23:59:16',1,565),(62,7.5,'2018-06-09 00:18:07',1,570),(63,7.5,'2018-06-09 00:18:38',1,571),(64,2.75,'2018-06-09 00:46:15',1,572),(65,2.3125,'2018-06-09 00:47:43',1,573),(66,1.875,'2018-06-09 00:48:57',1,574),(67,2.3125,'2018-06-09 00:49:44',1,575),(68,1.875,'2018-06-09 00:50:41',1,576),(69,9.5,'2018-06-09 00:51:03',1,577),(70,0,'2018-06-09 01:40:10',2,592),(71,7.5,'2018-06-09 01:40:42',3,593),(72,3.75,'2018-06-09 01:41:06',1,594),(73,7.5,'2018-06-09 20:38:23',1,595),(74,0,'2018-06-09 20:39:49',4,598),(75,7.5,'2018-06-10 12:49:16',6,601),(76,7.5,'2018-06-10 23:36:41',8,602);
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

-- Dump completed on 2018-06-11 19:04:43
