package ru.sahlob.persistence.memory;

import org.springframework.stereotype.Component;
import ru.sahlob.persistence.Storage;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class MemoryStorage implements Storage {

    private final ConcurrentHashMap<String, Integer> counters = new ConcurrentHashMap<>();

    @Override
    public String addCounter(String name) {
        return counters.putIfAbsent(name, 0) == null ? "Counter added" : "Counter already exist";
    }

    @Override
    public String incCounter(String name) {
        var answer = counters.computeIfPresent(name, (x, value) -> value + 1);
        return answer == null ? "Counter not exist" : "Value is: " + answer;
    }

    @Override
    public String getValue(String name) {
        var result = counters.get(name);
        return result == null ? "Counter not exist" : String.valueOf(result);
    }

    @Override
    public String deleteValue(String name) {
        var result = counters.remove(name);
        return result == null ? "Counter not exist" : String.valueOf(result);
    }

    @Override
    public int getSumValue() {
        return counters.values().stream().mapToInt(x -> x).sum();
    }

    @Override
    public List<String> getCountersNames() {
        return Collections.list(counters.keys());
    }
}
