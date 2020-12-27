package com.cc.dp.core.adapter;

import com.cc.dp.core.key.DpKeyGenerator;
import com.cc.dp.core.DpMatchEnums;
import com.cc.dp.core.loader.DpLoader;

import java.util.Set;

public class DpAdapter<K> {

    private DpMatchEnums dpMatchEnums;
    private DpLoader<K> includeLoader;
    private DpLoader<K> excludeLoader;

    public DpAdapter(DpMatchEnums dpMatchEnums, DpLoader<K> includeLoader, DpLoader<K> excludeLoader) {
        this.dpMatchEnums = dpMatchEnums;
        this.includeLoader = includeLoader;
        this.excludeLoader = excludeLoader;
    }

    public boolean isInclude(K key, String permission){
        if (dpMatchEnums == null){
            return true;
        }
        Set<String> excludes = null;
        Set<String> includes = null;
        if (dpMatchEnums == DpMatchEnums.EXCLUDE){
            excludes = excludeLoader.load(key);
            return !excludes.contains(permission);
        }
        if (dpMatchEnums == DpMatchEnums.INCLUDE){
            includes = includeLoader.load(key);
            return includes.contains(permission);
        }
        if (dpMatchEnums == DpMatchEnums.ALL){
            excludes = excludeLoader.load(key);
            includes = includeLoader.load(key);
            if (includes == null || includes.isEmpty()){
                return false;
            }
            if (excludes == null || excludes.isEmpty()){
                return includes.contains(permission);
            }
            Set<String> diff = includes;
            diff.removeAll(excludes);
            return diff.contains(permission);
        }
        return false;
    }
}
