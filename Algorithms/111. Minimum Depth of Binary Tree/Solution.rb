# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer}
def min_depth(root)
    if root
        left=root.left ? min_depth(root.left) : nil
        right=root.right ? min_depth(root.right) : nil
        left= left ? left : (right ? right : 0)
        right= right ? right : (left ? left : 0)
        return 1+[left,right].min()
    else
        return 0
    end
end