create table patient
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	login VARCHAR(30),
	nom VARCHAR(30),
	prenom VARCHAR(30),
	password    VARCHAR(60),
	nivcourant	INT default 1,
	token VARCHAR(32),
	datechgtniv TIMESTAMP,
	nbtotcac INT,
	UNIQUE (login)
);
