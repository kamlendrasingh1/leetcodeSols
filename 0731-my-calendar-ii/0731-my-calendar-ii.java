class MyCalendarTwo {
    Map<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int bookings = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            bookings = bookings + entry.getValue();

            if(bookings > 2){
                map.put(startTime, map.get(startTime) - 1);
                map.put(endTime, map.get(endTime) + 1);

                if(map.get(startTime) == 0){
                    map.remove(startTime);
                }

                if(map.get(endTime) == 0){
                    map.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */