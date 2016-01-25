#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n<3:
            return n
        ans=[]
        ans.append(1)
        ans.append(2)
        for i in range(2,n):
            ans.append(ans[-1]+ans[-2])
        return ans[-1]