-- torna SAFE_MODE off
SET SQL_SAFE_UPDATES=0;

-- criacao instancia do banco de dados no servidor
CREATE SCHEMA IF NOT EXISTS db_projeto DEFAULT CHARACTER SET utf8;
USE db_projeto;

-- script de criacao da tabela agenda
CREATE TABLE IF NOT EXISTS curso (
  id        	 integer(4) 	not null auto_increment,
  nome           varchar(30)	not null,
  dataInicio     date       	not null,
  dataTermino    date       	not null,
  hora			 time			not null,
  vagas			 integer		not null,
  valor			 decimal(10,2)	not null,
  CONSTRAINT pk_curso PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS aluno (
  id		 	integer(5) 		not null auto_increment,
  nome       	 varchar(60) 	not null,
  endereco       varchar(60) 	not null,
  telefone       varchar(11)    not null,
  email          varchar(30) 	not null,
  rg			 varchar(9)	 	not null,
  cpf			 varchar(11)	not null,
CONSTRAINT pk_aluno PRIMARY KEY (id),
CONSTRAINT uk_aluno_rg  UNIQUE KEY (rg),
CONSTRAINT uk_aluno_cpf UNIQUE KEY (cpf)
);

