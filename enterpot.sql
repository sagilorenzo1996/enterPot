-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2019 at 09:56 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enterpot`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `address_line_one` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address_line_two` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthday` datetime(6) NOT NULL,
  `card_exp_date` datetime(6) NOT NULL,
  `card_number` varchar(19) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `country` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postal_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `address_line_one`, `address_line_two`, `birthday`, `card_exp_date`, `card_number`, `city`, `country`, `email`, `first_name`, `gender`, `last_name`, `password`, `postal_code`) VALUES
(1, '328/A', 'Suramya Mw', '1996-09-15 06:30:00.000000', '2022-03-10 05:30:00.000000', '9625929966859632', 'Homagama', 'SriLanka', 'aanjaloshanerosa@gmail.com', 'aanjalo', 'Male', 'shane', 'shane123', 12400),
(2, '279/C', 'adarsha mw', '1996-09-10 06:30:00.000000', '2025-06-10 05:30:00.000000', '9622129966859632', 'Horana', 'SriLanka', 'sagilorenzo@gmail.com', 'sagi', 'Male', 'lorenzo', 'sagi123', 15500);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `models` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `category`, `description`, `models`, `name`, `price`, `status`, `image`) VALUES
(1, 'Tech', 'Dell xps laptop 16GB RAM, 2GB nvidia VGA', 'Dell XPS 2019', 'Dell XPS laptop', '270000.00', 'available', 'img/item/1.jpg'),
(2, 'Tech', 'Samsung 32\'class smart LED', 'Samsung 2019', 'samsung LED', '65000.00', 'available', 'img/item/2.jpg'),
(3, 'Watch', 'seiko solar silver', 'seiko 2019', 'seiko silver', '25000.00', 'available', 'img/item/3.jpg'),
(4, 'Tech', 'nikon sandisk 32GB', 'nikon 2019', 'nikon sandisk', '4000.00', 'available', 'img/item/4.jpg'),
(5, 'Tech', 'canon digital camera', 'canon 2019', 'canon camera', '250000.00', 'available', 'img/item/5.jpg'),
(6, 'Fashion', 'women winter worm fluffy coat', 'sweater', 'winter worm', '1500.00', 'available', 'img/item/6.jpg'),
(7, 'Tech', 'iphone x 256GB storage 3GB RAM', 'iphone 2019', 'iphone x', '195000.00', 'available', 'img/item/7.jpg'),
(8, 'Tech', 'parrot bebop 2 quadcopter drone with HD video', 'parrot 2019', 'parrot bebop', '300000.00', 'available', 'img/item/8.jpg'),
(9, 'Tech', 'Xbox one X 1TB black', 'Xbox 2019', 'Xbox one', '15000.00', 'available', 'img/item/9.jpg'),
(10, 'Fashion', 'Ruby Swirl Pendant with Diamond in Sterling Silver', 'pendent', 'swirl pendenet', '450000.00', 'available', 'img/item/10.jpg'),
(11, 'Fashion', 'BMW Boss Logo T shirt Car Racing F1 Fashionr', 'Tshirt', 'BMW boss', '2000.00', 'available', 'img/item/11.jpg'),
(12, 'Fashion', 'Men\'s Wedding Shoes Pointed Leather Lace Up', 'Shoes 2019', 'leather shoe', '4500.00', 'available', 'img/item/12.jpg'),
(13, 'Tech', 'Original Adaptive Fast Wall Charger USB', 'samsung 2019', 'Fast charger', '1000.00', 'available', 'img/item/13.jpg'),
(14, 'Fashion', 'Ladies Block High Heels Ankle Strapped Sandals ', 'sandles 2019', 'high heels', '1500.00', 'available', 'img/item/14.jpg'),
(15, 'Tech', 'Apple iPad Pro 3rd Gen 512GB Wi-Fi ', 'apple 2019', 'ipad pro', '55000.00', 'available', 'img/item/15.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `item_order`
--

CREATE TABLE `item_order` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `estimated_delivery_date` datetime(6) DEFAULT NULL,
  `item_id` bigint(20) NOT NULL,
  `location` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ordered_date` datetime(6) NOT NULL,
  `quantity` int(11) NOT NULL,
  `shipped_date` datetime(6) DEFAULT NULL,
  `shipping_mode` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `now_at` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lat` float DEFAULT NULL,
  `lng` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `item_order`
--

INSERT INTO `item_order` (`id`, `customer_id`, `estimated_delivery_date`, `item_id`, `location`, `ordered_date`, `quantity`, `shipped_date`, `shipping_mode`, `status`, `total`, `country`, `now_at`, `lat`, `lng`) VALUES
(1, 1, NULL, 1, '328/A,Suramya Mw,Homagama,SriLanka,12400', '2019-05-13 23:11:12.000000', 1, NULL, 'ship', 'placed', '270000.00', 'new york', '{lat: 1.3521, lng: 103.8198}', 40.7128, -74.006),
(2, 1, NULL, 1, '328/A,Suramya Mw,Homagama,SriLanka,12400', '2019-05-13 23:19:20.000000', 1, NULL, 'ship', 'placed', '270000.00', NULL, '', NULL, NULL),
(3, 1, NULL, 1, '328/A,Suramya Mw,Homagama,SriLanka,12400', '2019-05-13 23:28:45.000000', 1, NULL, 'ship', 'placed', '270000.00', NULL, '', NULL, NULL),
(4, 1, NULL, 1, '328/A,Suramya Mw,Homagama,SriLanka,12400', '2019-05-14 00:11:33.000000', 1, NULL, 'ship', 'placed', '270000.00', NULL, '', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item_order`
--
ALTER TABLE `item_order`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `item_order`
--
ALTER TABLE `item_order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
