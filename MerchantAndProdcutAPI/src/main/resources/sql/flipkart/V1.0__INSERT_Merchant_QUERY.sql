create table Merchant(
  `ID` int NOT NULL AUTO_INCREMENT,
  `first_Name` varchar NOT NULL ,
  `middle_Name` varchar DEFAULT NULL ,
  `last_Name` varchar NOT NULL ,
  `gender` varchar NOT NULL ,
  `email` varchar NOT NULL ,
  `country` varchar NOT NULL ,
  `password` varchar NOT NULL ,
  UNIQUE(email),
   PRIMARY KEY (`ID`));

insert into Merchant (first_Name,middle_Name,last_Name,gender,email,country,password) values
('John','', 'Smith','Male','john@gmail.com','India','John@1234'),
('Ram','Charan', 'Teja','Male','ram@gmail.com','India','Ram@1234');