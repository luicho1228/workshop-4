package com.plurasight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    public UserInterface(){
        scanner = new Scanner(System.in);
        display();
    }
    public void display(){
        init();
        boolean isRunning = true;
        while (isRunning){
            //display Menu
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput){
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
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
            }
        }
    }
    private void init(){
        this.dealership = DealershipFileManager.getDealership();
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

    }
    public void processRemoveVehicleRequest(){

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
