class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, score = 0;
        int l = 0, r = tokens.length - 1;

        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                score++;
                l++;
                res = Math.max(res, score);
            } else if (score > 0) {
                power += tokens[r];
                score--;
                r--;
            } else {
                break;
            }
        }
        return res;
    }
}