## 중복되는 연산을 줄이자

- 최적의 해를 구하는 문제는 시간이 매우 많이 필요하거나 메모리 공간이 많이 필요하기 때문에 컴퓨터도 해결하기 어려운 문제이다.
    - 컴퓨터는 연산 속도에 한계가 있고, 메모리 공간을 사용할 수 있는 데이터의 개수도 한정적이기 때문이다.
    - 따라서 우리는 **연산 속도와 메모리 공간을 최대한으로 활용할 수 있는 효율적인 알고리즘을 작성해야 한다.**
- 다이나믹 프로그래밍(Dynamic Programming)기법은 대표적으로 **메모리 공간을 사용하여 연산 속도를 증가시키는 방법이다.**
    - 동적 계획법이라고 표현하기도 한다.
- 다이나믹 프로그래밍으로 해결할 수 있는 대표적인 예시로 피보나치 수열이 있다.
    - 피보나치 수열은 **이전 두 항의 합을 현재의 항으로 설정하는 특징이 있는 수열**이다.
    - 수학자들은 **점화식을 사용해 수열의 항이 이어지는 형태를 간결하게 표현**한다.
        - 점화식이란 **인접한 항들 사이의 관계식**을 의미한다.
    - 우리는 점화식을 통해 현재의 항을 이전의 항에 대한 식으로 표현할 수 있다.
- 프로그래밍에서는 **이러한 수열을 배열이나 리스트로 표현**할 수 있다.
    - 수열 자체가 여러 개의 수가 규칙에 따라서 배열된 형태를 의미하는 것이기 때문이다.
    - 리스트나 배열 모두 **‘연속된 많은 데이터’를 처리한다는 점은 동일**하다.
- 수학적 점화식을 프로그래밍으로 표현하려면 **재귀함수를 사용하여 간단하게 표현**할 수 있다.
    
    ```java
    public static int fibo(int x) {
    	if (x == 1 || x == 2) {
    		return 1;
    	}
    
    	return fibo(x - 1) + fibo(x - 2);
    }
    ```
    
- 그러나 피보나치 수열의 소스코드를 위와 같이 작성하면 문제가 될 수 있다.
    - f(n) 함수에서 **n이 커지면 커질수록 수행 시간이 기하급수적으로 늘어나기 때문**이다.
    - 일반적으로 피보나치 수열의 시간복잡도는 O(2^N) 지수 시간이 소요된다.
- 피보나치 그림을 보면 **동일한 함수가 반복적으로 호출**되는 것을 알 수 있다.
    - 따라서 피보나치 수열의 점화식을 재귀함수를 사용해 만들 수는 있지만 **단순히 매번 계산되도록 하면 문제를 효율적으로 해결할 수 없다.**
    - 이러한 문제는 **다이나믹 프로그래밍을 사용하면 효율적으로 해결**할 수 있다.
- 다이나믹 프로그래밍은 다음 조건을 만족하면 사용할 수 있다.
    1. 큰 문제를 작은 문제로 나눌 수 있다.
    2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.
- **메모이제이션(Memoization)은 다이나믹 프로그래밍을 구현하는 방법 중 한 종류**로, **한 번 구한 결과를 메모리 공간에 메모해두고 같은 식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법이다.**
    - 메모이제이션은 값을 저장하는 방법이므로 캐싱(Caching)이라고도 한다.
- 메모이제이션으로 피보나치 수열을 구현하면 다음과 같다.
    
    ```java
    public static long[] memos = new long[100];
    
    public static long fibo(int x) {
    	if (x == 1 || x == 2) {
    		return 1;
    	}
    
    	if (memos[x] != 0) {
    		return memos[x];
    	}
    
    	memos[x] = fibo(x - 1) + fibo(x - 2);
    	
    	return memos[x];
    }
    ```
    
    - 한 번 구한 정보를 리스트에 저장한다.
    - 다이나믹 프로그래밍을 재귀적으로 수행하다가 **같은 정보가 필요할 땐 이미 구한 정답을 그대로 리스트에서 가져오면 된다.**
