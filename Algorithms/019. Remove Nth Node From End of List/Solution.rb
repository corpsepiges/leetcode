# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @param {Integer} n
# @return {ListNode}
def remove_nth_from_end(head, n)
    node=head
    length=0
    while node
        node=node.next
        length+=1
    end
    return remove_nth_from_start(head,length-n+1)
end

def remove_nth_from_start(head,n)
    if n==1
        return head.next
    end
    head.next=remove_nth_from_start(head.next,n-1)
    return head
end