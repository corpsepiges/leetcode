public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (H-F)*(G-E)+(D-B)*(C-A)-(((H>D?D:H)>(F>B?F:B))?((H>D?D:H)-(F>B?F:B)):0)*((G>C?C:G)>(E>A?E:A)?((G>C?C:G)-(E>A?E:A)):0);
    }
}