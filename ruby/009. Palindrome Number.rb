# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
    return x>=0 && x==x.to_s.reverse.to_i
end