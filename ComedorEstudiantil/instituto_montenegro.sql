#
# Structure for table "administrador"
#

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `codigoAdmin` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(15) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoAdmin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "administrador"
#

INSERT INTO `administrador` VALUES (1,'administrador','admin123','instituto','montenegro');

#
# Structure for table "estudiante"
#

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `documento` int(11) NOT NULL DEFAULT '0',
  `nombres` varchar(60) DEFAULT NULL,
  `apellidos` varchar(60) DEFAULT NULL,
  `grado` varchar(5) DEFAULT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  `tipoPoblacion` varchar(50) DEFAULT NULL,
  `modeloPedagogico` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


#
# Structure for table "huella"
#

DROP TABLE IF EXISTS `huella`;
CREATE TABLE `huella` (
  `idhuella` int(11) NOT NULL AUTO_INCREMENT,
  `huelladocumneto` varchar(100) DEFAULT NULL,
  `huella` blob,
  `estudiante_documento` int(11) NOT NULL,
  PRIMARY KEY (`idhuella`,`estudiante_documento`),
  KEY `fk_huella_estudiante1_idx` (`estudiante_documento`),
  CONSTRAINT `fk_huella_estudiante1` FOREIGN KEY (`estudiante_documento`) REFERENCES `estudiante` (`documento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Structure for table "instituto_montenegro"
#

DROP TABLE IF EXISTS `instituto_montenegro`;
CREATE TABLE `instituto_montenegro` (
  `Nit` int(11) NOT NULL AUTO_INCREMENT,
  `documentoEstudiante` int(11) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `ultimoIngreso` date DEFAULT NULL,
  PRIMARY KEY (`Nit`),
  KEY `documento_Estudiante` (`documentoEstudiante`),
  CONSTRAINT `documento_Estudiante` FOREIGN KEY (`documentoEstudiante`) REFERENCES `estudiante` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
