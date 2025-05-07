
import java.util.ArrayList;
public class Car {
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /**
     * Constructs a new train Car with the specified maximum capacity.
     *
     * @param maxCapacity The maximum number of passengers the car can hold.
     */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        passengers = new ArrayList<Passenger>(maxCapacity);
    }

    /**
     * Gets the maximum passenger capacity of this car.
     *
     * @return The maximum passenger capacity.
     */
    public int getCapacity(){
        return maxCapacity;
    }

    /**
     * Calculates the number of remaining empty seats in this car.
     *
     * @return The number of empty seats.
     */
    public int seatsRemaining(){
        return maxCapacity-passengers.size();
    }

    /**
     * Adds a passenger to this car.
     *
     * @param p The passenger to add.
     * @return true if the passenger was successfully added, false if the car is full.
     */    
    public boolean addPassenger(Passenger p){
        if(passengers.size() < maxCapacity){
            passengers.add(p);
            return true;
        }
        return false;
    }

    /**
     * Removes a passenger from the car.
     *
     * @param p The passenger to remove.
     * @return true if the passenger was successfully removed, false if the passenger was not in the car.
     */    
    public boolean removePassenger(Passenger p){
        boolean inCar = false;
        for(Passenger pass: passengers){
            if(pass == p){
                inCar = true;
                passengers.remove(pass);
            }
        }
        return inCar;
    }


    /**
     * Prints a manifest of the passengers currently in this car.
     * If the car is empty, it prints a message indicating that.
     */
    public void printManifest(){
        if(passengers.size() == 0){
            System.out.println("This car is EMPTY.");
        }
        else{
            System.out.println("Passengers on this car include:");
            for(Passenger p: passengers){
                System.out.println(p);
            }
        }
    }
}