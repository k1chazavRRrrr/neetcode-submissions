class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap();
        for(String s : strs){
            int[] chars = new int[26];
            for(Character c : s.toCharArray()){
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars);

            result.putIfAbsent(key, new ArrayList());
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}
