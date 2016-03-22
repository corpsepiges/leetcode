#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        d={}
        for i in range(len(nums)):
            if d.get(nums[i]) is not None and i-d[nums[i]]<=k:
                return True
            d[nums[i]]=i
        return False