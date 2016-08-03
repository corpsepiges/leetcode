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
def is_balanced(root)
    return ! root || ((deep(root.left)-deep(root.right)).abs<=1 && is_balanced(root.left) && is_balanced(root.right))
end

def deep(root)
    return root ? 1+[deep(root.left), deep(root.right)].max : 0
end