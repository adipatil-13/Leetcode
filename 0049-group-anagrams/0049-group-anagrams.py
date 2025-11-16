class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for s in strs:
            sortS = ''.join(sorted(s))
            res[sortS].append(s)
        return list(res.values())
