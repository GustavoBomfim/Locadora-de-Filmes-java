CREATE DATABASE cinema;
USE cinema;
CREATE TABLE FILME(
id INT AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL UNIQUE,
genero VARCHAR(20) NOT NULL,
duracao TIME,
ator_principal VARCHAR(35), 
diretor VARCHAR(35),
PRIMARY KEY(id)
);
DROP TABLE FILME;

CREATE TABLE CLIENTE(
nome_cliente VARCHAR(50) NOT NULL,
cpf VARCHAR(16) NOT NULL UNIQUE,
nascimento DATE,
aluguel_pendente BOOLEAN DEFAULT FALSE,
PRIMARY KEY(cpf)
);
DROP TABLE CLIENTE;

CREATE TABLE ALUGUEL(
dia DATE NOT NULL,
devolucao DATE NOT NULL,
fk_cpf VARCHAR(16) UNIQUE NOT NULL,
fk_id INT AUTO_INCREMENT,
FOREIGN KEY(fk_cpf) REFERENCES CLIENTE(cpf),
FOREIGN KEY (fk_id) REFERENCES FILME(id)
);
DROP TABLE ALUGUEL;

INSERT INTO FILME(nome, genero, ator_principal, duracao, diretor) values ('Velozes e Furiosos', 'Acao','Dominique Toreto', 'Quentin Tarantino');

INSERT INTO FILME(nome, genero, ator_principal, duracao, diretor) values ('Velozes e Furiosos 2', 'Acao','Dominique Toreto', '02:30:40', 'Quentin Tarantino');

SELECT * FROM FILME;
