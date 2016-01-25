#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        matrix= [([0] * n) for i in range(m)]
        for i in range(m):
            for j in range(n):
                if i==0 or j==0:
                    matrix[i][j]=1
                else:
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1]
        return matrix[m-1][n-1]