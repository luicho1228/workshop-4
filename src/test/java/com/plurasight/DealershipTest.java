package com.plurasight;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    Dealership dealership = DealershipFileManager.getDealership();
    List<Vehicle> inventory = dealership.getAllVehicles();

    @Test
    void getVehiclesByPrice() {
        double[] expectedPrices = {1995.0,5500.0};
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(1000, 6000);
        double[] actualPrices = new double[vehicles.size()];
        int count = 0;
        for (Vehicle vehicle: vehicles){
            actualPrices[count] = vehicle.getPrice();
            count++;
        }
        assertArrayEquals(expectedPrices,actualPrices);
    }

    @Test
    void getVehicleByMakeModel(){
        String make = "Hyundai";
        String model = "Accent";
        List<Vehicle> vehiclesInMakeModel = new ArrayList<>();
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(new Vehicle(47619,2013,"Hyundai","Accent","Sedan","Gray",145900,5500.0));
        expectedList.add(new Vehicle(34911,2025,"Hyundai","Accent","Sedan","Gray",49000,47700.0));
        for(Vehicle vehicle: inventory){
            if (vehicle.getMake().equalsIgnoreCase(make)){
                if (vehicle.getModel().equalsIgnoreCase(model)){
                    vehiclesInMakeModel.add(vehicle);
                }
            }
        }assertIterableEquals(expectedList,vehiclesInMakeModel);
    }

    @Test
    void getVehicleByYear(){
        int year = 2001;
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(new Vehicle(37846,2001,"Ford","Ranger","truck","Yellow",172544,1995.0));
        expectedList.add(new Vehicle(64012,2001,"Toyota","Camry","Sedan","Red",233670,4250.0));

        List<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getYear() == year){
                vehiclesByYear.add(vehicle);
            }
        }
        assertIterableEquals(expectedList,vehiclesByYear);
    }

    @Test
    void getVehiclesByColor(){
        String color = "Red";
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(new Vehicle(10112,1993,"Ford","Explorer","SUV","Red",525123,995.0));
        expectedList.add(new Vehicle(64012,2001,"Toyota","Camry","Sedan","Red",233670,4250.0));
        List<Vehicle> vehiclesWithColor = new ArrayList<>();
        for (Vehicle vehicle:inventory){
            if (vehicle.getColor().equalsIgnoreCase(color)){
                vehiclesWithColor.add(vehicle);
            }
        }assertIterableEquals(expectedList, vehiclesWithColor);
    }

    @Test
    void getVehiclesByOdometer(){
        int min = 0;
        int max = 50000;
        List<Vehicle> expectedList = new ArrayList<>();
        expectedList.add(new Vehicle(37846,2001,"Ford","Ranger","truck","Yellow",172544,1995.0));
        expectedList.add(new Vehicle(34911,2025,"Hyundai","Accent","Sedan","Gray",49000,47700.0));
        List<Vehicle> vehiclesWithColor = new ArrayList<>();
        for (Vehicle vehicle: inventory){
            if (vehicle.getOdometer() > min && vehicle.getOdometer() < max){
                vehiclesWithColor.add(vehicle);
            }
        }assertIterableEquals(expectedList,vehiclesWithColor);
    }

}