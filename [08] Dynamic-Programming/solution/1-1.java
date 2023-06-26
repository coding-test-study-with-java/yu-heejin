import java.util.*;
import java.io.*;

// 코드 실행 시간:                    1ms

public class MyClass {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(reader.readLine());
        int[] memo = new int[x + 1];
        
        memo[0] = 0;
        memo[1] = 0;
        
        // 반복문은 바텀 업, 재귀는 탑 다운 방식임을 기억하라.
        for (int i = 2; i <= x; i++) {
            memo[i] = memo[i - 1] + 1;    // 1을 빼는 경우 (기본)
            
            if (i % 5 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 5] + 1);   // 기존 방법 vs 5로 나누는 방법
            }
            
            if (i % 3 == 0) {
                 memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }
            
            if (i % 2 == 0) {
                 memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }
        }
        
        System.out.println(memo[x]);
    }
}