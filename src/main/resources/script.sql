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
SELECT AVG(speed) FROM pc;

/*task12*/
SELECT AVG(speed)
FROM laptop
WHERE price > '1000';

/*task13*/
SELECT AVG(pc.speed)
FROM pc, product
WHERE pc.model = product.model AND product.maker = 'AAA';

/*task14*/
SELECT speed, sum(price)/count(price) AS avg_price
FROM pc
GROUP BY speed;


/*task15*/
SELECT hd FROM pc GROUP BY (hd) HAVING COUNT(model) >= 2;

/*task16*/
/*task17*/
/*task18*/
/*task19*/
/*task20*/
/*task21*/
/*task22*/
/*task23*/
/*task24*/
/*task25*/

