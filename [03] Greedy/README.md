## 당장 좋은 것만 선택하는 그리디

- 이 알고리즘 유형은 국내 알고리즘 교재에서 단어 그대로 번역하여 **‘탐욕법’**으로 소개된다.
- 어떤 문제가 있을 때 **단순 무식하게 탐욕적으로 문제를 푸는 알고리즘**이다.
    - 여기서 탐욕적이라는 말은, **‘현재 상황에서 지금 당장 좋은 것만 고르는 방법’**을 의미한다.
- 그리디 알고리즘을 이용하면 매 순간 가장 좋아 보이는 것을 선택하며, 현재의 선택이 나중에 미칠 영향에 대해서는 고려하지 않는다.
- 그리디 알고리즘의 문제 유형은 앞으로 다루게 될 알고리즘과 비교했을 때 ‘사전에 외우고 있지 않아도 풀 수 있을 가능성이 높은 문제 유형’이라는 특징이 있다.
    - 예외) 다익스트라 알고리즘은 엄밀히 말하면 그리디 알고리즘으로 분류되는데, 그리디 알고리즘이면서 암기가 필요한 알고리즘 이기도 하다.
- 그리디 알고리즘은 **기준에 따라 좋은 것을 선택하는 알고리즘**이므로, 문제에서 **‘가장 큰 순서대로’, ‘가장 작은 순서대로’와 같은 기준을 알게 모르게 제시**해준다.
    - 대체로 이 기준은 정렬 알고리즘을 사용했을 때 만족시킬 수 있기 때문에 **그리디 알고리즘 문제는 자주 정렬 알고리즘과 짝을 이뤄 출제된다.**

## 예제 3-1) 거스름돈

### 문제

당신은 음식점의 계산을 도와주는 점원이다. 카운터에는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다. 손님에게 거슬러줘야 할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라. 단 거슬러 줘야 할 돈 N은 항상 10의 배수이다.

### 내가 푼 코드

```java
public int solution(int N) {
	int sum = 0;
	int[] coins = {500, 100, 50, 10};
	int index = 0;
	
	while (N > 0) {
		sum += N / coins[i];
		N %= coins[i];
		i++;
	}

	return sum;
}
```

### 문제 해설

- 이 문제는 그리디 알고리즘을 이용해 풀 수 있는 대표적인 문제로, 간단한 아이디어만 떠올릴 수 있으면 문제를 해결할 수 있다.
- ‘가장 큰 화폐 단위부터’ 돈을 거슬러 주면 된다!
- N원을 거슬러줘야할 때, 가장 먼저 500원으로 거슬러줄 수 있을 만큼 거슬러주고, 100원, 50원, 10원짜리 동전을 차례대로 거슬러주면 최소의 동전 개수로 모두 거슬러줄 수 있다.

### 답안 코드

- 파이썬
    
    ```java
    n = 1260
    count = 0
    
    # 큰 단위 화폐부터 차례대로 확인
    coin_types = [500, 100, 50, 10]
    
    for coin in coin_types:
    	count += n // coin  # 해당 화폐로 거슬러 줄 수 있는 동전의 개수 세기
    	n %= coin
    
    print(count)
    ```
    
- 자바
    
    ```java
    public class Main {
    
        public static void main(String[] args) {
            int n = 1260;
            int cnt = 0;
            int[] coinTypes = {500, 100, 50, 10};
    		
            for (int i = 0; i < 4; i++) {
                int coin = coinTypes[i];
                cnt += n / coin;
                n %= coin;
            }
    
            System.out.println(cnt);
        }
    
    }
    ```
    
- 코드를 살펴보면 화폐의 종류만큼 반복을 수행하기 때문에, 화폐의 종류가 K개이면 시간 복잡도는 O(K)이다.
- 알고리즘의 시간 복잡도는 동전의 총 종류에만 영향을 받고, 거슬러줘야 하는 금액의 크기와는 무관하다.

## 그리디 알고리즘의 정당성

- 그리디 알고리즘을 모든 알고리즘 문제에 적용할 수 있는 것은 아니다.
    - **대부분의 문제는 그리디 알고리즘을 이용했을 때 ‘최적의 해’를 찾을 수 없을 가능성이 다분하다.**
    - 그러나 탐욕적으로 문제에 접근했을 때 정확한 답을 찾을 수 있다는 보장이 있을 때는 매우 효과적이고 직관적이다.
