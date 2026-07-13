class Solution {
    
    public int uniquePaths(int[][] grid,int m,int n,int row,int col,int[][] dp ) {
         
        if(row>=m || col >=n) return 0;
         if(grid[row][col] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;
         if(grid[m-1][n-1] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];
       return dp[row][col] = uniquePaths(grid,m,n,row+1,col,dp) +  uniquePaths(grid,m,n,row,col+1,dp) ;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
           for(int j=0; j<n; j++) dp[i][j] = -1;
        return uniquePaths(grid,m,n,0,0,dp) ;
    }
}