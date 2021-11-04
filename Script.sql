--<ScriptOptions statementTerminator=";"/>

CREATE TABLE devolucao (
	Id BIGINT NOT NULL,
	Data_Devolucao DATE,
	Obs_Devolucao VARCHAR(255),
	Qtd_Devolvida INT,
	Siape_Admin_Recebe BIGINT,
	Id_Emprestimo BIGINT NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE hibernate_sequence (
	next_val BIGINT,
	next_val BIGINT
);

CREATE TABLE material (
	Id BIGINT NOT NULL,
	Descricao VARCHAR(255) NOT NULL,
	Estado_De_Conservacao VARCHAR(255),
	Qtd_Estoque INT NOT NULL,
	Qtd_Emprestado INT,
	Valor_Estimado DOUBLE,
	Status BIT NOT NULL,
	PRIMARY KEY (Id)
);

CREATE TABLE servidor (
	DTYPE VARCHAR(31) NOT NULL,
	Siape BIGINT NOT NULL,
	Email VARCHAR(255) NOT NULL,
	Nome VARCHAR(255) NOT NULL,
	Senha VARCHAR(255),
	Status BIT NOT NULL,
	PRIMARY KEY (Siape)
);

CREATE TABLE emprestimo (
	Id BIGINT NOT NULL,
	Data_Entrega DATE NOT NULL,
	Obs_Entrega VARCHAR(255),
	Qtd_Emprestada INT NOT NULL,
	Siape_Admin_Entrega BIGINT NOT NULL,
	Id_Material BIGINT NOT NULL,
	Siape_Servidor BIGINT NOT NULL,
	Qtd_Tot_Devolvida INT NOT NULL,
	PRIMARY KEY (Id)
);

CREATE INDEX FK1wxqskmbvrgtuosqik56rw2gr ON devolucao (Siape_Admin_Recebe ASC);

CREATE INDEX FKrywsevdww862lf2605xnqs8u5 ON devolucao (Id_Emprestimo ASC);

CREATE INDEX FKb3smpnlb45pno660gw2t9ewbh ON emprestimo (Siape_Servidor ASC);

CREATE INDEX FKqxki5xdj6qityu6rir1bdk5fw ON emprestimo (Siape_Admin_Entrega ASC);

CREATE INDEX FKs0gqym0mp3efkgij4reweasy5 ON emprestimo (Id_Material ASC);

ALTER TABLE servidor ADD PRIMARY KEY (Siape);

