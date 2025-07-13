class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length;
        int n = trainers.length;
        int i = 0, j = 0, cnt = 0;

        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                cnt++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cnt;
    }
}