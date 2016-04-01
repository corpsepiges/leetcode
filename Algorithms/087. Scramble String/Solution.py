#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        if s1==s2:
            return True
        if not self.hasSameChars(s1,s2):
            return False;
        for i in range(1,len(s1)):
            if self.isScramble(s1[:i],s2[:i]) and self.isScramble(s1[i:],s2[i:]):
                return True
            if self.isScramble(s1[:i],s2[len(s1)-i:]) and self.isScramble(s1[i:],s2[:len(s1)-i]):
                return True
        return False

    def hasSameChars(self,s1,s2):
        if len(s1)!=len(s2):
            return False
        bits=[0]*26
        for i in range(len(s1)):
            bits[ord(s1[i])-97]+=1
            bits[ord(s2[i])-97]-=1
        for bit in bits:
            if bit!=0:
                return False
        return True