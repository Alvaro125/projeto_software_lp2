DROP TABLE IF EXISTS Professores;
DROP TABLE IF EXISTS Faculdades;

CREATE TABLE Professores(
    CPF varchar(15) NOT NULL PRIMARY KEY,
    Nome varchar(255) NOT NULL,
    Titulação varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Sexo char(1) NOT NULL
);

CREATE TABLE ProfessoresConvidados(
    Ministra int NOT NULL,
    Universidade_origem varchar(255) NOT NULL,
    CPF varchar(15) NOT NULL,
    FOREIGN KEY (CPF) REFERENCES Professores(CPF)
);

CREATE TABLE ProfessoresEfetivo(
    Experiencia_empresarial int NOT NULL,
    Envolvido_pesquisa boolean NOT NULL,
    CPF varchar(15) NOT NULL,
    FOREIGN KEY (CPF) REFERENCES Professores(CPF)
);

CREATE TABLE Faculdades(
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sigla varchar(15) NOT NULL UNIQUE,
    NomeCompleto varchar(255) NOT NULL,
    ÁreaConhecimento INT NOT NULL,
    AnoCriação INT NOT NULL
);