package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        minMaxStack = new MinMaxStackImpl();
        this.populate();
    }

    private void populate(){
        minMaxStack.push(1);
        minMaxStack.push(2);
        minMaxStack.push(3);
    }

    @Test
    public void testEmpty() {
        assertFalse(minMaxStack.isEmpty());
    }
}