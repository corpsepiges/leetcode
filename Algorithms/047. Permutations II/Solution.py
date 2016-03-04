#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return list(self.f(nums,[]))
    def f(self,nums,state):
        if len(nums)==0:
            yield []
        else:
            intMap={}
            for i in range(len(nums)):
                if intMap.get(nums[i]) is None:
                    #过滤掉重复的组合
                    intMap[nums[i]]=1
                    for result in self.f(nums[0:i]+nums[i+1:],state+[nums[i]]):
                        yield [nums[i]]+result