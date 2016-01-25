#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        strs=s.split(' ')
        for i in range(len(strs)-1,-1,-1):
            if len(strs[i])!=0 : return len(strs[i])
        return 0