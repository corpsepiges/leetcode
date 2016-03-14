/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums.sort(compare);
    var ans=new Array();
    console.log(nums)
    for (var i = 0; i < nums.length; i++) {
    	if(i==0||nums[i]!=nums[i-1]){
    		var s=i+1
	    	var e=nums.length-1;
	    	while(s<e){
	    		var t=nums[i]+nums[s]+nums[e];
	    		if (t==0) {
	    			var a=[nums[i],nums[s],nums[e]];
	    			ans.push(a);
	    			while(nums[s+1]==nums[s]){
	    				s+=1
	    			}
	    			s+=1;
	    			e-=1;
	    		}else{
	    			if(t>0){
	    				e-=1;
	    			}else{
	    				s+=1;
	    			}
	    		}
	    	}
    	}
    }
    return ans
};
var compare = function(a,b){
	return a-b; 
}