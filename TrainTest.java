import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrainTest {

    public Train t;

    /**
     * Set up a standard Train object used later
     */
    @Before
    public void setup() {
        this.t = new Train(FuelType.ELECTRIC, 100, 4, 500);
    }

    //Engine tests

    /**
     * Tests  the Engine constructor properly initializes
     */
    @Test
    public void testEngineConstructor() {
        Engine e = new Engine(FuelType.STEAM, 20, 100);
        assertEquals(FuelType.STEAM, e.getFuelType());
        assertEquals(20, e.getCurrentFuel(), 0.001);
        assertEquals(100, e.getMaxFuel(), 0.001);
    }

    /**
     * Tests the Engine.go() method for fuel usage
     */    
    @Test
    public void testEngineGo() {
        Engine e = new Engine(FuelType.ELECTRIC, 4, 100);
        assertTrue(e.go());
        assertEquals(2, e.getCurrentFuel(), 0.001);
        assertTrue(e.go());
        assertEquals(0, e.getCurrentFuel(), 0.001);
        assertFalse(e.go());
    }

    // Car Tests

    /**
     * Tests adding a passenger to a car with space and error message when full.
     */    
    @Test
    public void testCarAddPassenger() {
        Car c = new Car(1);
        Passenger p = new Passenger("Alice");
        Passenger b = new Passenger("Bob");
        assertTrue(c.addPassenger(p));
        assertFalse(c.addPassenger(b));
    }

    /**
     * Tests removing a passenger who exists and failing for one who hasn't boarded the car
     */
    @Test
    public void testCarRemovePassenger() {
         Car c = new Car(2);
        Passenger p = new Passenger("Charlie");
        Passenger f = new Passenger("FakePassenger");
        c.addPassenger(p);
        assertTrue(c.removePassenger(p));
        assertFalse(c.removePassenger(f));
    }

    // Passenger Tests

    /**
     * Tests boarding a car that isn't full
     */    
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car c = new Car(2);
        Passenger p = new Passenger("Dana");
        p.boardCar(c);
        assertEquals(1, c.seatsRemaining());
    }

    /**
     * Tests boarding a full car
     */
    @Test
    public void testPassengerBoardCarFull() {
        Car c = new Car(1);
        Passenger p1 = new Passenger("Ed");
        Passenger p2 = new Passenger("Fay");
        p1.boardCar(c);
        p2.boardCar(c);
        assertEquals(0, c.seatsRemaining());
    }

    // Train Tests

    /**
     * Tests that the Train constructor sets up engine and cars
     */    
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 200, 2, 100);
        assertEquals(100, train.getMaxCapacity());
        assertEquals(FuelType.ELECTRIC, train.getEngine().getFuelType());
        assertEquals(100, train.getCar(1).getCapacity() + train.getCar(0).getCapacity());
    }

    /**
     * Tests the Train.seatsRemaining() method after boarding a passenger.
     */
    @Test
    public void testTrainPassengerCount() {
        assertEquals(500, t.getMaxCapacity());
        assertEquals(500, t.seatsRemaining());
        Car car = t.getCar(0);
        car.addPassenger(new Passenger("Greg"));
        assertEquals(499, t.seatsRemaining());
    }

    /**
     * Tests retrieving a car from Train by index.
     */
    @Test
    public void testTrainGetCar() {
        Car car = t.getCar(2);
        assertNotNull(car);
        assertEquals(125, car.getCapacity());
    }

    /**
     * Calls printManifest()
     */    
    @Test
    public void testTrainPrintManifest() {
        Car car = t.getCar(0);
        car.addPassenger(new Passenger("Helen"));
        car.addPassenger(new Passenger("Ivy"));
        car.printManifest();
    }
    
}
