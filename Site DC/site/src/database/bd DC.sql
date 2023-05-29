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


create table QuizCharada (
idQuizCharada int auto_increment,
fkUsuario int,
acertos int,
erros int,
constraint fkQU foreign key (fkUsuario) references usuario(idUsuario),
constraint pkQU primary key (idQuizCharada, fkUsuario)
);

select * from usuario;

insert into quizCharada values
(null, 4, 4, 1);

select * from quizCharada;


SELECT (SUM(acertos) / (COUNT(*) * 5)) * 100 AS "Porcentagem de acertos",
	 (SUM(erros) / (COUNT(*) * 5)) * 100 AS "Porcentagem de erros" FROM quizCharada;
     
     SELECT (SUM(acertos) / (COUNT(*) * 5)) * 100 AS "Porcentagem de acertos",
	 (SUM(erros) / (COUNT(*) * 5)) * 100 AS "Porcentagem de erros" FROM quizCharada where fkUsuario = 20;



select count(usuario.fkPersonagemFav) as qntVotos, personagemFav.nomeP as 'Nome Heroi'
	from usuario join personagemFav on personagemFav.idPersonagemFav = usuario.fkPersonagemFav 
		group by usuario.fkPersonagemFav;

select usuario.nome as 'Nome Usuario', email, senha, dtNasc, Genero, personagemFav.nomeP as 'Personagem Favorito' 
	from usuario join personagemFav on fkPersonagemFav = idPersonagemFav;
