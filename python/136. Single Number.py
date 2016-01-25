#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans=0
        for num in nums:
            ans^=num
        return ans