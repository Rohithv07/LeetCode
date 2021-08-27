class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = collections.Counter(nums).most_common(k)
        return [ele for ele, counter in count]
