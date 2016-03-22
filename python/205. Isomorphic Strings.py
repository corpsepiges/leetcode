#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s)!=len(t):
            return False
        smap={}
        tmap={}
        for i in range(len(s)):
            if smap.get(s[i]) or tmap.get(t[i]):
                if smap.get(s[i])!=t[i] or tmap.get(t[i])!=s[i]:
                    return False
            smap[s[i]]=t[i]
            tmap[t[i]]=s[i]
        return True