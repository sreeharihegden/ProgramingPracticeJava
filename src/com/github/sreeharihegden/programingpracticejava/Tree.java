package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);

        if(root == null){
            root = node;
            return;
        }

        var current = root;
        while(true){
            if(value < current.value){
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while(current!=null){
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    // BST
    public int min(){
          if(root == null)
              throw new IllegalStateException();

          var current = root;
          var last = current;
          while(current!=null){
              last = current;
              current = current.leftChild;
          }

          return last.value;
    }

    // BT
    private int min(Node root){
        if( isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree other){
        if(other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first!=null && second !=null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return isBST(root.leftChild, min, root.value - 1) // If root is 20, leftChild can have max of 19 only, else in above root.value > max, it won't work.
                && isBST(root.rightChild, root.value + 1, max);

    }

    public ArrayList<Integer> getNodesAtKDistance(int k){
        var list = new ArrayList<Integer>();
        getNodesAtKDistance(root, k, list);
        return list;
    }

    private void getNodesAtKDistance(Node root, int k, ArrayList<Integer> list){
        if(root == null)
            return;

        if(k == 0){
            list.add(root.value);
            return;
        }

        getNodesAtKDistance(root.leftChild, k-1, list);
        getNodesAtKDistance(root.rightChild, k-1, list);
    }

    public void traverseLevelOrder(){
        for(var i=0; i<=height(); i++)
            for(var value : getNodesAtKDistance(i))
                System.out.println(value);
    }
}
