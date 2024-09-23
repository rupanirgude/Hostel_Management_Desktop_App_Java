-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2018 at 08:52 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `routroom` ()  Select FirstName,LastName,RoomNo from `register` where RoomNo=109$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `testrout` ()  Select FirstName,LastName,USN,Contact,Email from register$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Eid` varchar(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Designation` varchar(25) NOT NULL,
  `Department` varchar(25) NOT NULL,
  `Salary` int(25) NOT NULL,
  `Age` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `USN` varchar(15) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Fees` int(10) NOT NULL,
  `Paid` int(10) NOT NULL,
  `Balance` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`USN`, `Name`, `Fees`, `Paid`, `Balance`) VALUES
('1va16is052', 'ShubhamYadav', 60000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `loginlog`
--

CREATE TABLE `loginlog` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Time` varchar(25) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loginlog`
--

INSERT INTO `loginlog` (`Username`, `Password`, `Time`, `Date`) VALUES
('a', 'b', '23:28:20', '2018-11-12'),
('a', 'b', '23:29:30', '2018-11-12'),
('a', 'b', '13:50:23', '2018-11-13'),
('a', 'b', '14:04:09', '2018-11-13'),
('a', 'b', '17:55:05', '2018-11-13'),
('a', 'b', '19:01:31', '2018-11-14'),
('a', 'b', '19:03:59', '2018-11-14'),
('a', 'b', '20:00:57', '2018-11-14'),
('a', 'b', '20:01:42', '2018-11-14'),
('a', 'b', '20:02:27', '2018-11-14'),
('a', 'b', '21:07:04', '2018-11-14'),
('a', 'b', '21:07:58', '2018-11-14'),
('a', 'b', '21:09:04', '2018-11-14'),
('a', 'b', '21:25:55', '2018-11-14');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `USN` varchar(25) NOT NULL,
  `DOB` varchar(25) DEFAULT NULL,
  `CourseId` varchar(25) NOT NULL,
  `Contact` varchar(25) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PName` varchar(25) NOT NULL,
  `PLName` varchar(25) NOT NULL,
  `PContact` varchar(25) NOT NULL,
  `RoomNo` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`FirstName`, `LastName`, `USN`, `DOB`, `CourseId`, `Contact`, `Email`, `PName`, `PLName`, `PContact`, `RoomNo`) VALUES
('Shubham', 'Yadav', '1va16is052', 'Aug 4, 1998', 'B.Tech', '8951832355', 'shubham@saividya.ac.in', 'S S', 'Yadav', '864452001', '106');

--
-- Triggers `register`
--
DELIMITER $$
CREATE TRIGGER `random` AFTER UPDATE ON `register` FOR EACH ROW INSERT into updatelog VALUES(new.USN,now())
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `Eid` int(10) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Salary` int(25) NOT NULL,
  `Paid` int(25) NOT NULL,
  `Balance` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `updatelog`
--

CREATE TABLE `updatelog` (
  `USN` varchar(15) NOT NULL,
  `LastUpdate` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `updatelog`
--

INSERT INTO `updatelog` (`USN`, `LastUpdate`) VALUES
('1va16is057', '2018-11-13 13:53:24');

-- --------------------------------------------------------

--
-- Table structure for table `username`
--

CREATE TABLE `username` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `username`
--

INSERT INTO `username` (`Username`, `Password`) VALUES
('youtube', 'google'),
('a', 'b');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Eid`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`USN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
