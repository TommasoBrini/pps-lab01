package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int INITIAL_SIZE = 5;
    private static final int MIN_VALUE = 0;

    MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        minMaxStack = new MinMaxStackImpl();
        this.populate();
    }

    private void populate(){
        for(int i = MIN_VALUE; i < INITIAL_SIZE; i++){
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

    private void clearStack() {
        for (int i = 0; i < INITIAL_SIZE; i++){
            minMaxStack.pop();
        }
    }

    @Test
    public void testPopEmptyStack() {
        clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testMin(){
        assertEquals(minMaxStack.getMin(), MIN_VALUE);
        clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> minMaxStack.getMin());
    }
}