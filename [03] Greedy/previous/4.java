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

// 코드 실행 시간:                    2ms
// CPU Time: 0.13 sec(s), Memory: 33704 kilobyte(s)
// compiled and executed in 1.506 sec(s)

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(numbers);
            
        int target = 1;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (target < numbers.get(i)) {
                result = target;
                break;
            }
            
            target += numbers.get(i);
        }
        
        System.out.println(target);
    }
}