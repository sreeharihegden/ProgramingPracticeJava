package com.github.sreeharihegden.programingpracticejava;

public class QuickSort {
    public void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    private void sort(int[] array, int start, int end){
        // Base condition for recursion.
        if(start>=end)
            return;

        // Find Boundary or first Pivot's correct position.
        int boundary = partition(array, start, end);

        // Recursive call.
        // sort(array, 0, boundary-1);
        sort(array, start, boundary-1);
        // sort(array, boundary+1, array.length-1);
        sort(array, boundary+1, end);
    }

    private int partition(int[] array, int start, int end){
        // var pivot = array[array.length-1];
        var pivot = array[end];
        // var boundary = -1;
        var boundary = start-1;
        // for (var i=0; i<array.length; i++)
        for (var i=start; i<=end; i++)
            if(array[i]<=pivot) {
                // boundary++;
                // swap(array, i, boundary);
                swap(array, i, ++boundary);
            }
        return boundary;
    }

    private void swap(int[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
