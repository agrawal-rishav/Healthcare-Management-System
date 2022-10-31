DROP TABLE `admin`;
DROP TABLE `appointment`;
DROP TABLE `doctors`;
DROP TABLE `doctorslog`;
DROP TABLE `doctorspecilization`;
DROP TABLE `tblcontactus`;
DROP TABLE `tblmedicalhistory`;
DROP TABLE `tblpatient`;
DROP TABLE `userlog`;
DROP TABLE `users`;


CREATE TABLE `admin`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `updationdate` varchar(255) NOT NULL,
  PRIMARY KEY(`id`)
);



CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `doctorspecialization` varchar(255) DEFAULT NULL,
  `doctorid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `consultancyfees` int(11) DEFAULT NULL,
  `appointmentdate` varchar(255) DEFAULT NULL,
  `appointmenttime` varchar(255) DEFAULT NULL,
  `postingdate` varchar(255) NULL DEFAULT current_timestamp(),
  `userstatus` int(11) DEFAULT NULL,
  `doctorstatus` int(11) DEFAULT NULL,
  `updationdate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`)
);



CREATE TABLE `doctors` (
  `id` int(11) NOT NULL  AUTO_INCREMENT,
  `specilization` varchar(255) DEFAULT NULL,
  `doctorname` varchar(255) DEFAULT NULL,
  `address` longtext DEFAULT NULL,
  `docfees` varchar(255) DEFAULT NULL,
  `contactno` bigint(11) DEFAULT NULL,
  `docemail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `creationdate` varchar(255) NULL DEFAULT current_timestamp(),
  `updationdate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`)
);



CREATE TABLE `doctorslog` (
  `id` int(11) NOT NULL  AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userip` binary(16) DEFAULT NULL,
  `logintime` varchar(255) NULL DEFAULT current_timestamp(),
  `logout` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY(`id`)
);



CREATE TABLE `doctorspecilization` (
  `id` int(11) NOT NULL  AUTO_INCREMENT,
  `specilization` varchar(255) DEFAULT NULL,
  `creationDate` varchar(255) NULL DEFAULT current_timestamp(),
  `updationDate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`)
);



CREATE TABLE `tblcontactus` (
  `id` int(11) NOT NULL  AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contactno` bigint(12) DEFAULT NULL,
  `message` mediumtext DEFAULT NULL,
  `postingdate` varchar(255) NULL DEFAULT current_timestamp(),
  `adminremark` mediumtext DEFAULT NULL,
  `lastupdationdate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `isread` int(11) DEFAULT NULL,
  PRIMARY KEY(`id`)
);



CREATE TABLE `tblmedicalhistory` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `patientid` int(10) DEFAULT NULL,
  `bloodpressure` varchar(200) DEFAULT NULL,
  `bloodsugar` varchar(200) NOT NULL,
  `weight` varchar(100) DEFAULT NULL,
  `temperature` varchar(200) DEFAULT NULL,
  `medicalpres` mediumtext DEFAULT NULL,
  `creationdate` varchar(255) NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`)
);



CREATE TABLE `tblpatient` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `docid` int(10) DEFAULT NULL,
  `patientname` varchar(200) DEFAULT NULL,
  `patientcontno` bigint(10) DEFAULT NULL,
  `patientemail` varchar(200) DEFAULT NULL,
  `patientgender` varchar(50) DEFAULT NULL,
  `patientadd` mediumtext DEFAULT NULL,
  `patientage` int(10) DEFAULT NULL,
  `patientmedhis` mediumtext DEFAULT NULL,
  `creationdate` varchar(255) NULL DEFAULT current_timestamp(),
  `updationdate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`)
);



CREATE TABLE `userlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userip` binary(16) DEFAULT NULL,
  `loginTime` varchar(255) NULL DEFAULT current_timestamp(),
  `logout` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY(`id`)
);



CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `address` longtext DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regdate` varchar(255) NULL DEFAULT current_timestamp(),
  `updationdate` varchar(255) NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY(`id`),
  KEY(`email`)
);

