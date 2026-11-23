class Solution {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

            graph.clear();
            result.clear();

            for(List<String> ticket : tickets){
                String from = ticket.get(0);
                String to = ticket.get(1);


                graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
            }
                dfs("JFK");

                Collections.reverse(result);

                return result;
            }

            private void dfs(String airport){
                PriorityQueue<String> destination = graph.get(airport);

                while(destination != null && !destination.isEmpty()){
                    String nextAirport = destination.poll();
                    dfs(nextAirport);
                }

                result.add(airport);
            }
   
}


