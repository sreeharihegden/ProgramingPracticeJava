package com.github.sreeharihegden.codesharepracticejava;

import java.util.*;

public class TopKUsers {

    public List<List<Integer>> getTopKUsers(List<Integer> input, int n){

        // Populate count for each User IDs.
        Map<Integer, Integer> counts = new HashMap<>();
        for (var entry : input){
            if(counts.get(entry) != null)
                counts.put(entry, counts.get(entry) + 1);
            else
                counts.put(entry, 1);
        }

        // Add User IDs to Priority Queue based on counts.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (x, y) -> y.getValue().compareTo(x.getValue()));
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            pq.add(entry);
        }

        // Loop over Priority Queue to populate top n User IDs.
        List<List<Integer>> output = new LinkedList<>();
        for(int i= 0 ; i<n; i++){
            List<Integer> l = new LinkedList<>();
            int temp = pq.peek().getValue();
            while(!pq.isEmpty() && pq.peek().getValue() == temp)
                    l.add(pq.remove().getKey());
            output.add(l);
        }
        return output;
    }
}