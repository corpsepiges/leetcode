# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} inorder
# @param {Integer[]} postorder
# @return {TreeNode}
def build_tree(inorder, postorder)
    length=postorder.length
    if length==0
        return nil
    end
    root=TreeNode.new(postorder[length-1])
    mid=0
    while inorder[mid]!=postorder[length-1]
        mid+=1
    end
    root.left=build_tree(inorder[0...mid],postorder[0...mid])
    root.right=build_tree(inorder[mid+1...inorder.length],postorder[mid...length-1])
    return root
end