import java.util.*;
import java.io.*;

// 코드 실행 시간:                    1ms

public class MyClass {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        
        int n = Integer.parseInt(tokenizer.nextToken());   // 회사 개수
        int m = Integer.parseInt(tokenizer.nextToken());   // 경로의 개수
        int[][] map = new int[n + 1][n + 1];
        
        // 최단 거리 테이블을 99999로 초기화한다.
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], 99999);
        }
        
        // 자기 자신은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }
        
        // 초기화
        for (int i = 1; i <= m; i++) {
            StringTokenizer company = new StringTokenizer(reader.readLine(), " ");
            
            int a = Integer.parseInt(company.nextToken());
            int b = Integer.parseInt(company.nextToken());
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }
        
        String[] xk = reader.readLine().split(" ");

        int x = Integer.parseInt(xk[0]);
        int k = Integer.parseInt(xk[1]);
        
        int result = map[1][k] + map[k][x];
        
        if (result > 99999) {
            System.out.println(-1);
        } else {
            System.out.println(map[1][k] + map[k][x]);
        }
    }
}