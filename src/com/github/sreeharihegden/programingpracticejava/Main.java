package com.github.sreeharihegden.programingpracticejava;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();

        /*
        demoDynamicArray();

        demoStack();

        demoStackBalancedExpression();

        demoQueue();

        demoQueueArray();

        demoQueueWithTwoStacks();

        demoPriorityQueueArray();

        demoHashTable();

        demoTree();

        demoGraph();

        // Sort
        demoBubbleSort();

        demoSelectionSort();

        demoInsertionSort();

        demoMergeSort();

        demoQuickSort();

        demoCountingSort();

        demoBucketSort();

        demoHeapSort();

        demoHuffmanCode();

        // Extra
        demoMatrixMultiplication();

        demoComparatorSort();
        */
        demoBitManipulation();
    }

    public static void demoDynamicArray(){
        System.out.println("\n*******************");
        System.out.println("In demoDynamicArray");
        System.out.println("*******************");
        DynamicArray arr = new DynamicArray(5);

        System.out.println("Print Array");
        arr.print();
        arr.insert(5);
        arr.insert(4);
        arr.insert(8);
        System.out.println("Print Array after insert");
        arr.print();
        arr.insertAt(3, 0);
        arr.insertAt(7, 4);
        arr.insertAt(10, 2);
        System.out.println("Print Array after insertAt");
        arr.print();
        arr.reverse();
        System.out.println("Print Array after reverse");
        arr.print();
        System.out.println("Max is: " + arr.max());
        System.out.println("Index of Max is: " + arr.indexOf(arr.max()));
        arr.removeAt(arr.indexOf(arr.max()));
        System.out.println("Print Array after removeAt indexOf max");
        arr.print();
        System.out.println("New Max is : " + arr.max());
        var other = new DynamicArray(4);
        other.insert(4);
        other.insert(1);
        other.insert(10);
        other.insert(8);
        System.out.println("Print other");
        other.print();
        var intersection = arr.intersect(other);
        System.out.println("Print intersection");
        intersection.print();
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

    public static void demoGraph(){
        System.out.println("\n************");
        System.out.println("In demoGraph");
        System.out.println("************");

        Graph g = new Graph();
        g.addNode("A");
        g.addNode("B");
        g.addNode("C");
        g.addNode("D");

        g.addEdge("A", "C");
        g.addEdge("B", "A");
        // g.addEdge("A", "B");
        g.addEdge("C", "D");

        g.print();

        // g.removeNode("B");
        // g.print();
        // g.removeEdge("A", "C");
        // g.removeEdge("C", "A");
        // g.print();

        System.out.println("traverseDepthFirstRecursive(A)");
        g.traverseDepthFirstRecursive("A");
        System.out.println("traverseDepthFirstRecursive(B)");
        g.traverseDepthFirstRecursive("B");

        System.out.println("traverseDepthFirstIterative(A)");
        g.traverseDepthFirst("A");
        System.out.println("traverseDepthFirstIterative(B)");
        g.traverseDepthFirst("B");

        System.out.println("traverseBreadthFirstIterative(A)");
        g.traverseBreadthFirst("A");
        System.out.println("traverseBreadthFirstIterative(B)");
        g.traverseBreadthFirst("B");

        System.out.println("TopologicalSort");
        List<String >sorted = g.topologicalSort();
        System.out.println(sorted);

        System.out.println("Detect Cycle");
        System.out.println(g.hasCycle());
        System.out.println("Adding Cycle Edge A to B");
        g.addEdge("A", "B");
        System.out.println(g.hasCycle());
    }

    // Sorting
    public static void demoBubbleSort(){
        System.out.println("\n*****************");
        System.out.println("In demoBubbleSort");
        System.out.println("*****************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        BubbleSort sorter = new BubbleSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoSelectionSort(){
        System.out.println("\n********************");
        System.out.println("In demoSelectionSort");
        System.out.println("********************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        SelectionSort sorter = new SelectionSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoInsertionSort(){
        System.out.println("\n********************");
        System.out.println("In demoInsertionSort");
        System.out.println("********************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        InsertionSort sorter = new InsertionSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoMergeSort(){
        System.out.println("\n****************");
        System.out.println("In demoMergeSort");
        System.out.println("****************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        MergeSort sorter = new MergeSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoQuickSort(){
        System.out.println("\n****************");
        System.out.println("In demoQuickSort");
        System.out.println("****************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        QuickSort sorter = new QuickSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoCountingSort(){
        System.out.println("\n*******************");
        System.out.println("In demoCountingSort");
        System.out.println("*******************");

        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5}; // For counting sort, only positive integers [0, k] allowed.
        CountingSort sorter = new CountingSort();
        long start = System.nanoTime();
        sorter.sort(array, 7);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoBucketSort(){
        System.out.println("\n*****************");
        System.out.println("In demoBucketSort");
        System.out.println("*****************");

        // int [] array = new int[] {7, 6, 0, 1, 2, -7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5}; // Negative numbers not usually allowed in Bucket Sort. If numBuckets is 21, -7 in input works, but if numBuckets is 3 it errors.
        int [] array = new int[] {7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5, 7, 6, 0, 1, 2, 7, 5};
        BucketSort sorter = new BucketSort();
        long start = System.nanoTime();
        sorter.sort(array, 3);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoHeapSort(){
        System.out.println("\n***************");
        System.out.println("In demoHeapSort");
        System.out.println("***************");

        int [] array = new int[] {10, 15, 20};
        HeapSort sorter = new HeapSort();
        long start = System.nanoTime();
        sorter.sort(array);
        long elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);

        array = new int[] {10, 15, 20, 5};
        start = System.nanoTime();
        sorter.sort(array);
        elapsedTime = System.nanoTime() - start;
        System.out.println(Arrays.toString(array));
        System.out.println("elapsedTime is: " + elapsedTime);
    }

    public static void demoHuffmanCode() {
        System.out.println("\n******************");
        System.out.println("In demoHuffmanCode");
        System.out.println("******************");

        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFrequency = { 5, 9, 12, 13, 16, 45 };
        /*
        Scanner s = new Scanner(System.in);
        int numberChars = 6;
        char[] charArray = new char[numberChars];
        int[] charFrequency = new int[numberChars];
        for(int i = 0; i<numberChars; i++){
            System.out.println("Enter character " + i + " and its frequency separated by space:");
            String input = s.nextLine();
            charArray[i] = input.charAt(0);
            charFrequency[i] = Integer.parseInt(input.substring(2));
        }
        */
        System.out.println("Character Array is: " + new String(charArray));
        System.out.println("Character Frequency Array is: " + Arrays.toString(charFrequency));
        HuffmanCode hc = new HuffmanCode();
        System.out.println("Huffman Code is: ");
        hc.getHuffmanCode(charArray, charFrequency);
    }

    // Extra
    public static void demoMatrixMultiplication(){
        System.out.println("\n***************************");
        System.out.println("In demoMatrixMultiplication");
        System.out.println("***************************");

        MultiplyMatrices m = new MultiplyMatrices();
        m.multiplyMatrices(m.firstMatrix, m.secondMatrix);
    }

    public static void demoComparatorSort(){
        System.out.println("\n*********************");
        System.out.println("In demoComparatorSort");
        System.out.println("*********************");

        int[] numbers = {4, 9, 1, 3, 2, 8, 7, 0, 6, 5};
        System.out.println("Array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted Array by Using Array.sort: " + Arrays.toString(numbers));

        Student[] students = new Student[5];
        students[0] = new Student("Jon", 25);
        students[1] = new Student("Adam", 15);
        students[2] = new Student("Jon", 23);
        students[3] = new Student("Abin", 10);
        students[4] = new Student("Bob", 15);
        System.out.println("Students: " + Arrays.toString(students));
        Arrays.sort(students, new Student.MyComparator());
        System.out.println("Sorted Students by Using Comparator: " + Arrays.toString(students));

        // Cannot do this due to return type of Collections.reverseOrder:
        // Student.MyComparator descendingStudentComparator = Collections.reverseOrder(new Student.MyComparator());
        Comparator<Student> descendingStudentComparator = Collections.reverseOrder(new Student.MyComparator());
        Arrays.sort(students, descendingStudentComparator);
        System.out.println("Descending order Sorted Students by Using Collections.reverseOrder: " + Arrays.toString(students));

        Arrays.sort(students, (Student s1, Student s2)-> {
            if(s1.fname.equals(s2.fname))
                return s1.age - s2.age;
            else
                return s1.fname.compareTo(s2.fname);});
        System.out.println("Sorted Students by Using Lambda: " + Arrays.toString(students));


        List<Student> studentsList = new ArrayList<Student>();
        for(Student student : students)
            studentsList.add(student);

        studentsList.sort((s1, s2) -> {
            if(s1.fname.equals(s2.fname))
                return s2.age - s1.age;
            else
                return s2.fname.compareTo(s1.fname);});
        System.out.println("Descending order Sorted StudentsList by Using Lambda: " + studentsList);

        studentsList.sort(Student::compareByNameThenAge);
        System.out.println("Ascending order Sorted StudentsList by Using Reference to Static Method: " + studentsList);
    }

    public static void demoBitManipulation() {
        System.out.println("\n******************");
        System.out.println("In BitManipulation");
        System.out.println("******************");

        BitManipulation obj = new BitManipulation();
        obj.and(6, 129);
        obj.or(6, 129);
        obj.exclusiveor(7, 129);

        obj.leftshift(129, 2);
        obj.rightshift(129, 2);
        obj.complement(2);

        obj.checkKthBitSet(129, 4);
        obj.checkKthBitSet(4, 3);
        obj.setKthBit(129, 4);
        obj.clearKthBit(129, 8);

        obj.toggleKthBit(129, 3);
        obj.toggleRightmostOneBit(5);
        obj.toggleRightmostOneBit(4); // Won't work as rightmost bit is not 1.
        obj.isolateRightmostOneBit(5);
        obj.isolateRightmostOneBit(4); // Won't work as rightmost bit is not 1.
        obj.isolateRightmostZeroBit(4); // Won't work as rightmost bit is not 1.
        obj.isolateRightmostZeroBit(135);
    }
}