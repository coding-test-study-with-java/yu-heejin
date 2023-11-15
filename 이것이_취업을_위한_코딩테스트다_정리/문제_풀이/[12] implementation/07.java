import java.io.*;
import java.util.*;

// 백준 기준 메모리: 14212KB	시간: 124ms

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int numberSize = input.length();
        
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < numberSize / 2; i++) {
            int front = input.charAt(i) -'0';
            int back = input.charAt(numberSize - 1 - i) - '0';
            
            leftSum += front;
            rightSum += back;
        }
        
        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}