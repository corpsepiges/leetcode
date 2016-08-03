public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a0, Integer a1) {
                if (a0 > a1) {
                    return -1;
                } else if (a0 < a1) {
                    return 1;
                }
                return 0;
            }
        });// 最大堆
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ((i + 1) * (j + 1) > k) {
                    break;
                }
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}