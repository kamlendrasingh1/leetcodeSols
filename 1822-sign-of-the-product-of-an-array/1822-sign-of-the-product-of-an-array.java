class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;

        for (int number : nums) {
            if (number == 0) {
                return 0;
            }
            if(number < 0){
                sign *= -1;
            }
        }
        return sign;
    }
}