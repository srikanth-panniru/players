CREATE TABLE players(
	id BIGINT PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	dob date,
	player_type varchar(50),
	email varchar(50) UNIQUE,
	jersey_number INT,
	created_at timestamp,
	updated_at timestamp
);
CREATE SEQUENCE players_id_sequence INCREMENT BY 1 MINVALUE 0 NO MAXVALUE START WITH 1 NO CYCLE;