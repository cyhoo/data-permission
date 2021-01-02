package com.cc.dp.core;

import java.util.Collections;
import java.util.Set;

public abstract class AbsDpAuthentication implements DpAuthentication{

    private Set<String> fields;

    public AbsDpAuthentication(Set<String> fields) {
        if (fields == null || fields.isEmpty()){
            this.fields = Collections.emptySet();
        }else {
            this.fields = fields;
        }
    }

    @Override
    public Set<String> getFields() {
        return fields;
    }

    @Override
    public boolean include(String field) {
        return this.fields.contains(field);
    }
}
