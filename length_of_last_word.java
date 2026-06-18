public class length_of_last_word {
    
    public int lengthOfLastWord(String s) {
        
        int i = s.length() - 1;
        
        while( i>=0 && s.charAt(i) == ' '){
            
            i--;
        }
        int count = 0;
        while( i>=0 && s.charAt(i) != ' '){
            count++;
            i--;
        }
     return count;
        
}

    public static void main(String[] args) {
        length_of_last_word sol = new length_of_last_word();
        String s = "Hello World";
        int result = sol.lengthOfLastWord(s);
        System.out.println(result); // Output: 5
}}
