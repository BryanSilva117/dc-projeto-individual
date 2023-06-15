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
nomeP varchar(30)
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


create table biografia (
idBiografia int auto_increment,
descricao varchar(100),
fkUsuario int,
constraint fkBu foreign key (fkUsuario) references usuario(idUsuario),
constraint pkBu primary key (idBiografia, fkUsuario)
);

select descricao from biografia where fkUsuario = 92;

delete from biografia where fkUsuario = 92;
delete from quizCharada where fkUsuario = 92;
delete from usuario where idUsuario = 92;

select * from usuario where idUsuario = 97;

UPDATE usuario
SET nome = 'ddjsjsd', sobrenome = 'carlos', email = 'Carlos22@asas', genero = 'masculino', dtNasc = '2001-01-01', fkPersonagemFav = 3
WHERE idUsuario = 1;

insert into quizCharada values
(null, 4, 4, 1);

select * from quizCharada;

select fkPersonagemFav as personagem from usuario where idUsuario = 40;


SELECT nome as Nome, (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
	(SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada join usuario on fkUsuario = idUsuario
		group by fkUsuario order by  fkUsuario desc limit 5;
     
SELECT (SUM(acertos) / (COUNT(*) * 5)) * 100 AS Acertos,
	(SUM(erros) / (COUNT(*) * 5)) * 100 AS Erros FROM quizCharada where fkUsuario = 7;
        
        
SELECT nome AS Nome, round((SUM(acertos) / (COUNT(*) * 5)) * 100, 1) AS MediaAcertos FROM QuizCharada
	JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaAcertos DESC, fkUsuario desc LIMIT 1;
        
        
SELECT nome AS Nome, round((SUM(erros) / (COUNT(*) * 5)) * 100, 1) AS MediaErros FROM QuizCharada
	JOIN Usuario ON fkUsuario = idUsuario GROUP BY fkUsuario ORDER BY MediaErros DESC, fkUsuario desc LIMIT 1;
        

select count(usuario.fkPersonagemFav) as qntVotos, personagemFav.nomeP as 'Nome Heroi'
	from usuario join personagemFav on personagemFav.idPersonagemFav = usuario.fkPersonagemFav 
		group by usuario.fkPersonagemFav;

SELECT usuario.nome AS NomeU, sobrenome, email, DATE_FORMAT(STR_TO_DATE(dtNasc, '%Y-%m-%d'), '%d/%m/%Y') AS dtNasc, Genero, personagemFav.nomeP AS Personagem
	FROM usuario
		JOIN personagemFav ON fkPersonagemFav = idPersonagemFav
				WHERE idUsuario = 3;
