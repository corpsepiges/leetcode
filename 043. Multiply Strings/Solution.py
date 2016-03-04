#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1=='0' or num2=='0':
            return '0'
        l1=len(num1)
        l2=len(num2)
        l=l1+l2-1
        ans=[0]*l
        sum=0
        carry=0
        for i in range(1,l+1):
            sum=0
            for a1 in range(i):
                a2=i-a1
                a1+=1
                if a1<=l1 and a2<=l2:
                    sum+=(int(num1[-a1])*int(num2[-a2]))
            sum+=carry
            carry=sum/10
            ans[-i]=sum%10
        res='' if carry==0 else str(carry)
        for a in ans:
            res+=str(a)
        return res