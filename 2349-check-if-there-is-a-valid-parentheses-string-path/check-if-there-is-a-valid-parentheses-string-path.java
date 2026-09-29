class Solution {
    int m,n;
  Boolean[][][] memo;
 boolean solve(int i, int j, int openCnt,char[][] grid ){
      
        openCnt += (grid[i][j] == '(') ? 1 : -1;
             if(openCnt < 0) return false;

             if(i == m-1 && j == n-1) return openCnt == 0;
             if (memo[i][j][openCnt] != null) return memo[i][j][openCnt];
             boolean res = false;
             if(i+1 < m){
                if(solve(i+1,j,openCnt,grid)) 
                return memo[i][j][openCnt] = true;
             }
             if(j+1 < n){
                if(solve(i,j+1,openCnt,grid)) 
                return memo[i][j][openCnt] = true;
             }
             return memo[i][j][openCnt] = res;
    }
    
    public boolean hasValidPath(char[][] grid) {
       this.m = grid.length;
       this.n = grid[0].length;
         if((m+n-1) % 2 ==1 ) return false;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
       memo = new Boolean[m][n][m + n];
        return solve(0,0,0,grid);
    }
   
}