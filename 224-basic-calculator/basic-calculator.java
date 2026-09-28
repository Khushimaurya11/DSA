class Solution {
    public int calculate(String s) {
        int n = s.length();
        int number = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< n; i++){
            if(Character.isDigit(s.charAt(i))){
               number = (number*10) + (s.charAt(i) - '0');
            }else if(s.charAt(i) == '+'){
            result +=( number*sign);
            number = 0;
            sign = 1;
            }else if(s.charAt(i)== '-'){
                result += (number*sign);
                number = 0;
                sign = -1;
            }else if(s.charAt(i) == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
             result += (number * sign);
             number = 0;
                   int last_sign = st.peek() ;
                   st.pop();
                   int last_number = st.peek();
                   st.pop();
                   result = result * last_sign;
                    result = result + last_number;
            }
        }
        result += (number * sign);
        return result;
    }
}