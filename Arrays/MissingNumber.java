class Solution {
    public int missingNumber(int[] nums) {
        
        for(int i = 1; i <= nums.length; i++){
            int flag = 0;

            for(int j = 0; j < nums.length; j++){
                if(nums[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return 0;
    }
}

Better:
class Solution {
    public int missingNumber(int[] nums) {
        
        int[] hash = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            hash[nums[i]] = 1;
        }
        for(int  i = 1; i<=nums.length; i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return 0;
    }
}

Optimal:

class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int sum = n*(n+1)/2;
        int S2 = 0;

        for(int i=0; i<n; i++){
            S2 += nums[i];
        }
        return sum-S2;
    }
}

Optimal:
class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;

        int xor1 = 0;

        for(int i = 0; i<=n; i++){
            xor1 = xor1^i;
        }

        int xor2 = 0;
        for(int i = 0; i<n; i++){
            xor2 = xor2^nums[i];
        }
        return xor1^xor2;
    } 
}
