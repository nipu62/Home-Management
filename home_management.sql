-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2016 at 05:23 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `home_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `authentication_reg`
--

CREATE TABLE IF NOT EXISTS `authentication_reg` (
  `log_in_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `family_location` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authentication_reg`
--

INSERT INTO `authentication_reg` (`log_in_id`, `username`, `password`, `family_location`) VALUES
(1, 'nipu', 'nipu', 'Dhaka'),
(2, 'urmee', 'urmee', 'Chittagong'),
(4, 'shoron', 'shoron', 'Sylhet'),
(5, 'ara', 'ara', 'Mymensingh'),
(7, 'F.R.I.E.N.D.S.', 'friends', 'CentralPark');

-- --------------------------------------------------------

--
-- Table structure for table `earning_member`
--

CREATE TABLE IF NOT EXISTS `earning_member` (
  `id` int(11) NOT NULL,
  `earningmember_name` varchar(30) NOT NULL,
  `earningmember_occupation` varchar(30) NOT NULL,
  `earningmember_income` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emergency_contacts`
--

CREATE TABLE IF NOT EXISTS `emergency_contacts` (
  `emergency_id` int(11) NOT NULL,
  `emergency_criteria` varchar(30) NOT NULL,
  `emergency_contact` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emergency_contacts`
--

INSERT INTO `emergency_contacts` (`emergency_id`, `emergency_criteria`, `emergency_contact`) VALUES
(7, 'Police', '9834726'),
(8, 'Ambulance', '083934'),
(9, 'Hospital', '9684438'),
(10, 'Fire Service', '0015267228'),
(11, 'Physician', '01728938290'),
(12, 'Electric Corporation', '8976547'),
(13, 'Disaster Management', '76785749'),
(14, 'Child Helpline', '765749'),
(15, 'WASA', '5476967');

-- --------------------------------------------------------

--
-- Table structure for table `family_info`
--

CREATE TABLE IF NOT EXISTS `family_info` (
  `log_in_id` int(11) NOT NULL,
  `family_name` varchar(30) NOT NULL,
  `member_id` int(11) NOT NULL,
  `member_name` varchar(30) NOT NULL,
  `member_gender` varchar(6) NOT NULL,
  `member_age` int(11) NOT NULL,
  `member_occupation` varchar(30) DEFAULT NULL,
  `member_income` int(11) DEFAULT NULL,
  `member_blood_group` varchar(3) NOT NULL,
  `member_contact_no` varchar(15) DEFAULT NULL,
  `member_location` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `family_info`
--

INSERT INTO `family_info` (`log_in_id`, `family_name`, `member_id`, `member_name`, `member_gender`, `member_age`, `member_occupation`, `member_income`, `member_blood_group`, `member_contact_no`, `member_location`) VALUES
(2, 'null', 11, 'Tania', 'Female', 23, 'Teacher', 25000, 'A+', '01782738277', 'sylhet'),
(2, 'null', 12, 'Ara', 'Female', 22, 'Student', 5000, 'A-', '01636362873', 'Mymensingh'),
(2, 'null', 21, 'Shoron', 'Female', 15, 'khai dai ghumai', 10, 'B+', '12345', 'Sylhet'),
(2, 'null', 23, 'Anika', 'Female', 10, 'Student', 0, 'B-', '', 'Dhaka'),
(2, 'null', 24, 'Urmee', 'Female', 17, 'Student', 4000, 'O+', '01922246387', 'Chittagong'),
(2, 'null', 25, 'Nipu', 'Female', 20, 'Student', 10, 'A+', '01962571891', 'Barishal'),
(2, 'null', 26, 'Khyo', 'Female', 5, '', 0, 'AB+', '093298893', 'Bandorban'),
(7, 'null', 29, 'Ross', 'Male', 30, 'Dinosaurs', 50000, 'O+', '911987644086', 'CentralPark'),
(7, 'null', 30, 'Monica', 'Female', 28, 'Cook', 40000, 'O-', '9916789157', 'CentralPark'),
(7, 'null', 31, 'Joey', 'Male', 30, 'Eating', 10000, 'B+', '9678907799', 'CentralPark'),
(7, 'null', 32, 'Rachel', 'Female', 25, 'Fashion', 34000, 'B+', '937689269', 'CentralPark'),
(7, 'null', 33, 'Chandler', 'Male', 30, 'Transponster', 60000, 'AB-', '93456819936', 'CentralPark');

-- --------------------------------------------------------

--
-- Table structure for table `monthly_expenses`
--

CREATE TABLE IF NOT EXISTS `monthly_expenses` (
  `log_in_id` int(11) NOT NULL,
  `month_id` int(11) NOT NULL,
  `month_name` varchar(30) NOT NULL,
  `rent_expense` int(11) DEFAULT NULL,
  `food_expense` int(11) DEFAULT NULL,
  `electricity_expense` int(11) DEFAULT NULL,
  `gass_expense` int(11) DEFAULT NULL,
  `water_expense` int(11) DEFAULT NULL,
  `transport_expense` int(11) DEFAULT NULL,
  `tution_expense` int(11) DEFAULT NULL,
  `phone_expense` int(11) DEFAULT NULL,
  `shopping_expense` int(11) DEFAULT NULL,
  `cable_expense` int(11) DEFAULT NULL,
  `internet_expense` int(11) DEFAULT NULL,
  `utility_expense` int(11) DEFAULT NULL,
  `travelling_expense` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monthly_expenses`
--

INSERT INTO `monthly_expenses` (`log_in_id`, `month_id`, `month_name`, `rent_expense`, `food_expense`, `electricity_expense`, `gass_expense`, `water_expense`, `transport_expense`, `tution_expense`, `phone_expense`, `shopping_expense`, `cable_expense`, `internet_expense`, `utility_expense`, `travelling_expense`, `total`) VALUES
(7, 19, 'January', 27000, 3000, 300, 550, 330, 560, 470, 387, 2500, 400, 400, 1400, 3000, NULL),
(7, 20, 'February', 30000, 6500, 300, 270, 410, 300, 700, 300, 5000, 500, 2000, 700, 350, NULL),
(7, 21, 'March', 30000, 3000, 530, 470, 550, 690, 3500, 500, 6700, 300, 270, 300, 340, NULL),
(7, 22, 'April', 28000, 4500, 560, 1000, 640, 360, 3000, 470, 1000, 2000, 200, 400, 250, NULL),
(7, 23, 'May', 3000, 4000, 500, 300, 500, 2000, 4000, 400, 3000, 400, 360, 200, 1500, NULL),
(7, 24, 'June', 24000, 5000, 1000, 200, 200, 2000, 3000, 400, 1000, 100, 200, 500, 2000, NULL),
(7, 25, 'July', 30000, 2000, 1000, 300, 200, 1500, 2000, 200, 2000, 300, 200, 1400, 1000, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `monthly_review`
--

CREATE TABLE IF NOT EXISTS `monthly_review` (
  `log_in_id` int(11) NOT NULL,
  `review_id` int(11) NOT NULL,
  `month_name` varchar(30) NOT NULL,
  `month_income` int(11) DEFAULT NULL,
  `month_saving` int(11) DEFAULT NULL,
  `month_ratio` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `monthly_review`
--

INSERT INTO `monthly_review` (`log_in_id`, `review_id`, `month_name`, `month_income`, `month_saving`, `month_ratio`) VALUES
(7, 24, 'January', 50000, NULL, NULL),
(7, 25, 'February', 60000, NULL, NULL),
(7, 26, 'March', 55000, NULL, NULL),
(7, 27, 'April', 70000, NULL, NULL),
(7, 28, 'May', 62000, NULL, NULL),
(7, 29, 'June', 72000, NULL, NULL),
(7, 30, 'February', 50000, NULL, NULL),
(7, 31, 'February', 50000, NULL, NULL),
(7, 32, 'January', 70000, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `authentication_reg`
--
ALTER TABLE `authentication_reg`
  ADD PRIMARY KEY (`log_in_id`);

--
-- Indexes for table `earning_member`
--
ALTER TABLE `earning_member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emergency_contacts`
--
ALTER TABLE `emergency_contacts`
  ADD PRIMARY KEY (`emergency_id`);

--
-- Indexes for table `family_info`
--
ALTER TABLE `family_info`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `log_in_id` (`log_in_id`);

--
-- Indexes for table `monthly_expenses`
--
ALTER TABLE `monthly_expenses`
  ADD PRIMARY KEY (`month_id`),
  ADD KEY `log_in_id` (`log_in_id`);

--
-- Indexes for table `monthly_review`
--
ALTER TABLE `monthly_review`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `log_in_id` (`log_in_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authentication_reg`
--
ALTER TABLE `authentication_reg`
  MODIFY `log_in_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `earning_member`
--
ALTER TABLE `earning_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `emergency_contacts`
--
ALTER TABLE `emergency_contacts`
  MODIFY `emergency_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `family_info`
--
ALTER TABLE `family_info`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `monthly_expenses`
--
ALTER TABLE `monthly_expenses`
  MODIFY `month_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `monthly_review`
--
ALTER TABLE `monthly_review`
  MODIFY `review_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `family_info`
--
ALTER TABLE `family_info`
  ADD CONSTRAINT `family_info_ibfk_1` FOREIGN KEY (`log_in_id`) REFERENCES `authentication_reg` (`log_in_id`);

--
-- Constraints for table `monthly_expenses`
--
ALTER TABLE `monthly_expenses`
  ADD CONSTRAINT `monthly_expenses_ibfk_1` FOREIGN KEY (`log_in_id`) REFERENCES `authentication_reg` (`log_in_id`);

--
-- Constraints for table `monthly_review`
--
ALTER TABLE `monthly_review`
  ADD CONSTRAINT `monthly_review_ibfk_1` FOREIGN KEY (`log_in_id`) REFERENCES `authentication_reg` (`log_in_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
