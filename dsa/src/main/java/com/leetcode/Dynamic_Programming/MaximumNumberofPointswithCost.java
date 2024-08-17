package com.leetcode.Dynamic_Programming;

import java.util.Arrays;

public class MaximumNumberofPointswithCost {
    public long maxPoints(int[][] points) {
        return dynamicProgrammingSolution(points);
    }

    // Dynamic Programming Solution -> Passed 157/157 test cases
    // Solution by Neetcode
    // Link: https://www.youtube.com/watch?v=ik1y7fz8AOc
     public long dynamicProgrammingSolution(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[] prevRow = new long[m];
        
        // Initialize the prevRow with the first row points
        for (int j = 0; j < m; j++) {
            prevRow[j] = points[0][j];
        }

        // Process each row from the second row to the last
        for (int i = 1; i < n; i++) {
            long[] newRow = new long[m];
            long[] left = new long[m];
            long[] right = new long[m];

            // Left to right
            left[0] = prevRow[0];
            for (int l = 1; l < m; l++) {
                left[l] = Math.max(prevRow[l], left[l - 1] - 1);
            }

            // Right to left
            right[m - 1] = prevRow[m - 1];
            for (int r = m - 2; r >= 0; r--) {
                right[r] = Math.max(prevRow[r], right[r + 1] - 1);
            }

            // Calculate the maximum points for the current row
            for (int k = 0; k < m; k++) {
                newRow[k] = points[i][k] + Math.max(left[k], right[k]);
            }

            // Update prevRow with newRow values
            prevRow = newRow;
        }

        // Return the maximum value in the last row
        return Arrays.stream(prevRow).max().getAsLong();
    }


    // Brute force -> Passed 156/157 test cases
    // Big(O) = O(n * m * m)
    public long bruteForceSolution(int[][] points){
        int n = points.length;
        int m = points[0].length;
        long[] result = new long[m];
        for(int i = 0; i < m; i++){
            result[i] = points[0][i];
        }
        int index = 0;
        for (int i = 1; i < n; i++) {
            long[] currentRow = new long[m];

            // Calculate the maximum points for each column in the current row
            for (int j = 0; j < m; j++) {
                long maxPoints = Long.MIN_VALUE;

                for (int k = 0; k < m; k++) {
                    maxPoints = Math.max(maxPoints, result[k] + points[i][j] - Math.abs(k - j));
                }

                currentRow[j] = maxPoints;
            }

            // Update the previous row with the current row values
            result = currentRow;
        }
        Arrays.sort(result);
        return result[m-1];
    }
}
