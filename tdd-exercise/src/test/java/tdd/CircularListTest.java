package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.CircularQueueImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int SIZE = 3;
    private CircularQueue circularQueue;

    @BeforeEach
    public void setup(){
        circularQueue = new CircularQueueImpl(SIZE);
    }

    @Test
    public void testEmpty(){
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void testPush() {
        circularQueue.push(1);
        assertEquals(1, circularQueue.size());
    }

}
