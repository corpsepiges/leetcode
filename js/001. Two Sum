/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
	var map={}
	for (var i = 0; i < nums.length; i++) {
		map[target-nums[i]]=i
	}
	for (var i = 0; i < nums.length; i++) {
		other=map[nums[i]]
		if (other!= undefined && i !=other) {
			return [i,other]
		}
	}
};