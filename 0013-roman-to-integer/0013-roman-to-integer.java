class Solution {
    private int val(char ch){
        switch(ch){
            case 'I':
            return 1;
            case 'V':
            return 5;
            case 'X':
            return 10;
            case 'L':
            return 50;
            case 'C':
            return 100;
            case 'D':
            return 500;
            case 'M':
            return 1000;
            default:
            return 0;
        }
    }
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            if(i+1 < chars.length && val(chars[i]) < val(chars[i+1])){
                sum = sum - val(chars[i]);
            }else{
                sum = sum + val(chars[i]);
            }
        }
        return sum;
    }
}