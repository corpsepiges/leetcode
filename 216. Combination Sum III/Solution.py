#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        return list(self.f(n,k,[]))
    def f(self,n,k,state):
        s=sum(state)
        for i in range((0 if s==0 else state[-1])+1,10):
            if len(state)==k-1 and i==n-s:
                yield [i]
            if len(state)<k-1 and s+2*i<n:
                for result in self.f(n,k,state+[i]):
                    yield [i]+result