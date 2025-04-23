class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int x = digitSum(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            maxSize = Math.max(maxSize, map.get(x));
        }

        for (int num : map.values()) {
            if (num == maxSize) count++;
        }
        return count;
    }
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}