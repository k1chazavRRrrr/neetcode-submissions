class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] buckets = new int[26];
        for(int i = 0; i < s.length(); i++){
            buckets[s.charAt(i) - 'a']++;
            buckets[t.charAt(i) - 'a']--;
        }

        for(int n : buckets){
            if (n != 0) return false;
        }
        return true;
    }
}
