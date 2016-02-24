#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        ans= [[0 for col in range(n)] for row in range(n)]
        step=n
        direction=x=a=0
        y=-1
        while step>0:
            for i in range(1,step+1):
                a+=1
                if direction%2==0:
                    y+= 1 if direction%4==0 else -1
                else:
                    x+= 1 if direction%4==1 else -1
                ans[x][y]=a
            if direction%2==0:
                step-=1
            direction+=1
        return ans