-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2020 at 07:11 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `depositMoneyN` (IN `AmountN` FLOAT(10,2), IN `TimeStampN` DATETIME, IN `MobileAgentIDN` INT(5), IN `UserIDN` INT(4), IN `PriorityN` INT(2), IN `AccountNoN` INT(6))  MODIFIES SQL DATA
BEGIN
 DECLARE balancen FLOAT(10,2);
 DECLARE depositIDN int(9);

/* BEGIN TRAN */

 START TRANSACTION; 
/* get the current balance from the account to balance_arg variable */
 SELECT Balance INTO balancen from savingsaccount where savingsaccount.sAccountNo = AccountNoN;
 
 /* update the value */
 SELECT balancen + AmountN into balancen ;
 
 /* update the table to new value */
 UPDATE savingsaccount set Balance = balancen where savingsaccount.sAccountNo = AccountNoN;
 
 /* insert the data to deposits table */
 INSERT into depositmoney(MobileAgentID,UserID,Amount,Priority,AccountNo,TimeStamp) values(MobileAgentIDN,UserIDN,AmountN,PriorityN,AccountNoN,TimeStampN);
 
 /* get the primary key from deposits table to deposit_ID_arg*/
 SET depositIDN = LAST_INSERT_ID();
 

 COMMIT;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `withdrawMoneyN` (IN `AmountN` FLOAT(10,2), IN `TimeStampN` DATETIME, IN `MobileAgentIDN` INT(5), IN `UserIDN` INT(4), IN `PriorityN` INT(2), IN `AccountNoN` INT(6))  MODIFIES SQL DATA
BEGIN
 DECLARE balancen float(10,2);
 DECLARE withdrawlIDN int(3);

/* BEGIN TRAN */

 START TRANSACTION; 
/* get the current balance from the account to balance_arg variable */
 SELECT Balance INTO balancen from savingsaccount where savingsaccount.sAccountNo = AccountNoN;
 
 /* update the value */
 SELECT balancen - AmountN into balancen ;
 

 /* proceed only if value can be redeemed*/
 IF balancen >=0 THEN
 
 /* update the table to new value */
 UPDATE savingsaccount set Balance = balancen where savingsaccount.sAccountNo = AccountNoN;
 
 /* insert the data to withdrawal table */
 INSERT into withdrawmoney(MobileAgentID,UserID,Amount,Priority,AccountNo,TimeStamp) values(MobileAgentIDN,UserIDN,AmountN,PriorityN,AccountNoN,TimeStampN);
 
 /* get the primary key from withdrawal table to withdrawl_ID_arg*/
 SET withdrawlIDN = LAST_INSERT_ID();
 
 /* insert account_Id and withdrawl_ID_arg to the make withdrawal table */

 COMMIT;

END IF;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `accountholder`
--

