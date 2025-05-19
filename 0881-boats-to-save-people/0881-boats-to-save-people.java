class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int l = 0, r = people.length - 1;

        while (l <= r) {
            if (people[r] + people[l] <= limit) l++;
            r--;
            res++;

        }
        return res;
    }
}