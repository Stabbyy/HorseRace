package com.example;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RaceSimulator {

    private final Random random = new Random();

    public int determineWinner(List<String> horses) {
        return random.nextInt(horses.size());
    }
}
