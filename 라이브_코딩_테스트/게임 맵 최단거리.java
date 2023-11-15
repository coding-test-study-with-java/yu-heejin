import java.util.*;

/**
 * 정확성  테스트
테스트 1 〉	통과 (0.14ms, 76MB)
테스트 2 〉	통과 (0.18ms, 73MB)
테스트 3 〉	통과 (0.21ms, 70.6MB)
테스트 4 〉	통과 (0.13ms, 72.9MB)
테스트 5 〉	통과 (0.19ms, 77.6MB)
테스트 6 〉	통과 (0.17ms, 76.7MB)
테스트 7 〉	통과 (0.23ms, 66.6MB)
테스트 8 〉	통과 (0.18ms, 72.2MB)
테스트 9 〉	통과 (0.15ms, 73.5MB)
테스트 10 〉	통과 (0.15ms, 74.3MB)
테스트 11 〉	통과 (0.14ms, 74.5MB)
테스트 12 〉	통과 (0.18ms, 79.4MB)
테스트 13 〉	통과 (0.19ms, 74MB)
테스트 14 〉	통과 (0.14ms, 75.4MB)
테스트 15 〉	통과 (0.15ms, 75.8MB)
테스트 16 〉	통과 (0.12ms, 72.4MB)
테스트 17 〉	통과 (0.14ms, 67.1MB)
테스트 18 〉	통과 (0.18ms, 73.9MB)
테스트 19 〉	통과 (0.16ms, 77.5MB)
테스트 20 〉	통과 (0.20ms, 85.3MB)
테스트 21 〉	통과 (0.18ms, 74.9MB)
효율성  테스트
테스트 1 〉	통과 (7.20ms, 53.6MB)
테스트 2 〉	통과 (2.90ms, 52.5MB)
테스트 3 〉	통과 (7.74ms, 53.2MB)
테스트 4 〉	통과 (4.15ms, 56.6MB)
 */

class Solution {
    
    int[][] visited;
    int[] moveX = {0, 0, -1, 1};
    int[] moveY = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        return visited[maps.length - 1][maps[0].length - 1] == 0
            ? -1
            : visited[maps.length - 1][maps[0].length - 1];
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + moveX[i];
                int nextY = curr[1] + moveY[i];
                
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }
            
                if (visited[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[curr[0]][curr[1]] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
        
    }
}