import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

// 코드 실행 시간:                   70ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        
        int[] position = { 0, 0 };
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        while (tokenizer.hasMoreTokens()) {
            String arrow = tokenizer.nextToken();
            
            switch (arrow) {
                case "L":
                    position[1]--;
                    break;
                    
                case "R":
                    position[1]++;
                    break;
                    
                case "U":
                    position[0]--;
                    break;
                
                case "D":
                    position[0]++;
                    break;
            }
            
            if (position[1] >= n) {
                position[1]--;
            }
            
            if (position[1] < 0) {
                position[1]++;
            }
            
            if (position[0] >= n) {
                position[0]--;
            }
            
            if (position[0] < 0) {
                position[0]++;
            }
        }
        
        System.out.println((position[0] + 1) + " " + (position[1] + 1));
    }
}