- 정리하자면 **다이나믹 프로그래밍이란 큰 문제를 작게 나누고, 같은 문제라면 한번씩만 풀어 문제를 효율적으로 해결하는 알고리즘 기법**이다.
- 큰 문제를 작게 나누는 방법은 퀵 정렬에서도 소개된 적이 있다.
    - **퀵 정렬은 정렬을 수행할 때 정렬할 리스트를 분할하며 전체적으로 정렬**이 될 수 있도록 한다.
        - 이는 **분할 정복(Divide and Conquer) 알고리즘**으로 분류된다.
    - 다이나믹 프로그래밍과 분할 정복의 차이점은 **다이나믹 프로그래밍은 문제들이 서로 영향을 미치고 있다는 점이다.**
        - 퀵 정렬은 한번 **기준 원소(pivot)가 자리를 변경해서 자리를 잡게 되면 그 기준 원소의 위치는 더 이상 바뀌지 않고 그 피벗값을 다시 처리하는 부분 문제는 존재하지 않는다.**
        - 반면 **다이나믹 프로그래밍은 한 번 해결했던 문제를 다시금 해결**한다는 점이 특징이다.
        - 따라서 이미 해결된 부분 문제에 대한 답을 저장해놓고, 이미 해결된 문제는 다시 해결할 필요가 없다고 반환하는 것이다.
- 재귀 함수를 사용하면 시스템에서는 함수를 다시 호출했을 때 메모리 상에 적재되는 일련의 과정을 따라야 하므로 오버헤드가 발생할 수 있다.
    - 따라서 재귀 함수 대신 반복문을 사용하면 오버헤드를 줄일 수 있다.
- 다이나믹 프로그래밍을 적용했을 때 피보나치 수열의 시간 복잡도는 O(N)이다.
    - 한 번 구한 결과는 다시 구해지지 않기 때문이다.
- 피보나치를 재귀로 구현한 소스 코드
    
    ```java
    public static long[] memo = new long[100];
    
    public static long fibo(int x) {
    	System.out.println("f(" + x + ") ");
    
    	if (x == 1 || x == 2) {
    		return 1;
    	}
    
    	if (memo[x] != 0) {
    		return memo[x];
    	}
    
    	memo[x] = fibo(x - 1) + fibo(x - 2);
    	
    	return memo[x];
    }
    ```
    
    - 재귀 함수를 이용하여 다이나믹 프로그래밍 소스코드를 작성하는 방법을 **큰 문제를 해결하기 위해 작은 문제를 호출한다고 하여 탑 다운(Top-Down) 방식이라고 한다.**
- 피보나치를 반복으로 구현한 코드
    
    ```java
    public static long[] memo = new long[100];
    
    public static long fibo(int x) {
    	memo[1] = 1;
    	memo[2] = 2;
    	int n = 50;     // 50번째 피보나치 수를 계산
    	
    	for (int i = 3; i <= n; i++) {
    		memo[i] = memo[i - 1] + memo[i - 2];
    	}
    }
    ```
    
    - 단순히 반복문을 이용해 소스코드를 작성하는 경우 **작은 문제부터 차근차근 답을 도출한다고 하여 바텀 업(Bottom-Up) 방식이라고 한다.**
- 탑다운 방식은 하향식이라고 하며, 바텀업 방식은 상향식이라고 한다.
    - **다이나믹 프로그래밍의 전형적인 형태는 바텀 업 방식이다.**
    - **바텀 업 방식에서 사용되는 결과 저장용 리스트는 DP 테이블**이라 부르며, **메모이제이션은 탑다운 방식에 국한되어 사용되는 표현이다.**
    - 다이나믹 프로그래밍과 메모이제이션의 개념을 혼용해서 사용하는 경우도 있는데, 엄밀히 말하면 **메모이제이션은 이전에 계산된 결과를 일시적으로 기록해 놓는 넓은 개념을 의미하므로 다이나믹 프로그래밍과는 별도의 개념이다.**
