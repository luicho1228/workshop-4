package com.plurasight;

import java.io.*;

public class DealershipFileManager {

    public static Dealership getDealership(){
        //loadDealership from file
        String filePath = "dealership-inventory.csv";
        Dealership dealership;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String fileDataString = bufferedReader.readLine();
            String[] fileDataArray = fileDataString.split("\\|");
            dealership = new Dealership(fileDataArray[0], fileDataArray[1],fileDataArray[2]);
            while ((fileDataString = bufferedReader.readLine()) != null){
                fileDataArray = fileDataString.split("\\|");
                int vin = Integer.parseInt(fileDataArray[0]);
                int year = Integer.parseInt(fileDataArray[1]);
                int odometer = Integer.parseInt(fileDataArray[6]);
                double price = Double.parseDouble(fileDataArray[7]);
                dealership.addVehicle(new Vehicle(vin,year,fileDataArray[2],fileDataArray[3],fileDataArray[4],fileDataArray[5],odometer,price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return dealership;
    }
    public static void saveDealership(Dealership dealership){

        //save data to files
    }
}
