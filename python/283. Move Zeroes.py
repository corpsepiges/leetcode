#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i=0
        j=-1
        while i < len(nums):
            if nums[i]==0:
                if j==-1:
                    j=i+1
                else:
                    j+=1
                while j<len(nums):
                    if nums[j]!=0:
                        t=nums[i]
                        nums[i]=nums[j]
                        nums[j]=t
                        break;
                    else:
                        j+=1
            i+=1