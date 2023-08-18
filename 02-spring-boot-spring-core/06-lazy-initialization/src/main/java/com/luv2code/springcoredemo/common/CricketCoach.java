package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach  implements Coach {
    public CricketCoach() {
        System.out.println("in constructor: "+getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast dowing for 15 minitues";
    }
}
