
-- -- THIS IS ROLE DATA

INSERT into role(id, role_name)
VALUES(1,'ADMIN');
INSERT into role(id, role_name)
VALUES(2,'BANKER');
INSERT into role(id, role_name)
VALUES(3,'CUSTOMER');

 -- THIS IS USER DATA


INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES(1,'Tsigab', 'Berhe','456 454 4752','tsigab@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 1);

INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES(2,'Diana', 'Tesfay','315 543 6168','moses@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 2);

INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES(3,'Daniel','Meresie', '526 527 4522','daniel@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 2);

INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES(4,'Feven','Dawit', '562 588 1341','feven@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 3);

INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES (5,'Noad','Zere','456 652 6524','noad@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 3);

INSERT INTO users(id, first_name, last_name, phone_number, email, password, role_id)
VALUES(6,'Ariam','Yemane','567 245 2472','ariam@gmail.com', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 3);

--  THIS IS ACCOUNT DATA

INSERT INTO account(id, account_number, account_type, balance, created_at, users_id)
VALUES(1, '123524', 'saving', 80000, '2020-3-7', 4);

INSERT INTO account(id, account_number, account_type, balance,  created_at, users_id)
VALUES(2, '785834', 'checking', 60000, '2021-3-2', 4);

INSERT INTO account(id, account_number, account_type, balance,  created_at, users_id)
VALUES(3, '456475', 'saving', 70000, '2019-3-4', 5);

INSERT INTO account(id, account_number, account_type, balance,  created_at, users_id)
VALUES(4, '653473', 'checking', 50000, '2019-2-6', 5);

INSERT INTO account(id, account_number, account_type, balance,  created_at, users_id)
VALUES(5, '456472', 'saving', 30000, '2017-1-13', 6);

INSERT INTO account(id, account_number, account_type, balance, created_at, users_id)
VALUES(6, '0454524', 'checking', 20000, '2017-8-12', 6);

-- THIS IS TRANSACTION DATA

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(1, 400,'2023-4-5', '22:20:03',  'deposit', 80400, 1);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(2,600,'2023-2-5', '20:37:03', 'withdrawal',79800, 1);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(3,800,'2020-4-5', '22:24:54', 'deposit', 60800, 2);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(4,400,'2022-1-12', '18:19:43', 'withdrawal', 60400, 2);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(5,1000,'2021-2-14','12:26:33',  'deposit', 71000, 3);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(6,200,'2023-2-1', '10:10:03', 'deposit',50200 ,4);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(7,300,'2023-12-5', '13:19:03', 'deposit',50500, 4);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(8,400,'2022-9-5', '23:17:03', 'withdraw',29600, 5);

INSERT INTO transaction(id, amount, transaction_date, transaction_time,  transaction_type, transaction_balance, account_id)
VALUES(9,500,'2023-4-2', '21:35:03', 'deposit',20500, 6);


