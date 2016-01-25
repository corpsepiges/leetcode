#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        l=str.split(' ')
        m1={}
        m2={}
        if len(pattern) !=len(l) :
            return False
        for i in range(len(pattern)):
            c=pattern[i]
            s=l[i]
            if m1.get(c) is None and m2.get(s) is None:
                m1[c]=s
                m2[s]=c
            elif m1.get(c) is not None and m2.get(s) is not None:
                if m1.get(c)!=s and m2.get(s)!=c:
                    return False
            else:
                return False
        return True