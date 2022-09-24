create database fateczsdmn20222;

create table fateczsdmn20222.usuarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255),
  senha VARCHAR(255),
  status VARCHAR(255),
  tipo VARCHAR(255),
  primary key (id));
  
create table fateczsdmn20222.pessoas (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255),
  cpf VARCHAR(255),
  tipo VARCHAR(255),
  email VARCHAR(255),
  primary key (id));

INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('BITTENCOURT', 'ABFABF010101', 'ATIVO', 'ADM');
INSERT INTO `fateczsdmn20222`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('SCURACCHIO', 'ABFABF010101', 'ATIVO', 'VISITANTE');


