import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testGasTankAfterDriving() {
        Car test_car = new Car("Toyota", "Prius", 10, 50);
        test_car.drive(50);
        assertEquals(9, test_car.getGasTankLevel(), 0.001);
    }

    @Test
    public void testGasTankAfterExceedingTankRange() {
        Car test_car = new Car("Honda", "Accord", 12, 60);
        test_car.drive(70);
        assertEquals(0, test_car.getGasTankLevel(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGasOverfillException() {
        Car test_car = new Car("Ford", "Fusion", 15, 75);
        test_car.addGas(5);
        fail("Shouldn't get here, car cannot have more gas in tank than the size of the tank");
    }
}