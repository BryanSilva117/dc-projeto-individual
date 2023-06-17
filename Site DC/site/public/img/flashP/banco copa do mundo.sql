CREATE DATABASE copadoMundo;
USE copadoMundo;



create table pais (
id int primary key auto_increment,
nome varchar(45),
siglas varchar(3)
);


create table clube (
id int auto_increment,
nome varchar(45),
dataFundacao date,
fkPais int,
constraint fkP foreign key (fkPais) references pais(id),
constraint pkCP primary key (id, fkPais)
);

create table selecao (
id int auto_increment,
nome varchar(45),
qntConvocados int,
qntDesfalques int,
fkPais int,
constraint fkSP foreign key (fkPais) references pais(id),
constraint pkPs primary key (id, fkPais)
);

create table jogador (
id int auto_increment,
nome varchar(45),
sobrenome varchar(45),
altura float,
dataNasc date,
peso float,
posicao varchar(45),
fkClube int,
fkPais int,
fkSelecao int,
constraint fkCl foreign key (fkClube) references clube(id),
constraint fkPj foreign key (fkPais) references pais(id),
constraint fkSe foreign key (fkSelecao) references selecao(id),
constraint pkPj primary key (id, fkPais)
);

create table tecnico (
id int auto_increment,
nome varchar(45),
dataNasc date,
anoExp int,
fkSelecao int,
fkPais int,
constraint fkTS foreign key (fkSelecao) references selecao(id),
constraint fkTp foreign key (fkPais) references pais(id),
constraint pkTp primary key (id, fkPais)
);

create table estadio (
id int auto_increment,
nome varchar(45),
inauguracao date,
lotacao float,
fkPais int,
constraint fkPe foreign key (fkPais) references pais(id),
constraint pkEp primary key (id, fkPais)
);

create table arbitro (
id int auto_increment,
nome varchar(45),
altura float,
peso float,
dtNasc date,
anosExpProf int,
avaliacao int,
funcao varchar(45),
fkPais int,
constraint fkPa foreign key (fkPais) references pais(id),
constraint pkPa primary key (id, fkPais)
);

create table jogo (
id int auto_increment,
dataJogo datetime,
fkEstadio int,
constraint fkEj foreign key (fkEstadio) references estadio(id),
constraint pkEj primary key (id, fkEstadio)
);

create table partida (
id int auto_increment,
fkSelecao int,
fkJogo int,
fkArbitro int,
constraint fkSeP foreign key (fkSelecao) references selecao(id),
constraint fkJo foreign key (fkJogo) references jogo(id),
constraint fkAr foreign key (fkArbitro) references arbitro(id),
constraint pkSja primary key (id, fkSelecao, fkJogo, fkArbitro)
);

create table cartao (
id int auto_increment,
fkJogador int,
fkPartida int,
qtdAmarelo int,
qtdVermelho int,
constraint fkJoC foreign key (fkJogador) references jogador(id),
constraint fkPaC foreign key (fkPartida) references partida(id),
constraint pkpj primary key (id, fkJogador, fkPartida)
);

INSERT INTO pais VALUES
(Null, 'Alemanha', 'ALE'),
(Null, 'Brasil', 'BRA'),
(Null, 'França', 'FRA'),
(Null, 'Suiça', 'SUI');
   
INSERT INTO clube VALUES
(null, 'Bayern', '1942-12-12', 1),
(null, 'PSG', '1922-05-02', 3),
(null, 'Borussia', '1922-12-12', 1);
   
INSERT INTO selecao VALUES
(null, 'Brasil', 22, 4, 2),
(null, 'Alemanha', 23, 1, 1),
(null, 'Franca', 25, 3, 3);

INSERT INTO jogador VALUES
(null, 'roger', 'matheus', 1.72, '1995-02-22', 88.02, 'ATA', 2, 2,  1),
(null, 'mario', 'jorge', 1.82, '1998-05-22', 90.02,'ATA', 2, 2,  1),
(null, 'gustavo', 'cruz', 1.52, '1992-04-22', 92.02, 'MEI', 3, 3, 1),
(null, 'rogerrio', 'guizinho', 1.20, '1992-03-22', 84.02, 'ZAG', 2, 2, 1);
   
INSERT INTO tecnico VALUES
(null,'jorge', '1983-12-12', 5, 1, 1),
(null,'bryan', '1963-02-02', 10, 3, 4);


INSERT INTO estadio VALUES
(null, 'Morumbi', '1965-03-09', 60000, 2),
(null, 'Neu quimica', '1978-04-12', 80000, 3);
   
INSERT INTO arbitro VALUES
(null, 'Rogerio', 1.79, 77.7, '1985-01-23', 5, 7, 'banderinha', 1);
   
INSERT INTO jogo VALUES
(null, '2023-03-09 16:00:00', 1);

insert into partida values
(null, 1, 1, 1),
(null, 2, 1, 1);


INSERT INTO cartao VALUES
(null,1,1,1,0);



