import java.util.*;
import java.io.*;

// CPU Time: 0.11 sec(s), Memory: 31776 kilobyte(s)

public class MyClass {
    
    private static String[] input;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        input = br.readLine().split(" ");
        List<Integer> balls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            balls.add(Integer.parseInt(input[i]));
        }
        
        Collections.sort(balls);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int selectedBall = balls.get(i);
            for (int j = 0; j < n; j++) {
                if (selectedBall < balls.get(j)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}