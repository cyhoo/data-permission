package com.cc.dp.core;

import java.util.HashSet;
import java.util.Set;

public class SimpleDpPointDetails implements DpPointDetails{

    private String point;

    private Set<String> includes;

    private Set<String> excludes;

    public void setPoint(String point) {
        this.point = point;
    }

    public void setIncludes(Set<String> includes) {
        this.includes = includes;
    }

    public void setExcludes(Set<String> excludes) {
        this.excludes = excludes;
    }

    @Override
    public String getPoint() {
        return this.point;
    }

    @Override
    public Set<String> getFields() {
        Set<String> tmpInclude = this.includes == null ? new HashSet<>() : new HashSet<>(this.includes);
        Set<String> tmpExclude = this.excludes == null ? new HashSet<>() : new HashSet<>(this.excludes);
        tmpInclude.removeAll(tmpExclude);
        return tmpInclude;
    }
}
