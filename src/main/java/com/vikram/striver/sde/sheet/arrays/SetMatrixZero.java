package com.vikram.striver.sde.sheet.arrays;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int [][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setMatrixZero.setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 2. Consider 2 int array, one for row and one for col, and instead of setting
    // whole row and col of matrix in-place, set only index in that row and col
    // array to identify which place position needs to be replaced with 0 in matrix
    // in either row array or col array is 0 then matrix position is zero
    public void setZeroes2(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        //process matrix
        for (int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        //replace
        for (int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 1. Solution with replacing -1 to row and colum where zero is detected
    // then replace all -1 with 0
    public void setZeroes(int[][] matrix) {
        //process matrix
        for (int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setMinus1InRowAndColumn(i, j, matrix);
                }
            }
        }
        //replace -1 with 0
        for (int i = 0; i < matrix.length; i++) {
            for( int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setMinus1InRowAndColumn(int row, int col, int[][] matrix) {
        //set whole col -1
        for (int i = 0; i< matrix.length; i++) {
            matrix[i][col] = -1;
        }
        //set whole row -1
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = -1;
        }
    }
}
