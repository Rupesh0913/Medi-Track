package com.airtribe.meditrack.Util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public void delete(String id) {
        store.remove(id);
    }
}
