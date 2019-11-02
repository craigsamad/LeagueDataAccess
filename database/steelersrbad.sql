DROP TABLE IF EXISTS season_owner;
DROP TABLE IF EXISTS owner_score;
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
	game_id serial,
	season integer NOT NULL,
	week_num integer NOT NULL,
	type integer NOT NULL,
	
	CONSTRAINT pk_game_game_id PRIMARY KEY (game_id)
);

CREATE TABLE owner_score (
	row_id serial,
	game_id integer NOT NULL,
	owner_id integer NOT NULL,
	score float NOT NULL,
	opponent_id integer NOT NULL,
	
	CONSTRAINT pk_owner_score_row_id PRIMARY KEY (row_id)
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

INSERT INTO game (season,week_num,type) VALUES (2011,1,1);
INSERT INTO game (season,week_num,type) VALUES (2011,1,1);
INSERT INTO game (season,week_num,type) VALUES (2011,1,1);
INSERT INTO game (season,week_num,type) VALUES (2011,1,1);
INSERT INTO game (season,week_num,type) VALUES (2011,2,1);
INSERT INTO game (season,week_num,type) VALUES (2011,2,1);
INSERT INTO game (season,week_num,type) VALUES (2011,2,1);
INSERT INTO game (season,week_num,type) VALUES (2011,2,1);
INSERT INTO game (season,week_num,type) VALUES (2011,3,1);
INSERT INTO game (season,week_num,type) VALUES (2011,3,1);
INSERT INTO game (season,week_num,type) VALUES (2011,3,1);
INSERT INTO game (season,week_num,type) VALUES (2011,3,1);
INSERT INTO game (season,week_num,type) VALUES (2011,4,1);
INSERT INTO game (season,week_num,type) VALUES (2011,4,1);
INSERT INTO game (season,week_num,type) VALUES (2011,4,1);
INSERT INTO game (season,week_num,type) VALUES (2011,4,1);
INSERT INTO game (season,week_num,type) VALUES (2011,5,1);
INSERT INTO game (season,week_num,type) VALUES (2011,5,1);
INSERT INTO game (season,week_num,type) VALUES (2011,5,1);
INSERT INTO game (season,week_num,type) VALUES (2011,5,1);
INSERT INTO game (season,week_num,type) VALUES (2011,6,1);
INSERT INTO game (season,week_num,type) VALUES (2011,6,1);
INSERT INTO game (season,week_num,type) VALUES (2011,6,1);
INSERT INTO game (season,week_num,type) VALUES (2011,6,1);
INSERT INTO game (season,week_num,type) VALUES (2011,7,1);
INSERT INTO game (season,week_num,type) VALUES (2011,7,1);
INSERT INTO game (season,week_num,type) VALUES (2011,7,1);
INSERT INTO game (season,week_num,type) VALUES (2011,7,1);
INSERT INTO game (season,week_num,type) VALUES (2011,8,1);
INSERT INTO game (season,week_num,type) VALUES (2011,8,1);
INSERT INTO game (season,week_num,type) VALUES (2011,8,1);
INSERT INTO game (season,week_num,type) VALUES (2011,8,1);
INSERT INTO game (season,week_num,type) VALUES (2011,9,1);
INSERT INTO game (season,week_num,type) VALUES (2011,9,1);
INSERT INTO game (season,week_num,type) VALUES (2011,9,1);
INSERT INTO game (season,week_num,type) VALUES (2011,9,1);
INSERT INTO game (season,week_num,type) VALUES (2011,10,1);
INSERT INTO game (season,week_num,type) VALUES (2011,10,1);
INSERT INTO game (season,week_num,type) VALUES (2011,10,1);
INSERT INTO game (season,week_num,type) VALUES (2011,10,1);
INSERT INTO game (season,week_num,type) VALUES (2011,11,1);
INSERT INTO game (season,week_num,type) VALUES (2011,11,1);
INSERT INTO game (season,week_num,type) VALUES (2011,11,1);
INSERT INTO game (season,week_num,type) VALUES (2011,11,1);
INSERT INTO game (season,week_num,type) VALUES (2011,12,1);
INSERT INTO game (season,week_num,type) VALUES (2011,12,1);
INSERT INTO game (season,week_num,type) VALUES (2011,12,1);
INSERT INTO game (season,week_num,type) VALUES (2011,12,1);
INSERT INTO game (season,week_num,type) VALUES (2011,13,1);
INSERT INTO game (season,week_num,type) VALUES (2011,13,1);
INSERT INTO game (season,week_num,type) VALUES (2011,13,1);
INSERT INTO game (season,week_num,type) VALUES (2011,13,1);
INSERT INTO game (season,week_num,type) VALUES (2011,14,1);
INSERT INTO game (season,week_num,type) VALUES (2011,14,1);
INSERT INTO game (season,week_num,type) VALUES (2011,14,1);
INSERT INTO game (season,week_num,type) VALUES (2011,14,1);
INSERT INTO game (season,week_num,type) VALUES (2011,15,2);
INSERT INTO game (season,week_num,type) VALUES (2011,15,2);
INSERT INTO game (season,week_num,type) VALUES (2011,15,2);
INSERT INTO game (season,week_num,type) VALUES (2011,15,2);
INSERT INTO game (season,week_num,type) VALUES (2011,16,2);
INSERT INTO game (season,week_num,type) VALUES (2011,16,2);
INSERT INTO game (season,week_num,type) VALUES (2011,16,3);
INSERT INTO game (season,week_num,type) VALUES (2011,16,3);
INSERT INTO game (season,week_num,type) VALUES (2011,17,3);
INSERT INTO game (season,week_num,type) VALUES (2011,17,4);
INSERT INTO game (season,week_num,type) VALUES (2011,17,3);
INSERT INTO game (season,week_num,type) VALUES (2011,17,3);

INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (1,1,84.78,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (1,2,122.9,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (2,3,115.3,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (2,8,72.56,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (3,4,125.18,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (3,7,95.16,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (4,5,125.28,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (4,6,94.66,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (5,1,142.62,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (5,4,119.48,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (6,2,100.06,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (6,3,120.02,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (7,5,131.02,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (7,8,96.08,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (8,6,105,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (8,7,107.4,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (9,1,108.68,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (9,6,86.5,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (10,2,76.02,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (10,4,108.64,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (11,5,122.28,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (11,3,68.34,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (12,8,110.46,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (12,7,79.8,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (13,1,107.94,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (13,8,76.12,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (14,5,121.62,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (14,2,137,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (15,6,134.24,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (15,4,125.74,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (16,3,84.38,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (16,7,52.04,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (17,1,116.74,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (17,3,88.4,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (18,2,97.76,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (18,6,73.48,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (19,5,74.34,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (19,7,82.76,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (20,4,105.4,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (20,8,75.8,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (21,5,112.34,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (21,1,81.66,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (22,2,104.82,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (22,7,70.62,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (23,6,120.52,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (23,8,52.86,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (24,3,81.78,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (24,4,122.58,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (25,1,109.34,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (25,7,46.5,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (26,2,130.42,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (26,8,83.48,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (27,6,79.72,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (27,3,79.06,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (28,5,85.6,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (28,4,62.44,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (29,1,139,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (29,2,121,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (30,3,105.36,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (30,8,68.08,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (31,4,68.96,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (31,7,42.36,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (32,5,51.92,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (32,6,84.74,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (33,1,110.38,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (33,4,92.22,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (34,2,77,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (34,3,84.6,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (35,5,113.48,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (35,8,101.78,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (36,6,91.1,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (36,7,55.22,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (37,1,77.18,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (37,6,84.08,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (38,2,95.36,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (38,4,80.72,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (39,5,146.4,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (39,3,69.76,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (40,8,73.86,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (40,7,44.38,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (41,1,94.26,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (41,8,89.76,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (42,5,117.46,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (42,2,72.8,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (43,6,101.44,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (43,4,74.88,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (44,3,84.46,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (44,7,23,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (45,1,92.82,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (45,3,113.92,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (46,2,84.84,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (46,6,71.68,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (47,5,85.88,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (47,7,48.32,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (48,4,84.2,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (48,8,92.44,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (49,5,115.86,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (49,1,91.96,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (50,2,118.62,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (50,7,52.98,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (51,6,112.28,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (51,8,136.42,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (52,3,89.18,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (52,4,90.06,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (53,1,105.48,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (53,7,51.18,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (54,2,94.18,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (54,8,85.28,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (55,6,117,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (55,3,107.6,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (56,5,147.54,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (56,4,93.92,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (57,1,121.3,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (57,8,91.78,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (58,2,107.24,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (58,4,82.06,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (59,6,91.06,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (59,3,96.98,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (60,5,110.7,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (60,7,66.28,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (61,1,119.26,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (61,2,137.92,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (62,5,132.02,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (62,3,86.96,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (63,4,105.22,8);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (63,8,87.68,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (64,6,70.22,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (64,7,40.18,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (65,1,65.12,3);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (65,3,103.9,1);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (66,5,122.2,2);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (66,2,133.3,5);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (67,6,84.24,4);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (67,4,121.1,6);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (68,8,101.84,7);
INSERT INTO owner_score (game_id,owner_id,score,opponent_id) VALUES (68,7,60.26,8);

ALTER TABLE season_owner ADD FOREIGN KEY (owner_id) REFERENCES owner(owner_id);
ALTER TABLE season_owner ADD FOREIGN KEY (season_id) REFERENCES season(season_id);
ALTER TABLE owner_score ADD FOREIGN KEY (game_id) REFERENCES game(game_id);