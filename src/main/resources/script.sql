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
SELECT p.model, price FROM product p, laptop l WHERE
        p.model = l.model AND p.maker = 'AAA'
UNION
SELECT p.model, price FROM product p, pc c WHERE
        p.model = c.model AND p.maker = 'AAA'
UNION
SELECT p.model, price FROM product p, printer r WHERE
        p.model = r.model AND p.maker = 'AAA';
/*task8*/
/*task9*/
/*task10*/
/*task11*/
/*task12*/
/*task13*/
/*task14*/
/*task15*/
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

