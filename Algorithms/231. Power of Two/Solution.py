#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n==0:
            return False
        while n!=1:
            if n%2!=0:
                return False
            n/=2
        return True