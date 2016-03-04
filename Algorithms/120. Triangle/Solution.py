#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def __init__(self):
        self.map={}
        self.tri=[[]]
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        self.tri=triangle
        self.map={}
        return self.f(0,0)
    def f(self,x,y):
        if x>=len(self.tri):
            return 0
        ans=self.map.get(str(x)+','+str(y))
        if ans is  None:
            ans=min(self.f(x+1,y),self.f(x+1,y+1))+self.tri[x][y]
            self.map[str(x)+','+str(y)]=ans
        return ans
