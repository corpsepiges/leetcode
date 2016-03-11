#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        low=0
        mid=0
        high=len(nums)-1
        while mid<=high:
            if nums[mid]==2:
                nums[mid]=nums[high]
                nums[high]=2
                high-=1
            elif nums[mid]==1:
                mid+=1
            else:
                nums[low]=0
                if mid!=low:
                    nums[mid]=1
                low+=1
                mid+=1
        print nums