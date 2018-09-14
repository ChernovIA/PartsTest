CREATE TABLE parts (
  id int(11) NOT NULL AUTO_INCREMENT,
  countInt int(11) NOT NULL,
  name varchar(255) DEFAULT NULL,
  required bit(1) NOT NULL,
  type varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf;

INSERT INTO parts (countInt, name, required, type)
VALUES
(100, 'Mother board Asus', true, 'MOTHERBOARD'),
(110, 'Mother board Aser', true, 'MOTHERBOARD'),
(40, 'Mother board Intel', true, 'MOTHERBOARD'),
(80, 'Mother board Gigabyte', true, 'MOTHERBOARD'),

(150, 'Intel core i7', true, 'PROCESSOR'),
(100, 'Intel core i5', true, 'PROCESSOR'),
(150, 'AMD X2 64', true, 'PROCESSOR'),

(70, 'GeForce Gtx960', true, 'VIDEOCARD'),
(80, 'GeForce Gtx860', true, 'VIDEOCARD'),
(40, 'AMD Radion HD', true, 'VIDEOCARD'),
(100, 'AMD Radion HR', true, 'VIDEOCARD'),

(150, 'SB MSI', true, 'SOUNDCARD'),
(150, 'SB Creative', true, 'SOUNDCARD'),
(100, 'SB ASUS', true, 'SOUNDCARD'),

(100, 'TP-LINK', false, 'ETHERNET'),
(40, 'D-LINK', false, 'ETHERNET'),
(10, 'Intel EXP', false, 'ETHERNET'),

(200, 'DDR4', true, 'MEMORY'),
(250, 'DDR3', true, 'MEMORY'),
(100, 'DDR2', true, 'MEMORY'),

(180, 'WIFI router TP-LINK', false, 'WIFI'),
(180, 'WIFI router ZYXEL', false, 'WIFI'),

(90, 'HDD Samsung', true, 'HDD_DRIVE'),
(120, 'HDD IBM', true, 'HDD_DRIVE'),
(190, 'HDD Seagate', true, 'HDD_DRIVE'),

(120, 'SDD Samsung', false, 'SDD_DRIVE'),
(250, 'SDD IBM', false, 'SDD_DRIVE'),
(200, 'SDD Seagate', false, 'SDD_DRIVE'),

(200, 'Monitor Samsung', true, 'MONITOR'),
(300, 'Monitor Acer', true, 'MONITOR'),
(201, 'Monitor BenQ', true, 'MONITOR'),

(201, 'Keyboard Oklick', true, 'KEYBOARD'),
(302, 'Keyboard Logitech', true, 'KEYBOARD'),
(240, 'Keyboard A4Tech', true, 'KEYBOARD'),

(105, 'Mouse Oklick', true, 'MOUSE'),
(200, 'Mouse Logitech', true, 'MOUSE'),
(310, 'Mouse A4Tech', true, 'MOUSE'),

(125, 'Midi Tiwer AeroCool', true, 'BODYCASE'),
(240, 'Mini-Tower IN WIN', true, 'BODYCASE'),
(110, 'Midi Tiwer Cooler Master', true, 'BODYCASE'),

(205, 'Deepcool GAMMAXX', true, 'COOLER'),
(230, 'Cooler Master', true, 'COOLER'),
(140, 'PCcooler', true, 'COOLER'),

(186, 'Thermaltake 500W', true, 'SUPPLY'),
(45, 'AeroCool 1000W', true, 'SUPPLY'),
(124, 'Deepcool 650W', true, 'SUPPLY')
