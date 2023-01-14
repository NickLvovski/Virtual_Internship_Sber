package ru.filatov.task1;

import ru.filatov.City;
import ru.filatov.CityUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        List<City> cityList = CityUtils.readFromFile();
        cityList.forEach(city -> System.out.println(city));
    }


}
