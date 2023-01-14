package ru.filatov;

public class City {
    private String name;
    private String region;
    private String district;
    private Integer population;
    private String foundation;

    public City() {
    }

    public City(String name, String region, String district, Integer population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString(){
        String separator = ",";
        StringBuilder builder = new StringBuilder("City{");
        builder.append(String.format("name=%s",name));
        builder.append(separator);
        builder.append(String.format("region=%s",region));
        builder.append(separator);
        builder.append(String.format("district=%s",district));
        builder.append(separator);
        builder.append(String.format("population=%d", population));
        builder.append(separator);
        builder.append(String.format("foundation=%s", foundation));
        builder.append("}");

        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }
}
