#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        index=list(self.f(nums,[]))
        ans=[[]]
        for ind in index:
            a=[]
            for i in ind:
                a.append(nums[i])
            if a not in ans:
                ans.append(a)
        return ans

    def f(self,nums,state):
        """
        :type nums: List[int]
        :type state: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            if len(state)==0 or i>state[-1]:
                yield [i]
                for result in self.f(nums,state+[i]):
                    yield [i]+result