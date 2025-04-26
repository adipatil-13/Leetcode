class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int l, String s, List<String> currPath, List<List<String>> res) {
        if (l == s.length()) {
            res.add(new ArrayList<>(currPath));
            return;
        }

        for (int r = l; r < s.length(); r++) {
            if (isPalindrome(s, l, r)) {
                // Since substring is inclusive of starting index & exclusive of ending index, we use r + 1 to include character at index r.
                currPath.add(s.substring(l, r + 1));
                backtrack(r + 1, s, currPath, res);
                currPath.remove(currPath.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}