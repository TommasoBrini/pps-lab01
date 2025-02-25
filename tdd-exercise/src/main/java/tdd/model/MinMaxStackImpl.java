package tdd.model;

import tdd.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    private List<Integer> stack;

    private int min;
    private int max;

    public MinMaxStackImpl() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        stack.add(value);
    }

    private int topOfStackIndex() {
        if(this.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return this.size() - 1;
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
        return 0;
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
