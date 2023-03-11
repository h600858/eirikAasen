SET search_path TO oblig3;
CREATE TABLE ansatt(
AnsattID SERIAL UNIQUE,
Brukernavn CHAR(4) PRIMARY KEY,
Fornavn VARCHAR(45) NOT NULL,
Etternavn VARCHAR(45) NOT NULL,
AnsettelseDato DATE NOT NULL,
Stilling VARCHAR(15) NOT NULL,
Maanedslonn INTEGER NOT NULL
)

CREATE TABLE Avdeling(
AvdelingID SERIAL,
AvdelingNavn VARCHAR(45) NOT NULL,
SjefBrukernavn VARCHAR(4) UNIQUE NOT NULL,
PRIMARY KEY (AvdelingID),
FOREIGN KEY(SjefBrukernavn) REFERENCES ansatt(brukernavn)