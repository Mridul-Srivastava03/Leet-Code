class Solution {
    public void reverse(int nums[], int start, int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public boolean check(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.length-1);
                reverse(nums, 0, nums.length-1);
                break;
            }
            // else if(nums[i] < nums[i+1]) {
            //     reverse(nums, 0, i);
            //     reverse(nums, i+1, nums.length-1);
            //     reverse(nums, 0, nums.length-1);
            //     break;
            // }
        }

        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1])
                return false;
        }
        return true;
    }
}