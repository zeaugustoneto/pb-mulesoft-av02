-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 09-Set-2022 às 13:47
-- Versão do servidor: 5.7.36
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pb_quiz`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `questoes`
--

DROP TABLE IF EXISTS `questoes`;
CREATE TABLE IF NOT EXISTS `questoes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(255) NOT NULL,
  `verdadeira` tinyint(1) NOT NULL,
  `ativa` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `questoes`
--

INSERT INTO `questoes` (`id`, `pergunta`, `verdadeira`, `ativa`) VALUES
(1, 'O diamante é feito de grafite', 0, 1),
(2, 'O pinguim é uma ave', 1, 1),
(3, 'Na tirania, predomina o mérito ', 0, 0),
(4, 'Palíndromo é uma frase ou palavra que se pode ler, indiferentemente, da esquerda para a direita ou vice-versa.', 1, 1),
(5, '\'Calcanhar de Aquiles\' significa ponto de equilíbrio do corpo', 0, 0),
(6, 'O apelido de Drácula dado à Vlad III foi por conta de seu pai ser apelidado de Dragão', 1, 1),
(7, 'Os louva-a-deus são capazes de capturar aranhas, lagartos e até ratos.', 1, 0),
(8, 'A gestação dos cavalos-marinhos é feita pelos machos.', 1, 1),
(9, 'Os morcegos não são os únicos mamíferos capazes de voar.', 0, 1),
(10, 'Um bicho-preguiça possui mais vértebras cervicais que um elefante ou uma girafa.', 1, 1),
(11, 'Os ornitorrincos são os únicos mamíferos venenosos que se tem notícia.', 0, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE IF NOT EXISTS `resultados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acertos` int(11) NOT NULL,
  `dataPartida` date DEFAULT NULL,
  `erros` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `resultados`
--

INSERT INTO `resultados` (`id`, `acertos`, `dataPartida`, `erros`, `nome`) VALUES
(1, 0, '2022-09-09', 7, 'jose'),
(2, 5, '2022-09-09', 2, 'jose'),
(3, 3, '2022-09-09', 4, 'jose neto'),
(4, 5, '2022-09-09', 2, 'fabio antonio'),
(5, 3, '2022-09-09', 4, 'josess'),
(6, 5, '2022-09-09', 2, 'Mauricio Ricardo'),
(7, 7, '2022-09-09', 0, 'ulisses faria'),
(8, 3, '2022-09-09', 4, 'marcio urias'),
(9, 4, '2022-09-09', 3, 'Marcene Roraima'),
(10, 7, '2022-09-09', 1, 'Marcinho'),
(11, 6, '2022-09-09', 2, 'eloissa');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
