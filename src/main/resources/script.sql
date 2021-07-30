/*task1*/
SELECT model, speed, hd
FROM pc
WHERE price < '500';

/*task2*/
SELECT maker
FROM product
WHERE type = 'printer';

/*task3*/
SELECT model, ram, screen
FROM laptop
WHERE price > '1000';

/*task4*/
SELECT *
FROM printer
where color = 'y';

/*task5*/
SELECT model, speed, hd
FROM pc
WHERE (cd = 'x12' OR cd = 'x24')
  AND price < '600';

/*task6*/
SELECT maker, speed
FROM product
         INNER JOIN laptop l on product.model = l.model
where hd > 300;

/*task7*/
SELECT p.model, price
FROM product p,
     laptop l
WHERE p.model = l.model
  AND p.maker = 'AAA'
UNION
SELECT p.model, price
FROM product p,
     pc c
WHERE p.model = c.model
  AND p.maker = 'AAA'
UNION
SELECT p.model, price
FROM product p,
     printer r
WHERE p.model = r.model
  AND p.maker = 'AAA';

/*task8*/
SELECT maker
FROM product
WHERE type = 'pc' EXCEPT
SELECT DISTINCT maker
FROM product
Where type = 'laptop';

/*task9*/
SELECT DISTINCT maker
FROM pc
         INNER JOIN product ON pc.model = product.model
WHERE pc.speed >= 450;

/*task10*/
SELECT model, price
FROM printer
WHERE price = (SELECT MAX(price) FROM printer);

/*task11*/
SELECT AVG(speed)
FROM pc;

/*task12*/
SELECT AVG(speed)
FROM laptop
WHERE price > '1000';

/*task13*/
SELECT AVG(pc.speed)
FROM pc,
     product
WHERE pc.model = product.model
  AND product.maker = 'AAA';

/*task14*/
SELECT speed, sum(price) / count(price) AS avg_price
FROM pc
GROUP BY speed;


/*task15*/
SELECT hd
FROM pc
GROUP BY (hd)
HAVING COUNT(model) >= 2;

/*task16*/
SELECT DISTINCT p1.model, p2.model, p1.speed, p1.ram
FROM pc p1,
     pc p2
WHERE p1.speed = p2.speed
  AND p1.ram = p2.ram
  AND p1.model > p2.model;

/*task17*/
select distinct p.type, p.model, l.speed
from laptop l
         join product p on l.model = p.model
where l.speed < (select min(speed)
                 from pc);

/*task18*/
SELECT DISTINCT product.maker, printer.price
FROM product,
     printer
WHERE product.model = printer.model
  AND printer.color = 'y'
  AND printer.price = (
    SELECT MIN(price)
    FROM printer
    WHERE printer.color = 'y');

/*task19*/
SELECT product.maker,
       AVG(screen)
FROM laptop
         LEFT JOIN product ON product.model = laptop.model
GROUP BY product.maker;

/*task20*/
SELECT maker, COUNT(model)
FROM product
WHERE type = 'pc'
GROUP BY product.maker
HAVING COUNT(DISTINCT model) >= 3;

/*task21*/
SELECT product.maker, MAX(pc.price)
FROM product,
     pc
WHERE product.model = pc.model
GROUP BY product.maker;

/*task22*/
SELECT pc.speed, SUM(price) / COUNT(price) AS avg_price
FROM pc
WHERE pc.speed > 600
GROUP BY pc.speed;

/*task23*/
SELECT DISTINCT maker
FROM product t1
         JOIN pc t2 ON t1.model = t2.model
WHERE speed >= 750
  AND maker IN
      (SELECT maker
       FROM product t1
                JOIN laptop t2 ON t1.model = t2.model
       WHERE speed >= 750);

/*task24*/
SELECT model
FROM (
         SELECT model, price
         FROM pc
         UNION
         SELECT model, price
         FROM Laptop
         UNION
         SELECT model, price
         FROM Printer
     ) t1
WHERE price = (
    SELECT MAX(price)
    FROM (
             SELECT price
             FROM pc
             UNION
             SELECT price
             FROM Laptop
             UNION
             SELECT price
             FROM Printer
         ) t2
);

/*task25*/
SELECT DISTINCT maker
FROM product
WHERE model IN (
    SELECT model
    FROM pc
    WHERE ram = (
        SELECT MIN(ram)
        FROM pc
    )
      AND speed = (
        SELECT MAX(speed)
        FROM pc
        WHERE ram = (
            SELECT MIN(ram)
            FROM pc
        )
    )
)
  AND maker IN (
    SELECT maker
    FROM product
    WHERE type = 'printer'
);
