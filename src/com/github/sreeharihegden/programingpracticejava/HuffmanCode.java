package com.github.sreeharihegden.programingpracticejava;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCode {
    private class HuffmanNode{
        int frequency;
        char c;

        HuffmanNode leftChild;
        HuffmanNode rightChild;
    }

    private class MyComparator implements Comparator<HuffmanNode>{
        public int compare(HuffmanNode x, HuffmanNode y){
            return x.frequency - y.frequency;
        }
    }

    private void printHuffmanCode(HuffmanNode root, String s){
        if(root.leftChild == null
            && root.rightChild == null
                && Character.isLetter(root.c)){
            System.out.println(root.c + ": " + s);
            return;
        }

        printHuffmanCode(root.leftChild, s + "0");
        printHuffmanCode(root.rightChild, s + "1");
    }

    public void getHuffmanCode(char[] charArray, int[] charFrequency){
        int n = charArray.length;
        // Initialize PriorityQueue of length same as the number of characters.
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        // Add character frequencies to the PriorityQueue.
        for(int i=0; i<n; i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.frequency = charFrequency[i];

            hn.leftChild = null;
            hn.rightChild = null;

            q.add(hn);
        }

        // Build the Huffman Tree.
        HuffmanNode root = null;
        while(q.size() > 1){
            // HuffmanNode x = q.peek();
            // q.poll();
            // Though below works, peek to create HuffmanNode is performant as Java PQ using heap does heap[0] for peek.
            // Whereas poll needs to do heapifyDown();
            HuffmanNode x = q.poll();

            // HuffmanNode y = q.peek();
            // q.poll();
            // Though below works, peek to create HuffmanNode is performant as Java PQ using heap does heap[0] for peek.
            // Whereas poll needs to do heapifyDown();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();
            f.frequency = x.frequency + y.frequency;
            f.c = '-';

            f.leftChild = x;
            f.rightChild = y;

            root = f;

            q.add(f);
        }

        printHuffmanCode(root, "");
    }
}
