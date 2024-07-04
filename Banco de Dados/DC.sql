CREATE DATABASE DC;

USE DC;

CREATE TABLE `personagem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `origem` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) DEFAULT NULL,
  `biografia` varchar(255) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  `personagem_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe0082obhbnksh89bohivjfl50` (`personagem_id`),
  CONSTRAINT `FKe0082obhbnksh89bohivjfl50` FOREIGN KEY (`personagem_id`) REFERENCES `personagem` (`id`)
);

CREATE TABLE `quiz_charada` (
  `id` int NOT NULL AUTO_INCREMENT,
  `acerto` int DEFAULT NULL,
  `erro` int DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6h7bco2074svsknoyj9esiip3` (`usuario_id`),
  CONSTRAINT `FK6h7bco2074svsknoyj9esiip3` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);




