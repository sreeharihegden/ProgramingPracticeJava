package com.github.sreeharihegden.programingpracticejava;

public class Queue {
    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            return "Node: " + data;
        }
    }

    private Node front, rear;
    Queue(){
        this.front = this.rear = null;
    }

    public void enqueue(int data){
        Node temp = new Node(data);

        if(isEmpty()){
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    public Boolean isEmpty(){
        // return(this.front == null && this.rear == null);
        return this.front == null;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        Node temp = this.front;
        this.front = this.front.next;
        if(isEmpty())
            this.rear = null;
        return temp.data;
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return this.front.data;
    }
}
