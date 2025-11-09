class Solution {
    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                res += num1 / num2;
                num1 %= num2;
            } else {
                res += num2 / num1;
                num2 %= num1;
            }
        }
        return res;
    }
}
/*
num1 = 10, num2 = 4

num1 >= num2
→ res += 10 / 4 = 2
→ num1 = 10 % 4 = 2
Now (num1, num2) = (2, 4)

num1 < num2
→ res += 4 / 2 = 2
→ num2 = 4 % 2 = 0

Total res = 4
*/