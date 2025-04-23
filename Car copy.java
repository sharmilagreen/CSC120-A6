import java.util.ArrayList;
public class Car {
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        passengers = new ArrayList<Passenger>(maxCapacity);
    }

    public int getCapacity(){
        return maxCapacity;
    }

    public int seatsRemaining(){
        return maxCapacity-passengers.size();
    }

    public boolean addPassenger(Passenger p){
        if(passengers.size() < maxCapacity){
            passengers.add(p);
            return true;
        }
        return false;
    }

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