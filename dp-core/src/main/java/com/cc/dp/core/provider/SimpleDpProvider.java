package com.cc.dp.core.provider;

public class SimpleDpProvider implements DpProvider{

    private DpProvider includeProvider;
    private DpProvider excludeProvider;

    public SimpleDpProvider() {
        this.includeProvider = new AllInclude();
    }

    public void setIncludeProvider(DpProvider includeProvider) {
        this.includeProvider = includeProvider;
    }

    public void setExcludeProvider(DpProvider excludeProvider) {
        this.excludeProvider = excludeProvider;
    }

    @Override
    public boolean contain(String point) {
        if (point == null){
            throw new NullPointerException("dp point is null");
        }
        //优先exclude
        if (this.excludeProvider != null){
            if (this.excludeProvider.contain(point)){
                return false;
            }
        }
        return this.includeProvider.contain(point);
    }

    protected static class AllInclude implements DpProvider{

        @Override
        public boolean contain(String point) {
            return true;
        }
    }
}