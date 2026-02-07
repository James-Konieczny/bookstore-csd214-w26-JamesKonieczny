CREATE TABLE Stationary (
    StationeryID INT PRIMARY KEY AUTO_INCREMENT,
    Brand VARCHAR(100) NOT NULL,
    Price DECIMAL(8,2) NOT NULL,
    Copies INT NOT NULL
);


CREATE TABLE BowlingBalls (
    BallID INT PRIMARY KEY AUTO_INCREMENT,
    WeightLbs INT NOT NULL,
    Color VARCHAR(50),
    Price DECIMAL(8,2) NOT NULL,
    Copies INT NOT NULL
);

-- https://www.w3schools.com/sql/sql_create_table.asp
-- https://www.w3schools.com/sql/sql_primarykey.asp
-- https://www.w3schools.com/sql/sql_datatypes.asp