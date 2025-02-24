package tdd.model;

import tdd.SmartDoorLock;

public class SmartDoorLockImpl implements SmartDoorLock {

    private enum Status {
        LOCKED, UNLOCKED, BLOCKED
    }

    private int pin;
    private Status status;

    public SmartDoorLockImpl(int pin) {
        this.setPin(pin);
        this.lock();
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(this.checkPin(pin)) {
            this.status = Status.UNLOCKED;
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
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }

    private boolean checkPin(int pin){
        return this.pin == pin;
    }
}
