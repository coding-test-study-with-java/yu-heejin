import java.util.*;
import java.io.*;

public class MyClass {
    
    private static int v, e;
    private static int[] indegree, times;
    private static List<ArrayList<Integer>> graph;
    private static String[] input;
    
    private static void topologySort(int n) {
        List<Integer> results = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            results.add(now);
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        
        // 위상 정렬을 수행한 결과 출력
    	for (int i = 0; i < results.size(); i++) {
    	    System.out.print(results.get(i) + " ");
    	}
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        indegree = new int[n + 1];
        times = new int[n + 1];
        graph = new ArrayList<>();
        
        Arrays.fill(indegree, 0);
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 1; i <= n; i++) {
            input = reader.readLine().split(" ");
            
            times[i] = Integer.parseInt(input[0]);
            int index = 1;
            
            while (!input[index].equals("-1")) {
                int before = Integer.parseInt(input[index]);
                
                graph.get(before).add(i);
                indegree[i]++;
                index++;
            }
        }
        
        topologySort(n);
    }
}