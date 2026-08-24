class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxCount = -1;
        int ans = -1;

        for(int key : map.keySet()){
            if(map.get(key) > maxCount){
                maxCount = map.get(key);
                ans = key;
            }
        }
        return ans;
    }
}