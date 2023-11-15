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

// CPU Time: 0.20 sec(s), Memory: 33576 kilobyte(s)
// compiled and executed in 1.782 sec(s)
// 코드 실행 시간:                    2ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String number = br.readLine();
        int[] position = {0, 0};
        
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            
            if (i == 0) {
                if (n == 1) {
                    position[1]++;
                } else {
                    position[0]++;
                }
            } else {
                int pn = number.charAt(i - 1) - '0';
                
                if (pn != n) {
                    if (n == 1) {
                        position[1]++;
                    } else {
                        position[0]++;
                    }
                }
            }
        }
        
        System.out.println(Math.min(position[0], position[1]));
    }
}