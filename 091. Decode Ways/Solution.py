#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        l=len(s)
        if l==0:
            return 0
        if l==1:
            return 0 if s=='0' else 1
        ans=[0]*l
        ans[-1]=(1 if int(s[-1])!=0 else 0)
        ans[-2]=0 if int(s[-2])==0 else (1 if int(s[-2:])<27 else 0)+ans[-1]
        i=l-3
        while i>=0:
            ans[i]=0 if int(s[i])==0 else (ans[i+1]+(ans[i+2] if int(s[i:i+2])<27 else 0))
            i-=1
        return ans[0]
