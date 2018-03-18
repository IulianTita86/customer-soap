# customer-soap
Soap ws for add or update Customer

In order to run and test this soap service you need to rund the below script in Mysql to create a new db and customer table.
This is build whit Spring boot and the main entry point is main method. I used SoapUI for testing.


///// Script for create customersdb
CREATE DATABASE IF NOT EXISTS `customersdb`;
USE `customersdb`;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY unique_email (`email`)
) ENGINE=InnoDB;
//////////////////////////////////////////
