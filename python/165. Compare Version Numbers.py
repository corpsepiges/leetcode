#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1=version1.split('.')
        v2=version2.split('.')
        for i in range(max(len(v1),len(v2))):
            a1=int(v1[i]) if i<len(v1) else 0
            a2=int(v2[i]) if i<len(v2) else 0
            if a1>a2:
                return 1
            if a1<a2:
                return -1
        return 0