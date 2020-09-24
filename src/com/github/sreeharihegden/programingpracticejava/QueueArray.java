package com.github.sreeharihegden.programingpracticejava;

import java.util.Arrays;

public class QueueArray {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public QueueArray(int capacity){
        this.items = new int[capacity];
    }

    @Override
    public String toString(){
        return Arrays.toString(items); // To print Queue using SOP(queue);
    }

    public void enqueue(int data){
        if(isFull())
            throw new IllegalStateException();

        // items[rear++] = data;
        // Circular Array.
        items[rear] = data;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        var item = items[front];
        // return items[front++] = 0;
        // Circular Array.
        items[front] = 0; // Just for our visualization.
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return items[front];
    }

    public Boolean isEmpty(){
        return count == 0;
    }

    public Boolean isFull(){
        return count == items.length;
    }
}
