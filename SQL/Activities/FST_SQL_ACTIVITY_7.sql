REM   Script: Activity 8
REM   Activity 8 aggregator functions

select * from scott.emp;

Select empno, ename,MGR from scott.emp e where e.EMPNO=e.MGR;

select * from scott.emp;

Select empno, ename,MGR from scott.emp e,scott.emp m where e.EMPNO=m.MGR;

Select e.empno, e.ename,m.MGR,m.ename from scott.emp e,scott.emp m where e.EMPNO=m.MGR;

select * from scott.emp;

select * from orders;

select * from oe.orders;

select SUM(purchase_amount) AS "Total sum" from oe.orders;

select SUM(oe.purchase_amount) AS "Total sum" from oe.orders;

select * from scott.emp;

select SUM(SAL) AS "Total sum" from scott.emp;

select Avg(SAL) AS "Avarage" from scott.emp;

select round(Avg(SAL)) AS "Avarage" from scott.emp;

select max(SAL) AS "Avarage" from scott.emp;

select min(SAL) AS "Min Salary" from scott.emp;

select count(*) AS "Total row" from scott.emp;

