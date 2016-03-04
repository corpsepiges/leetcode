#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return [[]]+list(self.f(nums,[]))

    def f(self,nums,state):
        """
        :type nums: List[int]
        :type state: List[int]
        :rtype: List[int]
        """
        for num in nums:
            if len(state)==0 or num>state[-1]:
                yield [num]
                for result in self.f(nums,state+[num]):
                    yield [num]+result