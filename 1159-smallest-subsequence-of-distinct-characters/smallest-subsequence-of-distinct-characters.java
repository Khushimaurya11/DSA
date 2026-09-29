class Solution {
    public String smallestSubsequence(String s) {
        
        int n = s.length();
        int[] lastIndex = new int[26];
        boolean[] taken = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< n; i++){
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i;
        }
        for(int i = 0; i< n; i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if(taken[idx]){
                continue;
            }
          while(sb.length()>0 && sb.charAt(sb.length() -1) > ch && lastIndex[sb.charAt(sb.length()-1) - 'a'] > i){
            char removed = sb.charAt(sb.length()-1);
            
            taken[removed - 'a'] = false;
            sb.deleteCharAt(sb.length()-1);
          }

          sb.append(ch);
          taken[idx] = true;
        }
   return sb.toString();

    }
}