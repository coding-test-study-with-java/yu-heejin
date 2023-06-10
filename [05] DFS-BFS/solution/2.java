import java.io.*;
import java.util.*;

// 코드 실행 시간:                   73ms

class MazePosition {
    int x;
    int y;
    
    public MazePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MyClass {
    // 상하좌우 탐색
    private static final int[] MOVE_X = { -1, 1, 0, 0 };
    private static final int[] MOVE_Y = { 0, 0, -1, 1 };
    
    private static int[][] maze;
    private static int n, m;
    
    // 갈 수 있는 공간인지 체크
    private static boolean isBoundary(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }
        
        if (maze[x][y] == 0) {
            return true;
        }
        
        return false;
    }
    
    private static int bfs(int x, int y) {
        Queue<MazePosition> queue = new LinkedList<>();
        
        // 출발 지점 insert
        // queue에 삽입 후 방문 처리를 한다.
        queue.offer(new MazePosition(0, 0));
        maze[0][0] = 1;

        while (!queue.isEmpty()) {
            MazePosition position = queue.poll();  // 방문 처리된 큐를 꺼낸다.
            System.out.println("( " + position.x + ", " + position.y + " ) => ");

            for (int i = 0; i < 4; i++) {
                // 상하좌우를 탐색하여 방문하지 않은 인접 노드를 모두 큐에 삽입 후 방문 처리
                int nextX = position.x + MOVE_X[i];
                int nextY = position.y + MOVE_Y[i];
                
                if (!isBoundary(nextX, nextY) && maze[nextX][nextY] == 1) {
                    queue.offer(new MazePosition(nextX, nextY));
                    maze[nextX][nextY] = maze[position.x][position.y] + 1;  // 원래 위치에서 +1 (거리 계산)
                }
            }
        }
        
        return maze[n-1][m-1];
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        
        maze = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String mazeLine = br.readLine();
            
            for (int j = 0; j < m; j++) {
                maze[i][j] = mazeLine.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
}