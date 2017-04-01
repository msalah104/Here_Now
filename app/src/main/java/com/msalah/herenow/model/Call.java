package com.msalah.herenow.model;

/**
 * Created by user on 3/31/17.
 */

public class Call {

    private AlarmTypes type;
    int hours;
    int min;
    boolean callStatus;

    public Call(AlarmTypes type) {
        this.type = type;
    }

    public AlarmTypes getType() {
        return type;
    }

    public void setType(AlarmTypes type) {
        this.type = type;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean isCallStatus() {
        return callStatus;
    }

    public void setCallStatus(boolean callStatus) {
        this.callStatus = callStatus;
    }
}
