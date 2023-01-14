package ru.filatov.task2;

import ru.filatov.City;
import ru.filatov.CityUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = null;
        try {
            cities = CityUtils.readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CityUtils.sortByDistrict(cities);
        System.out.println("Sorted by district:");
        cities.forEach(city -> System.out.println(city));
        CityUtils.sortByName(cities);
        System.out.println("\nSorted by name:");
        cities.forEach(city -> System.out.println(city));
    }
}
