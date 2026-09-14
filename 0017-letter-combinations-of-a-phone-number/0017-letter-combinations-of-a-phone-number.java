class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        result.add("");

        String[] lettersToDigit = new String[]{
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        for(char digit : digits.toCharArray()){
            String letters = lettersToDigit[digit-'2'];

            List<String> tempCombinations = new ArrayList<>();

            for(String combs : result){
                for(char letter : letters.toCharArray()){
                    tempCombinations.add(combs + letter);
                }
            }
            result = tempCombinations;
        }
        return result;
    }
}