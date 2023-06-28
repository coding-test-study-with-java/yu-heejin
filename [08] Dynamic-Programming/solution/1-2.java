import java.util.*;
import java.io.*;

// 코드 실행 시간:                    2ms

public class MyClass {
    private static Integer[] memo;
    
    private static int makeOne(int x) {
        if (memo[x] == null) {
            memo[x] = makeOne(x - 1) + 1;
            
            if (x % 5 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 5) + 1);
            }
        
            if (x % 3 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 3) + 1);
            }
            
            if (x % 2 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 2) + 1);
            }    
        }
        
        return memo[x];
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(reader.readLine());
        memo = new Integer[x + 1];
        
        memo[0] = 0;
        memo[1] = 0;
        
        System.out.println(makeOne(x));
    }
}