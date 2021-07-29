CREATE TABLE if not exists product
(
    model  varchar(50) NOT NULL PRIMARY KEY,
    maker  varchar(10),
    "type" varchar(50)
);

CREATE TABLE if not exists pc
(
    code  int   NOT NULL PRIMARY KEY,
    model varchar(50),
    speed smallint,
    ram   smallint,
    hd    real,
    cd    varchar(10),
    price money NOT NULL

);

CREATE TABLE if not exists laptop
(
    code   int   NOT NULL PRIMARY KEY,
    model  varchar(50),
    speed  smallint,
    ram    smallint,
    hd     real,
    price  money NOT NULL,
    screen smallint

);
CREATE TABLE if not exists printer
(
    code   int   NOT NULL PRIMARY KEY,
    model  varchar(50),
    color  char(1),
    "type" varchar(10),
    price  money NOT NULL

);
ALTER TABLE pc
    ADD FOREIGN KEY (model) REFERENCES product(model);

ALTER TABLE laptop
    ADD FOREIGN KEY (model) REFERENCES product(model);

ALTER TABLE printer
    ADD FOREIGN KEY (model) REFERENCES product(model);
