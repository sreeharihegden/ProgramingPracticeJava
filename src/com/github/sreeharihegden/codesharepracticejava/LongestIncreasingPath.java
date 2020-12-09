package com.github.sreeharihegden.codesharepracticejava;

import java.util.Arrays;

public class LongestIncreasingPath {

    private static final int[][] dirs = {
            {0, 1}, // same row, next column
            {1, 0}, // same column, next row
            {-1, 0}, // previous row, same column
            {0, -1}  // same row, previous column
    };

    public int getLongestIncreasingPath(int[][] matrix){
        if(matrix.length == 0)
            return 0;

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int row = 0;
        int col = 0;

        int[][] cache = new int[numRows][numCols];
        for(row = 0; row < numRows; row++)
            Arrays.fill(cache[row], -1);

        int maxPathLength = 0;
        for(row = 0; row < numRows; row++)
            for(col=0; col < numCols; col++){
                int pathLength = getLongestIncreasingPath(cache, matrix, numRows, numCols, row, col); // Can also do 1+ if counting nodes in path.
                maxPathLength = Math.max(pathLength, maxPathLength);
            }

        return maxPathLength;
    }

    private int getLongestIncreasingPath(int[][] cache, int[][] matrix, int numRows, int numCols, int row, int col){
        if(cache[row][col]!=-1)
            return cache[row][col];

        int maxPathLength = 0;

        for(int[] dir: dirs){
            int currentRow =  row + dir[0];
            int currentCol = col + dir[1];

            if(currentRow < 0 ||
                currentRow >= numRows ||
                    currentCol < 0 ||
                        currentCol >= numCols ||
                            matrix[currentRow][currentCol] <= matrix[row][col])
                continue;

            int pathLength = 1 + getLongestIncreasingPath(cache, matrix, numRows, numCols, currentRow, currentCol);
            maxPathLength = Math.max(maxPathLength, pathLength);
        }
        cache[row][col] = maxPathLength;
        return maxPathLength;
    }
}
