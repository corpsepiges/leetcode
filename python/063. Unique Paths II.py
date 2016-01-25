#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m=len(obstacleGrid)
        n=len(obstacleGrid[0])
        matrix= [([0] * n) for i in range(m)]
        print 'matrix[0][0]='+str(matrix[0][0])
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j]==1:
                    matrix[i][j]=0
                elif i==0 and j==0:
                    matrix[0][0]=1-obstacleGrid[0][0]
                else:
                    #负数是反向读第一个，为0，不影响结果
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1]
        return matrix[m-1][n-1]

