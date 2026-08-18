class Solution {
    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        int l = 0;
        int r = height.length - 1;

        while( l < r){
            if(height[l] < height[r]){
                if(height[l] > leftMax) leftMax = height[l];
                else result += leftMax - height[l];
                l++;
            }else{
                if(height[r] > rightMax) rightMax = height[r];
                else result += rightMax - height[r];
                r--;
            }
        }
        return result;
    }
}
