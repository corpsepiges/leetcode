#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        nums=range(n+1)
        nums.remove(0)
        return list(self.f(nums,k,[]))
    def f(self,nums,k,state):
        for num in nums:
            if len(state)==0 or num>state[-1]:
                if len(state)==k-1:
                    yield [num]
                else:
                    for result in self.f(nums,k,state+[num]):
                        yield [num]+result