- 그리디 알고리즘으로 문제의 해법을 찾았을 때는 **그 해법이 정당한지 검토**해야 한다.
    - 거스름돈 문제를 그리디 알고리즘으로 해결할 수 있는 이유는 **가지고 있는 동전 중에서 큰 단위가 ‘항상’ 작은 단위의 ‘배수’이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없기 때문**이다.
    - **‘항상’이라는 점에 주목할것!!!!!!!!!!!**
- 예를 들어, 800원을 거슬러줘야 할 때 화폐 단위가 500원, 400원, 100원인 경우를 생각해보자.
    - 이 경우 그리디 알고리즘으로는 4개의 동전(500, 100, 100, 100)을 거슬러줘야 하지만 최적의 해는 2개의 동전(400, 400)을 거슬러주는 것이다.
    - **500은 400의 배수가 될 수 없다.**
    - 다시 말해, 이 문제에서는 **큰 단위가 작은 단위의 배수 형태**이므로, ‘가장 큰 단위의 화폐부터 가장 작은 단위의 화폐까지 차례대로 확인하여 거슬러주는 작업만을 수행한다’는 아이디어는 정당하다.
    - 대부분의 그리디 알고리즘 문제에서는 **이처럼 문제 풀이를 위한 최소한의 아이디어를 떠올리고 이것이 정당한지 검토할 수 있어야 답을 도출할 수 있다.**
- 실제로 거스름돈 문제에서 동전의 단위가 서로 배수 형태가 아니라 **무작위로 주어진 경우에는 그리디 알고리즘으로는 해결할 수 없다.**
    - 무작위로 주어진 경우는 다이나믹 프로그래밍으로 해결할 수 있다.

---

## 큰 수의 법칙

### 풀이 과정

1. 일단 BufferedReader로 받아서 저장한다.
2. 정렬한다.
    - 시간을 줄이기 위해 Collection으로 받아서 Collections.sort()
3. count 3을 해서 4, 8 … 등의 4의 배수면 인덱스를 ++하고 그 다음 다시 줄여준다.

```java
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
        long startTime = System.currentTimeMillis();

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

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("코드 실행 시간: %20dms", endTime - startTime));
    }
}
```

### 문제 해설

- 이 문제를 해결하려면 입력값 중에서 **가장 큰 수와 두번째로 큰 수만 저장**하면 된다. ~~(천재네…)~~
- 또한, 수학적으로 접근하기 위해 반복되는 수열에 대해서 파악해야 한다.
    - 가장 큰 수와 두번째로 큰 수가 더해질 때는 **특정한 수열 형태로 일정하게 반복해서 더해지는 특징이 있다.**
- 반복되는 수열의 길이는 (K + 1)이다.
    - 따라서 M을 (K + 1)로 나눈 몫이 수열이 반복되는 횟수가 된다
    - 여기에 K를 곱해주면 (반복되는 배열 내에서) 가장 큰 수가 등장하는 횟수가 된다.
- 이때 M이 **(K+1)로 나누어 떨어지지 않는 경우도 존재**한다.
    - 그럴 땐 **M을 (K+1)로 나눈 나머지만큼 가장 큰 수가 추가로 더해지므로 이를 고려**해야한다.
- 결과적으로 가장 큰 수가 더해지는 횟수는 다음과 같다.
    
    <aside>
    💡 int(M / (K + 1)) * K + M % (K + 1)
    
    </aside>
    

```java
import java.util.*;

public class Main {

// 코드 실행 시간:                  112ms

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        **int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);**

        int result = 0;
        **result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기**

        System.out.println(result);
    }

}
```

---

## 숫자 카드 게임

### 풀이 과정

- 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 하지만 가장 높은 숫자인 카드를 뽑아야한다.
1. 일단 BufferedReader로 N, M을 받는다.
2. 숫자를 받고 가장 작으면서도 큰 값을 찾는다.

```java
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
```

### 문제 해설

