# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    return add(l1,l2,0)
end

def add(l1,l2,f)
    if not l1 and not l2 and f==0
        return nil
    end
    ans=f +(l1 ? l1.val : 0)+(l2 ? l2.val : 0)
    res=ListNode.new(ans%10)
    res.next=add(l1 ? l1.next : nil,l2 ? l2.next : nil,ans/10)
    return res
end