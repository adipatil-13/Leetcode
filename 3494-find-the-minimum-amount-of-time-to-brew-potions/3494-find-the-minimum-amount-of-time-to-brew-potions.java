class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;

        long[] doneBy = new long[n];

        for (int j = 0; j < mana.length; j++) {
            long now = doneBy[0];

            for (int i = 1; i < n; i++) {
                now = Math.max(now + skill[i - 1] * mana[j], doneBy[i]);
            }

            doneBy[n - 1] = now + skill[n - 1] * mana[j];

            for (int i = n - 2; i >= 0; i--) {
                doneBy[i] = doneBy[i + 1] - skill[i + 1] * mana[j];
            }
        }
        return doneBy[n - 1];
    }
}
