CREATE TABLE ers_user_roles(
	ERS_USER_ROLE_ID serial PRIMARY KEY,
	USER_ROLE varchar(10) NOT NULL
);

CREATE TABLE ers_reimbursement_type(
	REIMB_TYPE_ID serial PRIMARY KEY,
	REIMB_TYPE varchar(10) NOT NULL
);

CREATE TABLE ers_reimbursement_status(
	REIMB_STATUS_ID serial PRIMARY KEY,
	REIMB_STATUS varchar(10) NOT NULL
);

CREATE TABLE ers_users(
	ERS_USERS_ID serial PRIMARY KEY,
	ERS_USERNAME varchar(50) NOT NULL,
	ERS_PASSWORD varchar(50) NOT NULL,
	USER_FIRST_NAME varchar(100) NOT NULL,
	USER_LAST_NAME varchar(100) NOT NULL,
	USER_EMAIL  varchar(150) NOT NULL,
	USER_ROLE_ID int NOT NULL,
	FOREIGN KEY (USER_ROLE_ID)
		REFERENCES ers_user_roles(ERS_USER_ROLE_ID),
	CONSTRAINT uc_user UNIQUE (ERS_USERNAME, USER_EMAIL)
);

CREATE TABLE ers_reimbursement(
	REIMB_ID serial PRIMARY KEY,
	REIMB_AMOUNT DECIMAL NOT NULL,
	REIMB_SUBMITTED timestamp DEFAULT CURRENT_TIMESTAMP,
	REIMB_RESOLVED timestamp,
	REIMB_DESCRIPTION varchar(250),
	REIMB_AUTHOR int NOT NULL,
	REIMB_RESOLVER int,
	REIMB_STATUS_ID int NOT NULL,
	REIMB_TYPE_ID int NOT NULL,
	FOREIGN KEY (REIMB_AUTHOR) REFERENCES
	ers_users(ERS_USERS_ID),
	FOREIGN KEY (REIMB_RESOLVER) REFERENCES
	ers_users(ERS_USERS_ID),
	FOREIGN KEY (REIMB_STATUS_ID) REFERENCES
	ers_reimbursement_status(REIMB_STATUS_ID),
	FOREIGN KEY (REIMB_TYPE_ID) REFERENCES
	ers_reimbursement_type(REIMB_TYPE_ID)
);


DROP TABLE ers_reimbursement;
DROP TABLE ers_users;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_user_roles;

INSERT INTO ers_user_roles(USER_ROLE)
VALUES 
	('manager'),
	('employee');
	
INSERT INTO ers_reimbursement_type(REIMB_TYPE)
VALUES 
	('LODGING'),
	('TRAVEL'),
	('FOOD'),
	('OTHER');

INSERT INTO ers_reimbursement_status(REIMB_STATUS)
VALUES 
	('pending'),
	('approved'),
	('denied');

INSERT INTO ers_users(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES 
	('vikwald1999', '2manypuppies!', 'Viktoria', 'Waldroup', 'vik@gmail.com', 2),
	('diaspora', 'askJenkins', 'Demetra', 'Sikora', 'diaspora@hotmail.com', 2),
	('GimDeanWhiskey', '$Slainte!$', 'Dean', 'Gim', 'GimMeSum@yahoo.com', 2),
	('Niceshoesbud', '#k7*A!687c', 'Nandita', 'Petrosyan', 'petrolpetro@mail.com', 2),
	('SoriaMoria', 'Sc4leTheSumm!t', 'Jorrit', 'Blythe', 'yourBoss@company.com', 1),
	('DanicaFrost', '#j2va!i66s', 'Danica', 'Frost', 'dfrost@frost.com', 2),
	('6ers4ever' , 'stanTheMan2', 'Able', 'Cartwright', 'polkadot@gmail.com', 2);

INSERT INTO ers_reimbursement(REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID)
VALUES 
	(137.99, DEFAULT, '1999-01-01 00:00:01', 'One night lodging Best Western Billings, MT', 1, 5, 3, 1),
	(158.99, DEFAULT , '2000-01-01 00:00:01', 'One night lodging Best Western Billings, MT', 1, 5, 3, 1),
	(65.33, DEFAULT , '2007-11-13 15:15:15', 'Client meeting at Charlie''s Steakhouse', 2, 5, 2, 3),
	(1473.12, DEFAULT , '2012-12-20 12:20:12', 'First class airfare to conference', 3, 5, 2, 2),
	(44.44, DEFAULT , CAST(NULL AS timestamp) , 'Seasonal pine tree for office party', 4, NULL, 1, 4);

SELECT * FROM ers_user_roles;
SELECT * FROM ers_reimbursement_type;
SELECT * FROM ers_reimbursement_status;
SELECT * FROM ers_reimbursement;
SELECT * FROM ers_users;

INSERT INTO ers_users(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES 
	('test', 'test', 'test', 'manager', 'test@gmail.com', 1);

INSERT INTO ers_users(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES 
	('emp', 'emp', 'test', 'employee', 'employee@gmail.com', 2);

INSERT INTO ers_users(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID)
VALUES 
	('DeafZeppelin', '456plm%%', 'Marticia', 'Ross', 'oldschool@hotmail.com', 1);
	
