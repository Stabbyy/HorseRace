package com.example.service;

import com.example.entity.Horses;
import com.example.repositories.HorsesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HorsesService {

    private static final int DEFAULT_HORSE_COUNT = 5;

    private final List<String> horses = new ArrayList<>();
    private final Random random = new Random();
    private final HorsesRepository horsesRepository;

    public List<Horses> findHorsesByName() {
        return horsesRepository.findAll();
    }

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

    public void addHorses() {
        for (Horses horse : findHorsesByName()) {
            horses.add(horse.getName());
        }
    }
}
