#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        x1=max(A,E)
        y1=max(B,F)
        x2=min(C,G)
        y2=min(D,H)
        s1=(C-A)*(D-B)
        s2=(G-E)*(H-F)
        return s1+s2-((x2-x1)*(y2-y1) if x2>x1 and y2>y1 else 0)