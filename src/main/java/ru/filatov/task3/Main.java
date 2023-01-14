package ru.filatov.task3;

import ru.filatov.City;
import ru.filatov.CityUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        List<City> cities = CityUtils.readFromFile();
        System.out.println(CityUtils.findMaximalPopulation(cities));
    }
}
