#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        a=0
        for i in range(32):
            a=a*2+n%2
            n/=2
        return a