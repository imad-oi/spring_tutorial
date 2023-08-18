package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for DI
    // @Autowired, indicates that Spring should automatically provide an instance of the Coach dependency when creating an instance of DemoController
    // this is actually what happens behind the scene:
    // Coach theCoach = new CricketCoach();
    // DemoController demoController = new DemoController(theCoach);
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyWork")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
