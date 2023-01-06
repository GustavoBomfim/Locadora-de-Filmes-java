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
id int auto_increment, /*ID do aluguel */
dia DATE NOT NULL, /*Data da retirada do filme*/
devolucao DATE NOT NULL, /* Previsão para devolução */
fk_cpf VARCHAR(16) NOT NULL, /*CPF do cliente*/
fk_id INT NOT NULL, /* id do filme */
devolucao_pendente BOOLEAN DEFAULT TRUE,
devolvido_em DATE, /*Devolução real*/
PRIMARY KEY (id),
FOREIGN KEY(fk_cpf) REFERENCES CLIENTE(cpf),
FOREIGN KEY (fk_id) REFERENCES FILME(id)
);
DROP TABLE ALUGUEL;

INSERT INTO FILME(nome, genero, ator_principal, duracao, diretor) values ('Velozes e Furiosos', 'Acao','Dominique Toreto', 'Quentin Tarantino');

INSERT INTO FILME(nome, genero, ator_principal, duracao, diretor) values ('Velozes e Furiosos 2', 'Acao','Dominique Toreto', '02:30:40', 'Quentin Tarantino');

SELECT * FROM CLIENTE;
INSERT INTO CLIENTE( nome_cliente, cpf, nascimento
) values ('Gustavo', '445.087.606.55', '2001-01-01');

INSERT INTO CLIENTE( nome_cliente, cpf, nascimento
) values ('Mia', '505.092.406.55', '1995-10-19');

INSERT INTO ALUGUEL(dia, devolucao, fk_cpf, fk_id) VALUES ('2022-12-26', '2022-12-29', '445.087.606.55', 1);
select * from ALUGUEL;

select * from FILME;
select * from ALUGUEL;
select * from CLIENTE;


alter table ALUGUEL add filme_devolvido BOOLEAN DEFAULT FALSE; 
alter table FILME add filme_alugado BOOLEAN DEFAULT FALSE; 