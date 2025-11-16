class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map = Counter(nums)
        # for num in nums:
        #     map[num] = 1 + map.get(num, 0)
        
        heap = []
        # for num in map.keys():
        #     heapq.heappush(heap, (map[num], num))
        #     if len(heap) > k:
        #         heapq.heappop(heap)

        for num, cnt in map.items():
            heapq.heappush(heap, (cnt, num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        return res