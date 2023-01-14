package ru.filatov;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CityUtils {
    public static List<City> readFromFile(String filePath) throws IOException {
        List<City> cities = new ArrayList<>();
        Path cityPath = Paths.get(filePath);
        Scanner scanner = new Scanner(cityPath);
        scanner.useDelimiter(System.getProperty("line.separator"));

        while (scanner.hasNext()){
            City city = parseCSVLine(scanner.next());
            cities.add(city);
        }
        scanner.close();

        return cities;
    }

    public static List<City> readFromFile() throws IOException{
        return readFromFile("src/main/resources/city_ru.csv");
    }

    public static void sortByName(List<City> cities){
        cities.sort(Comparator.comparing(City::getName));
    }

    public static void sortByDistrict(List<City> cities){
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    public static String findMaximalPopulation(List<City> cities){
        City[] citiesArray = cities.stream().toArray(City[]::new);
        int maxPopulationIndex = 0;
        int maxPopulation = citiesArray[0].getPopulation();

        for (int i = 1; i < citiesArray.length; i++){
            if (citiesArray[i].getPopulation() > maxPopulation){
                maxPopulation = citiesArray[i].getPopulation();
                maxPopulationIndex = i;
            }
        }

        return String.format("[%d] = %d", maxPopulationIndex, maxPopulation);
    }

    public static Map<String, Integer> findCountByRegions(List<City> cities){
        Map<String, Integer> regions = new HashMap<>();

        for (City city : cities) {
            if (!regions.containsKey(city.getRegion())) {
                regions.put(city.getRegion(), 1);
            }
            else {
                int cityCount = regions.get(city.getRegion());
                regions.put(city.getRegion(), ++cityCount);
            }
        }
        return regions;
    }

    private static City parseCSVLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*;\\s*");
        scanner.next();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        Integer population = scanner.nextInt();
        String foundation;
        try{
            foundation = scanner.next();
        }
        catch (NoSuchElementException e){
            foundation = "none";
        }
        scanner.close();

        return new City(name, region, district, population, foundation);
    }
}
