package de.lotto24.slotmachine.controller;

import de.lotto24.slotmachine.OptionNotFoundException;
import de.lotto24.slotmachine.controller.api.Option;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Storage {

    private Map<String, Option> storage = new HashMap<>();

    public Storage() {
        put(new Option("teamb", Arrays.asList("svoge", "skows")));
        put(new Option("numbers", Arrays.asList("1", "2")));
    }

    public Collection<Option> getAll() {
        return storage.values();
    }

    public Option remove(String optionName) {
        return Optional.ofNullable(storage.remove(optionName)).orElseThrow(() -> new OptionNotFoundException(optionName));
    }

    public void put(Option option) {
        storage.put(option.getOptionName(), option);
    }

    public Option get(String optionName) {
        return Optional.ofNullable(storage.get(optionName)).orElseThrow(() -> new OptionNotFoundException(optionName));
    }
}
