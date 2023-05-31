import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 코드 실행 시간:                    3ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        Map<Integer, int[]> moves = new HashMap<>();
        
        moves.put(0, new int[]{1, 2});
        moves.put(1, new int[]{-1, 2});
        moves.put(2, new int[]{1, -2});
        moves.put(3, new int[]{-1, -2});

        moves.put(4, new int[]{2, 1});
        moves.put(5, new int[]{-2, 1});
        moves.put(6, new int[]{2, -1});
        moves.put(7, new int[]{-2, -1});
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String start = reader.readLine();
        
        // Arrays.asList의 시간 복잡도는 O(1)
        List<String> rows = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
        List<String> cols = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
        
        int[] position = new int[]{ 
            rows.indexOf(String.valueOf(start.charAt(1))),
            cols.indexOf(String.valueOf(start.charAt(0))) 
        };
        
        int count = 0;
        
        for (int i = 0; i < 8; i++) {
            int[] move = moves.get(i);
            int row = position[0];
            int col = position[1];
            
            row += move[0];
            col += move[1];
            count++;
            
            if (row < 0 || row >= 8 || col < 0 || col >= 8) {
                count--;
            }
        }
        
        System.out.println(count);
    }
}