public class Engine implements EngineRequirements{
    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel Engine's maximum fuel level
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    public FuelType getFuelType(){
        return this.f;
    }

    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    public Boolean go(){
        this.currentFuelLevel += -2;
        if(this.currentFuelLevel < 0){
            return false;
        }
        return true;
    }

    public String toString(){
        return ("Engine has fuel type: " + this.f + ", current fuel level: " + this.currentFuelLevel + ", max Fuel level: " + this.maxFuelLevel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 50, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
         }
        System.out.println("Out of fuel.");
    }

}