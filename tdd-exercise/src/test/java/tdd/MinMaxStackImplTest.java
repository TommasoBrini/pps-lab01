package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.model.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int INITIAL_SIZE = 5;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = INITIAL_SIZE - 1;

    private MinMaxStack minMaxStack;

    @BeforeEach
    public void setup(){
        this.minMaxStack = new MinMaxStackImpl();
        this.populate();
    }

    private void populate(){
        for(int i = MIN_VALUE; i < INITIAL_SIZE; i++){
            this.minMaxStack.push(i);
        }
    }

    @Test
    public void testEmpty() {
        assertFalse(this.minMaxStack.isEmpty());
    }

    @Test
    public void testPop() {
        assertAll(() -> assertEquals(this.minMaxStack.pop(), INITIAL_SIZE - 1), () -> assertEquals(this.minMaxStack.size(), INITIAL_SIZE - 1));
    }

    @Test
    public void testPeek() {
        assertAll(() -> assertEquals(this.minMaxStack.peek(), INITIAL_SIZE - 1), () -> assertEquals(this.minMaxStack.size(), INITIAL_SIZE));
    }

    private void clearStack() {
        for (int i = 0; i < INITIAL_SIZE; i++){
            this.minMaxStack.pop();
        }
    }

    @Test
    public void testPopEmptyStack() {
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.pop());
    }

    @Test
    public void testMin(){
        assertEquals(this.minMaxStack.getMin(), MIN_VALUE);
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.getMin());
    }

    @Test
    public void testMax(){
        assertEquals(this.minMaxStack.getMax(), MAX_VALUE);
        this.clearStack();
        assertThrowsExactly(IllegalStateException.class, () -> this.minMaxStack.getMin());
    }

    @Test
    public void testMaxAfterPop(){
        this.minMaxStack.pop();
    }
}