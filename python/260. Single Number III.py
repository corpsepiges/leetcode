#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums)==0:
            return nums
        t=reduce(lambda x, y: x ^ y, nums)
        t=t-(t&(t-1))
        t1=reduce(lambda x,y:x^y,filter(lambda x:x&t==0,nums))
        t2=reduce(lambda x,y:x^y,filter(lambda x:x&t!=0,nums))
        return [t1,t2]