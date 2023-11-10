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

// CPU Time: 0.10 sec(s), Memory: 32432 kilobyte(s)
// compiled and executed in 1.37 sec(s)
// 코드 실행 시간:                    3ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 배열의 크기
        int m = Integer.parseInt(st.nextToken());   // 숫자가 더해지는 횟수
        int k = Integer.parseInt(st.nextToken());   // 특정한 인덱스가 연속해서 K번 이상 더해질 수 없음음

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        List<Integer> numbers = new ArrayList<>();

        while(st2.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(numbers, Comparator.reverseOrder());

        int index = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (count % 4 == 0) {
                index = 1;
            } else {
                index = 0;
            }

            sum += numbers.get(index);
            count++;
        }

        System.out.println(sum);
    }
}