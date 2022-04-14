CREATE TABLE IF NOT EXISTS bank(
   bank_id integer,
   bankname VARCHAR(60),
    customer_account_number bigserial
);



CREATE TABLE IF NOT EXISTS customers (
    customer_id integer,
    firstname VARCHAR(60),
    lastname VARCHAR(60),
    age integer,
    address VARCHAR(60)
);


CREATE TABLE IF NOT EXISTS account (
   account_id integer ,
   accountnumber bigserial,
   balance double precision,
   interest double precision
);

select * from account;
select * from bank;
select * from customers;

drop table customers;
drop table account;
drop table bank;