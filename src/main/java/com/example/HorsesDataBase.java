package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HorsesDataBase {

    private static final int DEFAULT_HORSE_COUNT = 5;
    private final List<String> horses = new ArrayList<>();
    private final Random random = new Random();

    public List<String> getHorses() {
        List<String> currentHorses = new ArrayList<>();
        int pick = random.nextInt(horses.size());
        while (currentHorses.size() != DEFAULT_HORSE_COUNT) {
            currentHorses.add(horses.get(pick));
            pick = random.nextInt(horses.size());
            currentHorses = currentHorses.stream().distinct().collect(Collectors.toList());
        }
        return currentHorses;
    }

    public void horsesFromTxt() {
        File file = new File("src/main/resources/horses.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                horses.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);
        }
    }
}
