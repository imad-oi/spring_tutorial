package com.luv2code.restcrud.rest;

public class StudentErrorResponse {
    private int stutus;
    private String message;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int stutus, String message, long timeStamp) {
        this.stutus = stutus;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStutus() {
        return stutus;
    }

    public void setStutus(int stutus) {
        this.stutus = stutus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestap() {
        return timeStamp;
    }

    public void setTimestap(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
