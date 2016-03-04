#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        s=list(secret)
        g=list(guess)
        a=0
        b=0
        i=0
        while i<len(s):
            if s[i]==g[i]:
                a+=1
                s.remove(s[i])
                g.remove(g[i])
            else:
                i+=1
        i=0
        while i<len(g):
            if g[i] in s:
                s.remove(g[i])
                g.remove(g[i])
                b+=1
            else:
                i+=1
        return str(a)+'A'+str(b)+'B'