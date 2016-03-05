#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        if n!=0:
            k%=n
            ans=nums[-k:]+nums[:-k]
            for i in range(n):
                nums[i]=ans[i]