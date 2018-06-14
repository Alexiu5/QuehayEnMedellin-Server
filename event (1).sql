-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2018 at 06:25 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event`
--

-- --------------------------------------------------------

--
-- Table structure for table `databasechangelog`
--

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('initial-data', 'developer', 'liquibase/changelog/initialdata.sql', '2018-05-31 16:39:39', 1, 'EXECUTED', '7:cf5414ca2ad94127aa8a4befb7758c43', 'sql', '', NULL, '3.5.4', NULL, NULL, '7802779193'),
('roles-data', 'developer', 'liquibase/changelog/rolesData.sql', '2018-05-31 16:39:39', 2, 'EXECUTED', '7:de48a6f415b6294bd527bd0d7a77319b', 'sql', '', NULL, '3.5.4', NULL, NULL, '7802779193');

-- --------------------------------------------------------

--
-- Table structure for table `databasechangeloglock`
--

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tblattendance`
--

CREATE TABLE `tblattendance` (
  `id` int(11) NOT NULL,
  `attendance` tinyint(1) NOT NULL,
  `rate` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tblcomment`
--

CREATE TABLE `tblcomment` (
  `id` int(11) NOT NULL,
  `comment` text,
  `creationDate` timestamp NULL DEFAULT NULL,
  `updateDate` timestamp NULL DEFAULT NULL,
  `idEvent` int(11) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tblevent`
--

CREATE TABLE `tblevent` (
  `id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `longitude` varchar(45) NOT NULL,
  `latitude` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `hour` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `creationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` int(11) DEFAULT NULL,
  `idEventType` int(11) DEFAULT NULL,
  `published` tinyint(1) DEFAULT NULL,
  `publishedDate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblevent`
--

INSERT INTO `tblevent` (`id`, `title`, `description`, `longitude`, `latitude`, `date`, `hour`, `address`, `img`, `active`, `cost`, `creationDate`, `updateDate`, `idUser`, `idEventType`, `published`, `publishedDate`) VALUES
(17, 'Fest', 'Texto de prueba', '-75.55372396473888', '6.26089524994363', '2018-06-04', '21:00:00', ' ', 'event.png', 1, '250000.00', '2018-06-13 16:20:53', '2018-06-13 16:20:53', 19, 2, 1, '2018-06-13 05:00:00'),
(19, 'my bro', 'Coma mierdadasdasdas', '-75.55179277424816', '6.254368323917816', '2018-06-02', '21:00:00', ' ', 'evento_principal.png', 0, '250000.00', '2018-06-13 16:53:45', '2018-06-13 16:53:45', 19, 1, 1, '2018-06-13 05:00:00'),
(20, 'dasdasd', 'dasdasdasd', '-75.59513764796571', '6.266526257835312', '2018-06-12', '21:00:00', ' ', NULL, 0, '250000.00', '2018-06-13 16:58:12', '2018-06-13 16:58:12', 19, 1, 1, '2018-06-13 05:00:00'),
(21, 'main test', 'Main test', '-75.5093765258789', '6.289193071493112', '2018-06-10', '21:00:00', ' ', NULL, 0, '250000.00', '2018-06-13 17:11:19', '2018-06-13 17:11:19', 19, 2, 1, '2018-06-13 05:00:00'),
(22, 'lals', 'dsadasdasda', '-75.55720748369697', '6.255008222230456', '2018-06-12', '2018-06-13T18:07:52.000Z', ' ', NULL, 0, '250000.00', '2018-06-13 18:08:23', '2018-06-13 18:08:23', 19, 1, 1, '2018-06-13 05:00:00'),
(23, 'aLesdas', 'dasdasdasdas', '-75.55549086992744', '6.261108546803808', '2018-06-26', '2018-06-13T18:10:57.000Z', ' ', NULL, 0, '250000.00', '2018-06-13 18:11:19', '2018-06-13 18:11:19', 19, 1, 1, '2018-06-13 05:00:00'),
(24, 'TEEEEEEEEST', 'lorem ipsum', '-75.55720010762218', '6.2655583364482315', '2018-06-25', '2018-06-14T14:20:56.000Z', ' ', NULL, 0, '250000.00', '2018-06-14 14:21:27', '2018-06-14 14:21:27', 19, 1, 1, '2018-06-14 05:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbleventtype`
--

CREATE TABLE `tbleventtype` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbleventtype`
--

INSERT INTO `tbleventtype` (`id`, `name`, `active`) VALUES
(1, 'asdasda', 1),
(2, 'asdgahjdgas', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblfile`
--

CREATE TABLE `tblfile` (
  `id` int(11) NOT NULL,
  `content` longblob,
  `url` varchar(200) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `idEvent` int(11) DEFAULT NULL,
  `creationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tblrole`
--

CREATE TABLE `tblrole` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblrole`
--

INSERT INTO `tblrole` (`id`, `name`, `active`) VALUES
(1, 'ADMIN', 1),
(2, 'USER', 1),
(3, 'COMPANY', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbltag`
--

CREATE TABLE `tbltag` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbltagevent`
--

CREATE TABLE `tbltagevent` (
  `id` int(11) NOT NULL,
  `idEvent` int(11) NOT NULL,
  `idTag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `tbluser` (
  `id` int(11) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,
  `idRole` int(11) NOT NULL,
  `creationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`id`, `firstName`, `lastName`, `login`, `password`, `email`, `phone`, `active`, `idRole`, `creationDate`, `updateDate`) VALUES
(19, 'admin', 'admin', 'admin', 'admin123*', 'admin@admin.com', '3005221515', 1, 1, '2018-06-07 05:00:00', '2018-06-07 20:45:50'),
(20, 'TEst', 'dñjasldksa', 'testA', '8Kwk8!bGC3', 'admin@mail.com', '3005166565', 0, 2, '2018-06-11 05:00:00', '2018-06-11 22:50:26'),
(21, 'dasdasdas', 'dsadasdas', 'cascasdsa', 'admin123**', 'carlm@mail.com', '300512345', 1, 1, '2018-06-13 05:00:00', '2018-06-14 01:32:20'),
(22, 'dasdas', 'dasasdas', 'dsadasdas', 'bA$7*8u2TD', 'admdasdasdasin@admin.com', '123456785123', 0, 1, '2018-06-14 05:00:00', '2018-06-14 16:50:09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tblattendance`
--
ALTER TABLE `tblattendance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ATTENDANCE_EVENT_idx` (`idEvent`),
  ADD KEY `FK_ATTENDANCE_USER_idx` (`idUser`);

--
-- Indexes for table `tblcomment`
--
ALTER TABLE `tblcomment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_COMMENT_USER_idx` (`idUser`),
  ADD KEY `FK_COMMENT_EVENT_idx` (`idEvent`);

--
-- Indexes for table `tblevent`
--
ALTER TABLE `tblevent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_EVENT_USER_idx` (`idUser`),
  ADD KEY `FK_EVENT_EVENT_TYPE_idx` (`idEventType`);

--
-- Indexes for table `tbleventtype`
--
ALTER TABLE `tbleventtype`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `tblfile`
--
ALTER TABLE `tblfile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_FILE_EVENT_idx` (`idEvent`);

--
-- Indexes for table `tblrole`
--
ALTER TABLE `tblrole`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `tbltag`
--
ALTER TABLE `tbltag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbltagevent`
--
ALTER TABLE `tbltagevent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TAG_EVENT_TAG_idx` (`idTag`),
  ADD KEY `FK_TAG_EVENT_EVENT_idx` (`idEvent`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_USER_ROLE_idx` (`idRole`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblattendance`
--
ALTER TABLE `tblattendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tblcomment`
--
ALTER TABLE `tblcomment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tblevent`
--
ALTER TABLE `tblevent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `tbleventtype`
--
ALTER TABLE `tbleventtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tblfile`
--
ALTER TABLE `tblfile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tblrole`
--
ALTER TABLE `tblrole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbltag`
--
ALTER TABLE `tbltag`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbltagevent`
--
ALTER TABLE `tbltagevent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tbluser`
--
ALTER TABLE `tbluser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblattendance`
--
ALTER TABLE `tblattendance`
  ADD CONSTRAINT `FK_ATTENDANCE_EVENT` FOREIGN KEY (`idEvent`) REFERENCES `tblevent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_ATTENDANCE_USER` FOREIGN KEY (`idUser`) REFERENCES `tbluser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tblcomment`
--
ALTER TABLE `tblcomment`
  ADD CONSTRAINT `FK_COMMENT_EVENT` FOREIGN KEY (`idEvent`) REFERENCES `tblevent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_COMMENT_USER` FOREIGN KEY (`idUser`) REFERENCES `tbluser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tblevent`
--
ALTER TABLE `tblevent`
  ADD CONSTRAINT `FK_EVENT_EVENT_TYPE` FOREIGN KEY (`idEventType`) REFERENCES `tbleventtype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_EVENT_USER` FOREIGN KEY (`idUser`) REFERENCES `tbluser` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tblfile`
--
ALTER TABLE `tblfile`
  ADD CONSTRAINT `FK_FILE_EVENT` FOREIGN KEY (`idEvent`) REFERENCES `tblevent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbltagevent`
--
ALTER TABLE `tbltagevent`
  ADD CONSTRAINT `FK_TAG_EVENT_EVENT` FOREIGN KEY (`idEvent`) REFERENCES `tblevent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_TAG_EVENT_TAG` FOREIGN KEY (`idTag`) REFERENCES `tbltag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD CONSTRAINT `FK_USER_ROLE` FOREIGN KEY (`idRole`) REFERENCES `tblrole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
