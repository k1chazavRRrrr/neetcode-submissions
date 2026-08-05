class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for(int n : nums){
            seen.add(n);
        }
        int longestStreak = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(!seen.contains(nums[i] - 1)){
                int streak = 1;
                while(seen.contains(nums[i] + streak)){
                    streak++;
                }
                if(streak > longestStreak){
                    longestStreak = streak;
                }
            }
        }
        return longestStreak;
    }
}
