create table THEATER(
theaterID integer primary key,
zipcode integer,
theaterName varchar(100)
);

create table MOVIE(
movieID integer primary key,
title varchar(100),
description varchar(500)
);

create table SHOWING(
showingID integer primary key,
movieID integer,
theaterID integer,
showing_time time,
foreign key(movieID) references MOVIE(movieID),
foreign key(theaterID) references THEATER(theaterID)
);


insert into THEATER values(0, 60006, 'Movie Theater 1');
insert into THEATER values(1, 60006, 'Cinemark Plus');
insert into THEATER values(2, 55232, 'AMC Movies 140');
insert into THEATER values(3, 75057, 'AMC Movies 121');
insert into THEATER values(4, 75057, 'Movies R Us');
insert into THEATER values(5, 12345, 'Movie Theater 5');
insert into THEATER values(6, 60006, 'Movies Movies Movies!');
insert into THEATER values(7, 44214, 'Movies and more');
insert into THEATER values(8, 77665, 'Dine in Movies');
insert into THEATER values(9, 44214, 'AMC Movies 177');
insert into THEATER values(10, 12345, 'AMC Movies 203');

insert into MOVIE values(0, 'Superbad', 'This hilarious film follows two teens as they try to end their high school years with a bang');
insert into MOVIE values(1, 'Dunkirk', 'This film follows the true story behind the heroes that saved the soldiers at Dunkirk during World War 2' );
insert into MOVIE values(2, 'Shawshank Redemption', 'A classic tale of two inmates that become best friends');
insert into MOVIE values(3, 'Interstellar', 'Space: Humanities last hope against a famine like no other');
insert into MOVIE values(4, 'Avengers Endgame', 'The Avengers must find a way to bring back what was lost and defeat Thanos');
insert into MOVIE values(6, 'Inception', 'Is it all one big dream?');

