#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        mstep=len(matrix)
        if mstep==0:
            return []
        nstep=len(matrix[0])
        direction=0
        x=0
        y=-1
        ans=[]
        while mstep>0 and nstep>0:
            if direction%2==0:
                for i in range(1,nstep+1):
                    y+= 1 if direction%4==0 else -1
                    ans.append(matrix[x][y])
                mstep-=1
            else:
                for i in range(1,mstep+1):
                    x+= 1 if direction%4==1 else -1
                    ans.append(matrix[x][y])
                nstep-=1
            direction+=1
        return ans