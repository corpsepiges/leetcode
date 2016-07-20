# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    map={}
    index=0
    nums.each{|num| map[(target-num)]=index;index+=1}
    puts map
    for i in 0..nums.size
        print i,nums[i],map[nums[i]]
        if map[nums[i]] && i!=map[nums[i]]
            return [i,map[nums[i]]]
        end
    end
    return []
end