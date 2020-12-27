package com.cc.dp.core.loader;

import java.util.Set;

public interface DpLoader<K>{

    Set<String> load(K key);
}
