package com.cc.dp.core;

import com.cc.dp.core.loader.DpLoader;

import java.util.Set;

public abstract class AbsDpMatcher<K> implements DpMatcher{

    private DpLoader<K> dpLoader;

    public AbsDpMatcher(DpLoader<K> dpLoader) {
        this.dpLoader = dpLoader;
    }

    @Override
    public boolean match(String node, String field) {
        Set<String> fields = this.dpLoader.load(loadKey(node));
        DpNode dpNode = new DpNode(node,fields);
        return dpNode.isContain(node,field);
    }

    protected abstract K loadKey(String node);
}
