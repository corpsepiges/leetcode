#coding=utf-8
__author__ = 'xuxuan'
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        return Solution().addTwo(l1,l2,False)
    def addTwo(self,l1,l2,flag):
        t=False
        val=0;
        if(l1):
            val+=l1.val
            t=True
        if(l2):
            val+=l2.val
            t=True
        if(flag):
            val+=1
            t=True
        if(val>=10):
            flag=True
            val-=10
        else :
            flag=False
        if(t):
            ans=ListNode(val)
            ans.next=Solution().addTwo(l1.next if l1 else None ,l2.next if l2 else None,flag)
            return ans
        else :
            return None


a=ListNode(0)
b=ListNode(0)
sol=Solution()
print sol.addTwoNumbers(a,b)