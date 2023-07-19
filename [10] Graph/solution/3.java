import java.util.*;
import java.io.*;

public class MyClass {
    
    private static int[] indegree, times;
    private static List<ArrayList<Integer>> graph;
    private static String[] input;
    
    private static void topologySort(int n) {
        List<Integer> results = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        // 결과에는 노드가 아닌 시간을 삽입
        for (int i = 0; i <= n; i++) {
            results.add(times[i]);
        }
        
        // 진입 차수가 0인 노드를 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
           int now = q.poll();
           
           for (int i = 0; i < graph.get(now).size(); i++) {
               // 연결된 노드의 강의 시간 vs 현재 강의를 듣고 연결된 노드를 듣는 강의 시간
               results.set(graph.get(now).get(i), Math.max(results.get(graph.get(now).get(i)), results.get(now) + times[graph.get(now).get(i)]));
               indegree[graph.get(now).get(i)]--;
               
               if (indegree[graph.get(now).get(i)] == 0) {
                   q.offer(graph.get(now).get(i));
               }
           }
        }
        
        // 위상 정렬을 수행한 결과 출력
    	for (int i = 1; i < results.size(); i++) {
    	    System.out.print(results.get(i) + " ");
    	}
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        
        indegree = new int[n + 1];  // 차수
        times = new int[n + 1];  // 각 강의마다 걸리는 시간
        graph = new ArrayList<>();  // 간선 정보 연결리스트
        
        Arrays.fill(indegree, 0);
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 1; i <= n; i++) {
            input = reader.readLine().split(" ");
            
            // 첫번째 입력값은 해당 강의를 듣는데 걸리는 시간
            times[i] = Integer.parseInt(input[0]);
            int index = 1;
            
            // 입력값이 -1이 되기 전까지 수행
            while (!input[index].equals("-1")) {
                int before = Integer.parseInt(input[index]);
                
                // 해당 강의를 듣기 위해 먼저 들어야하는 강의들을 삽입
                graph.get(before).add(i);
                indegree[i]++;
                index++;
            }
        }
        
        topologySort(n);
    }
}