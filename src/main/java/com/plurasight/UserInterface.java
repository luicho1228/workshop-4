package com.plurasight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner;
    public UserInterface(){
        scanner = new Scanner(System.in);
    }
    public void display(){
        init();
        boolean isRunning = true;
        while (isRunning){
            System.out.println("Enter Option:"+"\n1.Look up vehicle"+"\n2.Add vehicle to dealership"+"\n3.remove vehicle from dealership" + "\n4.Exit");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput){
                case 1:
                    lookUpVehicleDisplay();
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
            }
        }
    }

    private void init(){
        this.dealership = DealershipFileManager.getDealership();
    }

    public void lookUpVehicleDisplay(){
        System.out.println("Select filter search: " +
                "\n1.Search vehicles by price " +
                "\n2.Search Vehicles by Make and Model " +
                "\n3.Search vehicles by year " +
                "\n4.Search vehicles by Color " +
                "\n5.Search vehicles by mileage " +
                "\n6.Search vehicles by vehicle type " +
                "\n7.Search all vehicles in dealership " +
                "\n8.Go Back");
        boolean isRunning = true;
        while (isRunning) {
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
        }
    }

    public void processGetByPriceRequest(){
        System.out.println("Enter min price value:");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter max price value:");
        double max = scanner.nextDouble();
        scanner.nextLine();
        displayVehicles(dealership.getVehiclesByPrice(min,max));
    }
    public void processGetByMakeModelRequest(){
        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make,model));

    }
    public void processGetByYearRequest(){

    }
    public void processGetByColorRequest(){

    }
    public void processGetByMileageRequest(){

    }
    public void processGetByVehicleTypeRequest(){

    }
    public void processGetAllVehicleRequest(){
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest(){
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
        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
        DealershipFileManager.saveDealership(dealership);

    }
    public void processRemoveVehicleRequest(){
        //remove vehicle from dealership
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
