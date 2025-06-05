class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] counter = new int[2];
        for (int i = 0; i < students.length; i++) {
            counter[students[i]]++;
        }

        int rem = sandwiches.length;
        for (int sandwich : sandwiches) {
            if (counter[sandwich] == 0) break;
            rem--;
            counter[sandwich]--;
        }
        return rem;
    }
}