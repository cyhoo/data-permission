package com.cc.dp.core.key;

public interface DpKeyGenerator<K> {

    K generator(String pointValue,String fieldValue);
}
