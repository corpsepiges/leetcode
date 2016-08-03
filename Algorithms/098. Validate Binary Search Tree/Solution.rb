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
def is_valid_bst(root)
    return is_valid(root,nil,nil)
end

def is_valid(root, min, max)
    return !root || ((!max || root.val< max) && (! min || root.val >min) && is_valid(root.left,min,root.val) && is_valid(root.right,root.val,max))
end