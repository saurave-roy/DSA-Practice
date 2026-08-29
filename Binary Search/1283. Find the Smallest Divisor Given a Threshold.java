class Solution {

    private int sumByD(int[] nums, int d){
        int sum = 0;
        for(int num:nums){
            sum += (num + d - 1) / d;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = 0;

        for(int num:nums){
            maxi = Math.max(maxi, num);
        }

        int low = 1;
        int high = maxi;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(sumByD(nums, mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
