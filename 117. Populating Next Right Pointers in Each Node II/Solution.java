/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root!=null) {
        	TreeLinkNode rootNext=root.next;
        	TreeLinkNode sonNext=null;
        	while (rootNext!=null&&sonNext==null) {
				if (rootNext.left!=null) {
					sonNext=rootNext.left;
				}else {
					sonNext=rootNext.right;
				}
				rootNext=rootNext.next;
			}
        	if (root.left!=null) {
				if (root.right!=null) {
					root.left.next=root.right;
				}else {
					root.left.next=sonNext;
				}
			}
        	if (root.right!=null) {
				root.right.next=sonNext;
			}
        	connect(root.right);
        	connect(root.left);
		}
    }
}