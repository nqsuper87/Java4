-- Create Users table
CREATE TABLE Users (
    Id INT PRIMARY KEY,
    Password VARCHAR(50),
    Fullname VARCHAR(100),
    Email VARCHAR(100),
    Admin BIT
);

-- Insert sample records into Users table
INSERT INTO Users (Id, Password, Fullname, Email, Admin)
VALUES
    (1, 'password1', 'John Doe', 'john@example.com', 1),
    (2, 'password2', 'Alice Smith', 'alice@example.com', 0),
    (3, 'password3', 'Bob Johnson', 'bob@example.com', 0),
    (4, 'password4', 'Emma Brown', 'emma@example.com', 0),
    (5, 'password5', 'Michael Lee', 'michael@example.com', 1),
    (6, 'password6', 'Sophia Garcia', 'sophia@example.com', 0),
    (7, 'password7', 'William Martinez', 'william@example.com', 0),
    (8, 'password8', 'Olivia Lopez', 'olivia@example.com', 1),
    (9, 'password9', 'James Wilson', 'james@example.com', 0),
    (10, 'password10', 'Charlotte Taylor', 'charlotte@example.com', 0);

-- Create Video table
CREATE TABLE Video (
    Id INT PRIMARY KEY,
    Title VARCHAR(255),
    Poster VARCHAR(255),
    Description TEXT,
    Active BIT,
    Views INT
);

-- Insert sample records into Video table
INSERT INTO Video (Id, Title, Poster, Description, Active, Views)
VALUES
    (1, 'Introduction to SQL', 'sql_intro.jpg', 'A beginner''s guide to SQL programming.', 1, 1000),
    (2, 'Advanced SQL Techniques', 'advanced_sql.jpg', 'Explore advanced SQL queries and optimizations.', 1, 500),
    (3, 'Data Modeling Basics', 'data_modeling.jpg', 'Understanding the fundamentals of data modeling.', 0, 300),
    (4, 'Database Administration Essentials', 'db_administration.jpg', 'Key concepts and practices for database administrators.', 1, 800),
    (5, 'SQL Injection Prevention', 'sql_injection.jpg', 'Protecting your applications from SQL injection attacks.', 1, 1200),
    (6, 'NoSQL Databases Overview', 'nosql_overview.jpg', 'An introduction to NoSQL databases and their advantages.', 1, 700),
    (7, 'Big Data Analytics Techniques', 'big_data_analytics.jpg', 'Techniques for analyzing large volumes of data.', 0, 400),
    (8, 'Data Warehousing Fundamentals', 'data_warehousing.jpg', 'Understanding the basics of data warehousing.', 1, 600),
    (9, 'Introduction to MongoDB', 'mongodb_intro.jpg', 'Getting started with MongoDB, a popular NoSQL database.', 1, 900),
    (10, 'SQL Best Practices', 'sql_best_practices.jpg', 'Best practices for writing efficient and secure SQL code.', 1, 1500);

-- Create Favorites table
CREATE TABLE Favorites (
    Id INT PRIMARY KEY,
    VideoId INT,
    UserId INT,
    LikeDate DATETIME,
    FOREIGN KEY (VideoId) REFERENCES Video(Id),
    FOREIGN KEY (UserId) REFERENCES Users(Id)
);

-- Insert sample records into Favorites table
INSERT INTO Favorites (Id, VideoId, UserId, LikeDate)
VALUES
    (1, 1, 2, '2024-03-15 08:30:00'),
    (2, 3, 4, '2024-03-16 10:45:00'),
    (3, 5, 6, '2024-03-17 12:20:00'),
    (4, 7, 8, '2024-03-18 14:55:00'),
    (5, 9, 10, '2024-03-19 16:40:00'),
    (6, 2, 3, '2024-03-20 18:25:00'),
    (7, 4, 5, '2024-03-21 20:10:00'),
    (8, 6, 7, '2024-03-22 22:00:00'),
    (9, 8, 9, '2024-03-23 23:50:00'),
    (10, 10, 1, '2024-03-24 01:30:00');
