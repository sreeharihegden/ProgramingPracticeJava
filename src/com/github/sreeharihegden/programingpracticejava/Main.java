package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();

        demoStack();

        demoStackBalancedExpression();

        demoPriorityQueueArray();
    }

    public static void demoStack(){
        System.out.println("\n************");
        System.out.println("In demoStack");
        System.out.println("************");
        Stack s = new Stack();

        s.push(50);
        s.push(60);
        s.push(70);

        s.display();

        s.pop();
        s.pop();

        s.display();
    }

    public static void demoStackBalancedExpression(){
        System.out.println("\n******************************");
        System.out.println("In demoStackBalancedExpression");
        System.out.println("******************************");

        List<String> expressionList = new ArrayList<>();
        expressionList.add("1+2)");
        expressionList.add("(1+2)");
        expressionList.add("(");
        expressionList.add(")1+2(");
        expressionList.add("((1+2)");
        expressionList.add("(1+2>");

        for(String exp : expressionList){
            System.out.println(exp + " " + StackBalancedExpression.isBalanced(exp));
        }
    }

    public static void demoPriorityQueueArray(){
        System.out.println("\n*************************");
        System.out.println("In demoPriorityQueueArray");
        System.out.println("*************************");

        PriorityQueueArray pqr = new PriorityQueueArray(3);
        pqr.enqueue(5);
        pqr.enqueue(2);
        pqr.enqueue(3);
        System.out.println(pqr);
        // pqr.enqueue(4);
        System.out.println("Removing: " + pqr.dequeue());
        System.out.println("Removing: " + pqr.dequeue());
        System.out.println("Removing: " + pqr.dequeue());
        // pqr.dequeue();
        pqr.enqueue(4);
        System.out.println(pqr);
        System.out.println("Removing: " + pqr.dequeue());
    }
}
