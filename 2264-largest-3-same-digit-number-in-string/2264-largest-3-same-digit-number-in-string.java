class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String curr = num.substring(i, i + 3);
                if (curr.equals("999")) return "999";
                if (curr.compareTo(res) > 0) {
                    res = curr;
                }
            }
        }
        return res;
    }
}