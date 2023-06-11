## Project Name & Pitch

New Garden Point of Sale System

A Java Swing GUI allows users to place and customize food orders remotely from the menu of New Garden.

Built with Java (Netbeans) and SQL (PostgreSQL). Utilized layout managers MigLayout and CardLayout.

## Installation and Setup Instructions

Clone down this repository. You will need `VS Code` and `PostgreSQL` installed globally on your machine.  

Start your PostgreSQL server. Copy the tables from the Database directory. In DBConnection.java, change the information to your own.

Open the repository with VS Code. Run the code.

## Reflection

The project was a passion project created in the summer of 2020. The project's goals included: using previously learned technologies, challenging myself to learn new libraries and tools without instruction, and solving a real-world issue (the inefficiency of taking customer orders with pen and paper).

Originally I wanted to build an application with Netbean's built-in GUI builder to create this project, allowing me to drag and drop panels into the interface. However, the limitations of the builder left me dissatisfied. Though I was past halfway through designing it, I decided to research different alternatives. I was able to discover MigLayout and Cardlayout, the foundation of the project.

One of the main challenges I ran into was the menu size. I initially had a JLabel and JPanel for every item on the menu (over 100 items). I didn't believe an array was the correct solution to store everything, leading me to spend a few days on a research spike into databases. I learned the basics of SQL and chose PostgreSQL because I felt it was most relevant to my goals. I stored the entire menu in a database that recorded the frequency of items to assist with inventory.

Finally, the technologies implemented in this project are Java and SQL. In the following iterations, there are a few things I wish to improve on. I want to include an "Employee" clearance allowing employees to change the menu dynamically. An example would be removing the option of a specific item if the inventory is empty. Another change is having a window that displays the restaurant's ingredient inventory. Both require visiting the database in the back end, making it clunky for the user. Lastly, I would've approached building this project differently. I was manually testing every time I inserted more complexity. Now I would include a form of automated testing.

## Project Screen Shots

### Home Page: <img width="1440" alt="home_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/68f9438c-0a16-4e8e-add6-fd80a3110d7b">

### Categories Page: <img width="1438" alt="categ_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/19b4b74b-70b1-4fb9-a993-2c9772638099">

### Customize Item Page: <img width="1438" alt="custom_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/799569c8-2fe0-42b5-8cd2-ed7d8a876c97">

### Continue or Complete Order Page: <img width="1440" alt="continue_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/d26a7c49-1ee0-427f-b1be-338f4eed71bc">

### Edit Order Page: <img width="1438" alt="edit_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/5cd09192-a6e1-4343-bc48-bd6985b784d6">

### Inactivity Timer Page: <img width="1438" alt="timer_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/afe1495a-12b8-4e83-8035-2324d83517e2">

### Order Completed Page: <img width="1439" alt="complete_page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/05fd1082-bbcd-4d5a-9d46-27a8ea22beff">

### Cancel Ordering Page: <img width="1438" alt="cancel page" src="https://github.com/johnnyj2608/NewGarden/assets/54607786/1e1c8d7b-035b-4af9-8e54-67ad4f063a4f">
