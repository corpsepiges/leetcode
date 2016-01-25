#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        map={}
        for num in nums:
            if map.get(num) is None:
                map[num]=1
            else :
                return True
        return False