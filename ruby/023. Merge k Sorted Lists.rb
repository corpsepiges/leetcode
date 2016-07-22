# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode[]} lists
# @return {ListNode}
def merge_k_lists(lists)
    l=lists.length
    if l<=2
        return merge_two_lists(lists[0],l==2 ? lists[1] : nil)
    end
    return merge_two_lists(merge_k_lists(lists[0,l/2]),merge_k_lists(lists[l/2,l-l/2]))
end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def merge_two_lists(l1, l2)
    if not l1
        return l2
    end
    if not l2
        return l1
    end
    if l1.val > l2.val
        return merge_two_lists(l2, l1)
    end
    l1.next=merge_two_lists(l1.next,l2)
    return l1
end