## 럭키 스트레이트

- 럭키 스트레이트 기술은 매우 강력한 대신 게임 내에서 점수가 특정 조건을 만족할 때만 이용 가능하다.
- 특정 조건은 현재 캐릭터의 점수를 N이라고 할 때 **자릿수를 기준으로 점수 N을 반으로 나누어 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황**을 의미한다.

```java
import java.io.*;
import java.util.*;

// 백준 기준 메모리: 14212KB	시간: 124ms

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int numberSize = input.length();
        
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < numberSize / 2; i++) {
            int front = input.charAt(i);
            int back = input.charAt(numberSize - 1 - i);
            
            leftSum += front;
            rightSum += back;
        }
        
        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
```

## 문자열 재정렬

- 알파벳 대문자, 숫자로만 구성된 문자열
- 모든 알파벳을 오름차순으로 정렬한 후 그 뒤의 모든 숫자를 더한 값을 이어서 출력한다.

```java
import java.io.*;
import java.util.*;

// CPU Time: 0.25 sec(s), Memory: 36656 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        List<Character> alpha = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                alpha.add(ch);
            } else {
                sum += (ch - '0');
            }
        }
        
        Collections.sort(alpha);
        
        StringBuilder sb = new StringBuilder();
        for (char ch : alpha) {
            sb.append(ch);
        }
        
        System.out.println(sb.toString() + sum);
    }
}
```

## 문자열 압축

```java
import java.util.*;

// 프로그래머스 기준 메모리: 79.6 MB, 시간: 0.07 ms

class Solution {
    
    public int solution(String s) {
        int min = s.length();
        
        if (s.length() == 1) {
            return 1;
        }
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String start = s.substring(0, i);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            for (int j = i; j <= s.length() - i; j += i) {
                String curr = s.substring(j, j + i);
                if (start.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(start);
                    start = curr;
                    count = 1;
                }
            }
            
            if (count > 1) {
                sb.append(count);
            }
            sb.append(start);
            
            // 문자열이 나누어 떨어지지 않는 경우 고려
            int div = s.length() % i;
            min = Math.min(min, sb.toString().length() + div);
        }
        
        return min; // 가장 작은 문자열 길이 저장
    }
}
```