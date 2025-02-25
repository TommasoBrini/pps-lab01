package tdd.model;

import tdd.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private static final int MAX_VALUE = -9999;
    private static final int MIN_VALUE = 9999;

    private final List<Integer> stack;

    private int min;
    private int max;

    public MinMaxStackImpl() {
        this.stack = new ArrayList<>();
        this.min = MIN_VALUE;
    }

    @Override
    public void push(int value) {
        this.checkMin(value);
        this.stack.add(value);
    }

    private void checkMin(int value){
        if (value < this.min) {
            this.min = value;
        }
    }

    private int topOfStackIndex() {
        checkNotEmpty();
        return this.size() - 1;
    }

    private void checkNotEmpty(){
        if(this.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
    }

    @Override
    public int pop() {
        int value = this.stack.remove(topOfStackIndex());
        return value;
    }

    @Override
    public int peek() {
        return this.stack.get(topOfStackIndex());
    }

    @Override
    public int getMin() {
        checkNotEmpty();
        return min;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
