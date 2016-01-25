#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if(x==0):
            return 0
        flag=False
        if(x<0):
            flag=True
            x=0-x
        ans=0
        while x!=0:
            ans=10*ans+x%10
            x/=10
            print ('ans',ans)
        if(flag):
            ans=0-ans
        if(ans>2147483647 or ans<-2147483648):
            return 0
        return ans


x=1000
print str(x).strip('0')[::-1] if x>0 else '-'+str(-x).strip('0')[::-1]
