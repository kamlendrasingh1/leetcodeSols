class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;

        for(int number : nums){
            if(number < 10){
                singleDigitSum += number;
            } else{
                doubleDigitSum += number;
            }
        }
        return singleDigitSum != doubleDigitSum;
    }
}