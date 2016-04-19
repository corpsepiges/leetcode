#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums[-1]=True
        index=len(nums)-2
        if index<0:
            return True
        while index>=0:
            length=nums[index]
            if index+length>=len(nums)-1:
                nums[index]=True
            else:
                flag=False
                for i in range(1,length+1):
                    if nums[index+i]:
                        flag=True
                        break
                nums[index]=flag
            index-=1
        return nums[0]