#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        i=0
        j=len(s)-1
        a=list('aeiouAEIOU')
        s=list(s)
        while i<j:
            while i<j and s[i] not in a:
                i+=1
            while i<j and s[j] not in a:
                j-=1
            if i<j:
                temp=s[i]
                s[i]=s[j]
                s[j]=temp
                i+=1
                j-=1
        return ''.join(s)