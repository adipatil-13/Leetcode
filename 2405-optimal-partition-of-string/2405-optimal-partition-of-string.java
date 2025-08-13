    class Solution {
        public int partitionString(String s) {
            int res = 1;
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    res++;
                    set.clear();
                }
                set.add(c);
            }
            return res;
        }
    }