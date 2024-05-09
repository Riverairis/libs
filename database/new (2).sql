-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2024 at 07:04 AM
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
-- Table structure for table `archive`
--

CREATE TABLE `archive` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_num` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

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
(1, 'Harry Potter and Goblet of Fire', 'J. K. Rowling', 4, 'Pottermore'),
(5, 'we', 'we', 5, 'sfdf'),
(6, 'sf', 'asf', 5, 'sfsf'),
(7, 'Harry Potter and Deathly Hallow', 'J. K. Rowling', 0, 'Pottermore'),
(8, 'Pride and Prejudice', 'Alexander Dumas', 0, 'Pearson'),
(9, 'To Kill A Mocking Bird', 'Harper Lee', 5, 'McGraw'),
(10, 'The Hunger Games', 'Suzanne Collins', 0, 'Pearson'),
(11, 'The Perks Of being A Wallflower', 'Stephen Chbosky', 0, 'Klett'),
(12, 's', 'asf', 1, 'asf');

-- --------------------------------------------------------

--
-- Table structure for table `borrowings`
--

CREATE TABLE `borrowings` (
  `bor_id` int(20) NOT NULL,
  `book_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `return_date` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `borrowings`
--

INSERT INTO `borrowings` (`bor_id`, `book_id`, `u_id`, `Status`, `return_date`) VALUES
(34, 7, 30, 'Borrowed', 0);

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
(1, 'irisup', 'kamylle', 'kai@gmail.com', 'kits', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '0'),
(2, 'Kaiupdaye', 'Delimanpdate', 'kai@gmail.ph', 'kaiup', 'CP3AhUTcBfcPrqT57CmcyNDXRM2zkrfCgmKVeQe0FX0=', 'Pending', 'Admin', '2147483647'),
(3, 'Indayup', 'Deli', 'deliman@gmail.com', 'indayup', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '2147483647'),
(4, 'mikeuodate', 'tra', 'tra@gmail.com', 'mikeuo', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'User', '2147483647'),
(5, 'update', 'yooup', 'this@gmail', 'meeeeee', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '2147483647'),
(6, 'mikey', 'you', 'trazona@gmail.com', 'mikey', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(7, 'kliey', 'ryuga', 'bfklfbk', 'ryuga', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(8, 'kliey', 'kilay', 'kilay', 'ilay', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(9, 'klis', 'klis', 'klis', 'klis', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(12, 'me', 'metoo', 'uou@gmail.com', 'to', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '2147483647'),
(17, 'mike', 'afasfa', 'yu@gmail.com', 'koys', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(18, 'fsfsf', 'afaf', 'tes@gmail.com', 'tes', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '2147483647'),
(20, 'fwer', 'fsfd', 'fsf@gmail.com', 'asf', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '2147483647'),
(21, 'adup', 'asup', 'eldie@gmail.com', 'ko', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'Admin', '0'),
(22, 'eq', 'qe', 'kot@gmail.com', 'mike', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '0'),
(23, 'qw', 'qw', 'ko', 'mo', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Pending', 'Admin', '2147483647'),
(24, 'me', 'me', 'me@gmail.com', 'mee', '4k35IAeMPdTn6NJELwDlyasqIxuzkY1lzFCQbknsrvQ=', 'Active', 'User', '0'),
(27, 'awda', 'as', 'assf', 'aff', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'Admin', '2147483647'),
(28, 'sf', 'sf', 'asf', 'bio', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '0'),
(29, 'dsa', 'adad', 'daa', 'dff', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '0'),
(30, 'dgs', 'sdgsd', 'sdg', 'xx', '73l8gRjwLftklgfdXT+MdiMEjJwGPVMsyVxe16iYpk8=', 'Active', 'User', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrowings`
--
ALTER TABLE `borrowings`
  ADD PRIMARY KEY (`bor_id`);

--
-- Indexes for table `tbl`
--
ALTER TABLE `tbl`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `archive`
--
ALTER TABLE `archive`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `book_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `borrowings`
--
ALTER TABLE `borrowings`
  MODIFY `bor_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `tbl`
--
ALTER TABLE `tbl`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
