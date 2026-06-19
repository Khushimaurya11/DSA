class palindrome {
    public boolean isPalindrome(int x) {
          int n = x;
        int reverse = 0;
        if(x < 0){
            return false;
        }
       while(x > 0){
         int rem = x % 10;
         reverse = reverse * 10 + rem;
         x = x /10;
       }
       if(n == reverse){
        return true;
    }
     return false;
    }

    public static void main(String[] args) {
        palindrome sol = new palindrome();
        int x = 121;
        boolean result = sol.isPalindrome(x);
        System.out.println(result); // Output: true
    }
}