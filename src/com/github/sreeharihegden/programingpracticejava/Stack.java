package com.github.sreeharihegden.programingpracticejava;

public class Stack {

    private class Node{
        private int data;
        private Node next;
    }

    // private int size = 0;

    // public Node top = null;
    public Node top;
    Stack(){
        this.top = null;
    }

    public void push(int data){
        Node n = new Node();
        n.data = data;
        n.next = top;
        top = n;
        // size++;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public int pop(){
        //if(!(top == null)){
        if(!this.isEmpty()){
            Node temp = top;
            // int data = top.data;
            top = top.next;
            // size--;
            return temp.data;
            // return data;
        }
        return -1;
    }

    public void display(){
        if(!(top == null)){
            // int count = size;
            Node temp = top;
            while(temp != null){
                System.out.printf("%d->", temp.data);
                temp = temp.next;
                // count--;
            }
            System.out.println();
        }
    }
}
