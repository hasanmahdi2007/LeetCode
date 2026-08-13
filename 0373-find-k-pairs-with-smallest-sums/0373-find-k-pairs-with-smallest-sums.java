class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (b[1] + b[0]) - (a[0] + a[1]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            for(int j = 0; j < Math.min(k, nums2.length); j++){
                if(heap.size() < k){
                    heap.add(new int[] {nums1[i], nums2[j]});
                } else {
                    int[] max = heap.peek();
                    int maxSum = max[0] + max[1];
                    int currentSum = nums1[i] + nums2[j];
                    if(maxSum <= currentSum) break;
                    else {
                        heap.poll();
                        heap.add(new int[] {nums1[i], nums2[j]});
                    }
                }
            }
        }

        while (!heap.isEmpty()) {
            int[] pair = heap.poll();
            ans.add(List.of(pair[0], pair[1]));
        }
        return ans;
    }
}