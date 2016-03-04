public class NumArray {
    int[] arrays=null;
    public NumArray(int[] nums) {
        arrays=nums;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int a=i;a<=j;a++){
            sum+=arrays[a];
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);