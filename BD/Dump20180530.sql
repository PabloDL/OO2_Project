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
INSERT INTO `colectivo` VALUES (248,'100',2,'1'),(252,'100',2,'1'),(256,'100',2,'1'),(261,'100',2,'1'),(265,'100',2,'1'),(269,'100',2,'1'),(272,'100',2,'1'),(276,'100',2,'1'),(280,'100',2,'1'),(283,'100',2,'1'),(287,'100',2,'1'),(291,'100',2,'1'),(294,'100',2,'1'),(298,'100',2,'1'),(302,'100',2,'1'),(307,'100',2,'1'),(311,'100',2,'1'),(315,'100',2,'1'),(318,'100',2,'1'),(322,'100',2,'1'),(326,'100',2,'1'),(329,'100',2,'1'),(332,'100',2,'1'),(335,'100',2,'1'),(338,'100',2,'1'),(343,'100',2,'1'),(346,'100',2,'1'),(349,'100',2,'1'),(352,'100',2,'1'),(355,'100',2,'1'),(359,'100',2,'1'),(362,'100',2,'1'),(366,'100',2,'1'),(369,'100',2,'1'),(372,'100',2,'1'),(375,'100',2,'1'),(378,'100',2,'1'),(381,'100',2,'1'),(384,'100',2,'1'),(387,'100',2,'1'),(390,'100',2,'1'),(393,'100',2,'1'),(396,'100',2,'1'),(399,'100',2,'1'),(408,'100',2,'1'),(411,'100',2,'1'),(414,'100',2,'1'),(417,'100',2,'1'),(420,'100',2,'1'),(423,'100',2,'1'),(450,'100',2,'1'),(453,'100',2,'1'),(456,'100',2,'1'),(459,'100',2,'1'),(462,'100',2,'1'),(466,'100',2,'1'),(469,'100',2,'1'),(473,'100',2,'1'),(476,'100',2,'1'),(479,'100',2,'1'),(488,'100',2,'1'),(491,'100',2,'1'),(494,'100',2,'1'),(496,'100',3,'2'),(501,'100',2,'1'),(515,'100',2,'1'),(522,'100',2,'1'),(523,'100',2,'1'),(533,'100',3,'2'),(537,'100',3,'2');
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
  KEY `fk_persona_sube_idx` (`idSube`),
  CONSTRAINT `fk_persona_sube` FOREIGN KEY (`idSube`) REFERENCES `sube` (`idSube`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Nicolas','Goday','\0','\0',1,1,0),(2,'Nicolas','Fiasche','\0','\0',2,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sube`
--

LOCK TABLES `sube` WRITE;
/*!40000 ALTER TABLE `sube` DISABLE KEYS */;
INSERT INTO `sube` VALUES (1,1234,396,1),(2,1235,90.75,2);
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
INSERT INTO `subte` VALUES (246,'A'),(249,'A'),(253,'A'),(257,'A'),(259,'A'),(262,'A'),(266,'A'),(270,'A'),(273,'A'),(277,'A'),(281,'A'),(284,'A'),(288,'A'),(292,'A'),(295,'A'),(299,'A'),(303,'A'),(305,'A'),(308,'A'),(312,'A'),(316,'A'),(319,'A'),(320,'A'),(323,'A'),(324,'A'),(327,'A'),(330,'A'),(333,'A'),(336,'A'),(339,'A'),(340,'A'),(341,'A'),(344,'A'),(347,'A'),(350,'A'),(353,'A'),(356,'A'),(357,'A'),(360,'A'),(363,'A'),(364,'A'),(367,'A'),(370,'A'),(373,'A'),(376,'A'),(379,'A'),(382,'A'),(385,'A'),(388,'A'),(391,'A'),(394,'A'),(397,'A'),(400,'A'),(402,'A'),(404,'A'),(406,'A'),(409,'A'),(412,'A'),(415,'A'),(418,'A'),(421,'A'),(424,'A'),(426,'A'),(428,'A'),(430,'A'),(432,'A'),(434,'A'),(436,'A'),(438,'A'),(440,'A'),(442,'A'),(444,'A'),(446,'A'),(448,'A'),(451,'A'),(454,'A'),(457,'A'),(460,'A'),(463,'A'),(464,'A'),(467,'A'),(470,'A'),(471,'A'),(474,'A'),(477,'A'),(480,'B'),(484,'A'),(486,'A'),(489,'A'),(492,'A'),(498,'C'),(503,'A'),(509,'A'),(516,'A'),(517,'E'),(518,'E'),(519,'B'),(520,'A'),(521,'A'),(524,'A'),(525,'A'),(526,'B'),(527,'B'),(528,'B'),(529,'B'),(530,'A'),(531,'A');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=538 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(19),(20),(21),(22),(23),(24),(25),(26),(27),(28),(29),(30),(31),(32),(33),(34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(45),(46),(47),(48),(49),(50),(51),(52),(53),(54),(55),(56),(57),(58),(59),(60),(61),(62),(63),(64),(65),(66),(67),(68),(69),(70),(71),(72),(73),(74),(75),(76),(77),(78),(79),(80),(81),(82),(83),(84),(85),(86),(87),(88),(89),(90),(91),(92),(93),(94),(95),(96),(97),(98),(99),(100),(101),(102),(103),(104),(105),(106),(107),(108),(109),(110),(111),(112),(113),(114),(115),(116),(117),(118),(119),(120),(121),(122),(123),(124),(125),(126),(127),(128),(129),(130),(131),(132),(133),(134),(135),(136),(137),(138),(139),(140),(141),(142),(143),(144),(145),(146),(147),(148),(149),(150),(151),(152),(153),(154),(155),(156),(157),(158),(159),(160),(161),(162),(163),(164),(165),(166),(167),(168),(169),(170),(171),(172),(173),(174),(175),(176),(177),(178),(180),(181),(182),(183),(184),(185),(186),(187),(188),(189),(190),(191),(192),(193),(194),(195),(196),(197),(198),(199),(200),(201),(202),(203),(204),(205),(206),(207),(208),(209),(210),(211),(212),(213),(214),(215),(216),(217),(218),(219),(220),(221),(222),(223),(224),(225),(226),(227),(228),(229),(230),(231),(232),(233),(234),(235),(236),(237),(238),(239),(240),(241),(242),(243),(244),(245),(246),(247),(248),(249),(250),(251),(252),(253),(254),(255),(256),(257),(258),(259),(260),(261),(262),(263),(264),(265),(266),(267),(268),(269),(270),(271),(272),(273),(274),(275),(276),(277),(278),(279),(280),(281),(282),(283),(284),(285),(286),(287),(288),(289),(290),(291),(292),(293),(294),(295),(296),(297),(298),(299),(300),(301),(302),(303),(304),(305),(306),(307),(308),(309),(310),(311),(312),(313),(314),(315),(316),(317),(318),(319),(320),(321),(322),(323),(324),(325),(326),(327),(328),(329),(330),(331),(332),(333),(334),(335),(336),(337),(338),(339),(340),(341),(342),(343),(344),(345),(346),(347),(348),(349),(350),(351),(352),(353),(354),(355),(356),(357),(358),(359),(360),(361),(362),(363),(364),(365),(366),(367),(368),(369),(370),(371),(372),(373),(374),(375),(376),(377),(378),(379),(380),(381),(382),(383),(384),(385),(386),(387),(388),(389),(390),(391),(392),(393),(394),(395),(396),(397),(398),(399),(400),(401),(402),(403),(404),(405),(406),(407),(408),(409),(410),(411),(412),(413),(414),(415),(416),(417),(418),(419),(420),(421),(422),(423),(424),(425),(426),(427),(428),(429),(430),(431),(432),(433),(434),(435),(436),(437),(438),(439),(440),(441),(442),(443),(444),(445),(446),(447),(448),(449),(450),(451),(452),(453),(454),(455),(456),(457),(458),(459),(460),(461),(462),(463),(464),(465),(466),(467),(468),(469),(470),(471),(472),(473),(474),(475),(476),(477),(478),(479),(480),(481),(482),(483),(484),(485),(486),(487),(488),(489),(490),(491),(492),(493),(494),(495),(496),(497),(498),(499),(500),(501),(502),(503),(504),(505),(506),(507),(508),(509),(510),(511),(512),(513),(514),(515),(516),(517),(518),(519),(520),(521),(522),(523),(524),(525),(526),(527),(528),(529),(530),(531),(532),(533),(534),(535),(536),(537);
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
INSERT INTO `tren` VALUES (485,'Roca','Ezeiza','Temperley','-',NULL),(487,'Roca','Ezeiza','Temperley','Llavallol','2018-05-29 23:48:14'),(490,'Roca','Ezeiza','Temperley','Llavallol','2018-05-29 23:48:14'),(493,'Roca','Ezeiza','Llavallol','Temperley','2018-05-29 23:48:15'),(495,'Roca','Ezeiza','Constitucion','Lanus','2018-05-30 00:03:08'),(497,'Roca','Ezeiza','Constitucion','Lanus','2018-05-30 00:25:07'),(499,'Roca','Ezeiza','Constitucion','Llavallol','2018-05-30 00:29:59'),(500,'Roca','Ezeiza','Constitucion','Llavallol','2018-05-30 00:33:24'),(502,'Roca','Ezeiza','Llavallol','Constitucion','2018-05-30 00:34:21'),(504,'Roca','Ezeiza','Constitucion','-',NULL),(505,'Roca','Ezeiza','Llavallol','-',NULL),(506,'Roca','Ezeiza','Lanus','Constitucion','2018-05-30 01:06:33'),(507,'Roca','Ezeiza','Llavallol','-',NULL),(508,'Roca','Ezeiza','Constitucion','Llavallol','2018-05-30 01:40:35'),(510,'Roca','Ezeiza','Lanus','Constitucion','2018-05-30 01:43:02'),(511,'Roca','Ezeiza','Constitucion','-',NULL),(512,'Roca','Ezeiza','Lanus','Constitucion','2018-05-30 02:04:54'),(513,'Roca','Ezeiza','Llavallol','Constitucion','2018-05-30 02:06:15'),(514,'Roca','Ezeiza','Constitucion','Temperley','2018-05-30 02:14:46'),(532,'Roca','Ezeiza','Temperley','Constitucion','2018-05-30 10:46:12'),(534,'Roca','Ezeiza','Constitucion','Temperley','2018-05-30 11:04:00'),(535,'Roca','Ezeiza','Constitucion','Temperley','2018-05-30 11:05:30'),(536,'Roca','Ezeiza','Lanus','Llavallol','2018-05-30 11:07:17');
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
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
INSERT INTO `viaje` VALUES (40,4,'2018-05-30 11:06:54',1,536),(41,9.25,'2018-05-30 11:09:08',2,537);
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

-- Dump completed on 2018-05-30 13:33:32
