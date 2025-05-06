import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrainTest {

    public Train t;

    @Before
    public void setup() {
        this.t = new Train(FuelType.ELECTRIC, 100, 4, 500);
    }
    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine e = new Engine(FuelType.STEAM, 20, 100);
        assertEquals(FuelType.STEAM, e.getFuelType());
        assertEquals(20, e.getCurrentFuel(), 0.001);
        assertEquals(100, e.getMaxFuel(), 0.001);
    }

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
    @Test
    public void testCarAddPassenger() {
        Car c = new Car(1);
        Passenger p = new Passenger("Alice");
        Passenger b = new Passenger("Bob");
        assertTrue(c.addPassenger(p));
        assertFalse(c.addPassenger(b));
    }

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
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car c = new Car(1);
        Passenger p = new Passenger("Dana");
        p.boardCar(c);
        assertEquals(0, c.seatsRemaining());
    }

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
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 200, 2, 100);
        assertEquals(100, train.getMaxCapacity());
        assertEquals(FuelType.ELECTRIC, train.getEngine().getFuelType());
        assertEquals(100, train.getCar(1).getCapacity() + train.getCar(0).getCapacity());
    }

    @Test
    public void testTrainPassengerCount() {
        assertEquals(500, t.getMaxCapacity());
        assertEquals(500, t.seatsRemaining());
        Car car = t.getCar(0);
        car.addPassenger(new Passenger("Greg"));
        assertEquals(499, t.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Car car = t.getCar(2);
        assertNotNull(car);
        assertEquals(125, car.getCapacity());
    }

    @Test
    public void testTrainPrintManifest() {
        Car car = t.getCar(0);
        car.addPassenger(new Passenger("Helen"));
        car.addPassenger(new Passenger("Ivy"));
        car.printManifest();
    }
    
}
