CREATE TABLE IF NOT EXISTS `customer`(
`customer_id` int AUTO_INCREMENT PRIMARY KEY,
`first_name` varchar(100) NOT NULL,
`last_name` varchar(100),
`email` varchar(100) NOT NULL,
`age` int
);

