CREATE DATABASE dbDispositivosM;
DROP DATABASE dbdispositivosM;




CREATE TABLE dbDispositivosM.usuario (
  idusu INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  PRIMARY KEY (idusu));

    INSERT INTO dbDispositivosM.usuario (idusu, login, senha, status, tipo) VALUES (1, '1', '1', 'ADM', 'ADM');
    SELECT * FROM dbDispositivosM.usuario;
    DROP TABLE dbDispositivosM.usuario;




CREATE TABLE dbDispositivosM.aluno (
  idalu INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  ra VARCHAR(255),
  ano VARCHAR(255),
  idade VARCHAR(255),
  PRIMARY KEY (idalu));

    INSERT INTO dbDispositivosM.aluno (idalu, nome, ra, ano, idade) VALUES (1, 'ALAN', '47474747', '2000', '30');
    SELECT * FROM dbDispositivosM.aluno;
    DROP TABLE dbDispositivosM.aluno;




CREATE TABLE dbDispositivosM.boletim (
  idbol INT NOT NULL AUTO_INCREMENT,
  semestre INT,
  nmat INT,
  npor INT,
  ngeo INT,
  PRIMARY KEY (idbol));

    INSERT INTO dbDispositivosM.boletim (idbol, semestre, nmat, npor, ngeo) VALUES (1, 2, 3, 4, 5);
    SELECT * FROM dbDispositivosM.boletim;
    DROP TABLE dbDispositivosM.boletim;




CREATE TABLE dbDispositivosM.rc (
   idrc INT PRIMARY KEY AUTO_INCREMENT,
   idusu INT,
   idalu INT,
   idbol INT,
   FOREIGN KEY (idusu) REFERENCES dbDispositivosM.usuario(idusu),
   FOREIGN KEY (idalu) REFERENCES dbDispositivosM.aluno(idalu),
   FOREIGN KEY (idbol) REFERENCES dbDispositivosM.boletim (idbol));

    INSERT INTO dbDispositivosM.rc (idusu, idalu, idbol) VALUES (1, 1, 1, 1);
    SELECT * FROM dbDispositivosM.rc;
    DROP TABLE dbDispositivosM.rc;