class Solution {
    public int maxDepth(String s) {
        int cnt = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                if (max < cnt) max = cnt;
            } else if (s.charAt(i) ==')') {
                cnt--;
            }
        }
        return max;
    }
}

/* Follow up: Return all characters that have the highest nesting depth as a character array.

class Solution {
    public char[] maxDepthChars(String s) {
        int cnt = 0, max = 0;
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                    result.clear();
                    result.add(c);
                } else if (cnt == max) {
                    result.add(c);
                }
            } else if (c == ')') {
                if (cnt == max) result.add(c);
                cnt--;
            }
        }
        char[] resArray = new char[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}
