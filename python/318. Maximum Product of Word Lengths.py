#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        l=len(words)
        if l==0:
            return 0
        mas=[]
        for word in words:
            a=0
            for s in word:
                a|=1<<(ord(s)-97)
            mas.append(a)
        ans=0
        for i in range(l-1):
            for j in range(i+1,l):
                if mas[i]&mas[j]==0 and len(words[i])*len(words[j])>ans:
                    ans=len(words[i])*len(words[j])
        return ans