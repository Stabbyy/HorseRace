package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public void horsesFromDB() {
        DBHorses dbHorses = new DBHorses();
        String query = "select name from horses order by id";

        try (Statement statement = dbHorses.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String horseName = resultSet.getString("name");
                horses.add(horseName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
