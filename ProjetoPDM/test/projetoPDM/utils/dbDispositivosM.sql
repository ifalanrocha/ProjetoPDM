create database dbDispositivosM;
DROP database dbdispositivosm;

create table dbDispositivosM.usuario (
  idusu INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (idusu));

  INSERT dbDispositivosM.usuario (login, senha, status, tipo) VALUES ('ALAN', '332', 'ADM', 'OOL');
  insert escola.usuario (email, senha) values ('admin', 'admin');
  select * from dbDispositivosM.usuario;
  DROP TABLE dbDispositivosM.usuario;


create table dbDispositivosM.aluno (
  idalu INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  ra VARCHAR(255),
  ano VARCHAR(255),
  idade VARCHAR(255),
  primary key (idalu));

INSERT INTO dbDispositivosM.aluno (idalu, nome, ra, ano, idade) VALUES ('12', 'ALAN', '47474747', '2000', '12');
  select * from dbDispositivosM.aluno;
  DROP TABLE dbDispositivosM.aluno;


create table dbDispositivosM.boletim (
  idbol INT NOT NULL AUTO_INCREMENT,
  semestre INT,
  nmat INT,
  npor INT,
  ngeo INT,
  primary key (idbol));

  INSERT INTO dbDispositivosM.boletim (idbol, idusuario, idpessoa, obs, usu, pes) VALUES ('1', '3', '4', 'oi', 'alan', 'rocha');
  select * from dbDispositivosM.boletim;
  DROP TABLE dbDispositivosM.boletim;



create table dbDispositivosM.rc (
   idrc int PRIMARY KEY AUTO_INCREMENT,
   idusu int,
   idalu int,
   idbol int,
   FOREIGN KEY (idusu) REFERENCES dbDispositivosM.usuario(idusu),
   FOREIGN KEY (idalu) REFERENCES dbDispositivosM.aluno(idalu),
   FOREIGN KEY (idbol) REFERENCES dbDispositivosM.boletim (idbol));

  INSERT INTO dbDispositivosM.rc (idrc, idusu, idalu, idbol) VALUES ('1', '3', '4', '2');
  select * from dbDispositivosM.boletim;
  DROP TABLE dbDispositivosM.rc;