CREATE TABLE `accountholder` (
  `UserID` int(4) NOT NULL,
  `UserMobileNo` int(11) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Pin` int(4) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `FirstName` varchar(10) NOT NULL,
  `LastName` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accountholder`
--

INSERT INTO `accountholder` (`UserID`, `UserMobileNo`, `Password`, `Pin`, `NIC`, `FirstName`, `LastName`) VALUES
(1, 705569832, 'testing1', 7896, '856936145V', 'Sadun', 'Kumara'),
(2, 724568957, 'testing2', 8965, '905641256V', 'Vimukthi', 'Udakara');

-- --------------------------------------------------------

--
-- Table structure for table `customeragent`
--

CREATE TABLE `customeragent` (
  `UserID` int(4) NOT NULL,
  `AgentID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customeragent`
--

INSERT INTO `customeragent` (`UserID`, `AgentID`) VALUES
(1, 80001),
(2, 80002);

-- --------------------------------------------------------

--
-- Table structure for table `depositmoney`
--

CREATE TABLE `depositmoney` (
  `DepositID` int(3) NOT NULL,
  `MobileAgentID` int(5) NOT NULL,
  `UserID` int(4) NOT NULL,
  `Amount` float(10,2) NOT NULL,
  `Priority` int(2) NOT NULL,
  `AccountNo` int(6) NOT NULL,
  `TimeStamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depositmoney`
--

INSERT INTO `depositmoney` (`DepositID`, `MobileAgentID`, `UserID`, `Amount`, `Priority`, `AccountNo`, `TimeStamp`) VALUES
(1, 80001, 1, 100000.00, 1, 2001, '2020-01-23 04:24:08'),
(2, 80002, 1, 1000.00, 1, 2000, '2020-01-02 10:33:02'),
(3, 80001, 1, 1000.00, 1, 2000, '2020-01-02 10:35:10'),
(4, 80001, 1, 1000.00, 1, 2000, '2020-01-02 10:38:33');

-- --------------------------------------------------------

--
-- Table structure for table `fixeddeposit`
--

CREATE TABLE `fixeddeposit` (
  `FDAccountNo` int(11) NOT NULL,
  `Account_Balance` float(10,2) DEFAULT NULL,
  `OpeningDate` date NOT NULL,
  `FDTypeID` int(11) NOT NULL,
  `SAccountNo` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fixeddeposit`
--

INSERT INTO `fixeddeposit` (`FDAccountNo`, `Account_Balance`, `OpeningDate`, `FDTypeID`, `SAccountNo`) VALUES
(1000, 1500.00, '2018-02-15', 1, 2000),
(1001, 10000.56, '2017-04-13', 3, 2001);

-- --------------------------------------------------------

--
-- Table structure for table `fixeddeposittype`
--

CREATE TABLE `fixeddeposittype` (
  `TypeID` int(2) NOT NULL,
  `InterestRate` float(2,2) DEFAULT NULL,
  `TimeDurationInMonth` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fixeddeposittype`
--

INSERT INTO `fixeddeposittype` (`TypeID`, `InterestRate`, `TimeDurationInMonth`) VALUES
(1, 0.13, 6),
(2, 0.14, 12),
(3, 0.15, 36);

-- --------------------------------------------------------

--
-- Table structure for table `holds`
--

CREATE TABLE `holds` (
  `SAccountNo` int(6) NOT NULL,
  `UserID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `holds`
--

INSERT INTO `holds` (`SAccountNo`, `UserID`) VALUES
(2000, 1),
(2000, 2),
(2001, 2);

-- --------------------------------------------------------

--
-- Table structure for table `mobileagent`
--

CREATE TABLE `mobileagent` (
  `AgentID` int(5) NOT NULL,
  `DevicePassword` varchar(15) NOT NULL,
  `DeviceID` int(3) NOT NULL,
  `AgentMobileNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mobileagent`
--

INSERT INTO `mobileagent` (`AgentID`, `DevicePassword`, `DeviceID`, `AgentMobileNo`) VALUES
(80001, 'admin1', 1, 776942378),
(80002, 'admin2', 2, 709631245);

-- --------------------------------------------------------

--
-- Table structure for table `savingsaccount`
--

CREATE TABLE `savingsaccount` (
  `SAccountNo` int(6) NOT NULL,
  `SATypeID` int(2) NOT NULL,
  `Balance` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `savingsaccount`
--

INSERT INTO `savingsaccount` (`SAccountNo`, `SATypeID`, `Balance`) VALUES
(2000, 3, 1000.00),
(2001, 1, 75000.96);

-- --------------------------------------------------------

--
-- Table structure for table `savingsaccounttype`
--

CREATE TABLE `savingsaccounttype` (
  `TypeID` int(2) NOT NULL,
  `MinimumBalance` float(8,2) DEFAULT NULL,
  `InterestRate` float NOT NULL,
  `Type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `savingsaccounttype`
--

INSERT INTO `savingsaccounttype` (`TypeID`, `MinimumBalance`, `InterestRate`, `Type`) VALUES
(1, 0.00, 0.12, 'Children'),
(2, 500.00, 0.11, 'Teen'),
(3, 1000.00, 0.1, 'Adult'),
(4, 1000.00, 0.13, 'Senior'),
(5, 5000.00, 0.07, 'Joint');

-- --------------------------------------------------------

--
-- Table structure for table `withdrawmoney`
--

CREATE TABLE `withdrawmoney` (
  `WithrawID` int(3) NOT NULL,
  `MobileAgentID` int(5) NOT NULL,
  `UserID` int(4) NOT NULL,
  `Amount` float(10,2) NOT NULL,
  `Priority` int(2) NOT NULL,
  `AccountNo` int(6) NOT NULL,
  `TimeStamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `withdrawmoney`
--

INSERT INTO `withdrawmoney` (`WithrawID`, `MobileAgentID`, `UserID`, `Amount`, `Priority`, `AccountNo`, `TimeStamp`) VALUES
(1, 80002, 1, 5000.00, 1, 2001, '2020-01-01 04:10:07'),
(3, 80001, 1, 1000.00, 1, 2000, '2020-01-02 10:58:02');

--
-- Triggers `withdrawmoney`
--
DELIMITER $$
CREATE TRIGGER `withdrawals_trigger` BEFORE INSERT ON `withdrawmoney` FOR EACH ROW begin
if new.Amount > (select b_a.Balance - a_t.MinimumBalance from savingsaccount as b_a, savingsaccounttype as a_t where b_a.SAccountNo=new.AccountNo and b_a.SATypeID=a_t.TypeID) then
        signal sqlstate '45000'
        set message_text = 'You cant withdraw because of low balance';
        else
        update savingsaccount
        set Balance = (select Balance from savingsaccount where SAccountNo=new.AccountNo)  - new.Amount
        where SAccountNo=new.AccountNo;
        end if;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountholder`
--
ALTER TABLE `accountholder`
  ADD PRIMARY KEY (`UserID`) USING BTREE;

--
-- Indexes for table `customeragent`
--
ALTER TABLE `customeragent`
  ADD PRIMARY KEY (`UserID`,`AgentID`),
  ADD KEY `AgentID` (`AgentID`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `depositmoney`
--
ALTER TABLE `depositmoney`
  ADD PRIMARY KEY (`DepositID`),
  ADD KEY `UserID` (`UserID`,`AccountNo`),
  ADD KEY `deposit_index` (`AccountNo`,`DepositID`);

--
-- Indexes for table `fixeddeposit`
--
ALTER TABLE `fixeddeposit`
  ADD PRIMARY KEY (`FDAccountNo`),
  ADD KEY `FDTypeID` (`FDTypeID`),
  ADD KEY `SAccountNo` (`SAccountNo`);

--
-- Indexes for table `fixeddeposittype`
--
ALTER TABLE `fixeddeposittype`
  ADD PRIMARY KEY (`TypeID`);

--
-- Indexes for table `holds`
--
ALTER TABLE `holds`
  ADD PRIMARY KEY (`SAccountNo`,`UserID`),
  ADD KEY `SAccountNo` (`SAccountNo`,`UserID`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `mobileagent`
--
ALTER TABLE `mobileagent`
  ADD PRIMARY KEY (`AgentID`);

--
-- Indexes for table `savingsaccount`
--
ALTER TABLE `savingsaccount`
  ADD PRIMARY KEY (`SAccountNo`),
  ADD KEY `SATypeID` (`SATypeID`),
  ADD KEY `account_index` (`SAccountNo`,`SATypeID`);

--
-- Indexes for table `savingsaccounttype`
--
ALTER TABLE `savingsaccounttype`
  ADD PRIMARY KEY (`TypeID`);

--
-- Indexes for table `withdrawmoney`
--
ALTER TABLE `withdrawmoney`
  ADD PRIMARY KEY (`WithrawID`),
  ADD KEY `UserID` (`UserID`,`AccountNo`),
  ADD KEY `withdrawl_index` (`AccountNo`,`WithrawID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customeragent`
--
ALTER TABLE `customeragent`
  MODIFY `UserID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `depositmoney`
--
ALTER TABLE `depositmoney`
  MODIFY `DepositID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fixeddeposittype`
--
ALTER TABLE `fixeddeposittype`
  MODIFY `TypeID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `savingsaccounttype`
--
ALTER TABLE `savingsaccounttype`
  MODIFY `TypeID` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `withdrawmoney`
--
ALTER TABLE `withdrawmoney`
  MODIFY `WithrawID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customeragent`
--
ALTER TABLE `customeragent`
  ADD CONSTRAINT `customeragent_ibfk_1` FOREIGN KEY (`AgentID`) REFERENCES `mobileagent` (`AgentID`),
  ADD CONSTRAINT `customeragent_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `accountholder` (`UserID`);

--
-- Constraints for table `depositmoney`
--
ALTER TABLE `depositmoney`
  ADD CONSTRAINT `depositmoney_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `holds` (`UserID`),
  ADD CONSTRAINT `depositmoney_ibfk_2` FOREIGN KEY (`AccountNo`) REFERENCES `holds` (`SAccountNo`);

--
-- Constraints for table `fixeddeposit`
--
ALTER TABLE `fixeddeposit`
  ADD CONSTRAINT `fixeddeposit_ibfk_3` FOREIGN KEY (`SAccountNo`) REFERENCES `savingsaccount` (`SAccountNo`),
  ADD CONSTRAINT `fixeddeposit_ibfk_4` FOREIGN KEY (`FDTypeID`) REFERENCES `fixeddeposittype` (`TypeID`);

--
-- Constraints for table `holds`
--
ALTER TABLE `holds`
  ADD CONSTRAINT `holds_ibfk_1` FOREIGN KEY (`SAccountNo`) REFERENCES `savingsaccount` (`SAccountNo`),
  ADD CONSTRAINT `holds_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `accountholder` (`UserID`);

--
-- Constraints for table `savingsaccount`
--
ALTER TABLE `savingsaccount`
  ADD CONSTRAINT `savingsaccount_ibfk_1` FOREIGN KEY (`SATypeID`) REFERENCES `savingsaccounttype` (`TypeID`);

--
-- Constraints for table `withdrawmoney`
--
ALTER TABLE `withdrawmoney`
  ADD CONSTRAINT `withdrawmoney_ibfk_1` FOREIGN KEY (`AccountNo`) REFERENCES `holds` (`SAccountNo`),
  ADD CONSTRAINT `withdrawmoney_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `holds` (`UserID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
