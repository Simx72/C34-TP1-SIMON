package tp1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DroneTest {

    Drone d1;

    @BeforeEach
    void setUp() {
        d1 = new Drone("111", 10, 1, 5, 30);
    }

    @Test
    void energieConsomme() {
        assertEquals(30, d1.energieConsomme());
    }

    @Test
    void energieRestante() {
        assertEquals(0, d1.energieRestante());
    }

    @Test
    void pourcentageBatterieRestante() {
        assertEquals(0, d1.pourcentageBatterieRestante());
    }

    @Test
    void autonomieRestante() {
        assertEquals(0, d1.autonomieRestante());
    }

    @Test
    void calculateDistance() {
        assertEquals(150, d1.calculateDistance());
    }

    @Test
    void distancePossible() {
        assertEquals(0, d1.distancePossible());
    }
}