- 수열은 배열이나 리스트로 표현할 수 있는데, **메모이제이션은 때에 따라서 다른 자료형을 이용할 수도 있다.**
- 다이나믹 프로그래밍을 이용하여 피보나치 수열 문제를 풀었던 방법을 잘 알아두면 다른 다이나믹 프로그래밍 문제에 접근하는 방법 또한 떠올릴 수 있다.
- 문제를 푸는 첫번째 단계는 **주어진 문제가 다이나믹 프로그래밍 유형임을 파악하는 것**이다.
    - 특정한 문제를 완전 탐색 알고리즘으로 접근했을 때 시간이 매우 오래 걸린다면 다이나믹 프로그래밍을 적용할 수 있는지 **해결하고자 하는 부분 문제들의 중복 여부를 확인하는 것이 좋다.**
    - 일단 단순 재귀함수로 비효율적인 프로그램을 작성한 뒤에(탑다운) 작은 문제에서 구한 답이 큰 문제에서 그대로 사용될 수 있으면, 즉 메모이제이션을 적용할 수 있으면 코드를 개선하는 방법도 좋은 아이디어이다.
- 또한, 가능하다면 **재귀함수를 이용하는 탑다운 방식보다는 바텀 업 방식으로 구현하는 것을 권장**한다.
    - 시스템 상 재귀 함수의 스택 크기가 한정되어 있을 수 있기 때문이다.

### 다이나믹 프로그래밍과 동적 할당의 다이나믹은 같은 의미일까?

- 프로그래밍에서 다이나믹은 ‘**프로그램이 실행되는 도중에**’라는 의미이다.
- 예를 들어 자료구조에서 동적 할당(Dynamic Allocation)은 프로그램 실행 중에 프로그램 실행에 필요한 메모리를 할당하는 기법이다.

---

## 실전 문제 1 - 1로 만들기

### 풀이 과정

- 연산 4개 → 1로 만들기
- DP 메모이제이션으로 최소 경우의 수를 저장한다.
- 참고 사이트 https://st-lab.tistory.com/133

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                    1ms

public class MyClass {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(reader.readLine());
        int[] memo = new int[x + 1];
        
        memo[0] = 0;
        memo[1] = 0;
        
        // 반복문은 바텀 업, 재귀는 탑 다운 방식임을 기억하라.
        for (int i = 2; i <= x; i++) {
            memo[i] = memo[i - 1] + 1;    // 1을 빼는 경우 (기본)
            
            if (i % 5 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 5] + 1);   // 기존 방법 vs 5로 나누는 방법
            }
            
            if (i % 3 == 0) {
                 memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }
            
            if (i % 2 == 0) {
                 memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }
        }
        
        System.out.println(memo[x]);
    }
}
```

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                    2ms

public class MyClass {
    private static Integer[] memo;
    
    private static int makeOne(int x) {
        if (memo[x] == null) {
            memo[x] = makeOne(x - 1) + 1;
            
            if (x % 5 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 5) + 1);
            }
        
            if (x % 3 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 3) + 1);
            }
            
            if (x % 2 == 0) {
                memo[x] = Math.min(memo[x], makeOne(x / 2) + 1);
            }    
        }
        
        return memo[x];
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(reader.readLine());
        memo = new Integer[x + 1];
        
        memo[0] = 0;
        memo[1] = 0;
        
        System.out.println(makeOne(x));
    }
}
```

### 문제 해설

- 함수가 호출되는 과정을 그리면 같은 함수들이 동일하게 여러번 호출되는 것을 알 수 있다.
- 점화식으로 표현하면 다음과 같다.
    
    $$
    ai = min(ai-1, ai/2, ai/3, ai/5) + 1
    $$
    
    - 끝에 1을 더해주는 이유는 함수의 호출 횟수를 구해야하기 때문이다.

```java
import java.util.*;

public class Main {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[x]);
    }
}
```

## 실전 문제 2 - 개미 전사

### 풀이 과정

