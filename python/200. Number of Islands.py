#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _landform=[]
    _row=0
    _col=0
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        self._landform=[]
        self._row=len(grid)
        if self._row==0:
            return 0
        for s in grid:
            l=list(s)
            self._landform.append(l)
        self._col=len(grid[0])
        ans=0
        for x in range(self._row):
            for y in range(self._col):
                if self._landform[x][y]=='1':
                    ans+=1
                    self.explore(x,y)
        return ans

    def explore(self,x,y):
        if x>=0 and x<self._row and y>=0 and y<self._col and self._landform[x][y]=='1':
            self._landform[x][y]='2'
            self.explore(x-1,y)
            self.explore(x+1,y)
            self.explore(x,y-1)
            self.explore(x,y+1)