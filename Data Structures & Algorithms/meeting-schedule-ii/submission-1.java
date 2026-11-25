class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
       
       if(intervals.size() == 0){
        return 0;
       }

       intervals.sort((a,b) -> Integer.compare(a.start, b.start));

       PriorityQueue<Integer> minHeap = new PriorityQueue<>();

       minHeap.add(intervals.get(0).end);

       for(int i = 1; i < intervals.size(); i++){
        if(intervals.get(i).start >= minHeap.peek()){
            minHeap.poll();
        }

        minHeap.add(intervals.get(i).end);
       }

       return minHeap.size();
    }
}
