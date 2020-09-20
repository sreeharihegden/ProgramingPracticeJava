package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();

        demoStack();

        demoStackBalancedExpression();

        demoPriorityQueueArray();

        demoHashTable();
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

    public static void demoHashTable(){
        System.out.println("\n****************");
        System.out.println("In demoHashTable");
        System.out.println("****************");

        HashTable ht = new HashTable();
        ht.put(6, "Sam"); // 1
        ht.put(8, "Jon"); // 3
        ht.put(11, "First"); // 3
        ht.put(5, "Last"); // 0
        ht.put(3, "Mid"); // 2
        ht.put(6, "Out"); // 1
        // ht.put(9, "Four"); // 4
        System.out.println("Done Put HashTable.");
        System.out.println("Value of 10: " + ht.get(10));
        System.out.println("Value of 6: " + ht.get(6));
        System.out.println("Value of 1: " + ht.get(1));
        System.out.println("Value of 11: " + ht.get(11));
        System.out.println("Value of 9: " + ht.get(9));
        ht.remove(6);
        System.out.println("Value of 6: " + ht.get(6));
        // ht.remove(9);
    }
}
