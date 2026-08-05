class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // The maximum repetitive amount of number is nums.length
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i : map.keySet()){
            if(buckets[map.get(i)] == null){
                buckets[map.get(i)] = new ArrayList<Integer>();
            }
            buckets[map.get(i)].add(i);
        }
        int counter = 0;
        int[] result = new int[k];

        for(int i = buckets.length - 1; i > 0; i--){
            if(buckets[i] == null) continue;
            for(int bucket : buckets[i]){
                if(counter == k) break;
                result[counter] = bucket;
                counter++;
            }
            if(counter == k) break;
        }
        return result;
    }
}
