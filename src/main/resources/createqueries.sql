CREATE TABLE USER
(
ID INT PRIMARY KEY AUTO_INCREMENT,
FIRST_NAME VARCHAR(30) NOT NULL,
LAST_NAME VARCHAR(30) NOT NULL,
LOGINID VARCHAR(15) NOT NULL,
PASSWORD VARCHAR(20) NOT NULL,
ADDRESS VARCHAR(40) NOT NULL,
EMAIL VARCHAR(40) NOT NULL,
PHONE VARCHAR(15) NOT NULL,
JOIN_DATE DATE NOT NULL,
CREATED TIMESTAMP DEFAULT NOW()
);