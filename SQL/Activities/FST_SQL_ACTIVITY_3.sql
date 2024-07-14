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

-- Run table data for only 2 colum
SELECT salesman_id, salesman_city FROM salesman;

-- Verify data for city paris only
SELECT * FROM salesman WHERE salesman_city='Paris';

-- Check data only for 2 colum with spacifc salesman_name
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';