package ru.sahlob.rest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sahlob.persistence.Storage;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final Storage storage;

    /**
     * Adds a new counter if there is no such counter with this name.
     * @param counterName name of the tag to be created.
     * @return result of adding a counter.
     */
    @PostMapping("/addCounter")
    public @ResponseBody String addCounter(@RequestParam(name = "name") String counterName) {
        return storage.addCounter(counterName);
    }

    /**
     * Increases the counter value by one, if there is one.
     * @param counterName name of the tag to be incremented.
     * @return result of incremented counter.
     */
    @PostMapping("/incCounter")
    public @ResponseBody String incCounter(@RequestParam(name = "name") String counterName) {
        return storage.incCounter(counterName);
    }

    /**
     * Returns the value of the counter, if there is one
     * @param counterName Name of the counter whose value should be returned.
     * @return value of counter if it exists.
     */
    @GetMapping("/getValue")
    public @ResponseBody String getValue(@RequestParam(name = "name") String counterName) {
        return storage.getValue(counterName);
    }

    /**
     * Delete the value if the counter exists.
     * @param counterName Name of the counter whose value should be deleted.
     * @return delete counter if it exists.
     */
    @DeleteMapping("/delete")
    public @ResponseBody String deleteCounter(@RequestParam(name = "name") String counterName) {
        return storage.deleteValue(counterName);
    }

    /**
     * @return the sum of all counters.
     */
    @GetMapping("/getAllValues")
    public @ResponseBody int getSumValues() {
        return storage.getSumValue();
    }

    /**
     * @return all names of oll counters.
     */
    @GetMapping("/getCountersNames")
    public @ResponseBody List<String> getCountersNames() {
        return storage.getCountersNames();
    }

}
