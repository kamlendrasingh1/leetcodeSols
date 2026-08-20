class SummaryRanges {
    List<Integer> list;

    public SummaryRanges() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int value) {
        if (list.contains(value)) {
            return;
        }
        list.add(value);
    }

    public int[][] getIntervals() {
        if (list.size() == 0) {
            return new int[][] {};
        }

        Collections.sort(list);

        List<int[]> res = new ArrayList<>();

        int left = list.get(0);
        int right = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == right + 1) {
                right = list.get(i);
            } else {
                res.add(new int[] { left, right });
                left = list.get(i);
                right = list.get(i);
            }
        }

        // add final interval
        res.add(new int[] { left, right });

        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */