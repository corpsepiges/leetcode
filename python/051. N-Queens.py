#coding=utf-8
__author__ = 'xuxuan'
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        ans=[]
        for solution in list(self.f(n,())):
            a=[]
            for pos in solution:
                a.append('.'*(pos)+'Q'+'.'*(len(solution)-pos-1))
            ans.append(a)
        return ans
    def f(self,num,state):
    #这里的num表示每行的测试数据
        for pos in range(num):
            flag=True
            #校验，检测到False则停止，if条件写成一行
            for i in range(len(state)):
                #abs(state[i]-pos)如果等于0表示处于同一列
                #abs(state[i]-pos)如果等于len(state)-i表示处于斜线
                if abs(state[i]-pos) in (0,len(state)-i):flag=False;break
            #如果正确则继续进入生成器
            if flag :
                #如果当前的state已经只差一个结果，那么直接返回这次测试成功的值
                if len(state)==num-1:yield (pos,)
                else :
                    #否则继续测试
                    for result in self.f(num,state+(pos,)):
                        yield (pos,)+result