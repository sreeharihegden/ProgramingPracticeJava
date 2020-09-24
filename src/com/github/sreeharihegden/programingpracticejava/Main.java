package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();

        demoStack();

        demoStackBalancedExpression();

        demoQueue();

        demoQueueArray();

        demoQueueWithTwoStacks();

        demoPriorityQueueArray();

        demoHashTable();

        demoTree();
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

    public static void demoQueue(){
        System.out.println("\n************");
        System.out.println("In demoQueue");
        System.out.println("************");
        Queue q = new Queue();

        // q.peek();
        q.enqueue(10);
        System.out.println("Peek: " + q.peek());
        q.enqueue(5);
        q.enqueue(20);

        System.out.println(q.dequeue());
        System.out.println("Peek: " + q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        // q.peek();
        // System.out.println(q.dequeue());
    }

    public static void demoQueueArray(){
        System.out.println("\n*****************");
        System.out.println("In demoQueueArray");
        System.out.println("*****************");
        QueueArray q = new QueueArray(5);

        // q.peek();
        q.enqueue(10);
        System.out.println(q);
        System.out.println("Peek: " + q.peek());
        q.enqueue(5);
        q.enqueue(20);
        System.out.println(q);

        System.out.println(q.dequeue());
        System.out.println("Peek: " + q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q);
        // q.peek();
        // System.out.println(q.dequeue());

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q);
        System.out.println("Peek: " + q.peek());
        // q.enqueue(6);
    }

    public static void demoQueueWithTwoStacks(){
        System.out.println("\n*************************");
        System.out.println("In demoQueueWithTwoStacks");
        System.out.println("*************************");
        QueueWithTwoStacks q = new QueueWithTwoStacks();

        // q.peek();
        q.enqueue(100);
        System.out.println("Peek: " + q.peek());
        q.enqueue(50);
        q.enqueue(200);

        System.out.println(q.dequeue());
        System.out.println("Peek: " + q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        // q.peek();
        // System.out.println(q.dequeue());
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

    public static void demoTree(){
        System.out.println("\n***********");
        System.out.println("In demoTree");
        System.out.println("***********");

        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println("Tree insert done.");
        System.out.println("Find 10: " + tree.find(10));
        System.out.println("Find 7: " + tree.find(7));
        System.out.println("Find 12: " + tree.find(12));
        System.out.println("Find 1: " + tree.find(1));
        System.out.println("Find 9: " + tree.find(9));
        System.out.println("PreOrder Traversal");
        tree.traversePreOrder();
        System.out.println("InOrder Traversal");
        tree.traverseInOrder();
        System.out.println("PostOrder Traversal");
        tree.traversePostOrder();

        System.out.println("Height: " + tree.height());
        System.out.println("Min: " + tree.min());

        Tree t2 = new  Tree();
        t2.insert(7);
        t2.insert(4);
        t2.insert(9);
        t2.insert(1);
        t2.insert(6);
        t2.insert(8);
        t2.insert(10);
        System.out.println("Equals t2: " + tree.equals(t2));
        Tree t3 = new  Tree();
        t3.insert(7);
        t3.insert(4);
        t3.insert(9);
        t3.insert(1);
        System.out.println("Equals t3: " + tree.equals(t3));
        System.out.println("isBST t3: " + t3.isBST());

        System.out.println("Nodes at distance 2 for tree: " + tree.getNodesAtKDistance(2));
        System.out.println("Nodes at distance 2 for t3: " + t3.getNodesAtKDistance(2));

        System.out.println("LevelOrder Traversal for tree");
        tree.traverseLevelOrder();
    }
}
