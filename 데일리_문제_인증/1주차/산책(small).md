## 문제 링크

[22868번: 산책 (small)](https://www.acmicpc.net/problem/22868)

## 코드

- 실패 코드
    
    ```java
    import java.io.*;
    import java.util.*;
    
    public class Main {
        static int n, m;
        static List<List<Integer>> graph;
        static boolean[] visited;
        static int answer = 0;
        static int[] routes;
        
        public static void main(String args[]) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            
            graph = new ArrayList<>();
            visited = new boolean[n + 1];
            
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            // 사전순을 위한 경로 정렬
            for (int i = 0; i <= n; i++) {
                Collections.sort(graph.get(i));
            }
            
            routes = new int[n + 1];
            
            // s -> e까지의 경로 리스트
            bfs(s, e);
          
            // e -> s까지의 경로 리스트
            Arrays.fill(visited, false);
            int routeIndex = 1;
            while (routes[routeIndex] != 0) {
                visited[routeIndex] = true;
                routeIndex++;
            }
            visited[s] = false;
            bfs(e, s);
            
            // 정답 출력
            System.out.println(answer);
        }
        
        private static void bfs(int s, int e) {
            Queue<int[]> q = new LinkedList<>();
            
            q.add(new int[] {s, 0});
            visited[s] = true;
            
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                routes[curr[1]] = curr[0];
                
                List<Integer> connected = graph.get(curr[0]);
                
                // 현재 정점과 연결된 정점 탐색
                for (int i = 0; i < connected.size(); i++) {
                    if (!visited[connected.get(i)]) {
                        q.add(new int[] {connected.get(i), curr[1] + 1});
                        visited[connected.get(i)] = true;
                        routes[curr[1] + 1] = connected.get(i);
                        
                        if (connected.get(i) == e) {
                            answer += (curr[1] + 1);
                            return;
                        }
                    }
                }
            }
        }
    }
    ```
    

```java
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] routes;    // 이전 경로 역추적(해당 노드 방문 전 거쳐온 노드)
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        
        // 사전순을 위한 경로 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        
        routes = new int[n + 1];
        
        int answer = 0;
        // s -> e까지의 경로 리스트
        answer += bfs(s, e);
        
        Arrays.fill(visited, false);
        
        int goal = routes[e];
        while (goal > 0) {
            visited[goal] = true;
            goal = routes[goal];
        }
        visited[s] = false;
        
        // e -> s 경로
        answer += bfs(e, s);
        
        System.out.println(answer);
    }
    
    private static int bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {s, 0});
        visited[s] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == e) {
                return curr[1];
            }
            
            List<Integer> connected = graph.get(curr[0]);
            
            // 현재 정점과 연결된 정점 탐색
            for (int n : connected) {
                if (visited[n]) continue;
                
                visited[n] = true;
                routes[n] = curr[0];
                q.add(new int[] {n, curr[1] + 1});
            }
        }
        
        return 0;
    }
}
```

## 풀이

### 어떤 알고리즘 / 자료구조를 사용했나요?

- BFS
- 처음에는 다익스트라를 고민했지만, 간선 간의 비용이 없어서 pass

### 해당 문제를 맞았다면 / 틀렸다면 어떻게 접근했나요?

- 지나온 경로를 표시하는 것이 가장 핵심적인 구현 포인트
    - 해당 노드로 이동하기 전에 왔던 노드를 저장하면, 역추적이 가능하다.
    - 미리 사전순으로 정렬한 후 bfs하기 때문에 더 큰 숫자가 들어오는 일은 없다.
- 지나온 경로를 추적했다면, e → s를 위해 visited를 다시 설정해야한다.
    - 목적지부터 역추적해서 visited = true 처리하면, e → s할 때 visited 처리된 경로는 다시 방문하지 않는다.

### 참고한 자료

- https://record-developer.tistory.com/105