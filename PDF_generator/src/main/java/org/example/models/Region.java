package org.example.models;

import java.util.List;
import java.util.Map;

public class Region {
    private final String name;
    private final List<String> cities;
    private final Map<String, List<Integer>> postCodes;

    public Region(String name, List<String> cities, Map<String, List<Integer>> postCodes) {
        this.name = name;
        this.cities = cities;
        this.postCodes = postCodes;
    }

    public String getName() {
        return name;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<Integer> getPostCodesByCity(String city) {
        return postCodes.get(city);
    }
}
