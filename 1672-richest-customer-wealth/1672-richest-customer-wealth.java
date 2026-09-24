class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int[] cutsomerAccounts : accounts){
            int currentCustWealth = 0;
            for(int accountBal : cutsomerAccounts){
                currentCustWealth += accountBal;
            }
            maxWealth = Math.max(maxWealth, currentCustWealth);
        }
        return maxWealth;
    }
}