Bruteforce:

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++){
            int num = nums[i];
            int cnt = 0;

            for(int j = 0; j<n; j++){
                if(nums[j] == num){
                    cnt++;
                }
            }
            if(cnt == 1){
                return num;
            }
        }
        return 0;
    }
}

Better:

class Solution {
    public int singleNumber(int[] nums) {
        int max = nums[0];

        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] hash = new int[max + 1];

        for(int i = 0; i<nums.length; i++){
            hash[nums[i]]++;
        }
        for(int i = 0; i<nums.length; i++){
            if(hash[nums[i]]==1){
                return nums[i];
            }
        }
        return -1;
    }
}

Optimal:

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        for(int i = 0; i<nums.length; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}
