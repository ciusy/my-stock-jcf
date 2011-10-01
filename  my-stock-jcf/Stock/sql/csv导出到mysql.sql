LOAD DATA LOCAL INFILE 'c:/stock/600416.csv' 
INTO TABLE t_600416 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\n' 
(date,open, high, low, close,volumn);