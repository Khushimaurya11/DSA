class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
       
      for(int i = 0; i< operations.length;i++){
                if (Character.isDigit(operations[i].charAt(0))) {
                   st.push(Integer.parseInt(operations[i]));
    }
            else if(operations[i].equals("C")){
                st.pop();
            }
           else if(operations[i].equals("D")){
                int top = st.peek();
                 st.push(2 * top);
            }
           else if(operations[i].equals("+")){
                int first = st.pop();
                int second = st.peek();
                st.push(first);
                st.push(first + second);
            }
            else {
                 st.push(Integer.parseInt(operations[i]));
            }
      }
       int ans = 0;
            while(st.size() != 0){
                ans = ans + st.pop();
            }
    return ans;
    }
}