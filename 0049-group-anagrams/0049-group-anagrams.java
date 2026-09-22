class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);
            anagrams.computeIfAbsent(sortedKey, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}