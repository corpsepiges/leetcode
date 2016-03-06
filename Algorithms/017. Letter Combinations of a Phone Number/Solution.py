#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    keyboard={}
    keyboard['2']=list('abc')
    keyboard['3']=list('def')
    keyboard['4']=list('ghi')
    keyboard['5']=list('jkl')
    keyboard['6']=list('mno')
    keyboard['7']=list('pqrs')
    keyboard['8']=list('tuv')
    keyboard['9']=list('wxyz')
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        return list(self.f(digits,'')) if len(digits)>0 else []
    def f(self,string,state):
        for v in self.keyboard.get(string[0]):
            if len(string)==1:
                yield v
            else:
                for result in self.f(string[1:],state+v):
                    yield v+result