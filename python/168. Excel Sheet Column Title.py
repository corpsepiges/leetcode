#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        return '' if n==0 else self.convertToTitle((n-1)/26)+chr((n-1)%26+65)