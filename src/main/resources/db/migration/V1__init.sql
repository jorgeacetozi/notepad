CREATE TABLE note (
    id INTEGER NOT NULL AUTO_INCREMENT, 
	title VARCHAR(255) NOT NULL, 
	content VARCHAR(255) NOT NULL, 
	PRIMARY KEY (id)
);

INSERT INTO notepad.note VALUES (1, 'What is Cassandra?', 'Cassandra is a NoSQL database that belongs to the Column Family NoSQL database category.');
