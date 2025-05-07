
public class Passenger {
    
    private String name;

    /**
     * Constructor for a passenger
     * @param name Passenger's name
     */    
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Method to add Passenger to a given car
     * Prints a successful string if boarded, otherwise indicates car is full
     * @param c Car to be boarded
     */
    public void boardCar(Car c){
        if(c.addPassenger(this)){
            System.out.println("You have baorded the car.");
        }
        else{
            System.out.println("This car is full.");
        }
    }

    /**
     * Method to remove Passenger from a given car
     * Prints a successful string if unboarded, otherwise indicates car was never boarded
     * @param c Car to deboard from
     */    
    public void getOffCar(Car c){
        if(c.removePassenger(this)){
            System.out.println("You have gotten off the car.");
        }
        else{
            System.out.println("You are not on this car.");
        }
    }
}