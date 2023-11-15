import java.util.*;
import java.io.*;

// 코드 실행 시간:                    3ms

public class MyClass {
    
    private static final int UNION = 0;
    private static final int FIND = 1;
    
    private static String[] input;
    private static int[] parent;
    
    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = findParent(parent[x]);
    }
    
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            
            int operation = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            
            if (operation == UNION) {
                unionParent(a, b);
            } else {
                int rootA = findParent(a);
                int rootB = findParent(b);
                
                if (rootA == rootB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}