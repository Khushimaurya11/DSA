class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            if (ans.length() == 0 && ch == '0') {
                continue;
            }
            ans.append(ch);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}