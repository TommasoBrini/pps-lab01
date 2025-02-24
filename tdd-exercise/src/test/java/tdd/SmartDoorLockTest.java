package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int PIN = 1234;

    @BeforeEach
    public void setup(){
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl(PIN);
    }

    @Test
    public void todo() {
        assertTrue(true);
    }

}
