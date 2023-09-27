import java.util.*;

// 미완성 코드 ㅠㅠ

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        // 연결되었는지 확인
        
        // 같은 네트워크끼리 묶음
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int cnt = results.getOrDefault(parent[i], 0);
            results.put(parent[i], cnt + 1);
        }
        return results.size();
    }
    
    private boolean union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
        y = find(y); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}