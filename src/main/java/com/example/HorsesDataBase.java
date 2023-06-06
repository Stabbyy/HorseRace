package com.example;

import com.example.entity.Horses;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@Component
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

    public void horsesHibernate() {
        for (Horses horse : new HorsesHelper().getHorsesList()) {
            horses.add(horse.getName());
        }
    }
}
