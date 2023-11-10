import java.util.*;
import java.io.*;

// 코드 실행 시간:                   57ms

public class MyClass {
    
    private static List<ArrayList<Node>> map = new ArrayList<>();
    private static int[] distance;

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int dist = node.distance;
            int now = node.index;
            
            if (distance[now] < dist) continue;
            
            for (int i = 0; i < map.get(now).size(); i++) {
                int time = distance[now] + map.get(now).get(i).distance;
                
                if (time < distance[map.get(now).get(i).index]) {
                    distance[map.get(now).get(i).index] = time;
                    queue.offer(new Node(map.get(now).get(i).index, time));
                }
            }
        }
    }
    
    private static int[] getCountAndTotalTime(int start) {
        // 연결된 도시들 중에서 가장 큰 시간
        int totalTime = map.get(start).get(0).distance;
        
        for (int i = 1; i < map.get(start).size(); i++) {
            int time = map.get(start).get(i).distance;
            
            if (time > totalTime) {
                totalTime = time;
            }
        }
        
        return new int[] { map.get(start).size(), totalTime };
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nmc = reader.readLine().split(" ");
        
        int n = Integer.parseInt(nmc[0]);
        int m = Integer.parseInt(nmc[1]);
        int c = Integer.parseInt(nmc[2]);
        
        distance = new int[n + 1];
        
        Arrays.fill(distance, 99999);
        
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < m; i++) {
            String[] connectedInformation = reader.readLine().split(" ");
            
            int city = Integer.parseInt(connectedInformation[0]);
            int connectedCity = Integer.parseInt(connectedInformation[1]);
            int time = Integer.parseInt(connectedInformation[2]);
            
            map.get(city).add(new Node(connectedCity, time));
        }
        
        dijkstra(c);
        
        int[] result = getCountAndTotalTime(c);
        
        System.out.println(result[0] + " " + result[1]);
    }
    
    static class Node implements Comparable<Node> {
        
        int index;
        int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }
}