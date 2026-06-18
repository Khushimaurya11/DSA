public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            if(n%2 == 1) count++;
            n = n / 2;
        }
    return count;
    }


    public static void main(String[] args) {
        HammingWeight sol = new HammingWeight();
        int n = 11; // Binary representation: 1011
        int result = sol.hammingWeight(n);
        System.out.println(result); // Output: 3
    }
}