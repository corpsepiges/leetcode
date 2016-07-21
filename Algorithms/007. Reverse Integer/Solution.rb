# @param {Integer} x
# @return {Integer}
def reverse(x)
    ans = x<0 ?( "-"+x.to_s[1,x.to_s.length].reverse).to_i : x.to_s.reverse.to_i
    return (ans >= -2147483648 and ans <= 2147483647 )? ans : 0
end