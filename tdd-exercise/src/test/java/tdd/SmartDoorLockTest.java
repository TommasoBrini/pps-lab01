package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN = 1234;
    private static final int WRONG_PIN = 4321;
    private static final int WRONG_ATTEMPS = 4;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    public void setup(){
        this.smartDoorLock = new SmartDoorLockImpl(PIN);
    }

    @Test
    public void testLock() {
        this.smartDoorLock.lock();
        assertTrue(this.smartDoorLock.isLocked());
    }

    @Test
    public void testUnlock(){
        this.smartDoorLock.unlock(PIN);
        assertFalse(this.smartDoorLock.isLocked());
    }

    @Test
    public void testBlockedState(){
        this.blockDoor();
        assertTrue(this.smartDoorLock.isBlocked());
    }

    private void blockDoor(){
        for (int i = 0; i < WRONG_ATTEMPS; i++) {
            this.smartDoorLock.unlock(WRONG_PIN);
        }
    }

}
