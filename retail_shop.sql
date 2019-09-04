-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2019 at 06:00 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `retail_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_tbl`
--

CREATE TABLE `customer_tbl` (
  `customerId` int(11) NOT NULL,
  `customerName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product_tbl`
--

CREATE TABLE `product_tbl` (
  `productId` int(11) NOT NULL,
  `productName` varchar(250) NOT NULL,
  `productDescription` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_tbl`
--

INSERT INTO `product_tbl` (`productId`, `productName`, `productDescription`) VALUES
(8, 'Ndumaa', '                                                                \r\n                          Sweet roots\r\n                            '),
(10, 'BEANS', 'Healthy and nutriative proteins\r\n                            '),
(12, 'CHEESE', '\r\n                    healthy milk product        '),
(13, 'SUGAR', 'Pure without mercury\r\n                            \r\n                            '),
(14, 'APPLES', '\r\n               Keeps the doctor away             '),
(15, 'CAKE', 'sweet and delicious\r\n                            ');

-- --------------------------------------------------------

--
-- Table structure for table `receiving_tbl`
--

CREATE TABLE `receiving_tbl` (
  `batchNo` int(11) NOT NULL,
  `qty` int(200) NOT NULL,
  `receivalDate` date NOT NULL,
  `runningBalance` int(11) NOT NULL,
  `buyingPrice` double NOT NULL,
  `sellingPrice` double NOT NULL,
  `productId` int(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiving_tbl`
--

INSERT INTO `receiving_tbl` (`batchNo`, `qty`, `receivalDate`, `runningBalance`, `buyingPrice`, `sellingPrice`, `productId`) VALUES
(1, 20, '2019-08-28', 10, 100, 250, 2),
(2, 1000, '2019-08-28', 900, 100, 250, 1),
(3, 10002, '2019-09-02', 10002, 30, 80, 8),
(4, 1002, '2019-09-02', 1002, 40, 50, 10);

-- --------------------------------------------------------

--
-- Table structure for table `sale_tbl`
--

CREATE TABLE `sale_tbl` (
  `saleId` int(11) NOT NULL,
  `productId` int(150) NOT NULL,
  `saleDate` date NOT NULL,
  `qty` int(250) NOT NULL,
  `sellingPrice` double NOT NULL,
  `userId` int(150) NOT NULL,
  `userName` varchar(250) NOT NULL,
  `customerName` varchar(250) NOT NULL,
  `productName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_tbl`
--

INSERT INTO `sale_tbl` (`saleId`, `productId`, `saleDate`, `qty`, `sellingPrice`, `userId`, `userName`, `customerName`, `productName`) VALUES
(1, 1, '2019-08-28', 10, 250, 1, 'GEORGE', 'RISPER', 'WHEAT'),
(2, 2, '2019-08-28', 100, 250, 2, 'DENOH', 'AGNES', 'CASSAVA');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_tbl`
--

CREATE TABLE `supplier_tbl` (
  `supplierId` int(11) NOT NULL,
  `supplierName` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_tbl`
--

CREATE TABLE `user_tbl` (
  `userId` int(11) NOT NULL,
  `userName` varchar(250) NOT NULL,
  `userPassword` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tbl`
--

INSERT INTO `user_tbl` (`userId`, `userName`, `userPassword`) VALUES
(1, 'GEORGE', '1234'),
(2, 'PINTO', '123'),
(3, 'admin', '1234'),
(4, 'admin', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_tbl`
--
ALTER TABLE `customer_tbl`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `product_tbl`
--
ALTER TABLE `product_tbl`
  ADD PRIMARY KEY (`productId`);

--
-- Indexes for table `receiving_tbl`
--
ALTER TABLE `receiving_tbl`
  ADD PRIMARY KEY (`batchNo`);

--
-- Indexes for table `sale_tbl`
--
ALTER TABLE `sale_tbl`
  ADD PRIMARY KEY (`saleId`);

--
-- Indexes for table `supplier_tbl`
--
ALTER TABLE `supplier_tbl`
  ADD PRIMARY KEY (`supplierId`);

--
-- Indexes for table `user_tbl`
--
ALTER TABLE `user_tbl`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_tbl`
--
ALTER TABLE `customer_tbl`
  MODIFY `customerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product_tbl`
--
ALTER TABLE `product_tbl`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `receiving_tbl`
--
ALTER TABLE `receiving_tbl`
  MODIFY `batchNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sale_tbl`
--
ALTER TABLE `sale_tbl`
  MODIFY `saleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplier_tbl`
--
ALTER TABLE `supplier_tbl`
  MODIFY `supplierId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_tbl`
--
ALTER TABLE `user_tbl`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
