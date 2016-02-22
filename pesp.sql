# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 localhost
# Database:             pesp
# Server version:       4.1.9-max
# Server OS:            Win95/Win98
# max_allowed_packet:   1048576
# HeidiSQL version:     3.0 RC3 Revision: 111
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/


#
# Database structure for database 'pesp'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `pesp`;

USE `pesp`;


#
# Table structure for table 'atendimento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `atendimento` (
  `cdAtendimento` int(10) unsigned NOT NULL auto_increment,
  `cdEstabelecimento` int(10) unsigned NOT NULL default '0',
  `cdPaciente` int(10) unsigned NOT NULL default '0',
  `cdProfissional` int(10) unsigned NOT NULL default '0',
  `cdCid` int(10) unsigned default NULL,
  `dtAtendimento` datetime default NULL,
  `dsAtendimento` text,
  `cdProcedimento` int(10) unsigned NOT NULL default '0',
  `tpConsulta` enum('M','E') default 'E',
  `dsQueixa` text,
  PRIMARY KEY  (`cdAtendimento`),
  KEY `ATENDIMENTO_FKIndex2` (`cdCid`),
  KEY `ATENDIMENTO_FKIndex3` (`cdProcedimento`),
  KEY `ATENDIMENTO_FKIndex4` (`cdProfissional`),
  KEY `ATENDIMENTO_FKIndex5` (`cdPaciente`),
  KEY `ATENDIMENTO_FKIndex6` (`cdEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'atendimento'
#

/*!40000 ALTER TABLE `atendimento` DISABLE KEYS;*/
LOCK TABLES `atendimento` WRITE;
INSERT INTO `atendimento` (`cdAtendimento`, `cdEstabelecimento`, `cdPaciente`, `cdProfissional`, `cdCid`, `dtAtendimento`, `dsAtendimento`, `cdProcedimento`, `tpConsulta`, `dsQueixa`) VALUES ('1','3','1','9','14',NULL,'as','1','E','asd'),
	('2','3','1','9','14',NULL,'as','1','E','asd'),
	('3','3','1','9','14',NULL,'as','1','E','asd'),
	('4','3','2','9','14',NULL,'Descri��o','1','E','Queixa'),
	('5','3','2','9','14','2006-12-14 20:07:00','Descri��o','1','E','Queixa'),
	('6','3','2','9','14','2006-12-14 20:07:00','Descri��o','1','E','Queixa'),
	('7','3','1','9','14','2006-12-14 20:14:00','asdf','1','E','fas'),
	('8','3','1','9','14','2006-12-14 20:16:00','Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa ','1','E','Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa '),
	('9','3','1','9','14','2006-12-14 20:19:00',' Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o Descri��o','7','E',' Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa Queixa'),
	('10','3','1','9','14','2006-12-14 20:20:00','asdf','1','E','asdf'),
	('11','3','1','10','14','2006-12-14 20:20:00','asd','4','E','asd'),
	('12','3','1','9','14','2006-12-14 20:20:00','as dfsd','1','E','sadfs dfsdf'),
	('13','3','2','9','14','2006-12-14 20:21:00',' df sdfsdf','1','M','asdf dfsdf'),
	('14','3','2','9','14','2006-12-14 20:22:00','ds fgd','1','E','ds fsg'),
	('15','3','2','9','14','2006-12-14 20:23:00','lllllllllll','1','E','llllllllll'),
	('16','3','2','9','14','2006-12-14 20:27:00','asd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das d','1','E','asd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das dasd as das d'),
	('17','3','1','10','20','2006-12-14 20:53:00','foi encaminhado ao dentista','7','E','dor de dente!');
UNLOCK TABLES;
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS;*/


#
# Table structure for table 'cid'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `cid` (
  `cdCid` int(10) unsigned NOT NULL auto_increment,
  `dsCid` varchar(120) NOT NULL default '',
  `idStatus` enum('A','I') default NULL,
  PRIMARY KEY  (`cdCid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'cid'
#

/*!40000 ALTER TABLE `cid` DISABLE KEYS;*/
LOCK TABLES `cid` WRITE;
INSERT INTO `cid` (`cdCid`, `dsCid`, `idStatus`) VALUES ('1','sdf','A'),
	('2','Falta de fome','I'),
	('5','s gdfg sdf gsdf','A'),
	('6','asd','I'),
	('8','Morte por Katia Katiaxassa','A'),
	('9','Morte por Caxassa','A'),
	('11','teste de cadastro','A'),
	('12','outro teste','I'),
	('13','teste tet ete','A'),
	('14','Amputa��o de dedo(por dedo)','A'),
	('16','teste','A'),
	('18','t','A'),
	('20','Dor anal','A'),
	('21','asdasd as','A'),
	('22','Dor nas Costas','A'),
	('23','Apetite sexual exessivo','I'),
	('24','Dor Anual','A'),
	('25','Caxassada','A'),
	('26','Ressaca Forte','A'),
	('27','Ressaca  ou-','A'),
	('28','Dor na perna','A'),
	('29','Dor no p�','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `cid` ENABLE KEYS;*/


#
# Table structure for table 'domicilio'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `domicilio` (
  `cdDomicilio` int(10) unsigned NOT NULL auto_increment,
  `cdEstabelecimento` int(10) unsigned NOT NULL default '0',
  `dsLogradouro` varchar(80) default NULL,
  `dsBairro` varchar(60) default NULL,
  `dsMunicipio` varchar(60) default NULL,
  `dsEstado` char(2) default NULL,
  `dsTelefone` varchar(20) default NULL,
  `idStatus` enum('A','I') default NULL,
  PRIMARY KEY  (`cdDomicilio`),
  KEY `DOMICILIO_FKIndex1` (`cdEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'domicilio'
#

/*!40000 ALTER TABLE `domicilio` DISABLE KEYS;*/
LOCK TABLES `domicilio` WRITE;
INSERT INTO `domicilio` (`cdDomicilio`, `cdEstabelecimento`, `dsLogradouro`, `dsBairro`, `dsMunicipio`, `dsEstado`, `dsTelefone`, `idStatus`) VALUES ('1','2','foi exclu�do, nao mostrar','asd','asd','as','asd','I'),
	('2','3','Rua divina provid�ncia','Santa quit�ria','Pindamonhangaba','Pr','3221-5898','A'),
	('3','2','Mauricio Fruet, 2450 - Ap 02 Bl 01','Cajuru','Curitiba','Pr','41 33666650','A'),
	('4','1','Rua das Congonhas','Favela M�xico 70','Curitiba','Pr','3221-2121','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS;*/


#
# Table structure for table 'estabelecimento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `estabelecimento` (
  `cdEstabelecimento` int(10) unsigned NOT NULL auto_increment,
  `dsEstabelecimento` varchar(80) NOT NULL default '',
  `dsEndereco` varchar(80) default NULL,
  `dsMunicipio` varchar(80) default NULL,
  `dsEstado` char(2) default NULL,
  `dsTelefone` varchar(20) default NULL,
  `idStatus` enum('A','I') default NULL,
  PRIMARY KEY  (`cdEstabelecimento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



#
# Dumping data for table 'estabelecimento'
#

/*!40000 ALTER TABLE `estabelecimento` DISABLE KEYS;*/
LOCK TABLES `estabelecimento` WRITE;
INSERT INTO `estabelecimento` (`cdEstabelecimento`, `dsEstabelecimento`, `dsEndereco`, `dsMunicipio`, `dsEstado`, `dsTelefone`, `idStatus`) VALUES ('1','Unidade de Sa�de Jacu','Rua pimpolho','Curitiba','Pr','3022-7711','I'),
	('2','Unidade de Sa�de Teste','Rua Tamoios n� 42','Curitiba','PR','3022-2222','A'),
	('3','Unidade de Sa�de Atenas','Rua anitas de barros','Curitiba','Pr','30022122','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `estabelecimento` ENABLE KEYS;*/


#
# Table structure for table 'estabelecimentoprofissional'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `estabelecimentoprofissional` (
  `cdEstabelecimento` int(10) unsigned NOT NULL auto_increment,
  `cdProfissional` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`cdEstabelecimento`,`cdProfissional`),
  KEY `ESTABELECIMENTOPROFISSIONAL_FKIndex1` (`cdProfissional`),
  KEY `ESTABELECIMENTOPROFISSIONAL_FKIndex2` (`cdEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'estabelecimentoprofissional'
#



#
# Table structure for table 'fila'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `fila` (
  `cdFila` int(10) unsigned NOT NULL auto_increment,
  `cdEstabelecimento` int(10) unsigned NOT NULL default '0',
  `cdPaciente` int(10) unsigned NOT NULL default '0',
  `dtFila` datetime NOT NULL default '0000-00-00 00:00:00',
  `idStatus` enum('E','M','C') NOT NULL default 'E',
  PRIMARY KEY  (`cdFila`),
  KEY `FILA_FKIndex1` (`cdPaciente`),
  KEY `FILA_FKIndex2` (`cdEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'fila'
#

/*!40000 ALTER TABLE `fila` DISABLE KEYS;*/
LOCK TABLES `fila` WRITE;
INSERT INTO `fila` (`cdFila`, `cdEstabelecimento`, `cdPaciente`, `dtFila`, `idStatus`) VALUES ('1','2','1','2006-12-02 19:22:00','E'),
	('2','1','0',NULL,'E'),
	('3','1','0','2006-12-02 18:00:00','E'),
	('4','1','0','2006-12-02 18:00:00','E'),
	('5','1','0','2006-12-02 18:03:00','E'),
	('6','3','1',NULL,'M'),
	('7','2','1','2006-12-02 19:22:00','E'),
	('8','3','1','2006-12-02','M'),
	('9','3','1','2006-12-02','M'),
	('10','3','2','2006-12-02','M'),
	('11','3','2','2006-12-02','M'),
	('12','3','2','2006-12-02','C'),
	('13','3','1','2006-12-02','M'),
	('14','3','1','2006-12-02 18:54:00','C'),
	('15','3','2','2006-12-02','C'),
	('16','3','1',NULL,'M'),
	('17','3','1','2006-12-02','M'),
	('18','3','1','2006-12-02','M'),
	('19','3','2','2006-12-02','M'),
	('20','3','1','2006-12-14 20:22:00','E'),
	('21','3','1','2006-12-14 20:24:00','E'),
	('22','3','1','2006-12-14 20:27:00','E');
UNLOCK TABLES;
/*!40000 ALTER TABLE `fila` ENABLE KEYS;*/


#
# Table structure for table 'paciente'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `paciente` (
  `cdPaciente` int(10) unsigned NOT NULL auto_increment,
  `cdDomicilio` int(10) unsigned NOT NULL default '0',
  `nmPaciente` varchar(80) NOT NULL default '',
  `nmMae` varchar(80) default NULL,
  `dtNascimento` datetime default NULL,
  `dsTelefoneCel` varchar(20) default NULL,
  `tpSexo` char(1) default NULL,
  `idStatus` enum('A','I','O') default NULL,
  PRIMARY KEY  (`cdPaciente`),
  KEY `PACIENTE_FKIndex1` (`cdDomicilio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'paciente'
#

/*!40000 ALTER TABLE `paciente` DISABLE KEYS;*/
LOCK TABLES `paciente` WRITE;
INSERT INTO `paciente` (`cdPaciente`, `cdDomicilio`, `nmPaciente`, `nmMae`, `dtNascimento`, `dsTelefoneCel`, `tpSexo`, `idStatus`) VALUES ('1','3','Daniel Camargo','Eloisa','1981-08-17','41 88065267','M','A'),
	('2','4','Pen�lope Charmosa','Rebeca','1984-08-08','41 55555555','F','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS;*/


#
# Table structure for table 'procedimento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `procedimento` (
  `cdProcedimento` int(10) unsigned NOT NULL auto_increment,
  `dsProcedimento` varchar(80) default NULL,
  `idStatus` enum('A','I') NOT NULL default 'A',
  PRIMARY KEY  (`cdProcedimento`),
  KEY `PROCEDIMENTO_index` (`cdProcedimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'procedimento'
#

/*!40000 ALTER TABLE `procedimento` DISABLE KEYS;*/
LOCK TABLES `procedimento` WRITE;
INSERT INTO `procedimento` (`cdProcedimento`, `dsProcedimento`, `idStatus`) VALUES ('1','Administracao de Medicamentos por paciente','A'),
	('2','Atendimento de paciente portador de diabetes','A'),
	('3','Curativo por paciente','A'),
	('4','Amputacao por membro por dedo','A'),
	('5','Inalacao','A'),
	('6','Retirada de mebro inferior','A'),
	('7','Glicose na Veia','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `procedimento` ENABLE KEYS;*/


#
# Table structure for table 'profissao'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `profissao` (
  `cdProfissao` int(10) unsigned NOT NULL auto_increment,
  `dsProfissao` varchar(80) NOT NULL default '',
  `dsConselho` varchar(80) NOT NULL default '',
  `idStatus` enum('A','I') default NULL,
  PRIMARY KEY  (`cdProfissao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'profissao'
#

/*!40000 ALTER TABLE `profissao` DISABLE KEYS;*/
LOCK TABLES `profissao` WRITE;
INSERT INTO `profissao` (`cdProfissao`, `dsProfissao`, `dsConselho`, `idStatus`) VALUES ('4','Medico','5419','A'),
	('5','Enfermeiro','54269','A'),
	('6','A�ougueiro','2424','I');
UNLOCK TABLES;
/*!40000 ALTER TABLE `profissao` ENABLE KEYS;*/


#
# Table structure for table 'profissional'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `profissional` (
  `cdProfissional` int(10) unsigned NOT NULL auto_increment,
  `cdProfissao` int(10) unsigned NOT NULL default '0',
  `dsLogin` varchar(20) NOT NULL default '',
  `dsSenha` varchar(10) NOT NULL default '',
  `nmProfissional` varchar(80) NOT NULL default '',
  `dtNascimento` datetime NOT NULL default '0000-00-00 00:00:00',
  `dsCPF` varchar(11) NOT NULL default '',
  `nmMae` varchar(80) NOT NULL default '',
  `tpSexo` char(1) NOT NULL default '',
  `idStatus` enum('A','I') default NULL,
  PRIMARY KEY  (`cdProfissional`),
  KEY `PROFISSIONAL_FKIndex1` (`cdProfissao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'profissional'
#

/*!40000 ALTER TABLE `profissional` DISABLE KEYS;*/
LOCK TABLES `profissional` WRITE;
INSERT INTO `profissional` (`cdProfissional`, `cdProfissao`, `dsLogin`, `dsSenha`, `nmProfissional`, `dtNascimento`, `dsCPF`, `nmMae`, `tpSexo`, `idStatus`) VALUES ('9','4','daniel','danie','Daniel Pereira Camargo','1981-08-17','03187592929','Eloisa de F�tima Pereira Camargo','M','A'),
	('10','4','rkloss','123','Rafael Kloss','1981-08-18','7531526-0','Almira Oliveira Kloss','M','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `profissional` ENABLE KEYS;*/
