DROP SCHEMA IF EXISTS slanger_og_stiger CASCADE;
CREATE SCHEMA slanger_og_stiger;
SET search_path TO slanger_og_stiger;

-- 

CREATE TABLE Rute
(
    posisjon VARCHAR NOT NULL PRIMARY KEY,
    lengde VARCHAR NOT NULL,
    navn VARCHAR(30) CHECK(navn='Slange' OR navn='Stige') NOT NULL
);

INSERT INTO
  Rute(posisjon, lengde, navn)
VALUES
    (2, 36, 'Stige'),
    (4, 10, 'Stige'),
    (8, 23, 'Stige'),
    (16, 10, 'Slange'),
    (21, 21, 'Stige'),
    (28, 56, 'Stige'),
    (36, 8, 'Stige'),
    (47, 22, 'Slange'),
    (49, 38, 'Slange'),
    (51, 16, 'Stige'),
    (56, 3, 'Slange'),
    (62, 60, 'Slange'),
    (64, 4, 'Slange'),
    (71, 20, 'Stige'),
    (80, 20, 'Stige'),
    (87, 63, 'Slange'),
    (93, 20, 'Slange'),
    (95, 20, 'Slange'),
    (98, 20, 'Slange');
