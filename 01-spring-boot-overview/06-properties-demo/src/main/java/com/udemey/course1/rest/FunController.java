package com.udemey.course1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    // inject properties for : coach.name and team.name

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    //expose new endpint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+coachName+ ", Team name: "+teamName;
    }

    // expose '/' hello world
    @GetMapping("/")
    public String sayHello() {
        return "Hello world";
    }

    // expose "/funtime" that returns hi there
    @GetMapping("/funtime")
    public String sayHi() {
        return "hi there";
    }
}
