package com.github.sreeharihegden.programingpracticejava;

import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data){
        s1.push(data);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return s2.pop();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return s2.peek();
    }

    private void moveStack1ToStack2(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }

    public Boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}