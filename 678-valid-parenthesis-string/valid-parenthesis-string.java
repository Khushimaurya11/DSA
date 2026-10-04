class Solution {
    Boolean[][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n + 1];
        return solve(s, 0, 0);
    }

    private boolean solve(String s, int i, int open) {
        if (i == s.length()) {
            return open == 0;
        }

        if (memo[i][open] != null) {
            return memo[i][open];
        }

        char c = s.charAt(i);

        if (c == '(') {
            return memo[i][open] = solve(s, i + 1, open + 1);
        }
        
        if (c == ')') {
            if (open == 0) return memo[i][open] = false;
            return memo[i][open] = solve(s, i + 1, open - 1);
        }

        // Case when c == '*'
        boolean placeOpen = solve(s, i + 1, open + 1);
        boolean placeClose = (open > 0) && solve(s, i + 1, open - 1);
        boolean ignore = solve(s, i + 1, open);

        return memo[i][open] = placeOpen || placeClose || ignore;
    }
}