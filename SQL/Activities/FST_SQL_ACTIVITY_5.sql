INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

--All rows are inserted 
INSERT ALL
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;
-- Run Query for check table data
SELECT * FROM salesman;

UPDATE salesman SET grade=90 WHERE salesman_city='Rome';

UPDATE salesman SET grade=20 WHERE salesman_name='James Hoog';

SELECT * FROM salesman;

UPDATE salesman SET grade=20 WHERE salesman_name='Pit Alex';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;