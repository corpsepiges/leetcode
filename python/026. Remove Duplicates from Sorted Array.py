#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i=1
        while i<len(nums):
           if nums[i]==nums[i-1]:
               del nums[i]
           else:
               i+=1
        return len(nums)