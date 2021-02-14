UNLOCK TABLES;

CREATE DATABASE  IF NOT EXISTS `spring_projects` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring_projects`;


DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `id_value` varchar(45) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `born_city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


LOCK TABLES `clients` WRITE;


INSERT INTO `clients` VALUES 
	(1,'Santiago','Garcia Arango','cc','1234',21,'Medellin'),
	(2,'Juan Guillermo','Rodriguez Rodriguez','cc','6789',75,'Pereira'),
	(3,'Monica','Hill Donadio','cc','6432',22,'Medellin'),
	(4,'Manuela','Paris Monsalve','cc','9876',28,'Santa Elena'),
	(5,'Daniel Andres','Vahos Mendoza','cc','5566',35,'Jardin'),
	(6,'Manuela','Medina Gomez','cc','4567',45,'Envigado');

UNLOCK TABLES;



