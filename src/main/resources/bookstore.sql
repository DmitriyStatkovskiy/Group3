CREATE TABLE IF NOT EXISTS books
(
    id          serial NOT NULL PRIMARY KEY,
    status      varchar(50),
    name        varchar(50),
    edition     varchar(50),
    price       money,
    description varchar(255),
    isOld       BOOLEAN,
    received    timestamp DEFAULT now(),
    order_id    integer
);

CREATE TABLE IF NOT EXISTS orders
(
    id            serial NOT NULL PRIMARY KEY,
    customer_name varchar(50),
    status        varchar(50),
    created       timestamp DEFAULT now(),
    closed        timestamp,
    price         money
);

CREATE TABLE IF NOT EXISTS requests
(
    id       serial NOT NULL PRIMARY KEY,
    status   varchar(50),
    quantity smallint,
    book_id  integer
);

ALTER TABLE requests
    ADD FOREIGN KEY (book_id) REFERENCES books (id);


ALTER TABLE books
    ADD FOREIGN KEY (order_id) REFERENCES orders (id);