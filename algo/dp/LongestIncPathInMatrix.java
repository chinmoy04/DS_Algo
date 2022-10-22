package com.algo.dp;

public class LongestIncPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int mem[][] = new int[row][col];
        
        int longest = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int path = dfs(matrix, mem, dir, i, j, row, col);
                longest = Math.max(path, longest);
            }
        }
                
        return longest;
    }
    
    int dfs(int[][] matrix, int[][] mem, int[][] dir, int i, int j, int row, int col){
        if(mem[i][j] > 0){
            return mem[i][j];
        }
        
        int max = 0;
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            
            if(x >= 0 && x < row && y>=0 && y < col && matrix[x][y] > matrix[i][j]){
                max = Math.max(max, dfs(matrix, mem, dir, x, y, row, col));
            }
        }
        
        mem[i][j] = max + 1;
        return max + 1;
    }
}