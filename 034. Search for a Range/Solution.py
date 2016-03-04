#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        arrays=self.search(nums,0,len(nums)-1,target)
        return [arrays[0],arrays[-1]] if len(arrays)>0 else [-1,-1]
    def search(self,nums,s,e,target):
        if s>e:
            return []
        if s==e and nums[s]==target:
            return [s]
        m=(s+e)/2
        if nums[m]<target:
            return self.search(nums,m+1,e,target)
        elif nums[m]>target:
            return self.search(nums,s,m-1,target)
        else:
            arrays=self.search(nums,s,m-1,target)
            arrays.extend([m])
            arrays.extend(self.search(nums,m+1,e,target))
            return arrays