- 식량 창고는 일직선, 정해진 수의 식량을 저장하고 있다.
- 메뚜기는 일직선상에 존재하는 식량창고 중에서 **서로 인접한 식량 창고가 공격받으면 바로 알아챌 수 있기 때문에** 개미 전사가 정찰병에게 들키지 않고 식량 창고를 약탈하기 위해서는 **최소한 한 칸이상 떨어진 식량 창고를 약탈해야 한다.**
- 일직선 상에서 최대한 많은 식량을 얻어야한다!
- dp를 사용해서 n번째 식량 창고를 방문했을 때 얻을 수 있는 식량 수 중에서 가장 큰 경우의 수를 저장한다.
- 한 칸씩 띄면서 최대한 많은 식량 창고를 터는 것이 중요하다.

### 문제 해설

- 특정 위치의 창고를 털지 안털지를 결정한다.
    - 턴다 → 바로 옆 창고를 안 턴다
    - 안 턴다 → 바로 옆 창고를 턴다
- memo의 각 칸에는 누적 값의 합을 저장한다.
- 자기 자신 + i - 2 누적값 vs i - 1

```java
import java.util.*;
import java.io.*;

// TODO: 다시 풀어볼것

public class MyClass {
    
    private static int[] memo;
    private static String[] foods;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        memo = new int[n];
        foods = reader.readLine().split(" ");
        
        memo[0] = Integer.parseInt(foods[0]);
        // 0이 크면 1은 털지 않는 것으로 간주
        memo[1] = Math.max(memo[0], Integer.parseInt(foods[1]));
        
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], Integer.parseInt(foods[i]) + memo[i - 2]);
        }
        
        System.out.println(memo[n - 1]);
    }
}
```

## 실전문제 3 - 바닥 공사

![image](https://github.com/yu-heejin/Backup/assets/96467030/56f8861d-93e4-45c9-a32e-69703f3fada0)

### 풀이 과정

- 가로 길이 N, 세로 길이 2
- 덮개는 1 x 2, 2 x 1, 2 x 2

```java
import java.util.*;
import java.io.*;

// TODO: 다시 풀어볼것
// 코드 실행 시간:                    2ms

public class MyClass {
    
    private static int[] memo;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        int[] memo = new int[n];
        
        memo[0] = 1;
        memo[1] = 3;
        
        for (int i = 2; i < n; i++) {
            memo[i] = (memo[i - 2] * 2 + memo[i - 1]) % 796796;
        }
        
        System.out.println(memo[n-1]);
    }
}
```

### 문제 해설

```java
import java.util.*;

public class Main {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
    public static int[] d = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N을 입력받기
        int n = sc.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        // 계산된 결과 출력
        System.out.println(d[n]);
    }
}
```

## 실전 문제 4 - 효율적인 화폐 구성

![KakaoTalk_20230628_210038946_01](https://github.com/yu-heejin/Backup/assets/96467030/e922370d-1e4e-4926-a6e8-406c8a2e1cfb)

### 풀이 과정 및 문제 해설

- n가지 종류의 화폐
- 화폐의 개수를 최소한으로 사용하여 가치의 합이 M원이 되도록 한다.
- 순서는 다른 것은 같은 경우로 구분한다.
- **i-k를 구성할 수 있는 방법이 존재한다면 i를 구성하는 방법 역시 존재한다.**

```java
import java.util.*;
import java.io.*;

// TODO: 다시 풀어볼것
// 코드 실행 시간:                    1ms

public class MyClass {
    
    private static final int MAX = 10001;
    private static int[] memo;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        
        int[] monies = new int[n];
        int[] results = new int[m + 1];
        
        for (int i = 0; i < n; i++) {
            monies[i] = Integer.parseInt(reader.readLine());
        }
        
        Arrays.fill(results, MAX);
        results[0] = 0;
        
        for (int i = 0; i < n; i++) {
            int money = monies[i];
            
            for (int j = money; j <= m; j++) {   // 해당 돈보다 작으면 만들 수 없으므로 보지 않음
                if (results[j - money] != 10001) {
                    System.out.println("result: " + results[j - money]);
                    results[j] = Math.min(results[j], results[j - money] + 1);
                }
            }
        }
        
        if (results[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(results[m]);
        }
    }
}
```