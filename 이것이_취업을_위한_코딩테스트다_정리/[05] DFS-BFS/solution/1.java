import java.io.*;
import java.util.*;

// 코드 실행 시간:                    2ms

public class MyClass {
    private static int[][] iceFrame;
    private static int n;
    private static int m;
    
    private static boolean dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || iceFrame[x][y] == 1) {
		    // 종료 조건
		    return false;
		}
		
		iceFrame[x][y] = 1;
		
		dfs(x - 1, y);  // 상
		dfs(x + 1, y);  // 하
        dfs(x, y - 1);  // 좌
        dfs(x, y + 1);  // 우
        
        return true;
	}
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> dfs = new Stack<>();
        
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        iceFrame = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String frame = br.readLine();
            for (int j = 0; j < m; j++) {
                iceFrame[i][j] = frame.charAt(j) - '0';
            }
        }
        
        int iceCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    iceCount++;
                }
            }
        }
        
        System.out.println(iceCount);
    }
}