import java.util.ArrayList;
public class Train {

    private Engine myEngine;
    private Car[] myCars;
    private int passengerCapacity;
    private int nCars;

    /**
     * Constructor for Train
     * @param fuelType Engine's fuel type
     * @param fuelCapacity Engine's maximum fuel level
     * @param nCars the number of cars the train has
     * @param passengerCapacity the maximum capacity the train has (which is spread evenly across the cars)
     * passengerCapacity and nCars are intiialized, as well as an engine and arraylist of cars for the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
        this.nCars = nCars;
        myEngine = new Engine(fuelType, 0, fuelCapacity);
        myCars = new Car[nCars];
        for(int i = 0; i <nCars; i++){
            myCars[i] = new Car((passengerCapacity/nCars));
        }
    }

    /**
     * Gets the Engine of this train.
     * @return The Engine
     */
    public Engine getEngine(){
        return myEngine;
    }

    /**
     * Gets one car from the stored arraylist of the train's cars, myCars
     * @param i the integer corresponding to the car in the arraylist myCars
     * @return the car corresponding to the int i
     */
    public Car getCar(int i){
        return myCars[i];
    } 

    /**
     * Gets the maximum capacity of the train
     * @return the maximum capacity of train
     */    
    public int getMaxCapacity(){
        return this.passengerCapacity;
    }

    /**
     * Calculates the seats remaining 
     * @return the amount of seats remaining based on the seats remaining in each car
     */
    public int seatsRemaining(){
        int remaining = 0;
        for(int i = 0; i <nCars; i++){
            remaining += myCars[i].seatsRemaining();
        }
        return remaining;
    }
    /**
     * Prints out the train's manifest, iterating through each car and printing its manifest
     */
    public void printManifest() {
        System.out.println("----- Train Manifest -----");
        if (myCars.length == 0) {
            System.out.println("This train has no cars.");
            return;
        }
        for (int i = 0; i < myCars.length; i++) {
            System.out.println("\n--- Car " + (i + 1) + " ---");
            myCars[i].printManifest();
        }
    }
}
