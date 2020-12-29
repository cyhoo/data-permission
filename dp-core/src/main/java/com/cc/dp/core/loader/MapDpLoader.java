package com.cc.dp.core.loader;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapDpLoader<K> implements DpLoader<K> {

    private Map<K,Set<String>> dpMap = new ConcurrentHashMap<>();

    public MapDpLoader() {
    }

    @Override
    public Set<String> load(K key) {
        return dpMap.getOrDefault(key, Collections.emptySet());
    }

    public void addPermission(K key,Set<String> permission){

        dpMap.put(key,permission);
    }
}
