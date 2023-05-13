## Project Name & Pitch

New Garden Point of Sale System

A Java Swing GUI allowing users to place and customize food orders remotely from the menu of New Garden.

Built with Java (Netbeans) and SQL (PostgreSQL). Utilized layout managers MigLayout and CardLayout.

## Project Screen Shots

### Home Page: <img width="1440" alt="home_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/34d13047-b3e0-4436-911c-fbcd2acfe729">

### Categories Page: <img width="1438" alt="categ_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/222e4f8e-6bf4-4a7d-ac2e-d937614c8989">

### Customize Item Page: <img width="1438" alt="custom_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/da8926e2-4f6c-4ad3-9605-f671630359bb">

### Continue or Complete Order Page: <img width="1440" alt="continue_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/baa9683e-ab9e-40b1-a235-4f4300005331">

### Edit Order Page: <img width="1438" alt="edit_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/2a4e204f-5531-4585-9eed-80d000cf6e8d">

### Inactivity Timer Page: <img width="1438" alt="timer_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/cbe1a10f-58b8-4b67-8287-7153079f6602">

### Order Completed Page: <img width="1439" alt="complete_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/5c73eec2-b039-4b04-aa33-5e988fb0d46c">

### Cancel Ordering Page: <img width="1438" alt="cancel page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/738fe5fa-445b-4015-a373-fd6d00381501">

### Installation and Setup Instructions

#### Example:  

Clone down this repository. You will need `node` and `npm` installed globally on your machine.  

Installation:

`npm install`  

To Run Test Suite:  

`npm test`  

To Start Server:

`npm start`  

To Visit App:

`localhost:3000/ideas`  

## Reflection

This was a 3 month long project built during the summer of 2020 as a passion project. Project goals included using technologies learned up until this point, challenging myself to learn new libraries and tools without instruction, and solving the real-world issue of the inefficiency of taking customer orders with pen and paper.

Originally I wanted to build an application with Netbean's built-in GUI builder to create this project, allowing me to drag and drop panels into the interface. However the limitations of the builder left me dissatisfied. Even though I was past halfway designing it, I decide to research different alternatives. I was able to discover MigLayout and Cardlayout, the foundation of the project.

One of the main challenges I ran into was the size of the menu. I initially had a JLabel and JPanel for every item on the menu (over 100 items). I didn't believe an array was the right answer to store everything either. This lead me to spend a few days on a research spike into databases. I learned the basics of SQL and chose PostgreSQL because I felt it was most relevant to my goals. I was now able to store the entire menu in a database that recorded the frequency of items to assist with inventory.

At the end of the day, the technologies implemented in this project are Java and SQL. In the next iterations there are a few things I wish to improve on. I want to include an "Owner" option that allowed employees to change the menu dynamically. For example removing the option of a specific item if inventory is empty. Another is having another window for the owner that showed the inventory of all the items. Both require visiting the database in the back-end, making it clunky for the user.
