class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        if(nums.length == 1 && nums[0] != val)
            return 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != val){
                i++;
                continue;
            }
            if(nums[i] == val && nums[j] == val){
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
        return i;
    }
}