#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    _dict={}
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        if self._dict.__len__()==0:
            for j in range(4000):
                i=j
                one=i%10
                i/=10
                ten=i%10
                i/=10
                h=i%10
                i/=10
                t=i
                ans='M'*t+'C'*h+'X'*ten+'I'*one
                if ans.__contains__('I'*9):
                    ans=ans.replace('I'*9,'IX')
                if ans.__contains__('I'*5):
                    ans=ans.replace('I'*5,'V')
                if ans.__contains__('I'*4):
                    ans=ans.replace('I'*4,'IV')

                if ans.__contains__('X'*9):
                    ans=ans.replace('X'*9,'XC')
                if ans.__contains__('X'*5):
                    ans=ans.replace('X'*5,'L')
                if ans.__contains__('X'*4):
                    ans=ans.replace('X'*4,'XL')

                if ans.__contains__('C'*9):
                    ans=ans.replace('C'*9,'CM')
                if ans.__contains__('C'*5):
                    ans=ans.replace('C'*5,'D')
                if ans.__contains__('C'*4):
                    ans=ans.replace('C'*4,'CD')
                self._dict[ans]=j
        return self._dict.get(s)