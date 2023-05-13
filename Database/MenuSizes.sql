CREATE TABLE sizes (
	item VARCHAR (50) PRIMARY KEY,
	size1 DOUBLE PRECISION DEFAULT 0.0,
	size2 DOUBLE PRECISION DEFAULT 0.0,
	size3 DOUBLE PRECISION DEFAULT 0.0,
	size4 DOUBLE PRECISION DEFAULT 0.0
);

INSERT INTO sizes(item, size1, size2, size3, size4) VALUES
	-- Fried Rice
	('Plain Fried Rice', 5.1, 7.5, 0, 0),
	('Regular Fried Rice', 5.1, 7.5, 0, 0),
	('Vegetable Fried Rice', 5.1, 7.5, 0, 0),
	('Pork Fried Rice', 5.5, 7.95, 0, 0),
	('Chicken Fried Rice', 5.5, 7.95, 0, 0),
	('Beef Fried Rice', 5.95, 8.95, 0, 0),
	('Shrimp Fried Rice', 5.95, 8.95, 0, 0),
	('House Special Fried Rice', 5.95, 8.95, 0, 0),

	-- Lo Mein
	('Plain Lo Mein', 5.1, 7.5, 6.25, 8.3),
	('Regular Lo Mein', 5.1, 7.5, 6.25, 8.3),
	('Vegetable Lo Mein', 5.1, 7.5, 6.25, 8.3),
	('Pork Lo Mein', 5.5, 7.95, 6.25, 8.3),
	('Chicken Lo Mein', 5.5, 7.95, 6.25, 8.3),
	('Beef Lo Mein', 5.95, 8.95, 6.25, 8.3),
	('Shrimp Lo Mein', 5.95, 8.95, 6.25, 8.3),
	('House Special Lo Mein', 5.95, 8.95, 6.25, 8.3),

	-- Mai Fun
	('Plain Mai Fun', 5.1, 7.5, 6.25, 8.3),
	('Regular Mai Fun', 5.1, 7.5, 6.25, 8.3),
	('Vegetable Mai Fun', 5.1, 7.5, 6.25, 8.3),
	('Pork Mai Fun', 5.5, 7.95, 6.25, 8.3),
	('Chicken Mai Fun', 5.5, 7.95, 6.25, 8.3),
	('Beef Mai Fun', 5.95, 8.95, 6.25, 8.3),
	('Shrimp Mai Fun', 5.95, 8.95, 6.25, 8.3),
	('House Special Mai Fun', 5.95, 8.95, 6.25, 8.3),

	-- Chow Mein
	('Vegetable Chow Mein', 5.1, 7.5, 6.25, 8.3),
	('Pork Chow Mein', 5.5, 7.95, 6.25, 8.3),
	('Chicken Chow Mein', 5.5, 7.95, 6.25, 8.3),
	('Beef Chow Mein', 5.95, 8.95, 6.25, 8.3),
	('Shrimp Chow Mein', 5.95, 8.95, 6.25, 8.3),
	('House Special Chow Mein', 5.95, 8.95, 6.25, 8.3),

	-- Poultry
	('Moo Goo Gai Pan', 6.35, 9.25, 6.25, 8.3),
	('Chicken w/ Broccoli', 6.35, 9.25, 6.25, 8.3),
	('Chicken w/ Snow Peas', 6.35, 9.25, 6.25, 8.3),
	('Chicken w/ Cashew Nuts', 6.35, 9.25, 6.25, 8.3),
	('Chicken w/ Mixed Veg.', 6.35, 9.25, 6.25, 8.3),
	('Chicken w/ Garlic Sauce', 6.35, 9.25, 6.25, 8.3),
	('Curry Chicken w/ Onions', 6.35, 9.25, 6.25, 8.3),
	('Kum Po Chicken', 6.35, 9.25, 6.25, 8.3),
	('Diced Chicken & Shrimp', 6.35, 9.25, 6.25, 8.3),
	('Sweet & Sour Chicken', 0, 9.25, 6.25, 8.3),
	('General Tso''s Chicken', 0, 10.35, 6.5, 8.5),
	('Sesame Chicken', 0, 10.35, 6.5, 8.5),
	('Orange Chicken', 0, 10.35, 6.5, 8.5),
	('Crispy Chicken', 0, 10.35, 6.5, 8.3),
	('Coral Chicken', 0, 10.35, 6.5, 8.3),
	('Pepper Chicken', 0, 10.35, 0, 8.5),

	-- Pork
	('Pork w/ Chinese Veg.', 6.35, 9.25, 6.25, 8.3),
	('Pork w/ Broccoli', 6.35, 9.25, 6.25, 8.3),
	('Pork w/ Snow Peas', 6.35, 9.25, 6.25, 8.3),
	('Pork w/ Mushroom', 6.35, 9.25, 6.25, 8.3),
	('Pork w/ Garlic Sauce', 6.35, 9.25, 6.25, 8.3),
	('Sweet & Sour Pork', 0, 9.25, 6.25, 8.3),
	('Sauteed Sliced Pork', 0, 9.25, 0, 0),

	-- Beef
	('Pepper Steak w/ Onions', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Broccoli', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Snow Peas', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Mushroom', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Garlic Sauce', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Chinese Veg.', 6.99, 9.95, 6.25, 8.3),
	('Beef w/ Mixed Veg.', 6.99, 9.95, 6.25, 8.3),
	('Curry Beef w/ Onions', 6.99, 9.95, 6.25, 8.3),
	('Orange Beef', 0, 10.65, 6.5, 8.5),
	('Mongolian Beef', 0, 10.35, 0, 8.5),

	-- Seafood
	('Shrimp w/ Lobster Sauce', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Broccoli', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Snow Peas', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Cashew Nuts', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Garlic Sauce', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Chinese Veg.', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Mixed Veg.', 6.99, 9.95, 6.25, 8.3),
	('Shrimp w/ Curry Sauce', 6.99, 9.95, 6.25, 8.3),
	('Kum Po Shrimp', 6.99, 9.95, 6.25, 8.3),
	('Sweet & Sour Shrimp', 0, 9.95, 6.25, 8.3),
	('Crab & Shrimp Garlic Sauce', 0, 9.95, 6.25, 8.3),
	('Coral Shrimp', 0, 12.99, 6.5, 8.5),

	-- Vegetable
	('Buddhist Delight', 0, 8.25, 0, 0),
	('Moo Shu Vegetable', 0, 8.25, 0, 0),
	('Sauteed Vegetable', 0, 8.25, 0, 0),
	('Mixed Veg. w/ Garlic Sauce', 0, 8.25, 0, 0),
	('Broccoli w/ Garlic Sauce', 0, 8.25, 0, 0),
	('Hunan Bean Curd', 0, 8.25, 0, 0),
	('Ma Po Tofu', 0, 8.25, 0, 0),
	('Steam Broccoli', 0, 8.25, 0, 0),
	('Steam Mixed Veg.', 0, 8.25, 0, 0),
	('Steam Chicken w/ Broccoli', 6.35, 9.25, 6.25, 8.3),
	('Steam Chicken w/ Mixed Veg.', 6.35, 9.25, 6.25, 8.3),
	('Steam Shrimp w/ Broccoli', 6.99, 9.95, 6.25, 8.3),
	('Steam Shrimp w/ Mixed Veg.', 6.99, 9.95, 6.25, 8.3),

	-- Soup
	('Wonton Soup', 2.5, 3.5, 0, 0),
	('Wonton Egg Drop Soup', 2.5, 3.5, 0, 0),
	('Chicken Noodle Soup', 2.5, 3.5, 0, 0),
	('Chicken Rice Soup', 2.5, 3.5, 0, 0),
	('Veg. w/ Bean Curd Soup', 2.5, 3.5, 0, 0),
	('Egg Drop Soup', 1.99, 2.99, 0, 0),
	('Hot & Sour Soup', 2.70, 3.99, 0, 0),
	('House Special Soup', 4.95, 0, 0, 0),
	('Seafood Soup', 5.95, 0, 0, 0),

	-- Appetizers
	('Spring Roll (2)', 2.5, 0, 0, 0),
	('Pork Egg Roll', 1.29, 0, 0, 0),
	('Shrimp Egg Roll', 1.39, 0, 0, 0),
	('Boneless Spare Ribs', 6.25, 10.99, 6.5, 8.5),
	('Fried Dumplings (8)', 5.25, 0, 0, 0),
	('Steam Dumplings (8)', 5.25, 0, 0, 0),
	('Cheese Wontons (8)', 4.5, 0, 0, 0),
	('Fried Pork Wontons (10)', 4.5, 0, 0, 0),
	('Fried Scallops (8)', 3.99, 0, 0, 0),
	('Fried Nuggets (8)', 3.99, 0, 0, 0),
	('Fried Onions (12)', 2.75, 0, 0, 0),
	('Apple Sticks (12)', 2.75, 0, 0, 0),
	('Teriyaki Chicken (5)', 4.69, 0, 0, 0),
	('Teriyaki Beef (5)', 4.99, 0, 0, 0),
	('Fried Shrimp (20)', 6.99, 0, 0, 0),

	-- Side Orders
	('White Rice', 2.5, 3.0, 0, 0),
	('Sweet & Sour Sauce', 1.0, 0, 0, 0),
	('Coral Sauce', 1.0, 0, 0, 0),
	('Dumpling Sauce', 0.5, 0, 0, 0),
	('Fried Noodles', 0.5, 0, 0, 0),
	('Hot Oil', 0.5, 0, 0, 0),

	 -- Egg Foo Young
	('Vegetable Egg Foo Young', 0, 8.5, 0, 8.3),
	('Pork Egg Foo Young', 0, 8.5, 0, 8.3),
	('Chicken Egg Foo Young', 0, 8.5, 0, 8.3),
	('Beef Egg Foo Young', 0, 9.5, 0, 8.3),
	('Shrimp Egg Foo Young', 0, 9.5, 0, 8.3),

	-- Szechuan & Hunan Cuisine
	('Seafood Pan Fried Noodles', 0, 11.7, 0, 0),
	('House Pan Fried Noodles', 0, 11.7, 0, 0),
	('Happy Family', 0, 11.7, 0, 0),
	('Seafood Delight', 0, 11.7, 0, 0),
	('Four Seasons', 0, 10.99, 0, 0),
	('Hunan Triple Delight', 0, 10.65, 0, 0),
	('Hunan Beef', 0, 10.35, 6.5, 8.5),
	('Hunan Chicken', 0, 10.35, 6.5, 8.5),
	('Moo Shu Pork', 0, 9.25, 0, 0),
	('Moo Shu Chicken', 0, 9.25, 0, 0),
	('Moo Shu Shrimp', 0, 9.95, 0, 0),
	('Szechuan Chicken', 0, 10.35, 0, 0);

select * from sizes;