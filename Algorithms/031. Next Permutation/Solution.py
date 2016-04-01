#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        start=-1
        for i in range(len(nums)-2,-1,-1):
            if nums[i]<nums[i+1]:
               start=i
               break
        if start==-1:
            nums.sort()
        else:
            end=0
            for i in range(start+1,len(nums)):
                if nums[i]>nums[start]:
                    end=i
            arrays=nums[start:end]+nums[end+1:]
            arrays.sort()
            nums[start]=nums[end]
            for i in range(start+1,len(nums)):
                nums[i]=arrays[i-start-1]