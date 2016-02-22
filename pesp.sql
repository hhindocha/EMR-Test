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
  `tpConsulta` enum('MEDICA','ENFERMAGEM') default NULL,
  `dsQueixa` varchar(255) default NULL,
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
REPLACE INTO `cid` (`cdCid`, `dsCid`, `idStatus`) VALUES ('1','sdf','A'),
	('2','Falta de fome','I'),
	('5','s gdfg sdf gsdf','A'),
	('6','asd','I'),
	('8','Morte por Katia Katiaxassa','A'),
	('9','Morte por Caxassa','A'),
	('11','teste de cadastro','A'),
	('12','outro teste','I'),
	('13','teste tet ete','A'),
	('14','Amputação de dedo(por dedo)','A'),
	('16','teste','A'),
	('18','t','A'),
	('20','Dor anal','A'),
	('21','asdasd as','A'),
	('22','Dor nas Costas','A'),
	('23','Apetite sexual exessivo','I'),
	('24','Dor Anual','A'),
	('25','Caxassada','A'),
	('26','Ressaca Forte','A'),
	('27','Ressaca  ou-','A');
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
REPLACE INTO `domicilio` (`cdDomicilio`, `cdEstabelecimento`, `dsLogradouro`, `dsBairro`, `dsMunicipio`, `dsEstado`, `dsTelefone`, `idStatus`) VALUES ('1','2','foi excluído, nao mostrar','asd','asd','as','asd','I'),
	('2','3','Rua divina providência','Santa quitéria','Pindamonhangaba','Pr','3221-5898','A'),
	('3','2','Mauricio Fruet, 2450 - Ap 02 Bl 01','Cajuru','Curitiba','Pr','41 33666650','A'),
	('4','1','Rua das Congonhas','Favela México 70','Curitiba','Pr','3221-2121','A');
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
REPLACE INTO `estabelecimento` (`cdEstabelecimento`, `dsEstabelecimento`, `dsEndereco`, `dsMunicipio`, `dsEstado`, `dsTelefone`, `idStatus`) VALUES ('1','Unidade de Saúde Jacu','Rua pimpolho','Curitiba','Pr','3022-7711','I'),
	('2','Unidade de Saúde Teste','Rua Tamoios nº 42','Curitiba','PR','3022-2222','A'),
	('3','Unidade de Saúde Atenas','Rua anitas de barros','Curitiba','Pr','30022122','A');
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
  `idStatus` enum('ENFERMAGEM','MEDICO','CONCLUIDO') NOT NULL default 'ENFERMAGEM',
  PRIMARY KEY  (`cdFila`),
  KEY `FILA_FKIndex1` (`cdPaciente`),
  KEY `FILA_FKIndex2` (`cdEstabelecimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'fila'
#



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
REPLACE INTO `paciente` (`cdPaciente`, `cdDomicilio`, `nmPaciente`, `nmMae`, `dtNascimento`, `dsTelefoneCel`, `tpSexo`, `idStatus`) VALUES ('1','3','Daniel Camargo','Eloisa','1981-08-17','41 88065267','M','A');
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
REPLACE INTO `procedimento` (`cdProcedimento`, `dsProcedimento`, `idStatus`) VALUES ('1','Administracao de Medicamentos por paciente','A'),
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
REPLACE INTO `profissao` (`cdProfissao`, `dsProfissao`, `dsConselho`, `idStatus`) VALUES ('4','Medico','5419','A'),
	('5','Enfermeiro','54269','A'),
	('6','Açougueiro','2424','I');
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
REPLACE INTO `profissional` (`cdProfissional`, `cdProfissao`, `dsLogin`, `dsSenha`, `nmProfissional`, `dtNascimento`, `dsCPF`, `nmMae`, `tpSexo`, `idStatus`) VALUES ('9','4','daniel','danie','Daniel Pereira Camargo','1981-08-17','03187592929','Eloisa de Fátima Pereira Camargo','M','A');
UNLOCK TABLES;
/*!40000 ALTER TABLE `profissional` ENABLE KEYS;*/
