public class Solution {
    int[] init;
    public Solution(int[] nums) {
        init=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] random=new int[init.length];
        for (int i = 0; i < random.length; i++) {
            random[i]=i;
        }
        Random r=new Random();
        for (int i = random.length-1; i >= 0 ; i--) {
            int t=r.nextInt(i+1);
            int swap=random[i];
            random[i]=random[t];
            random[t]=swap;
        }
        for (int i = 0; i < random.length; i++) {
            random[i]=init[random[i]];
        }
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */