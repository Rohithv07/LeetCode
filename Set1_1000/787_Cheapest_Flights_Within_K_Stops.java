//  O(n^k + klogn)

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0 || n <= 0 || k < 0)
            return -1;
        List<List<Pair>> graph = buildGraph(flights, n);
        PriorityQueue<City> minHeap = new PriorityQueue<>((city1, city2) -> Integer.compare(city1.costFromSrc, city2.costFromSrc));
        // source, distance from src to current city, cost from src to currency city
        minHeap.offer(new City(src, 0, 0));
        Map<Integer, Integer> visited = new HashMap<>();
        while (!minHeap.isEmpty()) {
            City currentCity = minHeap.poll();
            if (visited.containsKey(currentCity.city) && visited.get(currentCity.city) <= currentCity.distanceFromSrc)
                continue;
            if (currentCity.city == dst)
                return currentCity.costFromSrc;
            if (currentCity.distanceFromSrc > k)
                continue;
            visited.put(currentCity.city, currentCity.distanceFromSrc);
            List<Pair> neighbour = graph.get(currentCity.city);
            for (Pair pair : neighbour) {
                minHeap.offer(new City(pair.destination, currentCity.distanceFromSrc + 1, currentCity.costFromSrc + pair.price));
            }
        }
        return -1;
    }
    
    public List<List<Pair>> buildGraph(int [][] flights, int n) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        return graph;
    }
}

class City {
    int city;
    // means the number of stops from source
    int distanceFromSrc;
    int costFromSrc;
    public City(int city, int distanceFromSrc, int costFromSrc) {
        this.city = city;
        this.distanceFromSrc = distanceFromSrc;
        this.costFromSrc = costFromSrc;
    }
}

class Pair {
    int destination;
    int price;
    public Pair(int destination, int price) {
        this.destination = destination;
        this.price = price;
    }
}