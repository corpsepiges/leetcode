#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s)!=len(t):
            return False
        sm={};
        tm={};
        for i in range(len(s)):
            if sm.get(s[i]) is None:
                sm[s[i]]=0
            else:
                sm[s[i]]+=1
            if tm.get(t[i]) is None:
                tm[t[i]]=0
            else:
                tm[t[i]]+=1
        for i in range(len(s)):
            if sm.get(s[i])!=tm.get(s[i]):
                return False
        return True