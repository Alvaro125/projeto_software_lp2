DROP TABLE IF EXISTS Professores;
DROP TABLE IF EXISTS Faculdades;

CREATE TABLE Professores(
    CPF varchar(15) NOT NULL PRIMARY KEY,
    Nome varchar(255) NOT NULL,
    Titulação varchar(255) NOT NULL,
    Email varchar(255) NOT NULL
);
CREATE TABLE Faculdades(
    Sigla varchar(15) NOT NULL PRIMARY KEY,
    NomeCompleto varchar(255) NOT NULL,
    ÁreaConhecimento INT NOT NULL,
    AnoCriação INT NOT NULL
);