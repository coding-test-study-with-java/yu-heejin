## 아이디어를 코드로 바꾸는 구현

### 피지컬로 승부하기

- 코딩 테스트에서 구현이란 ‘**머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정**’이다.
- 어떤 문제를 풀든 소스코드를 작성하는 과정은 필수이므로, **구현 문제 유형은 모든 범위의 코딩 테스트 문제 유형을 포함하는 개념이다.**
- 우리는 구현하기 위해 **프로그래밍 언어의 문법**을 정확히 알고 있어야 하며, 문**제의 요구사항에 어긋나지 않는 답안 코드**를 **실수 없이 작성**해야 한다.
- 흔히 문제 해결 분야에서 구현 유형의 문제는 **‘풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제’**를 의미한다.
    - 알고리즘은 설계했는데 구현이 먼저 풀 수 있는 문제가 없을 때 푸는 게 좋다고 한다. (?)
- 어떤 문제가 구현하기 어려운 문제일까?
    - 알고리즘은 간단한데 코드가 지나칠만큼 길어지는 문제
    - 특정 소수점 자리까지 출력해야 하는 문제
    - 문자열이 입력으로 주어졌을 때 한 문자 단위로 끊어서 리스트에 넣어야 하는(파싱을 해야하는) 문제 등
    - 대체로 **사소한 조건 설정이 많은 문제일수록 코드로 구현하기 까다롭다.**
- 프로그래밍 문법을 정확하게 숙지하지 못했거나, 라이브러리 사용 경험이 부족하면 구현 유형의 문제를 풀 때 불리하다.
- **완전 탐색은 모든 경우의 수를 주저 없이 다 계산하는 해결 방법**을 의미하고, **시뮬레이션은 문제에서 제시한 알고리즘을 한 단계씩 차례대로 직접 수행**해야 하는 문제 유형을 의미한다.
    - 두 유형 모두 구현이 핵심이 되는 경우가 많다.

### 구현 시 고려해야 할 메모리 제약 사항

**C/C++에서 변수의 표현 범위**

- 전통적으로 정수형을 표현할 땐 `int` 자료형을 주로 사용하며, 이 자료형의 크기는 4바이트이다.
- 기본 int 자료형의 표현 범위는 -2,147,483,648 ~ 2,147,483,647인데, 이 말은 **`int` 자료형으로 처리하면 2,147,483,647보다 큰 수를 처리할 수 없다는 의미이다.**
- 더 큰 수의 처리는 크기가 8바이트인 `long long`과 같은 자료형을 사용한다.
    - 이는 9,223,372,036,854,775,807보다 큰 수를 처리할 수 없으므로 더 큰 수를 담으려면 `BigInteger` 클래스를 구현하거나 이용해야 한다.
    - 자바의 경우 `BigInteger`를 표준 라이브러리로 지원하지만, C++의 경우 표준 라이브러리에도 포함되어 있지 않다.

**리스트의 크기**

- 리스트를 이용할 때 고려해야 할 사항이 있는데, 바로 코딩 테스트의 메모리 제한이다.
    - 정적배열 vs 컬렉션의 메모리 효율?
    - 대체로 코딩 테스트는 128 ~ 512MB로 메모리를 제한한다.
- **데이터 처리량이 많을 때는 꼭 메모리 제한을 고려해야 한다.**
    - 일반적인 코딩 테스트 수준에서는 메모리 사용량 제한보다 더 적은 크기의 메모리를 사용해야 한다는 점을 기억하면 된다.

### 채점 환경

- 보통 우리가 접하는 코딩 테스트 환경에서는 다음과 같은 채점 시스템의 시간 제한 및 메모리 제한 정보가 적혀있다.
    
    ```
    시간 제한: 1초
    메모리 제한: 128MB
    ```
    
- 파이썬은 C/C++에 비해 동작 속도가 느리기 때문에 파이썬을 선택했을 땐 C/C++에 비해 2배의 수행 시간 제한을 적용하기도 한다.
- 시간 제한이 1초이고, 데이터의 개수가 100만 개인 문제가 있다면 일반적으로 **시간복잡도 O(nlogn) 이내의 알고리즘을 이용하여 문제를 풀어야 한다.**
    - 따라서 알고리즘 문제를 풀 때는 시간 제한과 데이터의 개수를 먼저 확인한 뒤에 이 문제를 어느 정도의 시간 복잡도의 알고리즘으로 작성해야 풀 수 있을 것인지 예측할 수 있어야 한다.

### 구현 문제에 접근하는 방법

- 보통 구현 유형의 문제는 사소한 입력 조건 등을 문제에서 명시해주며 문제의 길이가 꽤 긴 편이다.
    - 문제의 길이는 길지만 고차원적인 사고력을 요구하는 문제는 나오지 않는 편이라 문법에 익숙하다면 오히려 쉽게 풀 수 있다.
- **구현 유형의 문제는 C/C++, Java로 풀 때 더 어렵게 다가온다.**
    - 문자열을 처리하거나 큰 정수를 처리하는 문제가 출제되는 경우가 많은데, 위 언어는 문자열 처리가 파이썬에 비해 까다롭고, 큰 정수를 처리하는 라이브러리를 별도로 사용해야 하기 때문이다.
- API 개발 문제도 구현 유형과 상당히 맞닿아 있다.
    - 카카오 공채의 경우 API 개발 문제가 출제된 적이 있는데, 카카오 문제 풀이 서버와 통신하는 프로그램 모듈을 작성해야 한다.
    - 이는 알고리즘 문제와 별개로 **웹 서버나 데이터 분석에 대한 기초 지식도 필요하다.**

## 예제 4-1) 상하좌우

### 풀이 과정

- N x N 크기의 정사각형 공간 위에 여행가가 서 있고, 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다.
- 시작 좌표는 항상 왼쪽 위 (1, 1)

```java
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
```

### 문제 해설

- 연산의 횟수는 이동 횟수에 비례하게 된다.
- 이러한 유형은 **일련의 명령에 따라 개체를 차례대로 이동시킨다는 점에서 시뮬레이션 유형**으로 분류되며, 구현이 중요한 대표적인 문제 유형이다.
- 코딩 테스트나 알고리즘 대회에서 가장 난이도가 낮은 1~2번 문제는 대부분 **그리디 알고리즘이나 구현 문제이다.**
    - 두 유형이 논리적 사고력을 확인할 수 있는 가장 기본 난이도의 문제로 적합하기 때문이다.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기 
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시 
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행 
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }

}
```

## 예제 4-2) 시각

### 풀이 과정

- 00시 00분 00초 ~ N시 59분 59초