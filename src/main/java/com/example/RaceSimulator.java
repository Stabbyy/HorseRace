package com.example;

import java.util.List;
import java.util.Random;

public class RaceSimulator {

    private final Random random = new Random();

    public int determineWinner(List<String> horses) {
        return random.nextInt(horses.size());
    }
}
