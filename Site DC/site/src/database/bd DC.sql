create database DC;
use DC;

create table usuario (
idUsuario int primary key auto_increment,
nome varchar(60),
sobrenome varchar(60),
email varchar(80),
senha varchar(14),
dtNasc date,
genero varchar(30),
fkPersonagemFav int,
constraint fkPerso foreign key (fkPersonagemFav) references personagemFav(idPersonagemFav)
);

create table personagemFav (
idPersonagemFav int primary key auto_increment,
nomeP varchar(45)
);

insert into personagemFav values 
(null, 'Superman'),
(null, 'Batman'),
(null, 'Mulher Maravilha'),
(null, 'Flash'),
(null, 'Lanterna Verde'),
(null, 'Aquaman'),
(null, 'Ciborgue'),
(null, 'Outro'),
(null, 'Prefiro a Marvel');

select count(*) from usuario where fkPersonagemFav = 1;
select count(*) from usuario where fkPersonagemFav = 2;
select count(*) from usuario where fkPersonagemFav = 3;
select count(*) from usuario where fkPersonagemFav = 4;
select count(*) from usuario where fkPersonagemFav = 5;
select count(*) from usuario where fkPersonagemFav = 6;
select count(*) from usuario where fkPersonagemFav = 7;
select count(*) from usuario where fkPersonagemFav = 8;
select count(*) from usuario where fkPersonagemFav = 9;

select usuario.nome as 'Nome Usuario', email, senha, dtNasc, Genero, personagemFav.nomeP as 'Personagem Favorito' 
	from usuario join personagemFav on fkPersonagemFav = idPersonagemFav;
