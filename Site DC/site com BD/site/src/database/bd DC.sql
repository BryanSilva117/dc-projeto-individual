create database DC;
use DC;

create table usuario (
idUsuario int primary key auto_increment,
nome varchar(60),
sobrenome varchar(60),
email varchar(80),
senha varchar(14),
dtNasc date,
genero varchar(30)
);

create table personagemFav (
idPersonagemFav int primary key auto_increment,
nomeP varchar(45)
);

select * from usuario;
