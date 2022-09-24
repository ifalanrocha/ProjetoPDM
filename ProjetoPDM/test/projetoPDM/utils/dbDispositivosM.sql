create database dbDispositivosM;
DROP database dbdispositivosm;

create table dbDispositivosM.usuario (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
  INSERT INTO `dbDispositivosM`.`usuarios` (`id`, `login`, `senha`, `status`, `tipo`) VALUES ('1', 'ALAN', '332', 'ADM', 'OOL' );
  select * from dbDispositivosM.usuario;
  DROP TABLE dbDispositivosM.usuario;
  
  
create table dbDispositivosM.pessoa (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  rg VARCHAR(255),
  cpf VARCHAR(255),
  tipo VARCHAR(255),
  email VARCHAR(255),
  primary key (id));

INSERT INTO `dbDispositivosM`.`usuarios` (`id`, `nome`, `rg`, `cpf`, `tipo`,`email`) VALUES ('12', 'ALAN', '47474747', '47474747', 'VISITANTE', 'ALANLANALANA');
  select * from dbDispositivosM.pessoa;
  DROP TABLE dbDispositivosM.pessoa;
  
  
create table dbDispositivosM.usupes (
  id INT NOT NULL AUTO_INCREMENT,
  idusuario INT,
  idpessoa INT,
  obs VARCHAR(255),
  usu VARCHAR(255),
  pes VARCHAR(255),
  primary key (id));
  
  INSERT INTO `dbDispositivosM`.`usuarios` (`id`, `idusuario`, `idpessoa`, `obs`, `usu`, `pes`) VALUES ('1', '3', '4', 'oi', 'alan', 'rocha');
  select * from dbDispositivosM.usuario;
  DROP TABLE dbDispositivosM.usuario;
  
  
create table dbDispositivosM.logradouro (
  id INT NOT NULL AUTO_INCREMENT,
  idusupes INT,
  rua VARCHAR(255),
  numero INT,
  cep VARCHAR(255),
  uf VARCHAR(255),
  primary key (id));

INSERT INTO `dbDispositivosM`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('ROCHA', '345', 'ATIVO', 'VISITANTE');
  select * from dbDispositivosM.pessoa;
  DROP TABLE dbDispositivosM.pessoa;