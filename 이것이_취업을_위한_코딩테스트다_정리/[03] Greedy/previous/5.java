import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

// 코드 실행 시간:                    2ms

public class MyClass {
    private static final int PICK_SIZE = 2;
    private static int count = 0;
    private static int[] bucket = new int[PICK_SIZE];
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int maxSize = reader.readLine().charAt(0) - '0';
        
        StringTokenizer ballToken = new StringTokenizer(reader.readLine(), " ");
        int[] balls = new int[maxSize];
        int ballIndex = 0;
        
        while(ballToken.hasMoreTokens()) {
            balls[ballIndex] = Integer.parseInt(ballToken.nextToken());
            ballIndex++;
        }
        
        combination(balls, PICK_SIZE);
        
        System.out.println(count);
    }
    
    private static void combination(int[] balls, int r) {
        if (r == 0) {
            if (balls[bucket[0]] != balls[bucket[1]]) {
                count++;
            }
            return;
        }
        
        int lastIndex = PICK_SIZE - r - 1;
        int smallest = findSmallest(r, lastIndex);
        
        for (int i = smallest; i < balls.length; i++) {
            bucket[lastIndex + 1] = i;
            combination(balls, r - 1);
        }
    }
    
    private static int findSmallest(int r, int lastIndex) {
        if (PICK_SIZE > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
}