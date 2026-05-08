# Dealership Inventory Program

## Overview

The Dealership Inventory Program is a simple Java console application that allows users to manage a vehicle dealership inventory. The program can load vehicle information from a CSV file, display vehicles based on different search filters, add new vehicles, and remove vehicles from the dealership inventory.

This project was created to practice object-oriented programming, file handling, user input, and basic inventory management in Java.

## Features

- View all vehicles in the dealership inventory
- Search vehicles by:
  - Price range
  - Make and model
  - Year range
  - Color
  - Mileage range
  - Vehicle type
- Add a new vehicle to the inventory
- Remove an existing vehicle from the inventory
- Save updated inventory information to a CSV file
- Use JUnit tests to check some dealership search functionality

## Technologies Used

- Java 17
- Maven
- JUnit Jupiter
- IntelliJ IDEA
- CSV file storage

## Project Structure

```text
workshop-4/
│
├── dealership-inventory.csv
├── pom.xml
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── plurasight/
    │               ├── Main.java
    │               ├── UserInterface.java
    │               ├── Dealership.java
    │               ├── Vehicle.java
    │               └── DealershipFileManager.java
    │
    └── test/
        └── java/
            └── com/
                └── plurasight/
                    └── DealershipTest.java