public class NumArray {
    class TreeNode {
        int start = 0;
        int end = 0;
        int sum = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    TreeNode root = null; 
    public NumArray(int[] nums) {
        if (nums!=null&&nums.length>0) {
            this.root=bulidTree(0, nums.length-1, nums);
        }
    }
    public TreeNode bulidTree(int start,int end,int[] nums){
        TreeNode node=new TreeNode();
        node.start=start;
        node.end=end;
        if (start==end) {
            node.sum=nums[start];
        }else{
            int mid=start+(end-start)/2;
            node.left=bulidTree(start, mid, nums);
            node.right=bulidTree(mid+1, end, nums);
            node.sum=node.left.sum+node.right.sum;
        }
        return node;
    }

    void update(int i, int val) {
        updateTree(this.root, i, val);
    }
    public void updateTree(TreeNode node,int index,int val){
        if (node!=null) {
            if (node.start==node.end) {
                node.sum=val;
            }else {
                int mid=node.start+(node.end-node.start)/2;
                if (index<=mid) {
                    updateTree(node.left, index, val);
                }else{
                    updateTree(node.right, index, val);
                }
                node.sum=node.left.sum+node.right.sum;
            }
        }
    }

    public int sumRange(int i, int j) {
        return queryTree(this.root, i, j);
    }
    
    public int queryTree(TreeNode node,int start,int end){
        if (node==null) {
            return 0;
        }
        if (node.start==start&&node.end==end) {
            return node.sum;
        }
        int mid=node.start+(node.end-node.start)/2;
        if (mid>=end) {
            return queryTree(node.left, start, end);
        }else if (mid<start) {
            return queryTree(node.right, start, end);
        }else{
            return queryTree(node.left, start, mid)+queryTree(node.right, mid+1, end);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);