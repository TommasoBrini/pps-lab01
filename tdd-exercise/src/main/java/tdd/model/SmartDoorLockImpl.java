package tdd.model;

import tdd.SmartDoorLock;

public class SmartDoorLockImpl implements SmartDoorLock {

    private enum Status {
        LOCKED, UNLOCKED, BLOCKED
    }

    private static final int MAX_ATTEMPTS = 3;

    private int pin;
    private Status status;
    private int attempts;

    public SmartDoorLockImpl(int pin) {
        this.setPin(pin);
        this.lock();
        this.attempts = 0;
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(this.checkPin(pin)) {
            this.status = Status.UNLOCKED;
            this.attempts = 0;
        } else {
            this.attempts += 1;
            this.checkBlockDoor();
        }
    }

    @Override
    public void lock() {
        this.status = Status.LOCKED;
    }

    @Override
    public boolean isLocked() {
        return this.status == Status.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return this.status == Status.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return attempts;
    }

    @Override
    public void reset() {

    }

    private boolean checkPin(int pin){
        return this.pin == pin;
    }

    private void checkBlockDoor(){
        if (this.attempts > MAX_ATTEMPTS){
            this.status = Status.BLOCKED;
        }
    }
}
