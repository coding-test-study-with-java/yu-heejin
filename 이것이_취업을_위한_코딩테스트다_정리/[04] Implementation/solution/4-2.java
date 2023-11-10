import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

// 코드 실행 시간:                    2ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        
        for (int i = 0; i <= n; i++) {
            if (i == 3) {
                count += 60 * 60;  // 모든 분, 초 포함
            } else {
                count += (15 * 60) + (45 * 15);  // 3이 들어간 경우 모든 분, 초 포함, 그 외에는 15개
            }
        }
        
        System.out.println(count);
    }
}