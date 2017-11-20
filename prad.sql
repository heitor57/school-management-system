-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 30-Out-2017 às 23:25
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prad`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `CID_CODIGO` int(11) NOT NULL,
  `CID_NOME` varchar(60) NOT NULL,
  `CID_UF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`CID_CODIGO`, `CID_NOME`, `CID_UF`) VALUES
(1, 'Leopoldina', 1),
(3, 'Laranjal', 1),
(4, 'Muriae', 1),
(5, 'dasdsa', 1),
(6, 'dasdsa', 2),
(7, 'dsaads', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `CLI_CODIGO` int(11) NOT NULL,
  `CLI_NOME` varchar(100) NOT NULL,
  `CLI_EMAIL` varchar(100) NOT NULL,
  `CLI_TELEFONE` varchar(20) NOT NULL,
  `CLI_SENHA` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`CLI_CODIGO`, `CLI_NOME`, `CLI_EMAIL`, `CLI_TELEFONE`, `CLI_SENHA`) VALUES
(1, 'ewqewqewqdsad', '32sddsadsasad', '(32)1321-2312', ''),
(2, 'sdsadsa', 'dsadsasadsadsad', '(32)1321-3212', ''),
(3, '', '', '(  )    -    ', ''),
(4, 'ddsasddasasd', 'dsadsasdasdaasdasd', '(32)3132-1321', ''),
(5, 'DDDDD', 'DSADSA', '(31)2132-1233', ''),
(6, 'sadasd', '32dsasddsadas', '(32)1322-3123', ''),
(7, 'DDDDD', 'dssaddsa', '(23)2332-1321', ''),
(8, 'DDDDD', 'DSADSA', '(31)2132-1233', ''),
(9, 'heitor', 'heitorwerneck@hotmail.com', '(23)2131-1323', '123'),
(10, 'cdsaadsads', 'dasdsaadsads', '(32)1123-1321', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `uf`
--

CREATE TABLE `uf` (
  `iduf` int(11) NOT NULL,
  `sigla` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `uf`
--

INSERT INTO `uf` (`iduf`, `sigla`) VALUES
(1, 'MG'),
(2, 'SP');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`CID_CODIGO`),
  ADD KEY `ID_UF_IN` (`CID_UF`) USING BTREE;

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CLI_CODIGO`);

--
-- Indexes for table `uf`
--
ALTER TABLE `uf`
  ADD PRIMARY KEY (`iduf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `CID_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `CLI_CODIGO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `uf`
--
ALTER TABLE `uf`
  MODIFY `iduf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `ID_UF_FK` FOREIGN KEY (`CID_UF`) REFERENCES `uf` (`iduf`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
