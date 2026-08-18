class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int i : map.keySet()){
            if(buckets[map.get(i)] == null) buckets[map.get(i)] = new ArrayList();
            buckets[map.get(i)].add(i);
        }

        int counter = 0;
        int[] res = new int[k];
        for(int i = buckets.length - 1; i > 0 && counter < k; i--){
            if(buckets[i] == null) continue;
            for(int j : buckets[i]){
                res[counter] = j;
                counter++;
            }
            if(counter == k){
                break;
            }
        }
        return res;
    }
}
