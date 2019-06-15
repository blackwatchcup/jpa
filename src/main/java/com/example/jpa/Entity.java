package com.example.jpa;

import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Entity {
    private List<String> city;
    private Map<String, Integer> stringIntegerMap;
    private Set<String> excelString;

    public Entity() {
    }

    public List<String> getCity() {
        return city;
    }

    public Set<String> getExcelString() {
        return excelString;
    }

    public void setExcelString(Set<String> excelString) {
        this.excelString = excelString;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public Map<String, Integer> getStringIntegerMap() {
        return stringIntegerMap;
    }

    public void setStringIntegerMap(Map<String, Integer> stringIntegerMap) {
        this.stringIntegerMap = stringIntegerMap;
    }
}
