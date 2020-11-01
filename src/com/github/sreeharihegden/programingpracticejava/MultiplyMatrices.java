package com.github.sreeharihegden.programingpracticejava;

public class MultiplyMatrices{
    int[][] firstMatrix = {{3, -2, 5}, {3, 0, 4}};
    int[][] secondMatrix = {{2, 3}, {-9, 0}, {0, 4}};

    public void multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix){
        int r1 = firstMatrix.length;
        int c1 = firstMatrix[0].length;
        int c2 = secondMatrix[0].length;

        System.out.println("First Matrix is: ");
        displayMatrix(firstMatrix);
        System.out.println("Second Matrix is: ");
        displayMatrix(secondMatrix);

        int[][] product = new int[r1][c2];
        for(int i = 0; i<r1; i++){
            for(int j=0; j<c2; j++){
                for(int k=0; k<c1; k++){
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        System.out.println("Product is: ");
        displayMatrix(product);
    }

    public void displayMatrix(int[][] matrix){
        // System.out.println(matrix.getClass().getName() + " is: ");
        for(int[] row : matrix){
            for(int column :  row)
                System.out.print(column + "   ");
            System.out.println();
        }
    }
}


