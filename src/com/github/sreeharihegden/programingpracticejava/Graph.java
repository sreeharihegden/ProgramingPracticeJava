package com.github.sreeharihegden.programingpracticejava;

import java.util.*;
import java.util.Stack;
import java.util.Queue;

public class Graph {
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return("Node: " + label);
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String fromLabel, String toLabel){
        var fromNode = nodes.get(fromLabel);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(toLabel);
        if(toNode == null)
            throw new IllegalArgumentException();

        adjList.get(fromNode).add(toNode);
        // If Undirected Graph, also do:
        // adjList.get(toNode).add(fromNode);
    }

    public void print(){
        for(var source : adjList.keySet()){
            var targets = adjList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node == null)
            return;

        for(var n : adjList.keySet())
            adjList.get(n).remove(node);

        adjList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String fromLabel, String toLabel){
        var fromNode = nodes.get(fromLabel);
        var toNode = nodes.get(toLabel);
        if(fromNode == null || toNode == null)
            return;

        adjList.get(fromNode).remove(toNode);
        // If Undirected Graph, also do:
        // adjList.get(toNode).remove(fromNode);
    }

    public void traverseDepthFirstRecursive(String label){
        var rootNode = nodes.get(label);
        if(rootNode == null)
            return;

        traverseDepthFirstRecursive(rootNode, new HashSet<>());
    }

    private void traverseDepthFirstRecursive(Node rootNode, Set<Node> visited) {
        // System.out.println(rootNode.label);
        System.out.println(rootNode); // Because we have overridden toString() in Node class.
        visited.add(rootNode);

        for(var neighbors : adjList.get(rootNode)){
            if(!visited.contains(neighbors))
                traverseDepthFirstRecursive(neighbors, visited);
        }
    }

    public void traverseDepthFirst(String label) {
        var rootNode = nodes.get(label);
        if(rootNode == null)
            return;

        Set<Node> visited = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);

        while(!stack.isEmpty()){
            var current = stack.pop();

            if(visited.contains(current))
               continue;

            System.out.println(current);
            visited.add(current);

            for(var neighbors : adjList.get(current)){
                if(!visited.contains(neighbors))
                    stack.push(neighbors); // This will B and neighbors first instead of C and D unlike recursive, because we push B last.
            }
        }
    }

    public void traverseBreadthFirst(String label){
        var rootNode = nodes.get(label);
        if(rootNode == null)
            return;

        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(rootNode);

        while(!queue.isEmpty()){
            var current = queue.remove();

            if(visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for(var neighbors : adjList.get(current)){
                if(!visited.contains(neighbors))
                    queue.add(neighbors);
            }
        }
    }

    public List<String> topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        for(var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while(!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node rootNode, Set<Node> visited, Stack<Node> stack){
        if(visited.contains(rootNode))
            return;

        visited.add(rootNode);
        for(var neighbors :adjList.get(rootNode)){
            topologicalSort(neighbors, visited, stack);
        }
        stack.push(rootNode);
    }
}
