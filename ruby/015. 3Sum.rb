# @param {Integer[]} nums
# @return {Integer[][]}
def three_sum(nums)
    nums=nums.sort
    length=nums.length
    ans=[]
    for i in 0..length-3
        if i==0 || nums[i]!=nums[i-1]
            s,e=i+1 , length-1
            while s<e
                test=nums[i]+nums[s]+nums[e]
                if test==0
                    ans.push([nums[i],nums[s],nums[e]])
                end
                if test<=0
                    while nums[s]==nums[s+1]
                        s+=1
                    end
                    s+=1
                end
                if test>=0
                    while nums[e]==nums[e-1]
                        e-=1
                    end
                    e-=1
                end
            end
        end
    end
    return ans
end
