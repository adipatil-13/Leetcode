    class Solution {
        public int partitionString(String s) {
            boolean[] seen = new boolean[26];
            int count = 1;

            for (char ch : s.toCharArray()) {
                if (seen[ch - 'a']) {
                    count++;
                    seen = new boolean[26];
                }
                seen[ch - 'a'] = true;
            }
            return count;
        }
    }