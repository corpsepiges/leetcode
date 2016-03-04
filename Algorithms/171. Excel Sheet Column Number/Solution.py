#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans=0
        for c in s:
            ans=ans*26+ord(c)-64
        return ans