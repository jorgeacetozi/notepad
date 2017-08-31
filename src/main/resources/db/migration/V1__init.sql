CREATE TABLE note (
    id INTEGER NOT NULL AUTO_INCREMENT, 
	title VARCHAR(50) NOT NULL, 
	content text NOT NULL, 
	word_count INTEGER NOT NULL, 
	PRIMARY KEY (id)
);

INSERT INTO notepad.note VALUES (1, 'What is Cassandra?', 'Cassandra is a NoSQL database that belongs to the Column Family NoSQL database category.', 14);
