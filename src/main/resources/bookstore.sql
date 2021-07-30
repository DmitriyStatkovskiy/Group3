CREATE TABLE IF NOT EXISTS books
(
    id          varchar(50) NOT NULL PRIMARY KEY,
    status      varchar(50),
    name        varchar(50),
    edition     varchar(50),
    price       money,
    description varchar(255),
    isOld       BOOLEAN,
    received    timestamp DEFAULT now()
);

CREATE TABLE IF NOT EXISTS orders
(
    id           varchar(50) NOT NULL PRIMARY KEY,
    customerName varchar(50),
    status       varchar(50),
    created      timestamp DEFAULT now(),
    closed       timestamp,
    price        money
);

CREATE TABLE IF NOT EXISTS requests
(
    id       varchar(50) NOT NULL PRIMARY KEY,
    status   varchar(50),
    quantity smallint,
    book_id  varchar(50)
);

CREATE TABLE IF NOT EXISTS book_order
(
    id       serial PRIMARY KEY,
    book_id  varchar(50),
    order_id varchar(50)
);


ALTER TABLE requests
    ADD FOREIGN KEY (book_id) REFERENCES books (id);

