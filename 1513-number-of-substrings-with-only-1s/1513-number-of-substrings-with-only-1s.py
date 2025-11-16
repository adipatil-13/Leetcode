class Solution:
    def numSub(self, s: str) -> int:
        res, consec = 0, 0

        for i in range(len(s)):
            if s[i] == "0":
                res += consec * (consec + 1) // 2
                consec = 0
            else:
                consec += 1
        
        res += consec * (consec + 1) // 2
        res %= 10**9 + 7
        return res