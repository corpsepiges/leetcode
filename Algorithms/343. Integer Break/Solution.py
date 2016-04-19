#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _map={2:2,3:3}
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        return n-1 if n<4 else self.f(n)
    def f(self,n):
        if not self._map.get(n):
            ans=0
            for i in range(2,n-1):
                test=self.f(i)*self.f(n-i)
                ans=test if test>ans else ans
            self._map[n]=ans
        return self._map.get(n)