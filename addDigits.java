public class addDigits {
   
    public int addDigits(int num) {
        return 1 + (num-1) % 9;
    }


    public static void main(String[] args) {
        addDigits sol = new addDigits();
        int num = 38;
        int result = sol.addDigits(num);
        System.out.println(result); // Output: 2
}
}