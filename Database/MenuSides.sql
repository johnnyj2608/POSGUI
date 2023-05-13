CREATE TABLE sides (
	item VARCHAR (50) PRIMARY KEY,
	size1 DOUBLE PRECISION DEFAULT 0.0,
	size2 DOUBLE PRECISION DEFAULT 0.0,
	size3 DOUBLE PRECISION DEFAULT 0.0
);

INSERT INTO sides(item, size1, size2, size3) VALUES

	('White Rice', 0, 0, 0),
	('Plain Fried Rice', 0.75, 1.5, 0),
	('Regular Fried Rice', 0.75, 1.5, 0),
	('Vegetable Fried Rice', 0.75, 1.5, 0),
	('Pork Fried Rice', 1.0, 2.0, 0),
	('Chicken Fried Rice', 1.0, 2.0, 0),
	('Beef Fried Rice', 1.5, 2.5, 1.0),
	('Shrimp Fried Rice', 1.5, 2.5, 1.0),

	('Plain Lo Mein', 0, 2.5, 2.0),
	('Regular Lo Mein', 0, 2.5, 2.0),
	('Vegetable Lo Mein', 0, 2.5, 2.5),
	('Pork Lo Mein', 0, 3.0, 2.5),
	('Chicken Lo Mein', 0, 3.0, 2.5),
	('Beef Lo Mein', 0, 3.5, 3.0),
	('Shrimp Lo Mein', 0, 3.5, 3.0),
	('None', 0, 0, 0);

select * from sides;