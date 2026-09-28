class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i =0; i<n; i++){
           char ch = s.charAt(i);

           if(Character.isDigit(ch)){
            num = num *10 + (ch - '0');
           }

           if((!Character.isDigit(ch) && ch != ' ') || i == n-1){
            if(sign == '+'){
                st.push(num);
            }
           else if(sign == '-'){
                st.push(-num);
            }else if(sign == '*'){
                st.push(st.pop() * num);
            }
            else if(sign == '/'){
                st.push(st.pop() / num);
            }

            sign = ch;
            num = 0;
           }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}