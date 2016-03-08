#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tar=0
        nums.append(0)
        l=len(nums)
        for i in range(l):
            b=i
            a=nums[i]
            while a>0 and a<l and a!=b:
                tar=nums[a]
                nums[a]=a
                b=a
                a=tar
        for i in range(1,len(nums)):
            if nums[i]!=i:
                return i
        return len(nums)