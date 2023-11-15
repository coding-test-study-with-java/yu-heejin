import java.util.*;
import java.io.*;

class Planet {
    int x;
    int y;
    int z;
    int index;
    
    public Planet(int x, int y, int z, int index) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }
}

class Edge implements Comparable<Edge> {
    int o1;
    int value;
    
    public Edge(int o1, int value) {
        // n번째 행성과 연결된 행성 번호
        this.o1 = o1;
        // 두 행성 사이의 간선의 비용
        this.value = value;
    }
    
    @Override
    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Planet> planets = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            
            planets.add(new Planet(x, y, z, i));
        }
        
        // 각 정점별 이어지는 행성 정보 저장
        List<PriorityQueue<Edge>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connections.add(new PriorityQueue<Edge>());
        }
        
        // x순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.x - p2.x);
            
            // 양 간선 정보 업데이트
            connections.get(p1.index).add(new Edge(p2.index, value));
            connections.get(p2.index).add(new Edge(p1.index, value));
        }
        
        // y순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.y - p2.y);
            
            // 양 간선 정보 업데이트
            connections.get(p1.index).add(new Edge(p2.index, value));
            connections.get(p2.index).add(new Edge(p1.index, value));
        }
        
        // z순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.z - p2.z);
            
            // 양 간선 정보 업데이트
            connections.get(p1.index).add(new Edge(p2.index, value));
            connections.get(p2.index).add(new Edge(p1.index, value));
        }
        
        // prim - start를 0으로 설정한다.
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Edge> pq = new PriorityQueue<>();
        
        // 시작 지점
        pq.add(new Edge(0, 0));
        
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            
            if (visited[e.o1]) continue;
            
            answer += e.value;
            visited[e.o1] = true;
            for (Edge nextE : connections.get(e.o1)) {
                if (!visited[nextE.o1]) {
                    pq.add(nextE);
                }
            }
        }
        
        System.out.println(answer);
    }
}