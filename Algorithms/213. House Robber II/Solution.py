#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        if n==0:
            return 0
        if n==1:
            return nums[0]
        if n==2:
            return max(nums[0],nums[1])
        return max(self.robSimple(nums[:-1]),self.robSimple(nums[1:]))
    def robSimple(self,nums):
        n=len(nums)
        arrays=[nums[0],max(nums[0],nums[1])]
        for i in range(2,n):
            arrays.append(max(arrays[i-2]+nums[i],arrays[i-1]))
        return arrays[-1]