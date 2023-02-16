-- THIS IS USER DATA


INSERT INTO users(id, email, password, role_id)
VALUES(1,'tsigab@gmail.com', 123, 1);

INSERT INTO users(id, email, password, role_id)
VALUES(2,'moses@gmail.com', 123, 2);

INSERT INTO users(id, email, password, role_id)
VALUES(3,'daniel@gmail.com', 123, 2);

INSERT INTO users(id, email, password, role_id)
VALUES(4,'feven@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES(5,'daniel@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES (6,'moses@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES(7,'noad@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES(8,'yodit@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES(9,'ariam@gmail.com', 123, 3);

INSERT INTO users(id, email, password, role_id)
VALUES(10,'hagos@gmail.com',123, 3);


-- THIS IS CUSTOMER DATA

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(1, 'Daniel', 'Merseie', '602 347 3432', 5);

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(2, 'Moses', 'Dawit', '602 347 8755', 6);

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(3, 'Noad', 'Zere', '602 347 3454', 7);

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(4, 'yodit', 'Abraha', '602 347 5643', 8);

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(5, 'Ariam', 'yemane', '602 347 3546', 9);

INSERT INTO customer(id, first_name, last_name, phone_number, user_id)
VALUES(6, 'Hagos', 'Suzinino', '602 347 6666', 10);


-- THIS IS ACCOUNT DATA

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(1, '123524', 'saving', 80000, '2020-3-7', 1);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(2, '785834', 'checking', 60000, '2021-3-2', 1);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(3, '456475', 'saving', 70000, '2019-3-4', 2);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(4, '653473', 'checking', 50000, '2019-2-6', 2);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(5, '456472', 'saving', 30000, '2017-1-13', 3);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(6, '0454524', 'saving', 20000, '2017-8-12', 4);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(7, '54723', 'saving', 10000, '2018-3-6', 5);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(8, '54783', 'saving', 40000, '2020-12-17', 6);

INSERT INTO account(id, account_number, account_type, balance, created-at, customer_id)
VALUES(9, '123524', 'checking', 90000, '2020-8-2', 6);


-- THIS IS TRANSACTION DATA

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(1,400,'2023-4-5', '12:00', 'deposit', 1);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(2,600,'2023-2-5', '1:00', 'withdrawal', 1);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(3,800,'2020-4-5', '8:00', 'deposit', 2);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(4,400,'2022-1-12', '7:00', 'withdrawal', 2);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(5,1000,'2021-2-14', '2:00', 'deposit', 3);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(6,200,'2023-2-1', '3:00', 'deposit', 4);

INSERT INTO transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(7,300,'2023-12-5', '12:00', 'deposit', 4);

INSERT into transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(8,400,'2022-9-5', '12:00', 'withdraw', 5);

INSERT into transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(9,500,'2023-4-2', '12:00', 'deposit', 6);

value INSERT into transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(10,1200,'2023-4-2', '12:00', 'deposit', 7);

INSERT into transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(11,100,'2023-4-2', '12:00', 'deposit', 8);

INSERT into transaction(id, amount, transaction_date, transaction_time, transaction_type, account_id)
VALUES(9,400,'2022-3-7','12:00', 'withdrawal',9)


-- THIS IS ROLE DATA

INSERT into role(id, role_name)
VALUES(1,'ADMIN');
INSERT into role(id, role_name)
VALUES(2,'BANKER');
INSERT into role(id, role_name)
VALUES(3,'CUSTOMER');