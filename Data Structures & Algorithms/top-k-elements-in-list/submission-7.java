class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // [1, 1, 1] n times - [1];
        // [1, 1, 2, 2] both 2 times - [2, 1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        } 
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            if(buckets[map.get(key)] == null){
                buckets[map.get(key)] = new ArrayList<Integer>();
            }
            buckets[map.get(key)].add(key);
        }
        //[1,2,2,3,3,3]
        // buckets 
        // buckets[6] = null
        // buckets[5] = null
        // ...
        //buckets[3] = [3];
        //buckets[2] = [2];
        //buckets[1] = [1];

        int[] result = new int[k];
        int counter = 0;
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
