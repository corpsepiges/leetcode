#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        map={}
        while n!=1:
            if map.get(n) is None:
                map[n]=1
                string=str(n)
                sum=0
                for s in string:
                    i=int(s)
                    sum+=(i*i)
                n=sum
            else:
                return False
        return True