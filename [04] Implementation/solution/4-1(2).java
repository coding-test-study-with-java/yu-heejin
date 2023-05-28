import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

// 코드 실행 시간:                   36ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        Map<String, int[]> moves = new HashMap<>();
        
        moves.put("L", new int[]{0, -1});
        moves.put("R", new int[]{0, 1});
        moves.put("U", new int[]{-1, 0});
        moves.put("D", new int[]{1, 0});
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        
        int[] position = { 0, 0 };
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        while (tokenizer.hasMoreTokens()) {
            String arrow = tokenizer.nextToken();
            int[] move = moves.get(arrow);
            
            position[0] += move[0];
            position[1] += move[1];
            
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