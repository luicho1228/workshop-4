package com.plurasight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){
        display();
    }
    public void display(){
        init();
        boolean isRunning = true;
        while (isRunning){
            //display Menu
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            switch (userInput){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
    }
    private void init(){
        this.dealership = DealershipFileManager.getDealership();

    }

    public void processGetByPriceRequest(){

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

    }
    public void processAddVehicleRequest(){

    }
    public void processRemoveVehicleRequest(){

    }
}
