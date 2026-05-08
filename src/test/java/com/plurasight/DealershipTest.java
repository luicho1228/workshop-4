package com.plurasight;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @org.junit.jupiter.api.Test
    void getVehiclesByPrice() {
       // Dealership dealership =new Dealership();
        Dealership dealership = DealershipFileManager.getDealership();
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
}