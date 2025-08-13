class Solution {
    public boolean isPowerOfThree(int n) {
        double num = n;
        while(num >= 1.0 || num <= -1.0) {
            if(num == 1.0)
                return true;
            num /= 3.0;
        }
        return false;
    }
}