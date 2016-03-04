#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans=nums[0]
        sum=0
        for num in nums:
            sum+=num
            if(sum>ans):
                ans=sum
            if sum<0:
                sum=0
        return ans