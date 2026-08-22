class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int key : map.keySet()){
            if(buckets[map.get(key)] == null){
                buckets[map.get(key)] = new ArrayList();
            }
            buckets[map.get(key)].add(key);
        }

        int counter = 0;
        int[] result = new int[k];

        for(int i = buckets.length - 1; i > 0; i--){
            if(buckets[i] == null) continue;

            for(int j : buckets[i]){
                result[counter] = j;
                counter++;
                if(counter == k) break;
            }
            if(counter == k) break;
        }
        return result;
    }
}
