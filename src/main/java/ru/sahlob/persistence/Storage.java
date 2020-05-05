package ru.sahlob.persistence;

import java.util.List;

public interface Storage {
    String addCounter(String name);
    String incCounter(String name);
    String getValue(String name);
    String deleteValue(String name);
    int getSumValue();
    List<String> getCountersNames();
}
