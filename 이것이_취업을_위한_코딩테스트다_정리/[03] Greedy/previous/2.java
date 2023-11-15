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

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String number = br.readLine();
        int previousResult = 0;
        String op = "*";
        
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            
            if (n == 0 || previousResult == 0) {
                // 변환한 숫자가 0이거나 이전 결과가 0이면 더해준다.
                op = "+";
            } else {
                op = "*";
            }
            
            if (op.equals("+")) {
                previousResult += n;
            }
            
            if (op.equals("*")) {
                previousResult *= n;
            }
        }
        
        System.out.println(previousResult);
    }
}