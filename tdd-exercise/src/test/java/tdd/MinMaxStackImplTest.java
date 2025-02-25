package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int INITIAL_SIZE = 5;

    MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        minMaxStack = new MinMaxStackImpl();
        this.populate();
    }

    private void populate(){
        for(int i = 0; i < INITIAL_SIZE; i++){
            minMaxStack.push(i);
        }
    }

    @Test
    public void testEmpty() {
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testPop() {
        assertAll(() -> assertEquals(minMaxStack.pop(), INITIAL_SIZE - 1), () -> assertEquals(minMaxStack.size(), INITIAL_SIZE - 1));
    }

    @Test
    public void testPeek() {
        assertAll(() -> assertEquals(minMaxStack.peek(), INITIAL_SIZE - 1), () -> assertEquals(minMaxStack.size(), INITIAL_SIZE));
    }
}