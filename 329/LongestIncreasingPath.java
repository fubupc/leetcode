/**
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * 
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *
 *
 * Solution: DFS + memoization
 */

import java.util.ArrayList;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;

        int cols = matrix[0].length;
        int max = 1;

        boolean[][] marked = new boolean[rows][cols];
        int[][] count = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j]) {
                    dfs(matrix, marked, count, i, j);
                    max = Math.max(max, count[i][j]);
                }
            }
        }

        return max;
    }

    public void dfs(int[][] matrix, boolean[][] marked, int[][] count, int x, int y) {
        int max = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        marked[x][y] = true;

        for (int[] p : adj(rows, cols, x, y)) {
            int x0 = p[0];
            int y0 = p[1];
            if (matrix[x][y] < matrix[x0][y0]) {
                if (!marked[x0][y0]) {
                    dfs(matrix, marked, count, x0, y0);
                }
                max = Math.max(max,  count[x0][y0] + 1);
            }
        }

        count[x][y] = max;
    }


    private Iterable<int[]> adj(int rows, int cols, int x, int y) {
        ArrayList<int[]> a = new ArrayList<int[]>();

        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0 || i > rows - 1 ) continue;
            a.add(new int[]{i, y});
        }

        for (int j = y - 1; j <= y + 1; j++) {
            if (j < 0 || j > cols - 1) continue;
            a.add(new int[]{x, j});
        }

        return a;
    }
}

class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
        {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};

        Solution s = new Solution();
        System.out.println(s.longestIncreasingPath(matrix));
    }
}

