package com.plurasight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void display() {
        init();

        int userInput = 0;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("""
                    Enter Option:
                    1.Look up vehicle
                    2.Add vehicle to dealership
                    3.remove vehicle from dealership
                    4.Exit""");

            try {
              userInput = scanner.nextInt();
              scanner.nextLine();
              switch (userInput) {
                    case 1:
                        displayVehicleLookupMenu();
                        break;
                    case 2:
                        processAddVehicleRequest();
                        break;
                    case 3:
                        processRemoveVehicleRequest();
                        break;
                    case 4:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Select from th options available!");
                        break;
              }
        } catch (InputMismatchException ime) {
                System.out.println("Error you just enter a letter, the options available are numbers please try again and enter a number option available.");
                scanner.nextLine();
            }
        }
    }

    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }

    public void displayVehicleLookupMenu(){
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    Select filter search:
                    1.Search vehicles by price
                    2.Search Vehicles by Make and Model
                    3.Search vehicles by year
                    4.Search vehicles by Color
                    5.Search vehicles by mileage
                    6.Search vehicles by vehicle type
                    7.Search all vehicles in dealership
                    8.Go Back""");

            try {
                int userInput = scanner.nextInt();
                scanner.nextLine();
                switch (userInput) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehicleRequest();
                        break;
                    case 8:
                        isRunning = false;
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error you just enter a letter, the options available are numbers please try again and enter a number option available.");
                scanner.nextLine();
            }
        }
    }

    public void processGetByPriceRequest(){
        try {
            System.out.println("Enter min price value:");
            double min = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter max price value:");
            double max = scanner.nextDouble();
            scanner.nextLine();

            displayVehicles(dealership.getVehiclesByPrice(min,max));

        } catch (InputMismatchException ime) {
            System.out.println("Try again! Enter the correct value.");
            scanner.nextLine();
        }

    }
    public void processGetByMakeModelRequest(){
        System.out.println("Enter make:");
        String make = scanner.nextLine();

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make,model));
    }
    public void processGetByYearRequest(){
        try {
            System.out.println("Enter start Year: ");
            int startYear = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter end year: ");
            int endYear = scanner.nextInt();
            scanner.nextLine();

            displayVehicles(dealership.getVehiclesByYear(startYear,endYear));

        } catch (InputMismatchException ime) {
            System.out.println("Try again! Enter the correct value.");
            scanner.nextLine();
        }

    }
    public void processGetByColorRequest(){
        System.out.println("Enter vehicle color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest(){
        try {
            System.out.println("Enter min mileage: ");
            int minMileage = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter max mileage: ");
            int maxMileage= scanner.nextInt();
            scanner.nextLine();

            displayVehicles(dealership.getVehiclesByMileage(minMileage,maxMileage));

        } catch (InputMismatchException ime) {
            System.out.println("Try again! Enter the correct value.");
            scanner.nextLine();
        }
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }
    public void processGetAllVehicleRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){
        dealership.addVehicle(getVehicleFromUser());
        DealershipFileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest(){
        dealership.removeVehicle(getVehicleFromUser());
        DealershipFileManager.saveDealership(dealership);
    }

    public Vehicle getVehicleFromUser(){
        boolean getInput = true;
        do {
            try {
                System.out.println("Enter vehicle VIN: ");
                int vin = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter vehicle year: ");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter vehicle make: ");
                String make = scanner.nextLine();

                System.out.println("Enter vehicle model: ");
                String model = scanner.nextLine();

                System.out.println("Enter vehicle type: ");
                String vehicleType = scanner.nextLine();

                System.out.println("Enter vehicle color: ");
                String color = scanner.nextLine();

                System.out.println("Enter vehicle mileage: ");
                int odometer = scanner.nextInt();

                System.out.println("Enter vehicle price: ");
                double price = scanner.nextDouble();

                getInput =false;
                return new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

            } catch (InputMismatchException ime) {
                System.out.println("Try again! Enter the correct value.");
                scanner.nextLine();}
        }while (getInput);

        return null;
    }

    private void displayVehicles(List<Vehicle> vehicles){
        System.out.println("Vin | Year | Make | Model | Vehicle Type | Color | Odometer | Price");
        for (Vehicle vehicle: vehicles){
            System.out.println("* " + vehicle.getVin()+" | " +
                   vehicle.getYear()+" | " +
                    vehicle.getMake()+" | " +
                    vehicle.getModel()+" | " +
                    vehicle.getVehicleType()+" | " +
                    vehicle.getColor()+" | " +
                    vehicle.getOdometer()+" | " +
                    vehicle.getPrice()+" | ");
        }
    }

}