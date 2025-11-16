class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        mapS, mapT = {}, {}
        for c in range(len(s)):
            mapS[s[c]] = 1 + mapS.get(s[c], 0)
            mapT[t[c]] = 1 + mapT.get(t[c], 0)
        return mapS == mapT