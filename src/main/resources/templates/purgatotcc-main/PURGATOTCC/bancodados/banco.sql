CREATE DATABASE purgato
USE MASTER IF EXISTS(SELECT * FROM SYS.databases WHERE NAME = 'BDPurgato')
DROP DATABASE BDPurgato
GO

USE purgato
CREATE DATABASE BDPurgato
GO

	//CRIAR TABELAS//
USE BDPurgato
GO

CREATE TABLE Funcionario
( 
   Id             INT IDENTITY PRIMARY KEY,
   Nome           VARCHAR(100)	  NOT NULL,
   Cpf			  CHAR   (11)		  NOT NULL,
   Email          VARCHAR(100)	  NOT NULL,
   Senha          VARCHAR(100)	  NOT NULL,
   Nivel_Acesso   VARCHAR(10)     NULL, -- ADMIN ou TECNICO
   Foto			  VARBINARY(MAX)   NULL,
   Status_Func    VARCHAR(20)      NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA
)

CREATE TABLE Funcionario (
ID int  PRIMARY KEY  NOT NULL,
nome VARCHAR (50)  NOt null,
sexo  VARCHAR (10) NOT NULL,
cpf char (11) not null,
Senha char (10) not null,
)


CREATE TABLE LAVAGEM(
Roupas_Qnt int  not null,
ID int primary key not null,
Tel_cliente char (11) not null,
fOREIGN KEY (ID) REFERENCES Cliente (ID)
CREATE TABLE Cliente
(
   ID            INT IDENTITY PRIMARY KEY,
   Nome          VARCHAR (50)  NOT NULL,
   CPF           CHAR    (11)  NOT NULL,
   Data_nasc     DATE          NOT NULL,
   Telefone      CHAR    (14)  NOT NULL,
   Email         VARCHAR (50)  NOT NULL,
   Senha         VARCHAR (50)  NOT NULL,
)

CREATE TABLE maquina(
ID int primary key not null,
Marca Varchar (25) not null,
Disponibilidade Bit not null,)

CREATE TABLE Cliente(
ID int primary key not null,
Nome varchar (50) not null,
CPF char (11) not null,
data_nasc Date not null,
Telefone char (14) not null,
Email varchar (50) not null,
Senha varchar (50) not null,
   ID                INT IDENTITY primary key,
   Marca             VARCHAR (25)  NOT NULL,
   Capacidade        VARCHAR (50)  NOT NULL,
   Disponibilidade   BIT  NOT NULL --OCUPADA OU DISPONIVEL 
)

CREATE TABLE LAVAGEM(
   ID              INT IDENTITY primary key,
   cliente_id      INT NOT NULL,
   maquina_id      INT NOT NULL,
   Roupas_Qnt      INT  NOT NULL,
   Preco           DECIMAL (8,2) NOT NULL,
   Data_Lavagem   SMALLDATETIME NOT NULL,
   Link_Pagamento  VARCHAR (200) NOT NULL,

fOREIGN KEY (cliente_id) REFERENCES Cliente (ID),
fOREIGN KEY (maquina_id) REFERENCES maquina (ID)
)


/*
CREATE TABLE Pagamento (
Tipo_Pag varchar (20) not null,
ID int  PRIMARY KEY  NOT NULL,
fOREIGN KEY (ID) REFERENCES Cliente (ID),
fOREIGN KEY (ID) REFERENCES LAVAGEM (ID))

fOREIGN KEY (ID) REFERENCES LAVAGEM (ID)
)
*/