package com.github.sreeharihegden.programingpracticejava;

import java.util.Arrays;

public class PriorityQueueArray {
    private int[] items;
    private int count;

    public PriorityQueueArray(int capacity){
        items = new int[capacity];
    }

    public void enqueue(int item){
        if(isFull())
            throw new IllegalStateException();

        var index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public int shiftItemsToInsert(int item){
        int index;
        for( index = count-1; index>=0; index--){
            // MaxQueue
            // if(items[index] > item){
            // MinQueue
            if(items[index] < item){
                items[index+1] = items[index];
            }
            else
                break;
        }
        return index + 1;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}