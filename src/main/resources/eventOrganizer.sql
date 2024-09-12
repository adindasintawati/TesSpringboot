CREATE DATABASE eventOrganizer2

CREATE TABLE IF NOT EXISTS events (
    id SERIAL PRIMARY KEY,
    title varchar(250) NOT NULL,
    start_on TIMESTAMP NOT NULL,
    complete_on TIMESTAMP NOT NULL,
    participant INT NOT NULL,
    location varchar(100) NOT NULL,
	id_panitia INT NOT NULL,
    version INT,
	FOREIGN KEY (id_panitia) REFERENCES panitia(id) ON DELETE CASCADE
);

CREATE TABLE participants (
	id SERIAL PRIMARY KEY,
	event_id INT,
	participant_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) not NULL,
	FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);

CREATE TABLE committees (
id SERIAL PRIMARY KEY,
name VARCHAR(250) NOT NULL
);

INSERT INTO events (title, start_on, complete_on, participant, location, VERSION)
VALUES ('Kuliner', '2024-02-25T06:05:00.000000', '2024-02-27T10:27:00.000000', 100, 'BANDUNG', 0);

INSERT INTO participants (event_id, participant_name, email)
VALUES (1, 'Adinda', 'adinda@gmail.com');

INSERT INTO committees (name)
VALUES ('Sinta');