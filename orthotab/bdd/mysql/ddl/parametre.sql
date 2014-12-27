CREATE TABLE parametre
(
    id       INT PRIMARY KEY,
    cle    VARCHAR(30),
    valeur         VARCHAR(60),
    idpatient	INT,
    FOREIGN KEY (idpatient) REFERENCES patient(id)
);
