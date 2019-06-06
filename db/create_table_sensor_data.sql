CREATE TABLE `sensordata` (
  `data_id` int(11) NOT NULL AUTO_INCREMENT,
  `robot_model` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `patient_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `patient_surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `decibel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `face_express` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `humidty` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;