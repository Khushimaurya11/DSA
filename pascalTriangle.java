import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> curr_row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j == 0 || j==i){
                    curr_row.add(1);
                }
                else{
                    List<Integer> prevRow = ans.get(i-1);
                    curr_row.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            ans.add(curr_row);
             }
             return ans;
        }
}

    public static void main(String[] args) {
        pascalTriangle sol = new pascalTriangle();
        int numRows = 5;
        List<List<Integer>> result = sol.new Solution().generate(numRows);
        System.out.println(result); // Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
