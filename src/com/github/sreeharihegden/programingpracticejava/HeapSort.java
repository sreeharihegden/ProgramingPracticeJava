package com.github.sreeharihegden.programingpracticejava;

public class HeapSort {
    // When list of n elements already known, inserting n elements using Heap or HeapifyUp will take
    // 0(n*log n), whereas heapifying by heapifyDown can be done in O(n) or linear time as height is n-log n-1.
    public void sort(int[] items){
        // Heapify Down
        int heapSize = items.length;
        for(int i= (heapSize-1)/2; i >= 0; i--) // as leaf nodes always satisfy heap property, no need to check them.
            heapifyDown(items, heapSize, i);

        for(int i = heapSize-1; i >=0; i--){
            swap(items, i, 0);
            heapifyDown(items, i, 0);
        }
    }

    // This is not heapifyUp as we do swap with largest item in the root and then percolate down,
    // whereas in heapifyUp we compare with parent and percolate up.
    private void heapifyDown(int[] items, int heapSize, int rootIndex){
        int largestItemIndex = rootIndex;
        int leftChildIndex = 2*largestItemIndex + 1;
        int rightChildIndex = 2*largestItemIndex + 2;

        if(leftChildIndex < heapSize
                && items[leftChildIndex] > items[largestItemIndex])
            largestItemIndex = leftChildIndex;

        if(rightChildIndex < heapSize
                && items[rightChildIndex] > items[largestItemIndex])
            largestItemIndex = rightChildIndex;

        if(largestItemIndex!=rootIndex){
            swap(items, largestItemIndex, rootIndex);
            heapifyDown(items, heapSize, largestItemIndex);
        }
    }

    private void swap(int[] items, int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
