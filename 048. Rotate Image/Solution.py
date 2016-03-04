#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n=len(matrix)-1
        state=0
        for x in range((n+1)/2):
            for y in range(n/2+1):
                state=matrix[x][y]
                matrix[x][y]=matrix[n-y][x]
                matrix[n-y][x]=matrix[n-x][n-y]
                matrix[n-x][n-y]=matrix[y][n-x]
                matrix[y][n-x]=state