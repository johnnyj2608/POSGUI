CREATE TABLE menu (
	item_id SERIAL,
	item VARCHAR (50) PRIMARY KEY,
	half1 VARCHAR (25),
	half2 VARCHAR (25),
	amt INTEGER DEFAULT 0,
	categ VARCHAR (25)
);

INSERT INTO menu(item, half1, half2, categ) VALUES
	-- Fried Rice
	('Plain Fried Rice', 'Plain', 'Fried Rice', 'Fried Rice'),
	('Regular Fried Rice', 'Regular', 'Fried Rice', 'Fried Rice'),
	('Vegetable Fried Rice', 'Vegetable', 'Fried Rice', 'Fried Rice'),
	('Pork Fried Rice', 'Pork', 'Fried Rice', 'Fried Rice'),
	('Chicken Fried Rice', 'Chicken', 'Fried Rice', 'Fried Rice'),
	('Beef Fried Rice', 'Beef', 'Fried Rice', 'Fried Rice'),
	('Shrimp Fried Rice', 'Shrimp', 'Fried Rice', 'Fried Rice'),
	('House Special Fried Rice', 'House Special', 'Fried Rice', 'Fried Rice'),

	-- Lo Mein
	('Plain Lo Mein', 'Plain', 'Lo Mein', 'Lo Mein'),
	('Regular Lo Mein', 'Regular', 'Lo Mein', 'Lo Mein'),
	('Vegetable Lo Mein', 'Vegetable', 'Lo Mein', 'Lo Mein'),
	('Pork Lo Mein', 'Pork', 'Lo Mein', 'Lo Mein'),
	('Chicken Lo Mein', 'Chicken', 'Lo Mein', 'Lo Mein'),
	('Beef Lo Mein', 'Beef', 'Lo Mein', 'Lo Mein'),
	('Shrimp Lo Mein', 'Shrimp', 'Lo Mein', 'Lo Mein'),
	('House Special Lo Mein', 'House Special', 'Lo Mein', 'Lo Mein'),

	-- Mai Fun
	('Plain Mai Fun', 'Plain', 'Mai Fun', 'Mai Fun'),
	('Regular Mai Fun', 'Regular', 'Mai Fun', 'Mai Fun'),
	('Vegetable Mai Fun', 'Vegetable', 'Mai Fun', 'Mai Fun'),
	('Pork Mai Fun', 'Pork', 'Mai Fun', 'Mai Fun'),
	('Chicken Mai Fun', 'Chicken', 'Mai Fun', 'Mai Fun'),
	('Beef Mai Fun', 'Beef', 'Mai Fun', 'Mai Fun'),
	('Shrimp Mai Fun', 'Shrimp', 'Mai Fun', 'Mai Fun'),
	('House Special Mai Fun', 'House Special', 'Mai Fun', 'Mai Fun'),

	-- Chow Mein
	('Vegetable Chow Mein', 'Vegetable', 'Chow Mein', 'Chow Mein'),
	('Pork Chow Mein', 'Pork', 'Chow Mein', 'Chow Mein'),
	('Chicken Chow Mein', 'Chicken', 'Chow Mein', 'Chow Mein'),
	('Beef Chow Mein', 'Beef', 'Chow Mein', 'Chow Mein'),
	('Shrimp Chow Mein', 'Shrimp', 'Chow Mein', 'Chow Mein'),
	('House Special Chow Mein', 'House Special', 'Chow Mein', 'Chow Mein'),

	-- Poultry
	('Moo Goo Gai Pan', 'Moo Goo', 'Gai Pan', 'Chicken'),
	('Chicken w/ Broccoli', 'Chicken w/', 'Broccoli', 'Chicken'),
	('Chicken w/ Snow Peas', 'Chicken w/', 'Snow Peas', 'Chicken'),
	('Chicken w/ Cashew Nuts', 'Chicken w/', 'Cashew Nuts', 'Chicken'),
	('Chicken w/ Mixed Veg.', 'Chicken w/', 'Mixed Veg.', 'Chicken'),
	('Chicken w/ Garlic Sauce', 'Chicken w/', 'Garlic Sauce', 'Chicken'),
	('Curry Chicken w/ Onions', 'Curry Chicken', 'w/ Onions', 'Chicken'),
	('Kum Po Chicken', 'Kum Po', 'Chicken', 'Chicken'),
	('Diced Chicken & Shrimp', 'Diced Chicken', '& Shrimp', 'Chicken'),
	('Sweet & Sour Chicken', 'Sweet &', 'Sour Chicken', 'Chicken'),
	('General Tso''s Chicken', 'General Tso''s', 'Chicken', 'Chicken'),
	('Sesame Chicken', 'Sesame', 'Chicken', 'Chicken'),
	('Orange Chicken', 'Orange', 'Chicken', 'Chicken'),
	('Crispy Chicken', 'Crispy', 'Chicken', 'Chicken'),
	('Coral Chicken', 'Coral', 'Chicken', 'Chicken'),
	('Pepper Chicken', 'Pepper', 'Chicken', 'Chicken'),

	-- Pork
	('Pork w/ Chinese Veg.', 'Pork w/', 'Chinese Veg.', 'Pork'),
	('Pork w/ Broccoli', 'Pork w/', 'Broccoli', 'Pork'),
	('Pork w/ Snow Peas', 'Pork w/', 'Snow Peas', 'Pork'),
	('Pork w/ Mushroom', 'Pork w/', 'Mushroom', 'Pork'),
	('Pork w/ Garlic Sauce', 'Pork w/', 'Garlic Sauce', 'Pork'),
	('Sweet & Sour Pork', 'Sweet &', 'Sour Pork', 'Pork'),
	('Sauteed Sliced Pork', 'Sauteed', 'Sliced Pork', 'Pork'),

	-- Beef
	('Pepper Steak w/ Onions', 'Pepper Steak', 'w/ Onions', 'Beef'),
	('Beef w/ Broccoli', 'Beef w/', 'Broccoli', 'Beef'),
	('Beef w/ Snow Peas', 'Beef w/', 'Snow Peas', 'Beef'),
	('Beef w/ Mushroom', 'Beef w/', 'Mushroom', 'Beef'),
	('Beef w/ Garlic Sauce', 'Beef w/', 'Garlic Sauce', 'Beef'),
	('Beef w/ Chinese Veg.', 'Beef w/', 'Chinese Veg.', 'Beef'),
	('Beef w/ Mixed Veg.', 'Beef w/', 'Mixed Veg.', 'Beef'),
	('Curry Beef w/ Onions', 'Curry Beef', 'w/ Onions', 'Beef'),
	('Orange Beef', 'Orange', 'Beef', 'Beef'),
	('Mongolian Beef', 'Mongolian', 'Beef', 'Beef'),

	-- Seafood
	('Shrimp w/ Lobster Sauce', 'Shrimp w/', 'Lobster Sauce', 'Shrimp'),
	('Shrimp w/ Broccoli', 'Shrimp w/', 'Broccoli', 'Shrimp'),
	('Shrimp w/ Snow Peas', 'Shrimp w/', 'Snow Peas', 'Shrimp'),
	('Shrimp w/ Cashew Nuts', 'Shrimp w/', 'Cashew Nuts', 'Shrimp'),
	('Shrimp w/ Garlic Sauce', 'Shrimp w/', 'Garlic Sauce', 'Shrimp'),
	('Shrimp w/ Chinese Veg.', 'Shrimp w/', 'Chinese Veg.', 'Shrimp'),
	('Shrimp w/ Mixed Veg.', 'Shrimp w/', 'Mixed Veg.', 'Shrimp'),
	('Shrimp w/ Curry Sauce', 'Shrimp w/', 'Curry Sauce', 'Shrimp'),
	('Kum Po Shrimp', 'Kum Po', 'Shrimp', 'Shrimp'),
	('Sweet & Sour Shrimp', 'Sweet &', 'Sour Shrimp', 'Shrimp'),
	('Crab & Shrimp Garlic Sauce', 'Crab & Shrimp', 'Garlic Sauce', 'Shrimp'),
	('Coral Shrimp', 'Coral', 'Shrimp', 'Shrimp'),

	-- Vegetable
	('Buddhist Delight', 'Buddhist', 'Delight', 'Vegetable'),
	('Moo Shu Vegetable', 'Moo Shu', 'Vegetable', 'Vegetable'),
	('Sauteed Vegetable', 'Sauteed', 'Vegetable', 'Vegetable'),
	('Mixed Veg. w/ Garlic Sauce', 'Mixed Veg. w/', 'Garlic Sauce', 'Vegetable'),
	('Broccoli w/ Garlic Sauce', 'Broccoli w/', 'Garlic Sauce', 'Vegetable'),
	('Hunan Bean Curd', 'Hunan Bean', 'Curd', 'Vegetable'),
	('Ma Po Tofu', 'Ma Po', 'Tofu', 'Vegetable'),
	('Steam Broccoli', 'Steam', 'Broccoli', 'Vegetable'),
	('Steam Mixed Veg.', 'Steam', 'Mixed Veg.', 'Vegetable'),
	('Steam Chicken w/ Broccoli', 'Steam Chicken', 'w/ Broccoli', 'Vegetable'),
	('Steam Chicken w/ Mixed Veg.', 'Steam Chicken', 'w/ Mixed Veg.', 'Vegetable'),
	('Steam Shrimp w/ Broccoli', 'Steam Shrimp', 'w/ Broccoli', 'Vegetable'),
	('Steam Shrimp w/ Mixed Veg.', 'Steam Shrimp', 'w/ Mixed Veg.', 'Vegetable'),

	-- Soup
	('Wonton Soup', 'Wonton', 'Soup', 'Soup'),
	('Wonton Egg Drop Soup', 'Wonton Egg', 'Drop Soup', 'Soup'),
	('Chicken Noodle Soup', 'Chicken', 'Noodle Soup', 'Soup'),
	('Chicken Rice Soup', 'Chicken', 'Rice Soup', 'Soup'),
	('Veg. w/ Bean Curd Soup', 'Veg. w/ Bean',  'Curd Soup', 'Soup'),
	('Egg Drop Soup', 'Egg', 'Drop Soup', 'Soup'),
	('Hot & Sour Soup', 'Hot &', 'Sour Soup', 'Soup'),
	('House Special Soup', 'House Special', 'Soup', 'Soup'),
	('Seafood Soup', 'Seafood', 'Soup', 'Soup'),

	-- Appetizers
	('Spring Roll (2)', 'Spring', 'Roll (2)', 'Appetizer'),
	('Pork Egg Roll', 'Pork Egg', 'Roll', 'Appetizer'),
	('Shrimp Egg Roll', 'Shrimp Egg', 'Roll', 'Appetizer'),
	('Boneless Spare Ribs', 'Boneless', 'Spare Ribs', 'Appetizer'),
	('Fried Dumplings (8)', 'Fried', 'Dumplings (8)', 'Appetizer'),
	('Steam Dumplings (8)', 'Steam', 'Dumplings (8)', 'Appetizer'),
	('Cheese Wontons (8)', 'Cheese', 'Wontons (8)', 'Appetizer'),
	('Fried Pork Wontons (10)', 'Fried Pork', 'Wontons (10)', 'Appetizer'),
	('Fried Scallops (8)', 'Fried', 'Scallops (8)', 'Appetizer'),
	('Fried Nuggets (8)', 'Fried', 'Nuggets (8)', 'Appetizer'),
	('Fried Onions (12)', 'Fried', 'Onions (12)', 'Appetizer'),
	('Apple Sticks (12)', 'Apple', 'Sticks (12)', 'Appetizer'),
	('Teriyaki Chicken (5)', 'Teriyaki', 'Chicken (5)', 'Appetizer'),
	('Teriyaki Beef (5)', 'Teriyaki', 'Beef (5)', 'Appetizer'),
	('Fried Shrimp (20)', 'Fried', 'Shrimp (20)', 'Appetizer'),

	-- Side Orders
	('White Rice', 'White', 'Rice', 'Side Order'),
	('Sweet & Sour Sauce', 'Sweet &', 'Sour Sauce', 'Side Order'),
	('Coral Sauce', 'Coral', 'Sauce', 'Side Order'),
	('Dumpling Sauce', 'Dumpling', 'Sauce', 'Side Order'),
	('Fried Noodles', 'Fried', 'Noodles', 'Side Order'),
	('Hot Oil', 'Hot', 'Oil', 'Side Order'),

	 -- Egg Foo Young
	('Vegetable Egg Foo Young', 'Vegetable', 'Egg Foo Young', 'Egg Foo Young'),
	('Pork Egg Foo Young', 'Pork', 'Egg Foo Young', 'Egg Foo Young'),
	('Chicken Egg Foo Young', 'Chicken', 'Egg Foo Young', 'Egg Foo Young'),
	('Beef Egg Foo Young', 'Beef', 'Egg Foo Young', 'Egg Foo Young'),
	('Shrimp Egg Foo Young', 'Shrimp', 'Egg Foo Young', 'Egg Foo Young'),

	-- Szechuan & Hunan Cuisine
	('Seafood Pan Fried Noodles', 'Seafood Pan', 'Fried Noodles', 'Szechuan & Hunan'),
	('House Pan Fried Noodles', 'House Pan', 'Fried Noodles', 'Szechuan & Hunan'),
	('Happy Family', 'Happy', 'Family', 'Szechuan & Hunan'),
	('Seafood Delight', 'Seafood', 'Delight', 'Szechuan & Hunan'),
	('Four Seasons', 'Four', 'Seasons', 'Szechuan & Hunan'),
	('Hunan Triple Delight', 'Hunan Triple', 'Delight', 'Szechuan & Hunan'),
	('Hunan Beef', 'Hunan', 'Beef', 'Szechuan & Hunan'),
	('Hunan Chicken', 'Hunan', 'Chicken', 'Szechuan & Hunan'),
	('Moo Shu Pork', 'Moo Shu', 'Pork', 'Szechuan & Hunan'),
	('Moo Shu Chicken', 'Moo Shu', 'Chicken', 'Szechuan & Hunan'),
	('Moo Shu Shrimp', 'Moo Shu', 'Shrimp', 'Szechuan & Hunan'),
	('Szechuan Chicken', 'Szechuan', 'Chicken', 'Szechuan & Hunan');

select * from menu;