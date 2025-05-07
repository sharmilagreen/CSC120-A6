
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

    /**
     * Gets the fuel type of this train.
     *
     * @return The fuel type.
     */
    public FuelType getFuelType(){
        return this.f;
    }

    /**
     * Gets the maximum fuel capacity of this train.
     *
     * @return The maximum fuel level.
     */
    public double getMaxFuel(){
        return this.maxFuelLevel;
    }

    /**
     * Gets the current fuel level of this train.
     *
     * @return The current fuel level.
     */
    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }

    /**
     * Refuels the train back to the maximum fuel level
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * Removes fuel from the train as it travels
     * @return true if fuel is removed, false if the fuel level isn't compatible with going (train runs out of fuel)
     */      
    public Boolean go(){
        this.currentFuelLevel += -2;
        if(this.currentFuelLevel < 0){
            return false;
        }
        return true;
    }

    /**
     * toString of an Engine instance
     *
     * @return string that describes Engine based on fuel type, fuel level, and max fuel level
     */   
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