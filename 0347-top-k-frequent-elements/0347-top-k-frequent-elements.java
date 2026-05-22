class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : counts.keySet()) {
            int frequency = counts.get(num);
            if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(num);
        }
        int[] final_arr = new int[k]; int index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    final_arr[index++] = num;
                    if (index == k) return final_arr;
                }
            }
        } return final_arr;
    }
}