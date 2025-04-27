public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public void boardCar(Car c){
        if(c.addPassenger(this)){
            System.out.println("You have baorded the car.");
        }
        else{
            System.out.println("This car is full.");
        }
    }

    public void getOffCar(Car c){
        if(c.removePassenger(this)){
            System.out.println("You have gotten off the car.");
        }
        else{
            System.out.println("You are not on this car.");
        }
    }
}