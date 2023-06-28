import java.util.*;
import java.io.*;

// TODO: 다시 풀어볼것
// 코드 실행 시간:                    1ms

public class MyClass {
    
    private static final int MAX = 10001;
    private static int[] memo;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        int[] monies = new int[n];
        int[] results = new int[m + 1];
        
        for (int i = 0; i < n; i++) {
            monies[i] = Integer.parseInt(reader.readLine());
        }
        
        Arrays.fill(results, MAX);
        results[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int money = monies[i];
            
            for (int j = money; j <= m; j++) {   // 해당 돈보다 작으면 만들 수 없으므로 보지 않음
                if (results[j - money] != 10001) {
                    System.out.println("result: " + results[j - money]);
                    results[j] = Math.min(results[j], results[j - money] + 1);
                }
            }
        }
        
        if (results[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(results[m]);
        }
    }
}