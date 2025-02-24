package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    @BeforeEach
    public void setup(){
        SmartDoorLock smartDoorLock = new SmartDoorLockImpl(int pin);
    }

    @Test
    public void todo() {
        assertTrue(true);
    }

}
