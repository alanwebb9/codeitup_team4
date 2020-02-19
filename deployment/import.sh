#!/bin/bash
db_host=
db_user=admin
db=health

mysql -h $db_host -u $db_user -p$1 $db << eof
CREATE TABLE data (    
	x FLOAT NOT NULL,    
	y FLOAT NOT NULL,    
	fid INT NOT NULL,    
	cat VARCHAR(50),    
	ref VARCHAR(50),    
	name VARCHAR(100),    
	des VARCHAR(255),    
	lon FLOAT NOT NULL,    
	lat FLOAT NOT NULL,    
	email VARCHAR(255),    
	web VARCHAR(255),    
	phone VARCHAR(255),     
PRIMARY KEY (fid) ) ;
eof

mysql -h $db_host -u $db_user -p$1 $db << eof
LOAD DATA LOCAL INFILE 'outdoor.csv'  INTO TABLE data FIELDS TERMINATED BY ','  ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 ROWS;
eof

