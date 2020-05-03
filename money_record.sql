-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2020 at 03:01 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `money_record`
--

-- --------------------------------------------------------

--
-- Table structure for table `goals`
--

CREATE TABLE `goals` (
  `goals_id` int(4) NOT NULL,
  `budget` int(11) NOT NULL,
  `goals_name` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL,
  `user_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goals`
--

INSERT INTO `goals` (`goals_id`, `budget`, `goals_name`, `status`, `user_id`) VALUES
(1, 1000000, 'tabungan beli gadget', 'Done', 1),
(3, 1250000, 'Beli Laptop', 'Done', 2),
(4, 5000000, 'Beli HP', 'Not Yet', 2);

-- --------------------------------------------------------

--
-- Table structure for table `goals_detail`
--

CREATE TABLE `goals_detail` (
  `detail_id` int(4) NOT NULL,
  `goals_date` date NOT NULL,
  `amount` int(11) NOT NULL,
  `gtotal` int(11) NOT NULL,
  `goals_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goals_detail`
--

INSERT INTO `goals_detail` (`detail_id`, `goals_date`, `amount`, `gtotal`, `goals_id`) VALUES
(1, '2020-05-30', 500000, 500000, 1),
(2, '2020-05-31', 600000, 1100000, 1),
(4, '2020-05-03', 10000, 10000, 3),
(5, '2020-05-03', 250000, 250000, 4),
(7, '2020-05-03', 1000000, 1010000, 3),
(8, '2020-05-03', 240000, 1250000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tabungan`
--

CREATE TABLE `tabungan` (
  `tabungan_id` int(4) NOT NULL,
  `user_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabungan`
--

INSERT INTO `tabungan` (`tabungan_id`, `user_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tabungan_detail`
--

CREATE TABLE `tabungan_detail` (
  `tdetail_id` int(4) NOT NULL,
  `date` date NOT NULL,
  `description` text NOT NULL,
  `income` int(11) NOT NULL,
  `outcome` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `tabungan_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabungan_detail`
--

INSERT INTO `tabungan_detail` (`tdetail_id`, `date`, `description`, `income`, `outcome`, `total`, `tabungan_id`) VALUES
(1, '2020-04-30', 'Gaji', 100000, 0, 100000, 1),
(2, '2020-05-01', 'Bayar Kost', 0, 50000, 50000, 1),
(3, '2020-05-03', 'THR', 70000, 0, 70000, 2),
(4, '2020-05-03', 'Bulanan', 30000, 0, 100000, 2),
(5, '2020-05-03', 'Makan', 0, 10000, 90000, 2),
(6, '2020-05-03', 'Bulanan', 100000, 0, 150000, 1),
(7, '2020-05-03', 'Makan', 0, 15000, 135000, 1),
(9, '2020-05-03', 'Beli Sepatu', 0, 90000, 0, 2),
(10, '2020-05-03', 'Nemu Dijalan', 10000, 0, 10000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `email`, `password`) VALUES
(1, 'yesyua', 'yesyua@gmail.com', 'yesyua20'),
(2, 'args06', 'anjar@gmail.com', 'anjar'),
(3, 'ardt26', 'acool90@yahoo.co.id', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `goals`
--
ALTER TABLE `goals`
  ADD PRIMARY KEY (`goals_id`),
  ADD KEY `fk_user2` (`user_id`);

--
-- Indexes for table `goals_detail`
--
ALTER TABLE `goals_detail`
  ADD PRIMARY KEY (`detail_id`),
  ADD KEY `fk_goals` (`goals_id`);

--
-- Indexes for table `tabungan`
--
ALTER TABLE `tabungan`
  ADD PRIMARY KEY (`tabungan_id`),
  ADD KEY `fk_user1` (`user_id`);

--
-- Indexes for table `tabungan_detail`
--
ALTER TABLE `tabungan_detail`
  ADD PRIMARY KEY (`tdetail_id`),
  ADD KEY `fk_tabungan` (`tabungan_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `goals`
--
ALTER TABLE `goals`
  MODIFY `goals_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `goals_detail`
--
ALTER TABLE `goals_detail`
  MODIFY `detail_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tabungan`
--
ALTER TABLE `tabungan`
  MODIFY `tabungan_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tabungan_detail`
--
ALTER TABLE `tabungan_detail`
  MODIFY `tdetail_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `goals`
--
ALTER TABLE `goals`
  ADD CONSTRAINT `fk_user2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `goals_detail`
--
ALTER TABLE `goals_detail`
  ADD CONSTRAINT `fk_goals` FOREIGN KEY (`goals_id`) REFERENCES `goals` (`goals_id`);

--
-- Constraints for table `tabungan`
--
ALTER TABLE `tabungan`
  ADD CONSTRAINT `fk_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `tabungan_detail`
--
ALTER TABLE `tabungan_detail`
  ADD CONSTRAINT `fk_tabungan` FOREIGN KEY (`tabungan_id`) REFERENCES `tabungan` (`tabungan_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
