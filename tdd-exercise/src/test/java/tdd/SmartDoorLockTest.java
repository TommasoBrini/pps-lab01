package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN = 1234;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    public void setup(){
        smartDoorLock = new SmartDoorLockImpl(PIN);
    }

    @Test
    public void testLock() {
        this.smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlock(){
        this.smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

}
