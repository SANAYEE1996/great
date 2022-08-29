package com.best.great.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping("/wordle")
    public String wordle(){
        return "game/wordle";
    }

    @GetMapping("/dinosaur")
    public String dinosaur(){
        return "game/dinosaur";
    }
}
