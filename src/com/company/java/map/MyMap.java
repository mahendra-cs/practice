package com.company.java.map;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity;
    private int size;
    private final int INITIAL_CAPACITY = 16;

    public MyMap(){
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i=0; i<capacity; i++){
            bucket.add(null);
        }
    }
    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

}
