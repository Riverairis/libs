-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 02:28 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `book_id` int(20) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `quantity` int(20) NOT NULL,
  `Publisher` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `Author`, `quantity`, `Publisher`) VALUES
(1, 'Harry Potter and Goblet of Fire', 'J. K. Rowling', 3, 'Pottermore'),
(5, 'we', 'we', 4, 'sfdf'),
(6, 'sf', 'asf', 5, 'sfsf'),
(7, 'Harry Potter and Deathly Hallow', 'J. K. Rowling', 0, 'Pottermore'),
(8, 'Pride and Prejudice', 'Alexander Dumas', 0, 'Pearson'),
(9, 'To Kill A Mocking Bird', 'Harper Lee', 4, 'McGraw'),
(10, 'The Hunger Games', 'Suzanne Collins', 0, 'Pearson'),
(11, 'The Perks Of being A Wallflower', 'Stephen Chbosky', 0, 'Klett'),
(12, 's', 'asf', 0, 'asf'),
(13, 'SD', 'adas', 4, 'asdsa'),
(15, 'sad', 'asdsa', 5, 'asdsa'),
(16, 'sda', 'asda', 4, 'asdas'),
(17, 'AS', 'asA', 0, 'aSAS'),
(19, 'sd', 'ddf', 0, 'sdff');

-- --------------------------------------------------------

--
-- Table structure for table `borrowings`
--

CREATE TABLE `borrowings` (
  `bor_id` int(20) NOT NULL,
  `book_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `return_date` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `borrowings`
--

INSERT INTO `borrowings` (`bor_id`, `book_id`, `u_id`, `Status`, `return_date`) VALUES
(68, 13, 28, 'Borrowed', '2024-05-14'),
(70, 9, 28, 'Borrowed', '2024-05-19'),
(75, 1, 30, 'Borrowed', '2024-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `tbl`
--

CREATE TABLE `tbl` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `Number` varchar(11) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl`
--

INSERT INTO `tbl` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_status`, `u_type`, `Number`, `u_image`) VALUES
(1, 'irisup', 'kamylle', 'kai@gmail.com', 'kits', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '0', ''),
(2, 'Kaiupdaye', 'Delimanpdate', 'kai@gmail.ph', 'kaiup', 'CP3AhUTcBfcPrqT57CmcyNDXRM2zkrfCgmKVeQe0FX0=', 'Pending', 'Admin', '2147483647', ''),
(6, 'mikey', 'you', 'trazona@gmail.com', 'mikey', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Archived', 'Admin', '2147483647', ''),
(7, 'kliey', 'ryuga', 'bfklfbk', 'ryuga', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647', ''),
(22, 'eq', 'qe', 'kot@gmail.com', 'mike', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '0', ''),
(27, 'awda', 'as', 'assf', 'aff', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'Admin', '2147483647', ''),
(28, 'sf', 'sf', 'asf@gmail.com', 'bio', 'pGHqDEbhwE1ocbSqKnOMilXFYqm/V03w4bN9Z9rPDHc=', 'Active', 'User', '0', ''),
(29, 'dsa', 'adad', 'daa', 'dff', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '0', ''),
(30, 'dgs', 'sdgsd', 'sdg', 'xx', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '0', ''),
(39, 'jemari', 'jermari', 'jemari@gmai.com', 'jemari', 'zBwvtYaV2Ne4jbz30tO/pPWlQYo+6iIDW06858KZWRE=', 'Archive', 'Admin', '', ''),
(64, 'dsds', 'sdss', 'sdsd@gmail.com.up', 'sadasd', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Pending', 'Admin', '', ''),
(68, 'sdas', 'asdsad', 'sdad@gmail.com', 'asgdfgd', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'Admin', '12345678901', ''),
(69, 'sda', 'asd', 'asdasd@gmail.com', 'sawwe', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '', ''),
(70, 'asd', 'asd', 'asd@gmail.com', 'asd', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Pending', 'Admin', '12345', ''),
(71, 'sasdas', 'asdasd', 'sdasd@gmail.com', 'asdsd', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Pending', 'Admin', '12345678901', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrowings`
--
ALTER TABLE `borrowings`
  ADD PRIMARY KEY (`bor_id`),
  ADD KEY `book_id` (`book_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl`
--
ALTER TABLE `tbl`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `borrowings`
--
ALTER TABLE `borrowings`
  MODIFY `bor_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT for table `tbl`
--
ALTER TABLE `tbl`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrowings`
--
ALTER TABLE `borrowings`
  ADD CONSTRAINT `borrowings_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`),
  ADD CONSTRAINT `borrowings_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `tbl` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
