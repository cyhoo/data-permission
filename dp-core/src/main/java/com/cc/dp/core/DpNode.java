package com.cc.dp.core;

import java.util.HashSet;
import java.util.Set;

public class DpNode {

    private String node;
    private Set<String> fields;


    public DpNode(String node, Set<String> fields) {
        this.node = node;
        this.fields = fields;
    }

    public void addInclude(String field){
        checkNode();
        if (this.fields == null){
           this.fields = new HashSet<>();
        }
        this.fields.add(field);
    }

    public boolean isContain(String node,String field) {
        checkNode();
        if (!this.node.equals(node)){
            return false;
        }
        return this.fields.contains(field);
    }

    protected void checkNode(){
        if (this.node == null || this.node.length() == 0){
            throw new DpNodeException("DpNode is not blank");
        }
    }
}
