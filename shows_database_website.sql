-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2022 at 03:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shows database website`
--

-- --------------------------------------------------------

--
-- Table structure for table `shows`
--

CREATE TABLE `shows` (
  `shows_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `year` int(10) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `studio` varchar(50) NOT NULL,
  `your_score` int(20) NOT NULL,
  `average_score` int(20) NOT NULL,
  `no_of_reviews` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shows`
--

INSERT INTO `shows` (`shows_id`, `name`, `year`, `genre`, `studio`, `your_score`, `average_score`, `no_of_reviews`) VALUES
(1, 'Neon Genesis Evangelion', 1995, 'Sci-fi', 'Gainax', 100, 95, 56615),
(2, 'Cowboy Bebop', 1998, 'Sci-fi', 'Sunrise', 98, 96, 61456),
(3, 'Yu Yu Hakusho', 1992, 'Action', 'Studio Pierrot', 89, 85, 51894),
(4, 'Berserk', 1997, 'Action', 'VAP', 94, 91, 96243),
(5, 'Samurai Champloo', 2004, 'Action', 'Sunrise', 87, 92, 26731),
(6, 'Death Note', 2006, 'Drama', 'Madhouse', 93, 91, 64237),
(7, 'One Punch Man', 2015, 'Comedy', 'Madhouse', 93, 97, 75133),
(8, 'Steins Gate', 2007, 'Drama', 'White Fox', 85, 91, 73124),
(9, 'Jojos Bizarre Adventure', 2014, 'Action', 'David Productions', 90, 100, 65154),
(10, 'Mobile Suit Gundam', 1979, 'Mecha', 'Sunrise', 95, 93, 104853);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `no_of_entries` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `shows_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `your_score` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`no_of_entries`, `user_id`, `shows_id`, `name`, `your_score`) VALUES
(1, 1, 1, 'Neon Genesis Evangelion', 100),
(2, 1, 2, 'Cowboy Bebop', 98),
(3, 1, 3, 'Yu Yu Hakusho', 89),
(4, 1, 4, 'Berserk', 94),
(5, 1, 5, 'Samurai Champloo', 87),
(6, 1, 6, 'Death Note', 93),
(7, 1, 7, 'One Punch Man', 93),
(8, 1, 8, 'Steins Gate', 85),
(9, 1, 9, 'Jojos Bizarre Adventure', 90),
(10, 1, 10, 'Mobile Suit Gundam', 95);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `shows`
--
ALTER TABLE `shows`
  ADD PRIMARY KEY (`shows_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`no_of_entries`),
  ADD KEY `shows_id` (`shows_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `no_of_entries` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`shows_id`) REFERENCES `shows` (`shows_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
