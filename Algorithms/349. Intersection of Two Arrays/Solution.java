import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


//Definition for a binary tree node.


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<Integer>();
        Set<Integer> s2=new HashSet<Integer>();
        Set<Integer> ans=new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
        }
        for (Integer integer : s2) {
            if (s1.contains(integer)) {
                ans.add(integer);
            }
        }
        int[] res=new int[ans.size()];
        int a=0;
        for (Integer integer : ans) {
            res[a++]=integer;
        }
        return res;
    }
}