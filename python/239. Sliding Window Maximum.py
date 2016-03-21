#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        ans=[]
        maxNum=[]
        for i in range(len(nums)):
            while len(maxNum)>0 and nums[i]>maxNum[-1]:
                maxNum=maxNum[:-1]
            maxNum.append(nums[i])
            if i+1>k and nums[i-k]==maxNum[0]:
                maxNum=maxNum[1:]
            ans.append(maxNum[0])
        return ans[k-1:]