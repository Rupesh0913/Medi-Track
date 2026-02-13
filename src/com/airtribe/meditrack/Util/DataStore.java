package com.airtribe.meditrack.Util;

import com.airtribe.meditrack.Interface.Searchable;

import java.util.*;

public class DataStore<T> {

    private final Map<String, T> store = new HashMap<>();

    public void save(String id, T entity) {
        store.put(id, entity);
    }

    public T findById(String id) {
        return store.get(id);
    }

    public Collection<T> findAll() {
        return store.values();
    }

    public boolean exists(String id) {
        return store.containsKey(id);
    }

    public List<T> search(String keyword) {
        List<T> results = new ArrayList<>();

        for (T entity : store.values()) {
            if (entity instanceof Searchable) {
                Searchable searchable = (Searchable) entity;
                if (searchable.matches(keyword)) {
                    results.add(entity);
                }
            }
        }

        return results;
    }


    public void delete(String id) {
        store.remove(id);
    }
}
