#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if target<nums[0]:
            return 0
        end=len(nums)-1
        if target>nums[end]:
            return end+1
        start=0
        while start<end-1:
            mid=(start+end)/2
            if nums[mid]==target:
                return mid
            if nums[mid]<target:
                start=mid
            else:
                end=mid
        return start if nums[start]==target else end