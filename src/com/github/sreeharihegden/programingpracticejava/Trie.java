package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class TrieNode{
        private char value;
        private boolean isEndOfWord;
        private HashMap<Character, TrieNode> children= new HashMap<>();

        public TrieNode(char ch){
            this.value = ch;
        }

        @Override
        public String toString(){
            return "Node: " + value;
        }

        private boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        private void createChild(char ch){
            children.put(ch, new TrieNode(ch));
        }

        private TrieNode getChild(char ch){
            return children.get(ch);
        }

        private TrieNode[] getChildren(){
            return children.values().toArray(new TrieNode[0]);
        }

        private boolean hasChildren(){
            return !children.isEmpty();
        }

        private void removeChild(char ch){
            children.remove(ch);
        }
    }

    private TrieNode root = new TrieNode(' ');

    public void insert(String word){
        if(word == null)
            return;

        TrieNode current = root;
        for(var ch : word.toCharArray()){
            if(!current.hasChild(ch)){
                current.createChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if(word == null)
            return false;

        var current = root;
        for(var ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(TrieNode root){
        // Pre-Order for checking a word:
        // System.out.println(root.value);

        for(var child : root.getChildren())
            traverse(child);

        // Post-Order for deleting a word:
        System.out.println(root.value);
    }

    public void remove(String word){
        if(word == null)
            return;

        remove(root, word, 0);
    }

    private void remove(TrieNode root, String word, int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null)
            return;
        remove(child, word, index+1 );

        if(!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> autoCompletedList(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = getLastNode(prefix);
        autoCompletedList(lastNode, prefix, words);
        return words;
    }

    private void autoCompletedList(TrieNode lastNode, String prefix, List<String> words){
        if(lastNode == null)
            return;

        if (lastNode.isEndOfWord)
            words.add(prefix);

        for(var child : lastNode.getChildren())
            autoCompletedList(child, prefix + child.value, words);
    }

    private TrieNode getLastNode(String prefix){
        if(prefix == null)
            return null;

        var current = root;
        for(var ch : prefix.toCharArray()){
            /* This is also correct
            if(!current.hasChild(ch))
                return null;
            current = current.getChild(ch);
            */
            var child = current.getChild(ch);
            if(child == null)
                return null;
            current = child;
        }
        return current;
    }
}
