create table PRODUCT(
  `ID` int NOT NULL AUTO_INCREMENT,
  `product_Name` varchar NOT NULL ,
  `description` varchar NOT NULL ,
  `quantity` int NOT NULL,
  `price` float NOT NULL,
  `merchant_Id` int not null,
   PRIMARY KEY (`ID`));

insert into PRODUCT (product_Name,description,quantity,price,merchant_Id) values
('Lenovo-Laptop-Model-1000','Ram-8 GB, Processor-core i9',10,50000.50,1),
('Lenovo-Laptop-Model-2000','Ram-16 GB, Processor-core i7',10,100000.50,1),
('Lenovo-Laptop-Model-1000','Ram-8 GB, Processor-core i9',10,50000.50,2),
('Lenovo-Laptop-Model-2000','Ram-16 GB, Processor-core i7',10,100000.50,2);