// 13ms

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) return false;
            } else if (map.containsValue(tChar)) {
                return false;
            }

            map.put(sChar, tChar);
        }
        return true;
    }
}

// 8 ms

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] charS = new int[200];
        int[] charT = new int[200]; 
        
        if(s.length() != t.length()) {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(charS[s.charAt(i)] != charT[t.charAt(i)]) {
                return false; 
            }
            charS[s.charAt(i)] = i + 1;
            charT[t.charAt(i)] = i + 1; 
        }
        return true;
    }
}
