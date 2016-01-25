#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m=len(grid)
        n=len(grid[0])
        ans=[[0 for col in range(n)] for row in range(m)]
        for i in range(m):
            for j in range(n):
                ans[i][j]+=grid[i][j]
                if i!=0 and j!=0:
                    ans[i][j]+=min(ans[i-1][j],ans[i][j-1])
                elif i!=0:
                    ans[i][j]+=ans[i-1][j]
                elif j!=0:
                    ans[i][j]+=ans[i][j-1]
        print ans
        return ans[m-1][n-1]