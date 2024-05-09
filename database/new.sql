-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2024 at 02:16 PM
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
  `Status` varchar(50) NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`book_id`, `book_name`, `Author`, `Status`, `quantity`) VALUES
(1, 'Harry Potter and Goblet of Fire', 'J. K. Rowling', 'Available', 8),
(3, 'The da Vinci Code', 'Dan Brown', 'Available', 6);

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
  `Number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl`
--

INSERT INTO `tbl` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_status`, `u_type`, `Number`) VALUES
(1, 'irisup', 'kamylle', 'kai@gmail.com', 'kits', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', ''),
(2, 'Kaiupdaye', 'Delimanpdate', 'kai@gmail.ph', 'kaiup', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '12345678901'),
(3, 'Indayup', 'Deli', 'deliman@gmail.com', 'indayup', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '12345678901'),
(4, 'mikeuodate', 'tra', 'tra@gmail.com', 'mikeuo', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'User', '12345678901'),
(5, 'update', 'yooup', 'this@gmail', 'meeeeee', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '12345678901'),
(6, 'mikey', 'you', 'trazona@gmail.com', 'mikey', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(7, 'kliey', 'ryuga', 'bfklfbk', 'ryuga', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(8, 'kliey', 'kilay', 'kilay', 'ilay', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(9, 'klis', 'klis', 'klis', 'klis', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(12, 'me', 'metoo', 'uou@gmail.com', 'to', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '12345678901'),
(15, 'kls', 'saf', 'trazona', 'kils', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '12345678901'),
(16, 'sg', 'sg', 'to@gmail.com', 'kamylle', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '12345678901'),
(17, 'mike', 'afasfa', 'yu@gmail.com', 'koys', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(18, 'fsfsf', 'afaf', 'tes@gmail.com', 'tes', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '12345678901'),
(20, 'fwer', 'fsfd', 'fsf@gmail.com', 'asf', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '12345678901'),
(21, 'adup', 'asup', 'eldie@gmail.com', 'ko', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', ''),
(22, 'eq', 'qe', 'kot@gmail.com', 'mike', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', ''),
(23, 'qw', 'qw', 'ko', 'mo', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '12345678901'),
(24, 'me', 'me', 'me@gmail.com', 'mee', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', ''),
(25, 'ki', 'moti', 'dgmddfs', 'kom', 'oXREVQ4sEnsC6hwZe8/6QiwhcTBA9T1cLKeSVBm8z38=', 'Active', 'Admin', '12345678901'),
(26, 'w', 'as', 'afs', 'dgg', '12345678', 'Active', 'User', '12345678901'),
(27, 'awda', 'as', 'assf', 'aff', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '12345678901');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

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
  MODIFY `book_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl`
--
ALTER TABLE `tbl`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
