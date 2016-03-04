#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)<3:
            return len(nums)
        sign=nums[0]
        flag=False
        i=1
        while i<len(nums):
            if sign==nums[i]:
                if flag:
                    nums.remove(sign)
                    i-=1
                else:
                    flag=True
            else:
                sign=nums[i]
                flag=False
            i+=1
        return len(nums)