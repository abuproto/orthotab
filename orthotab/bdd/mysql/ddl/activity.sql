CREATE TABLE activity
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    type    VARCHAR(30),
    dateactivite    TIMESTAMP,
    duree    INT,
    details         VARCHAR(255),
    idpatient	INT,
    nbechec INT,
    FOREIGN KEY (idpatient) REFERENCES patient(id)
);
