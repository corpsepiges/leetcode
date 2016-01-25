#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n<0:
            return 1.0/self.myPow(x,-n)
        if n==0:
            return 1.0
        v=self.myPow(x,n/2)
        return v*v*(x if n%2==1 else 1)