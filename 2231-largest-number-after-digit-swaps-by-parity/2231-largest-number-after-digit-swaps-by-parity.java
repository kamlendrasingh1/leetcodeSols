class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        String s = Integer.toString(num);
        for(char c : s.toCharArray()){
            int val = c - '0';
            if(val % 2 == 0){
                even.add(val);
            }else{
                odd.add(val);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
           int val = c - '0';
            if(val % 2 == 0){
                sb.append(even.poll());
            }else{
                sb.append(odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }
}