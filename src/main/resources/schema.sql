CREATE TABLE Stationery (
    StationeryID INT PRIMARY KEY AUTO_INCREMENT,
    Brand VARCHAR(100) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    Color VARCHAR(50),
    PageCount INT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE bowling_balls (
    BallID INT PRIMARY KEY AUTO_INCREMENT,
    Brand VARCHAR(100) NOT NULL,
    Color VARCHAR(50),
    WeightLbs DECIMAL(4,1) NOT NULL,
    Core VARCHAR(100),
    Coverstock VARCHAR(100)
);

-- https://www.w3schools.com/sql/sql_create_table.asp
-- https://www.w3schools.com/sql/sql_primarykey.asp
-- https://www.w3schools.com/sql/sql_datatypes.asp