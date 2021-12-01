-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 01, 2021 at 09:47 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca`
--

-- --------------------------------------------------------

--
-- Table structure for table `libros`
--

CREATE TABLE `libros` (
  `id` int(5) NOT NULL,
  `nombre_libro` char(50) NOT NULL,
  `editorial` char(50) NOT NULL,
  `autor` char(50) NOT NULL,
  `precio` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `libros`
--

INSERT INTO `libros` (`id`, `nombre_libro`, `editorial`, `autor`, `precio`) VALUES
(1, ' La Biblia', 'Editorial Norma', 'Varios autores', 30000),
(3, ' Citas del Presidente Mao Tse-Tung', 'ELCID', 'Mao Tse-Tung', 40000),
(4, 'Harry Potter', 'SANTA FÉ', 'J.K. Rowling', 35000),
(5, 'El Señor de los Anillos', 'J.R.R. Tolkien', 'NORMA', 25000),
(6, ' El Alquimista', 'NORMA', 'Paulo Coelho', 50000),
(7, 'El Código da Vinci', 'SANTA FÉ', 'Dan Brown', 35000),
(8, 'Crepúsculo', 'NORMA', 'Stephenie Meyer', 45000),
(9, 'Lo que el viento se llevó', 'NORMA', 'Margaret Mitchell', 30000),
(10, ' Piense y hágase rico', 'ELCID', 'Napoleón Hill', 50000),
(11, 'El diario de Ana Frank', 'NORMA', 'Anna Frank', 43000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
