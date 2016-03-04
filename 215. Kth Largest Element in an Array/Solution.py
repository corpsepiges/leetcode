#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        pivot = nums[len(nums)/2]
        left=[]
        right=[]
        for i in range(len(nums)):
            if nums[i]>pivot:
                right.append(nums[i])
            if nums[i]<pivot:
                left.append(nums[i])
        if len(right)>=k:
            return self.findKthLargest(right,k)
        if k>len(nums)-len(left):
            return self.findKthLargest(left,k-len(nums)+len(left))
        return pivot