- 문제의 아이디어는 **각 행마다 가장 작은 수를 찾은 뒤 그 수 중 가장 큰 수를 찾는 것**이다.
- 이 문제를 해결하기 위해서는 리스트에서 가장 작은 원소를 찾아주는 min()함수를 이용하거나 2중 반복문 구조를 이용해야 한다. (파이썬)

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
    }

}
```

---

## 1이 될 때까지

### 풀이 과정

- N, K를 배수의 관계로 만들기 위해 1을 뺀 후 나누기를 수행한다.
- 나누어 떨어질 때에만 K로 나눌 수 있다는 것을 기억하라
- 또한, 0이 아니라 1을 만들어야한다…..
- 25 5가 1인 이유
    1. 25 / 5 = 5
    2. 5 / 5 = 1
    - 나머지가 아니라 몫이 정답임
- 나눠지면 나누고 아니면 -1

```java
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
```

### 문제 해설

- ‘최대한 많이 나누기’
    - 어떤 수가 있을 때 2이상의 수로 나누는 것이 1을 빼는 것보다 숫자를 훨씬 많이 줄일 수 있기 때문이다.
- 다음의 과정을 반복하면 정답을 구할 수 있다.
    1. N이 K의 배수가 될 때까지 1씩 빼기
    2. N을 K로 나누기

```java
import java.util.*;

public class Main {
// 코드 실행 시간:                   58ms
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            **int target = (n / k) * k;
            result += (n - target);**
            n = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result);
    }

}
```
---

## 모험가 길드

### 풀이 과정

- 공포도가 높은 모험가는 쉽게 공포를 느낀다.
- 공포도 X이면 반드시 X명 이상 모여야한다. (공포도가 같을 필요는 없음)
- 그룹수의 **최댓값**

1. 일단 공포도의 최댓값을 구한다.
2. 최댓값만큼 사람을 데려간다.
    1. **이때 공포도가 높은 사람을 데려가는것이 최댓값을 늘리는데 조금 더 유리**하다.
3. 3, 2, 2, 2, 1

```java
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

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        List<Integer> members = new ArrayList<>();
        
        while (st2.hasMoreTokens()) {
            members.add(Integer.parseInt(st2.nextToken()));
        }
        
        Collections.sort(members, Comparator.reverseOrder());
        
        List<List<Integer>> groups = new ArrayList<>();
        int index = 0;

        while(index < members.size()) {
            List<Integer> group = new ArrayList<>();
            int count = 0;
            
            while(count < members.get(index)) {
                group.add(members.get(index + count));
                count++;
            }

            groups.add(group);
            index += count;
        }
        
        System.out.println(groups.size());
    }
}
```

## 곱하기 혹은 더하기

### 풀이 과정

- 앞 숫자나 계산 결과가 0이면 +, 아니면 그냥 몽땅 곱하기
- 20억 이하의 정수이므로 long말고 int

```java
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
```

## 문자열 뒤집기

### 풀이 과정

- 연속된 숫자만 뒤집을 수 있다.
- 1이 시작되는 시점, 0이 시작되는 시점을 계산한다.
- 시작 시점이 작은 쪽을 바꿔준다 → 더 큰 쪽을 프린트

```java
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
        long endTime = System.currentTimeMillis();
    }
}
```

## 만들 수 없는 금액

### 풀이 과정

- 만들 수 없는 양의 정수 금액 중 최솟값
- 값을 더하지 말고, 작은 값 순서대로 정렬한다음 차례로 만들 수 있는 숫자를 확인한다.
- 목표값이 해당 동전보다 작으면 만들 수 없고, 동전을 하나씩 더해간다.

```java
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
```

- 동전이 1, 1, 2, 3, 9가 있다고 가정하자.
    1. 동전 1 → 1
    2. 동전 1, 1 → 1, 2
    3. 동전 1, 1, 2 → 1, 2, 3, 4
    4. 동전 1, 1, 2, 3, 9 → 1, 2, 3, 4, 5, 6, 7, 16
- 타겟값을 초기에는 1로 설정한다. (제일 작은 값)
- 만약 타겟값보다 새로 추가한 동전이 더 크면 해당 값은 만들 수 없다.
    - **새로 추가한 동전을 모두 더한 값이 만들 수 있는 가장 최대의 값**이기 때문
    - https://codingexplore.tistory.com/34