# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @param {Integer} k
# @return {Integer}
def kth_smallest(root, k)
    leftNum=calTreeNum(root.left)
    if leftNum+1==k
        return root.val
    end
    return leftNum+1>k ? kth_smallest(root.left, k) : kth_smallest(root.right, k-leftNum-1)
end

# @param {TreeNode} root
# @return {Integer}
def calTreeNum(root)
    return root ? 1+calTreeNum(root.left)+calTreeNum(root.right) : 0
end