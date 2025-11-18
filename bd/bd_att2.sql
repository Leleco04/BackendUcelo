CREATE DATABASE  IF NOT EXISTS `ucelo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ucelo`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: ucelo
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caneca`
--

DROP TABLE IF EXISTS `caneca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caneca` (
  `id_caneca` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nome_modelo` varchar(55) NOT NULL,
  `volume_caneca` double NOT NULL,
  `material` varchar(32) NOT NULL,
  `capacidade` double NOT NULL,
  `volume_borda` double NOT NULL,
  `enchimento` double NOT NULL,
  `resistencia_brasao` double NOT NULL,
  `resistencia_tracao` double NOT NULL,
  `deslocamento` double NOT NULL,
  `profundidade` double NOT NULL,
  `largura` double NOT NULL,
  `projecao` double DEFAULT NULL,
  `velocidade` double DEFAULT NULL,
  `densidade` double DEFAULT NULL,
  `numero_de_fileiras` int DEFAULT NULL,
  `canecas_metro` int DEFAULT NULL,
  `passo` double DEFAULT NULL,
  PRIMARY KEY (`id_caneca`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caneca`
--

LOCK TABLES `caneca` WRITE;
/*!40000 ALTER TABLE `caneca` DISABLE KEYS */;
INSERT INTO `caneca` VALUES (21,'CE-1 Nylon 160',1.6,'Nylon',1.45,0.15,90,450,900,0.35,160,200,60,2.5,0.75,1,6,165),(22,'CE-2 Polietileno 220',2.2,'Polietileno',2.05,0.16,92,480,950,0.4,180,220,70,2.8,0.7,1,5,200),(23,'CE-3 Aço Carbono 250',2.5,'Aço Carbono',2.3,0.2,88,900,1500,0.55,190,250,75,2.6,0.8,1,5,200),(24,'CE-4 Inox 304 280',2.8,'Aço Inox',2.55,0.18,91,1100,1700,0.5,200,280,80,2.3,0.78,1,4,220),(25,'CE-5 Nylon Slim 120',1.2,'Nylon',1.1,0.1,93,420,850,0.3,140,180,55,2,0.72,1,7,145),(26,'CE-6 Polietileno Reforçada 320',3.2,'Polietileno',2.95,0.2,92,500,1000,0.65,220,300,85,2.4,0.68,1,4,240),(27,'CE-7 Aço Carbono Heavy 350',3.5,'Aço Carbono',3.2,0.25,87,1200,2000,0.75,240,320,90,2.7,0.85,1,4,250),(28,'CE-8 Inox Alta Temperatura 180',1.8,'Aço Inox',1.65,0.12,89,1000,1600,0.38,160,210,65,2.2,0.76,1,6,165),(29,'CE-9 Polietileno Alimentício 260',2.6,'Polietileno',2.4,0.18,92,460,920,0.48,175,260,72,2.1,0.72,1,5,200),(30,'CE-10 Nylon Lateral Dupla 300',3,'Nylon',2.8,0.2,90,600,1100,0.6,210,300,78,2.5,0.73,2,8,125);
/*!40000 ALTER TABLE `caneca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` bigint unsigned NOT NULL AUTO_INCREMENT,
  `categoria_produto` varchar(32) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cnpj` char(14) NOT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `situacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_local`
--

DROP TABLE IF EXISTS `cliente_local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_local` (
  `id_local` bigint unsigned NOT NULL AUTO_INCREMENT,
  `rua` varchar(32) NOT NULL,
  `numero` smallint unsigned NOT NULL,
  `bairro` varchar(32) NOT NULL,
  `estado` varchar(32) NOT NULL,
  `cidade` varchar(32) NOT NULL,
  `cep` bigint unsigned NOT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`id_local`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `cliente_local_ibfk_1` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_local`
--

LOCK TABLES `cliente_local` WRITE;
/*!40000 ALTER TABLE `cliente_local` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_telefone`
--

DROP TABLE IF EXISTS `cliente_telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_telefone` (
  `id_telefone` bigint unsigned NOT NULL AUTO_INCREMENT,
  `numero_telefone` smallint unsigned DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `ddd` decimal(3,0) NOT NULL,
  PRIMARY KEY (`id_telefone`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `cliente_telefone_ibfk_1` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_telefone`
--

LOCK TABLES `cliente_telefone` WRITE;
/*!40000 ALTER TABLE `cliente_telefone` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correia`
--

DROP TABLE IF EXISTS `correia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correia` (
  `id_correia` int unsigned NOT NULL AUTO_INCREMENT,
  `modelo` varchar(32) NOT NULL,
  `espessura` double NOT NULL,
  `largura` double NOT NULL,
  `tensao_efetiva` double NOT NULL,
  `id_tambor` int unsigned DEFAULT NULL,
  `id_categoria` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id_correia`),
  KEY `id_tambor` (`id_tambor`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `correia_ibfk_1` FOREIGN KEY (`id_tambor`) REFERENCES `tambor` (`id_tambor`),
  CONSTRAINT `correia_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correia`
--

LOCK TABLES `correia` WRITE;
/*!40000 ALTER TABLE `correia` DISABLE KEYS */;
/*!40000 ALTER TABLE `correia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `tipo_trabalhador` varchar(32) NOT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_caneca`
--

DROP TABLE IF EXISTS `historico_caneca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_caneca` (
  `id_historico_caneca` int unsigned NOT NULL AUTO_INCREMENT,
  `id_caneca` bigint unsigned DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `data_gerado` datetime NOT NULL,
  PRIMARY KEY (`id_historico_caneca`),
  UNIQUE KEY `data_gerado` (`data_gerado`,`id_historico_caneca`),
  KEY `id_caneca` (`id_caneca`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_caneca_ibfk_2` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`),
  CONSTRAINT `historico_caneca_ibfk_3` FOREIGN KEY (`id_caneca`) REFERENCES `caneca` (`id_caneca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_caneca`
--

LOCK TABLES `historico_caneca` WRITE;
/*!40000 ALTER TABLE `historico_caneca` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_caneca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_capacidade`
--

DROP TABLE IF EXISTS `historico_capacidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_capacidade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` char(14) DEFAULT NULL,
  `velocidade` double NOT NULL,
  `passo` double NOT NULL,
  `numero_fileiras` int NOT NULL,
  `profundidade` double NOT NULL,
  `densidade_produto` double NOT NULL,
  `volume_caneca` double NOT NULL,
  `largura` double NOT NULL,
  `projecao` double NOT NULL,
  `fator_enchimento` double DEFAULT NULL,
  `capacidade_calculada` double DEFAULT NULL,
  `unidade` varchar(255) DEFAULT NULL,
  `data_calculo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_capacidade_ibfk_1` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_capacidade`
--

LOCK TABLES `historico_capacidade` WRITE;
/*!40000 ALTER TABLE `historico_capacidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_capacidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_correia`
--

DROP TABLE IF EXISTS `historico_correia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_correia` (
  `id_historico_correia` int unsigned NOT NULL AUTO_INCREMENT,
  `id_correia` int unsigned DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `data_gerado` datetime NOT NULL,
  PRIMARY KEY (`id_historico_correia`),
  UNIQUE KEY `data_gerado` (`data_gerado`,`id_historico_correia`),
  KEY `id_correia` (`id_correia`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_correia_ibfk_1` FOREIGN KEY (`id_correia`) REFERENCES `correia` (`id_correia`),
  CONSTRAINT `historico_correia_ibfk_2` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_correia`
--

LOCK TABLES `historico_correia` WRITE;
/*!40000 ALTER TABLE `historico_correia` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_correia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_motoredutor`
--

DROP TABLE IF EXISTS `historico_motoredutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_motoredutor` (
  `id_historico_motoredutor` int unsigned NOT NULL AUTO_INCREMENT,
  `id_motoredutor` int unsigned DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `data_gerado` datetime NOT NULL,
  PRIMARY KEY (`id_historico_motoredutor`),
  UNIQUE KEY `data_gerado` (`data_gerado`,`id_historico_motoredutor`),
  KEY `id_motoredutor` (`id_motoredutor`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_motoredutor_ibfk_1` FOREIGN KEY (`id_motoredutor`) REFERENCES `motoredutor` (`id`),
  CONSTRAINT `historico_motoredutor_ibfk_2` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_motoredutor`
--

LOCK TABLES `historico_motoredutor` WRITE;
/*!40000 ALTER TABLE `historico_motoredutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_motoredutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_parafuso`
--

DROP TABLE IF EXISTS `historico_parafuso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_parafuso` (
  `id_historico_parafuso` int unsigned NOT NULL AUTO_INCREMENT,
  `id_parafuso` int unsigned DEFAULT NULL,
  `cnpj` char(14) DEFAULT NULL,
  `data_gerado` datetime NOT NULL,
  PRIMARY KEY (`id_historico_parafuso`),
  UNIQUE KEY `data_gerado` (`data_gerado`,`id_historico_parafuso`),
  KEY `id_parafuso` (`id_parafuso`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_parafuso_ibfk_1` FOREIGN KEY (`id_parafuso`) REFERENCES `parafuso` (`id`),
  CONSTRAINT `historico_parafuso_ibfk_2` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_parafuso`
--

LOCK TABLES `historico_parafuso` WRITE;
/*!40000 ALTER TABLE `historico_parafuso` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_parafuso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_velocidade`
--

DROP TABLE IF EXISTS `historico_velocidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_velocidade` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `cnpj` char(14) DEFAULT NULL,
  `diametro_tambor` double NOT NULL,
  `rotacao_tambor` double NOT NULL,
  `velocidade_calculada` double NOT NULL,
  `unidade` varchar(45) NOT NULL,
  `data_calculo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `cnpj` (`cnpj`),
  CONSTRAINT `historico_velocidade_ibfk_1` FOREIGN KEY (`cnpj`) REFERENCES `cliente` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_velocidade`
--

LOCK TABLES `historico_velocidade` WRITE;
/*!40000 ALTER TABLE `historico_velocidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_velocidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id_material` int unsigned NOT NULL AUTO_INCREMENT,
  `nome_material` varchar(128) NOT NULL,
  `densidade` double NOT NULL,
  `observacoes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id_material`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motoredutor`
--

DROP TABLE IF EXISTS `motoredutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motoredutor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `potencia` double NOT NULL,
  `tipo_potencia` varchar(64) NOT NULL,
  `rpm` double NOT NULL,
  `torque` double NOT NULL,
  `relacao_reducao` double NOT NULL,
  `notas` varchar(256) DEFAULT NULL,
  `id_categoria` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `motoredutor_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motoredutor`
--

LOCK TABLES `motoredutor` WRITE;
/*!40000 ALTER TABLE `motoredutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `motoredutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parafuso`
--

DROP TABLE IF EXISTS `parafuso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parafuso` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `bitola` varchar(18) NOT NULL,
  `comprimento` decimal(7,2) NOT NULL,
  `torque` double NOT NULL,
  `aplicacao` varchar(128) DEFAULT NULL,
  `id_categoria` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `parafuso_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parafuso`
--

LOCK TABLES `parafuso` WRITE;
/*!40000 ALTER TABLE `parafuso` DISABLE KEYS */;
/*!40000 ALTER TABLE `parafuso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tambor`
--

DROP TABLE IF EXISTS `tambor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tambor` (
  `id_tambor` int unsigned NOT NULL AUTO_INCREMENT,
  `diametro` double DEFAULT NULL,
  `id_categoria` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id_tambor`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `tambor_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tambor`
--

LOCK TABLES `tambor` WRITE;
/*!40000 ALTER TABLE `tambor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tambor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-18 19:26:12
