#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        flag=False
        la=len(a)
        lb=len(b)
        l=max(la,lb)
        ans=''
        for i in range(1,l+1):
            t=(0 if i>la else int(a[-i])) + (0 if i>lb else int(b[-i])) + (1 if flag else 0)
            ans=str(t%2)+ans
            flag=t/2==1
        return ('1' if flag else '') +ans