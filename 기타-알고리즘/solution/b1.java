import java.util.*;
import java.io.*;

public class MyClass {
    
    private static String[] input;
    private static boolean[] isPrime;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        isPrime = new boolean[n + 1];
        
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                int j = 2;
                
                while (i * j <= n) {
                    // i의 배수를 모두 제거한다.
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }
        
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}