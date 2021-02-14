UNLOCK TABLES;

CREATE DATABASE  IF NOT EXISTS `spring_projects` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring_projects`;


DROP TABLE IF EXISTS `developers`;

CREATE TABLE `developers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `main_language` varchar(50) DEFAULT NULL,
  `birthday_date` date DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


LOCK TABLES `developers` WRITE;
 
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (1,'Santiago Garcia','Python','1986-01-15','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (2,'Monica Lopez','JavaScript','1982-06-28','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (3,'Santiago Medina','R','1987-11-10','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (4,'Daniel Suarez','JavaScript','1982-10-18','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (5,'Valentina Mejia','Java','1985-09-27','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (10,'Camilo Palacio','Python','1999-10-05','2021-02-05');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (11,'Tatiana Gomez','C++','1996-08-03','2021-02-06');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (13,'Melissa Toro','MATLAB','1996-04-22','2021-02-06');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (14,'Valentina Maldonado','MATLAB','1974-01-25','2021-02-06');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (15,'Santiago Villamil','PHP','1979-07-22','2021-02-06');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (16,'Carlos Guerra','Java','1979-10-09','2021-02-06');
INSERT INTO `developers` (`id`,`name`,`main_language`,`birthday_date`,`registration_date`) VALUES (18,'Patricia Buendia','Python','1985-02-02','2021-02-07');


UNLOCK TABLES;