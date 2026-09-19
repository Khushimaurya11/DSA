class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
         
        int totalLenth = row * col;

        int start = 0;
        int end =totalLenth -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int rowIndex = mid / col;
            int colIndex = mid % col;
            if(matrix[rowIndex][colIndex ] == target){
                return true;
            }
            if(matrix[rowIndex][colIndex ] < target){
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        return false;
        }
}