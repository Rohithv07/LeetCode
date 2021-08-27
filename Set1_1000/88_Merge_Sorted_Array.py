class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        temp = nums1[:m]
        nums1.clear()
        nums1.extend(temp)
        nums1.extend(nums2)
        nums1.sort()
