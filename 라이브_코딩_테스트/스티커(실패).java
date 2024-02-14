import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(input[j]);
                    dp[i][j] = sticker[i][j];
                }
            }
            
            // 위 스티커를 떼는 경우와 안 떼는 경우
            int max = -1000;
            
            for (int j = n-1; j > 1; j--) {
                int sum = 0;
                for (int i = 0; i < 2; i++) {
                    if (j == n - 1) sum += dp[i][j];
                    
                    if (i == 0) {
                        sum += Math.max(dp[i + 1][j - 1], dp[i + 1][j - 2]);
                    } 
                    
                    if (i == 1){
                        sum += Math.max(dp[i - 1][j - 1], dp[i - 1][j - 2]);
                    }
                }
                
                max = Math.max(sum, max);
            }
            
            System.out.println(max);
        }
    }
}