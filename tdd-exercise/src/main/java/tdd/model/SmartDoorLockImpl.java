package tdd.model;

import tdd.SmartDoorLock;


public class SmartDoorLockImpl implements SmartDoorLock {

    private enum Status {
        LOCKED, UNLOCKED, BLOCKED
    }

    private static final int MAX_ATTEMPTS = 3;
    private static final int DEFAULT_PIN = 0;
    private static final int INITIAL_ATTEMPTS = 0;

    private int pin;
    private Status status;
    private int attempts;

    public SmartDoorLockImpl() {
        this.reset();
    }

    @Override
    public void setPin(int pin) {
        if(!this.isBlocked() && !this.isLocked()){
            this.pin = pin;
        } else {
            throw new IllegalStateException("System is not open");
        }
    }

    @Override
    public void unlock(int pin) {
        if(!this.isBlocked()){
            if(this.checkPin(pin)) {
                this.attempts = INITIAL_ATTEMPTS;
                this.status = Status.UNLOCKED;
            } else {
                this.fail();
            }
        }
    }

    @Override
    public void lock() {
        if(!this.isBlocked()){
            if(pin != DEFAULT_PIN){
                this.status = Status.LOCKED;
            } else {
                throw new IllegalStateException("Pin is not set");
            }
        }
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
        this.attempts = INITIAL_ATTEMPTS;
        this.status = Status.UNLOCKED;
        this.pin = DEFAULT_PIN;
    }

    private boolean checkPin(int pin){
        return this.pin == pin;
    }

    private void fail(){
        attempts += 1;
        if (this.attempts > MAX_ATTEMPTS){
            this.status = Status.BLOCKED;
        }
    }
}
