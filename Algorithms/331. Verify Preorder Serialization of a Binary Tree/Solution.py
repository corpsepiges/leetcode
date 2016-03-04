#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        strs=preorder.split(',')
        return self.isVail(strs)
    def isVail(self,strs):
        """
        :type strs: List[str]
        :rtype: bool
        """
        l=len(strs)
        if l<3:
            return l==1 and strs[0]=='#'
        for i in range(l-2):
            if strs[i+1]=='#' and strs[i+2]=='#':
                if strs[i]=='#':
                    return False
                strs[i:i+3]='#'
                return self.isVail(strs)
        return False