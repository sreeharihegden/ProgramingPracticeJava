package com.github.sreeharihegden.programingpracticejava;

import java.util.*;
import java.util.Stack;
import java.util.List;

public class WeightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>(); // This is still an adjacency list as we store only edges that exist.
        // private Map<Node, List<Edge>> edges = new HashMap<>(); can provide faster lookup.

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }

        private void addEdge(Node toNode, int weight){
            edges.add(new Edge(this, toNode, weight));
        }

        private List<Edge> getEdges(){
            return edges;
        }

    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            // return "Edge from " + from + " to " + to + " with weight " + weight;
            return from + " -> " + to + ": " + weight;
        }
    }

    public class Path{ // Can write this class outside WeightedGraph too.
        private List<String> nodes = new ArrayList<>();

        public void add(String label){
            nodes.add(label);
        }

        @Override
        public String toString(){
            return nodes.toString();
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    // private Map<Node, List<Edge>> adjList = new HashMap<>(); Move adjList to Node class in this case to be more Object oriented.

    public void addNode(String label){
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String fromLabel, String toLabel, int weight){
        var fromNode = nodes.get(fromLabel);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(toLabel);
        if(toNode == null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight); // Because undirected graph we need to register edge for both nodes.
    }

    public void print(){
        for(var node : nodes.values()){
            var edges = node.getEdges();
            // System.out.println(node + " is connected to " + edges); // If only nodes.
            if(!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry{
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int dijkstraShortestDistance(String fromLabel, String toLabel){
        var fromNode = nodes.get(fromLabel);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(toLabel);
        if(toNode == null)
            throw new IllegalArgumentException();

        // Tables to keep track of shortest distance and via node information for each nodes.
        Map<Node, Integer> distances = new HashMap<>();
        // Map<Node, Node> previousNodes = new HashMap<>(); Required only in dijkstraShortestPath, see next method.

        for(var neighbour : nodes.values())
            distances.put(neighbour, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        // BFS Queue, but shortest one first.
        PriorityQueue<NodeEntry> pq = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        // BFS Visited Set.
        Set<Node> visited = new HashSet<>();

        pq.add(new NodeEntry(fromNode, 0));

        while(!pq.isEmpty()) {
            var current = pq.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    // previousNodes.put(edge.to, current); Required only in dijkstraShortestPath, see next method.
                    pq.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distances.get(toNode);
    }

    public Path dijkstraShortestPath(String fromLabel, String toLabel){
        var fromNode = nodes.get(fromLabel);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(toLabel);
        if(toNode == null)
            throw new IllegalArgumentException();

        // Tables to keep track of shortest distance and via node information for each nodes.
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();

        for(var neighbour : nodes.values())
            distances.put(neighbour, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        // BFS Queue, but shortest one first.
        PriorityQueue<NodeEntry> pq = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );

        // BFS Visited Set.
        Set<Node> visited = new HashSet<>();

        pq.add(new NodeEntry(fromNode, 0));

        while(!pq.isEmpty()) {
            var current = pq.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    pq.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode){

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while(previous!=null){
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while(!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }
}