insert into SHOWING values(0, 0, 0, '9:30');
insert into SHOWING values(1, 0, 0, '7:00');
insert into SHOWING values(2, 0, 0, '6:00');
insert into SHOWING values(3, 0, 0, '6:45');
insert into SHOWING values(4, 1, 0, '7:15');
insert into SHOWING values(5, 1, 0, '7:00');
insert into SHOWING values(6, 1, 0, '6:30');
insert into SHOWING values(7, 1, 0, '12:45');
insert into SHOWING values(8, 1, 0, '1:30');
insert into SHOWING values(9, 2, 0, '3:00');
insert into SHOWING values(10, 2, 0, '2:45');
insert into SHOWING values(11, 0, 1, '6:00');
insert into SHOWING values(12, 0, 1, '12:00');
insert into SHOWING values(13, 0, 1, '11:45');
insert into SHOWING values(14, 0, 1, '10:30');
insert into SHOWING values(15, 1, 1, '4:45');
insert into SHOWING values(16, 1, 1, '12:30');
insert into SHOWING values(17, 1, 1, '10:15');
insert into SHOWING values(18, 1, 1, '9:45');
insert into SHOWING values(19, 1, 1, '8:30');
insert into SHOWING values(20, 2, 1, '7:30');
insert into SHOWING values(21, 2, 1, '5:00');
insert into SHOWING values(22, 0, 2, '4:45');
insert into SHOWING values(23, 0, 2, '3:30');
insert into SHOWING values(24, 0, 2, '9:45');
insert into SHOWING values(25, 0, 2, '8:45');
insert into SHOWING values(26, 1, 2, '6:30');
insert into SHOWING values(27, 1, 2, '5:45');
insert into SHOWING values(28, 1, 2, '1:15');
insert into SHOWING values(29, 1, 2, '2:25');
insert into SHOWING values(30, 1, 2, '5:30');
insert into SHOWING values(31, 2, 2, '3:00');
insert into SHOWING values(32, 2, 2, '6:45');
insert into SHOWING values(33, 0, 3, '3:35');
insert into SHOWING values(34, 0, 3, '12:45');
insert into SHOWING values(35, 0, 3, '12:00');
insert into SHOWING values(36, 1, 3, '4:00');
insert into SHOWING values(37, 1, 3, '2:45');
insert into SHOWING values(38, 1, 3, '10:30');
insert into SHOWING values(39, 1, 3, '11:00');
insert into SHOWING values(40, 1, 3, '9:30');
insert into SHOWING values(41, 2, 3, '9:00');
insert into SHOWING values(42, 2, 3, '4:45');
insert into SHOWING values(43, 0, 4, '3:30');
insert into SHOWING values(44, 0, 4, '1:15');
insert into SHOWING values(45, 0, 4, '5:25');
insert into SHOWING values(46, 1, 4, '5:30');
insert into SHOWING values(47, 1, 4, '4:45');
insert into SHOWING values(48, 1, 4, '6:30');
insert into SHOWING values(49, 1, 4, '7:45');
insert into SHOWING values(50, 1, 4, '6:30');
insert into SHOWING values(51, 2, 4, '5:00');
insert into SHOWING values(52, 2, 4, '3:30');
insert into SHOWING values(53, 0, 5, '2:00');
insert into SHOWING values(54, 0, 5, '12:30');
insert into SHOWING values(55, 0, 5, '11:00');
insert into SHOWING values(56, 1, 5, '10:00');
insert into SHOWING values(57, 1, 5, '9:30');
insert into SHOWING values(58, 1, 5, '7:00');
insert into SHOWING values(59, 1, 5, '6:00');
insert into SHOWING values(60, 1, 5, '3:30');
insert into SHOWING values(61, 2, 5, '5:30');
insert into SHOWING values(62, 2, 5, '6:45');
insert into SHOWING values(63, 3, 1, '6:15');
insert into SHOWING values(64, 3, 5, '9:30');
insert into SHOWING values(65, 3, 3, '8:30');
insert into SHOWING values(66, 3, 3, '7:00');
insert into SHOWING values(67, 4, 1, '9:30');
insert into SHOWING values(68, 4, 1, '8:45');
insert into SHOWING values(69, 4, 1, '7:00');
insert into SHOWING values(70, 4, 4, '5:30');
insert into SHOWING values(71, 4, 6, '4:15');
insert into SHOWING values(72, 3, 6, '6:30');
insert into SHOWING values(73, 6, 2, '6:30');
insert into SHOWING values(74, 6, 4, '5:00');
insert into SHOWING values(75, 6, 3, '3:30');
insert into SHOWING values(76, 6, 5, '2:00');
insert into SHOWING values(77, 6, 6, '12:30');
insert into SHOWING values(78, 6, 7, '11:00');
insert into SHOWING values(79, 6, 8, '10:00');
insert into SHOWING values(80, 6, 9, '9:30');
insert into SHOWING values(81, 6, 9, '7:00');
insert into SHOWING values(82, 6, 8, '6:00');
insert into SHOWING values(83, 6, 10, '3:30');
insert into SHOWING values(84, 6, 4, '5:30');
insert into SHOWING values(85, 2, 10, '6:45');
insert into SHOWING values(86, 3, 4, '6:15');
insert into SHOWING values(87, 3, 8, '9:30');
insert into SHOWING values(88, 3, 7, '8:30');
insert into SHOWING values(89, 3, 6, '7:00');
insert into SHOWING values(90, 4, 9, '9:30');
insert into SHOWING values(91, 4, 9, '8:45');
insert into SHOWING values(92, 4, 10, '7:00');
insert into SHOWING values(93, 4, 10, '5:30');
insert into SHOWING values(94, 4, 9, '4:15');
insert into SHOWING values(95, 3, 9, '6:30');
insert into SHOWING values(96, 3, 7, '7:00');
insert into SHOWING values(97, 4, 7, '9:30');
insert into SHOWING values(98, 4, 5, '8:45');
insert into SHOWING values(99, 4, 6, '7:00');
insert into SHOWING values(100, 4, 8, '5:30');
insert into SHOWING values(101, 4, 8, '4:15');
insert into SHOWING values(102, 3, 9, '6:30');