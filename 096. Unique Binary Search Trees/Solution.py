#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def __init__(self):
        self.map={}
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<=1 :
            return 1
        if n not in self.map:
            ans=0
            for i in range(0,n):
                ans+=(self.numTrees(i)*self.numTrees(n-1-i))
            self.map[n]=ans
        else :
            ans=self.map[n]
        return ans