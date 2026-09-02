class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for(int i = 0; i < ransomNote.length(); i++){
            char letter = ransomNote.charAt(i);
            int index = magazine.indexOf(letter);
            if(index != -1){
                magazine = magazine.substring(0, index) + magazine.substring(index + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}