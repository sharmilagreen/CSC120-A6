import java.util.ArrayList;
public class Train {

    private Engine myEngine;
    private Car[] myCars;
    private int passengerCapacity;
    private int nCars;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
        this.nCars = nCars;
        myEngine = new Engine(fuelType, 0, fuelCapacity);
        myCars = new Car[nCars];
        for(int i = 0; i <nCars; i++){
            myCars[i] = new Car((passengerCapacity/nCars));
        }
    }

    public Engine getEngine(){
        return myEngine;
    }

    public Car getCar(int i){
        return myCars[i];
    } 

    public int getMaxCapacity(){
        return this.passengerCapacity;
    }

    public int seatsRemaining(){
        int remaining = 0;
        for(int i = 0; i <nCars; i++){
            remaining += myCars[i].seatsRemaining();
        }
        return remaining;
    }

    public void printManifest(){
        ArrayList<Passenger> passengers = new ArrayList<>();
    }
}
