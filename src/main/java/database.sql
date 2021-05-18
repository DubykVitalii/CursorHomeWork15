CREATE
DATABASE table_airport;

CREATE SCHEMA public;

CREATE TABLE planes
(
    id    INT PRIMARY KEY,
    model TEXT,
    seats INT
);

CREATE table planes_in_airport
(
    id            INT PRIMARY KEY,
    id_planes     INT         NOT NULL,
    serial_number TEXT UNIQUE NOT NULL,
    CONSTRAINT serial_planes_planes_fk FOREIGN KEY (id_planes) REFERENCES planes (id)
);

CREATE table pilots
(
    id                  INT PRIMARY KEY,
    identification_code INT,
    name                TEXT NOT NULL,
    age                 INT  NOT NULL,
    id_planes           INT,
    CONSTRAINT pilots_planes_fk FOREIGN KEY (id_planes) REFERENCES planes (id)
);


INSERT INTO planes(id, model, seats)
VALUES (1, 'Boing 747', 467),
       (2, 'Airobus A320', 186);

INSERT INTO planes_in_airport(id, id_planes, serial_number)
VALUES (1, 1, 'BX5643'),
       (2, 1, 'BX5645'),
       (3, 2, 'AX5643'),
       (4, 2, 'AX5644'),
       (5, 2, 'AX5645'),
       (6, 2, 'AX5646'),
       (7, 2, 'AX5647');

INSERT INTO pilots (id, identification_code, name, age, id_planes)
VALUES (1, 23303540, 'Robert Smit', 35, 1),
       (2, 21234541, 'Joe Melan', 38, 1),
       (3, 20987642, 'Dan Simpson', 27, 2),
       (4, 26111143, 'James Bond', 39, 2),
       (5, 25222244, 'Viktor Pavelchak', 30, 2),
       (6, 27143545, 'Donald Burn', 33, 2),
       (7, 25222244, 'Viktor Pavelchak', 30, 1);