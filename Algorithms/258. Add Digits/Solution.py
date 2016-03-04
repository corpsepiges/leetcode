#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        return 0 if num==0 else (num-1)%9+1