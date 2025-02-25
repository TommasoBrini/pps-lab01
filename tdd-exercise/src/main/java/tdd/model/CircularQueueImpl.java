package tdd.model;

import tdd.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final List<Integer> queue;
    private final int maxSize;

    public CircularQueueImpl(int size) {
        this.maxSize = size;
        this.queue = new ArrayList<>();
    }


    @Override
    public void push(int value) {
        queue.add(value);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
