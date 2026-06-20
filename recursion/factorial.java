
public class factorial { 
        public static int fact(int n) {
        if(n < 0) return -1;
        if(n == 0){
            return 1;
        } else{
            return n * fact(n-1);
        }
    }

}
// TC O(n)