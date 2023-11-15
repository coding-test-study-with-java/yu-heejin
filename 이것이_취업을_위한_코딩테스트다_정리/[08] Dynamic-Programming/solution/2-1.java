import java.util.*;
import java.io.*;

// TODO: 다시 풀어볼것
// 코드 실행 시간:                    2ms

public class MyClass {
    
    private static int[] memo;
    private static String[] foods;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        memo = new int[n];
        foods = reader.readLine().split(" ");
        
        memo[0] = Integer.parseInt(foods[0]);
        // 0이 크면 1은 털지 않는 것으로 간주
        memo[1] = Math.max(memo[0], Integer.parseInt(foods[1]));
        
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], Integer.parseInt(foods[i]) + memo[i - 2]);
        }
        
        System.out.println(memo[n - 1]);
    }
}