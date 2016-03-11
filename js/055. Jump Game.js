/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
	var distance=0;
	for (var i = 0; i < nums.length&&i<=distance; i++) {
		distance=Math.max(nums[i]+i,distance);
	}
	return distance>=nums.length-1;
};