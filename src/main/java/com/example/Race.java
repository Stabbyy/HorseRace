package com.example;

import java.util.List;
import java.util.Scanner;

public class Race {

    private static final int FIRST_CHOICE_HORSE = 1;
    private static final int LAST_CHOICE_HORSE = 5;

    public void run() {
        RaceSimulator raceSimulator = new RaceSimulator();
        HorsesDataBase horses = new HorsesDataBase();

        horses.horsesFromTxt();

        List<String> raceHorses = horses.getHorses();

        printHorses(raceHorses);

        int chosenHorse = pickWinner();
        int winner = raceSimulator.determineWinner(raceHorses);
        printResult(raceHorses, chosenHorse, winner);
    }

    private void printResult(List<String> raceHorses, int chosenHorse, int winner) {

        String winnerName = raceHorses.get(winner);
        String messageForUser = winner == chosenHorse ? "Congratulations!" : "Better luck next time.";

        System.out.printf("And the winner is %s! %s%n", winnerName, messageForUser);
    }

    public void printHorses(List<String> horseList) {
        System.out.println("Current competitors:");
        int count = 1;
        for (String horseName : horseList) {
            System.out.println(count + ". " + horseName);
            count++;
        }
    }

    public int pickWinner() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Your winner is?");
        int pick = scan.nextInt();
        while (pick < FIRST_CHOICE_HORSE || pick > LAST_CHOICE_HORSE) {
            System.out.println("Wrong number! Choose another one.");
            pick = scan.nextInt();
        }
        return pick - 1;
    }
}