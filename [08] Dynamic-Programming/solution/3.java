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
        int[] memo = new int[n];
        
        memo[0] = 1;
        memo[1] = 3;
        
        for (int i = 2; i < n; i++) {
            memo[i] = (memo[i - 2] * 2 + memo[i - 1]) % 796796;
        }
        
        System.out.println(memo[n-1]);
    }
}