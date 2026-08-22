class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int origN = n;
        while(n > 0){
            int rem = n % 10;
            sum = sum + rem;
            pro = pro * rem;
            n = n /10;
        }
         if(origN % (sum + pro) != 0){
        return false;
     }
     return true;
    }
}