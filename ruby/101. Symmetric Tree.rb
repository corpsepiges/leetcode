# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Boolean}
def is_symmetric(root)
    return ! root || is_same(root.left,root.right)
end

def is_same(left,right)
    return left && right ? left.val==right.val && is_same(left.left,right.right) && is_same(left.right,right.left) : left==right
end