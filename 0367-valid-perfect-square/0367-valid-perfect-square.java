class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        double left = 2, right = num / 2;
        while (left <= right) {
            double mid = Math.floor((left + right) / 2);
            double square = mid * mid;
            if (square == num) return true;
            else if (square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}