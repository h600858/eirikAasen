DROP SCHEMA IF EXISTS deltagere CASCADE;
CREATE SCHEMA deltagere;
SET search_path TO deltagere;

CREATE TABLE deltager
(
fornavn VARCHAR NOT NULL,
etternavn VARCHAR NOT NULL,
mobil INTEGER PRIMARY KEY,
hash VARCHAR NOT NULL,
salt VARCHAR NOT NULL,
passord VARCHAR NOT NULL,
kjonn CHAR CHECK(kjonn='M' OR kjonn='K') NOT NULL
);