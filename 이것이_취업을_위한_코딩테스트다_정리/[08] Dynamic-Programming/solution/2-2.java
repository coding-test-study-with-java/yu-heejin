import java.util.*;
import java.io.*;

public class MyClass {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        String[] foods = reader.readLine().split(" ");
        int[] memo = new int[n];
        
        // 1. 1번째 칸을 터는 경우
        memo[0] = Integer.parseInt(foods[0]);
        
        // 2. 2번째 칸을 털지 말지 비교한다.
        // 만약 더 작으면 털지 않는 것으로 간주한다.
        memo[1] = Math.max(memo[0], Integer.parseInt(foods[1]));
        
        // 3. 3번째 칸부터 하나씩 확인한다.
        // i - 2와 현재 칸, 이전 칸으로 비교하기 때문에 바로 전 칸을 털 일은 없음음
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], Integer.parseInt(foods[i]) + memo[i - 2]);
        }
        
        System.out.println(memo[n - 1]);
    }
}