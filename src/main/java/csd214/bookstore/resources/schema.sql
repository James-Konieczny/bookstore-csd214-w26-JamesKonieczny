CREATE TABLE Stationery (
    ProductID VARCHAR(50) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Brand VARCHAR(100)
);

CREATE TABLE BowlingBalls (
    ProductID VARCHAR(50) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Brand VARCHAR(100),
    MaintenanceRequired BOOLEAN NOT NULL,
    SkillLevel VARCHAR(50),
    Weight INT NOT NULL CHECK (Weight BETWEEN 6 AND 16),
    Color VARCHAR(50),
    Coverstock VARCHAR(50),
    Core VARCHAR(50)
);