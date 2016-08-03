# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} preorder
# @param {Integer[]} inorder
# @return {TreeNode}
def build_tree(preorder, inorder)
    if preorder.length==0
        return nil
    end
    root=TreeNode.new(preorder[0])
    mid=0
    while inorder[mid]!=preorder[0]
        mid+=1
    end
    root.left=build_tree(preorder[1...mid+1], inorder[0...mid])
    root.right=build_tree(preorder[mid+1...preorder.length], inorder[mid+1...inorder.length])
    return root
end