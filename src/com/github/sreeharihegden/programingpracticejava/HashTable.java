package com.github.sreeharihegden.programingpracticejava;

import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        var index = hash(key);
        if(entries[index] == null){
            entries[index] = new LinkedList<>();
        }

        // entries[index].addLast(entry);
        for(var entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        var entry = new Entry(key, value);
        entries[index].addLast(entry);
    }

    private int hash(int key){
        // key = Math.abs(key);
        return key % entries.length;
    }

    public String get(int key){
        var index = hash(key);
        // if(!(entries[index] == null)){
        if(entries[index] != null){
            for(var entry: entries[index]){
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(int key){
        var index = hash(key);
        if(entries[index] != null){
            for(var entry : entries[index]){
                if(entry.key == key){
                    entries[index].remove(entry);
                    return;
                }
            }
        }

        throw new IllegalStateException();
    }
}
