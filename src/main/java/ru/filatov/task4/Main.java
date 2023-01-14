package ru.filatov.task4;

import ru.filatov.City;
import ru.filatov.CityUtils;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        List<City> cities = CityUtils.readFromFile();
        Map<String, Integer> regions = CityUtils.findCountByRegions(cities);
        regions.forEach((region, count) -> System.out.printf("%s - %d\n", region, count));
    }
}
