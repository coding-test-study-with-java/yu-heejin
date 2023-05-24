import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// CPU Time: 0.16 sec(s), Memory: 33852 kilobyte(s)
// compiled and executed in 1.15 sec(s)
// 코드 실행 시간:                    4ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int min = -1;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            List<Integer> card = new ArrayList<>();
            
            while(st2.hasMoreTokens()) {
                card.add(Integer.parseInt(st2.nextToken()));    
            }
            
            int temp = Collections.min(card);
            
            if(min < temp) {
                min = temp;
            }
        }
        
        System.out.println(min);
    }
}