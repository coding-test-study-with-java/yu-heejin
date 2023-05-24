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

// CPU Time: 0.15 sec(s), Memory: 33752 kilobyte(s)
// compiled and executed in 0.843 sec(s)
// 코드 실행 시간:                    3ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n--;
            }
            
            count++;
        }
        
        System.out.println(count);
        long endTime = System.currentTimeMillis();

        System.out.println(String.format("코드 실행 시간: %20dms", endTime - startTime));
    }
}