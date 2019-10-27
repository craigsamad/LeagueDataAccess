DROP TABLE IF EXISTS season_owner;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS owner;
DROP TABLE IF EXISTS season;

CREATE TABLE owner (
	owner_id serial,
	first_name varchar(40) NOT NULL,          
	last_name varchar(40) NOT NULL,
  
	CONSTRAINT pk_owner_owner_id PRIMARY KEY (owner_id)
);

CREATE TABLE season (
	season_id integer NOT NULL,
	season_name varchar(60) NOT NULL,
  
	CONSTRAINT pk_season_season_id PRIMARY KEY (season_id)
);

CREATE TABLE season_owner (
	owner_id integer NOT NULL,
	season_id integer NOT NULL
);

CREATE TABLE game (
	row_id serial,
	season integer NOT NULL,
	owner_id integer NOT NULL,
	week_num integer NOT NULL,
	score decimal,
	opponent_id integer NOT NULL,
	win boolean,
	
	CONSTRAINT pk_game_row_id PRIMARY KEY (row_id)
);

INSERT INTO owner (first_name, last_name) VALUES ('Craig', 'Samad');
INSERT INTO owner (first_name, last_name) VALUES ('David', 'Samad');
INSERT INTO owner (first_name, last_name) VALUES ('Tyler', 'Begley');
INSERT INTO owner (first_name, last_name) VALUES ('Reece', 'Johnson');
INSERT INTO owner (first_name, last_name) VALUES ('Zach', 'Ahting');
INSERT INTO owner (first_name, last_name) VALUES ('Mitch', 'Gonthier');
INSERT INTO owner (first_name, last_name) VALUES ('Brett', 'Stoltz');
INSERT INTO owner (first_name, last_name) VALUES ('Ashley', 'Robinson');
INSERT INTO owner (first_name, last_name) VALUES ('Alex', 'Kakaris');
INSERT INTO owner (first_name, last_name) VALUES ('Seyra', 'Gadagbui');
INSERT INTO owner (first_name, last_name) VALUES ('Brian', 'Hackman');
INSERT INTO owner (first_name, last_name) VALUES ('Brad', 'Mueller');
INSERT INTO owner (first_name, last_name) VALUES ('Zach', 'Peters');
INSERT INTO owner (first_name, last_name) VALUES ('Joe', 'Fackler');
INSERT INTO owner (first_name, last_name) VALUES ('Ben', 'Pitonyak');
INSERT INTO owner (first_name, last_name) VALUES ('Scott', 'Dougherty');
INSERT INTO owner (first_name, last_name) VALUES ('Chris', 'Hatfield');
INSERT INTO owner (first_name, last_name) VALUES ('Hunter', 'Arey');
INSERT INTO owner (first_name, last_name) VALUES ('Jeff', 'Stevenson');
INSERT INTO owner (first_name, last_name) VALUES ('Tori', 'Witzke');
INSERT INTO owner (first_name, last_name) VALUES ('Cody', 'Farley');

INSERT INTO season (season_id, season_name) VALUES (2011, '2011 Season');
INSERT INTO season (season_id, season_name) VALUES (2012, '2012 Season');
INSERT INTO season (season_id, season_name) VALUES (2013, '2013 Season');
INSERT INTO season (season_id, season_name) VALUES (2014, '2014 Season');
INSERT INTO season (season_id, season_name) VALUES (2015, '2015 Season');
INSERT INTO season (season_id, season_name) VALUES (2016, '2016 Season');
INSERT INTO season (season_id, season_name) VALUES (2017, '2017 Season');
INSERT INTO season (season_id, season_name) VALUES (2018, '2018 Season');
INSERT INTO season (season_id, season_name) VALUES (2019, '2019 Season');

INSERT INTO season_owner (owner_id, season_id) VALUES (1,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (2,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (3,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (4,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (5,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (6,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (7,2011);
INSERT INTO season_owner (owner_id, season_id) VALUES (8,2011);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,1,125.28,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,2,131.02,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,3,122.28,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,4,121.62,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,5,74.34,7,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,6,112.34,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,7,85.60,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,8,51.92,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,9,113.48,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,10,146.40,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,11,117.46,2,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,12,85.88,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,13,115.86,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,14,147.54,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,15,110.70,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,16,132.02,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,5,17,122.20,2,FALSE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,1,84.78,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,2,142.62,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,3,108.68,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,4,107.94,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,5,116.74,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,6,81.66,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,7,109.34,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,8,139.00,2,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,9,110.38,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,10,77.18,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,11,94.26,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,12,92.82,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,13,91.96,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,14,105.48,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,15,121.30,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,16,119.26,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,1,17,65.12,3,FALSE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,1,122.90,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,2,100.06,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,3,76.02,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,4,137.00,5,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,5,97.76,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,6,104.82,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,7,130.42,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,8,121.00,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,9,77.00,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,10,95.36,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,11,72.80,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,12,84.84,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,13,118.62,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,14,94.18,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,15,107.24,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,16,137.92,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,2,17,133.30,5,TRUE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,1,94.66,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,2,105.00,7,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,3,86.50,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,4,134.24,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,5,73.48,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,6,120.52,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,7,79.72,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,8,84.74,5,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,9,91.10,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,10,84.08,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,11,101.44,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,12,71.68,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,13,112.28,8,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,14,117.00,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,15,91.06,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,16,70.22,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,6,17,84.24,4,FALSE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,1,115.30,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,2,120.02,2,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,3,68.34,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,4,84.38,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,5,88.40,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,6,81.78,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,7,79.06,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,8,105.36,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,9,84.60,2,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,10,69.76,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,11,84.46,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,12,113.92,1,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,13,89.18,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,14,107.60,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,15,96.98,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,16,86.96,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,3,17,103.90,1,TRUE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,1,125.18,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,2,119.48,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,3,108.64,2,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,4,125.74,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,5,105.40,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,6,122.58,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,7,62.44,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,8,68.96,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,9,92.22,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,10,80.72,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,11,74.88,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,12,84.20,8,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,13,90.06,3,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,14,93.92,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,15,82.06,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,16,105.22,8,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,4,17,121.10,6,TRUE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,1,72.56,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,2,96.08,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,3,110.46,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,4,76.12,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,5,75.80,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,6,52.86,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,7,83.48,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,8,68.08,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,9,101.78,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,10,73.86,7,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,11,89.76,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,12,92.44,4,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,13,136.42,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,14,85.28,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,15,91.78,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,16,87.68,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,8,17,101.84,7,TRUE);

INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,1,95.16,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,2,107.40,6,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,3,79.80,8,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,4,52.04,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,5,82.76,5,TRUE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,6,70.62,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,7,46.50,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,8,42.36,4,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,9,55.22,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,10,44.38,8,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,11,23.00,3,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,12,48.32,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,13,52.98,2,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,14,51.18,1,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,15,66.28,5,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,16,40.18,6,FALSE);
INSERT INTO game (season,owner_id,week_num,score,opponent_id,win) VALUES (2011,7,17,60.26,8,FALSE);


ALTER TABLE season_owner ADD FOREIGN KEY (owner_id) REFERENCES owner(owner_id);
ALTER TABLE season_owner ADD FOREIGN KEY (season_id) REFERENCES season(season_id);
ALTER TABLE game ADD FOREIGN KEY (owner_id) REFERENCES owner(owner_id);