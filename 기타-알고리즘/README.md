## 더 알아두면 좋은 알고리즘

### 소수의 판별

- 소수란 2보다 큰 자연수 중에서 **1과 자기 자신을 제외한 자연수로는 나누어 떨어지지 않는 자연수**를 말한다.
- 소수는 2보다 큰 자연수에 대해 정의되므로, **1은 소수에 해당하지 않는다는 특징**이 있다.
- 어떤 자연수가 주어졌을 때, 소수인지 아닌지 판별하는 가장 간단한 방법은 자연수 X를 2부터 X-1까지 나눠보는 것이다.
    
    ```java
    public static boolean isPrime(int x) {
    	for (int i = 2; i < x; i++) {
    		if (x % i == 0) {
    			return false;
    		}
    	}
    
    	return true;
    }
    ```
    
    - 해당 알고리즘의 시간 복잡도는 O(x)이다.
    - 숫자가 커지면 비효율적이다.
- 위 알고리즘을 개선해서 하나의 수가 소수인지 판별하는 알고리즘을 더 빠르게 동작하도록 변경할 수 있다.
    - 예를 들어, 16이라는 수의 약수는 다음과 같다.
        
        ```java
        1, 2, 4, 8, 16
        ```
        
    - 이 때 모든 약수에 대해서 **가운데 약수를 기준으로 하여 대칭적으로 2개씩 앞 뒤로 묶어서 곱하면 16을 만들 수 있다.**
        
        ```java
        1 x 16
        2 x 8
        4 x 4
        8 x 2
        16 x 1
        ```
        
        - 가운데 약수를 기준으로 각 등식이 대칭적인 형태를 보이는 것을 알 수 있다.
    - 따라서 우리는 특정한 자연수 X가 소수인지 확인하기 위해 **바로 가운데 약수까지만 나누어 떨어지는지 확인하면 된다.**
        - 위 예시에서는 4까지만 확인하면 된다.
        - 즉, 2, 3, 4를 확인하여 나누어 떨어지는지 확인한다.
        - 다시말해 제곱근까지만(가운데 약수까지만) 확인하면 된다.
- 개선된 알고리즘으로 소수를 판별하면 O(X^1/2)에 소수를 판별할 수 있다.
    
    ```java
    public static boolean isPrime(int x) {
    	for (int i = 2; i <= Math.sqrt(x); i++) {
    		if (x % i == 0) return false;
    	}
    
    	return true;
    }
    ```
    

### 에라토스테네스의 체

- 에라토스테네스의 체 알고리즘은 **여러 개의 수가 소수인지 아닌지를 판별할 때 사용하는 알고리즘이다.**
- N보다 작거나 같은 모든 소수를 찾을 때 사용할 수 있다.
- 에라토스테네스의 체 알고리즘의 과정은 다음과 같다.
    1. 2부터 N까지의 모든 자연수를 나열한다.
    2. 남은 수 중에서 아직 처리하지 않은 가장 작은 수 i를 찾는다.
    3. 남은 수 중에서 i의 배수를 모두 제거한다. (i는 제거하지 않는다.)
    4. 더이상 반복할 수 없을 때까지 2번과 3번의 과정을 반복한다.
- 매 스텝마다 남은 수중에서 아직 처리하지 않은 가장 작은 수 i를 찾는다고 했으나, 이 때 i는 N의 제곱근까지만 증가시켜 확인하면 된다.

```java
public static int n = 1000;
public static boolean[] arr = new boolean[n + 1];

public static void main(String[] args) {
	Arrays.fill(arr, true);   // 처음엔 모든 수가 소수인 것으로 초기화

	for (int i = 2; i <= Math.sqrt(n); i++) {
		if (arr[i] == true) {
			int j = 2;
			while (i * j <= n) {
				arr[i * j] = false;
				j++;
			}
		}
	}
}
```

```java
boolean[] checkPrime = new boolean[n + 1];
int count = 0;

checkPrime[0] = false;
checkPrime[1] = false;   // 1은 소수가 아니다.

for (int i = 2; i <= n; i++) {
    checkPrime[i] = true;
}

for (int i = 2; i * i <= n; i++) {
    if (checkPrime[i]) {
        for (int j = 2 * i; j <= n; j += i) checkPrime[j] = false;
				// i * 2로 시작해서 i를 점차 더해주면 i의 배수가 만들어진다.
    }
}
```

- 에라토스테네스의 체 알고리즘의 시간 복잡도는 O(NloglogN)으로 매우 빠르다.
- 동작이 빠르기 떄문에 다수의 소수를 찾는 문제에서 유용하지만, 메모리가 많이 필요하다는 단점이 있다.
- 에라토스테네스의 체를 이용해야 되는 문제의 경우 N이 1,000,000 이내로 주어지는 경우가 많다.

### 투 포인터 (Two Pointer)

- 투 포인터 알고리즘은 리스트에 순차적으로 접근해야할 때 **2개의 점의 위치를 기록하면서 처리하는 알고리즘을 의미한다.**
- 예를 들어 한 반에 학생이 40명이 있을 때, 모든 학생을 번호 순서대로 일렬로 세운 뒤, 학생들을 순차적으로 지목해야 할 경우를 생각해보자.
    - 2, 3, 4, 5, 6, 7번 학생을 지목해야할 때 번호로 한명씩 부르기 보다는 2번부터 7번까지의 학생이라고 부를 수도 있다.
    - 이처럼 **리스트에 담긴 데이터에 순차적으로 접근**해야할 땐 **시작점과 끝점 2개의 점으로 접근할 데이터의 범위를 표현할 수 있다.**

### 투 포인터 응용 - 특정한 합을 가지는 부분 연속 수열 찾기

- 투 포인터 알고리즘을 이용하여 **특정한 합을 가지는 부분 연속 수열 찾기 문제**를 풀 수 있다.
    - 특정한 합을 가지는 부분 연속 수열 찾기 문제는 양의 정수로만 구성된 리스트가 주어졌을 때, **그 부분 연속 수열 중에서 ‘특정한 합’을 갖는 수열의 개수를 출력하는 문제이다.**
- 투 포인터 알고리즘의 특징은 2개의 변수를 이용해 리스트 상의 위치를 기록한다는 점이다.
    - 부분 연속 수열 찾기 문제에서는 부분 연속 수열의 시작점과 끝점의 위치를 기록한다.
- 특정한 부분합을 M이라고 할 때, 구체적인 알고리즘은 다음과 같다.
    1. 시작점과 끝점이 첫번째 원소의 인덱스를 가리키도록 한다.
    2. 현재 부분합이 M과 같으면 count
    3. M보다 작으면 end를 1 증가시킨다.
    4. M보다 크거나 같으면 start를 1 증가시킨다.
    5. 모든 경우를 확인할 때까지 2번부터 4번까지의 과정을 반복한다.
- 이러한 문제를 투 포인터 알고리즘으로 해결할 수 있는 이유는 **기본적으로 시작점을 오른쪽으로 이동시키면 항상 합이 감소하고, 끝 점을 오른쪽으로 이동시키면 항상 합이 증가하기 때문이다.**
- 만약 원소에 음수 데이터가 포함된 경우 투 포인터 알고리즘으로 문제를 해결할 수 없다.

```java
static int n = 5;  // 요소의 개수
static int m = 5;  // 구해야하는 부분합
static int[] arr = { 1, 2, 3, 2, 5 };

public static void main(String[] args) {
	int cnt = 0;
	int intervalSum = 0;   // 부분합
	int end = 0;

	// start가 n보다 작을 때까지 반복
	for (int start = 0; start < n; start++) {
		while (intervalSum < m && end < n) {
			// end가 처음에는 start와 같은 위치이다.
			intervalSum += arr[end];
			end++;
		}

		if (intervalSum == m) {
			cnt++;
		}

		intervalSum -= arr[start];
	}

	System.out.println(cnt);
}
```

전반적으로,,, 로직이 잘 이해안감 ㅜㅜ스타트를 왜 빼는거지

### 투 포인터 알고리즘 - 정렬되어 있는 두 리스트의 합집합

- 투 포인터 알고리즘은 **정렬되어 있는 두 리스트의 합집합** 같은 문제에 효과적으로 사용할 수 있다.
- 이 문제는 **이미 정렬되어 있는 2개의 리스트가 입력으로 주어진다.**
    - 이 때 **두 리스트의 모든 원소를 합쳐서 정렬한 결과를 계산하는 것이 문제의 요구사항**이다.
    - 정렬되어 있는 리스트의 합집합 알고리즘은 병합 정렬(Merge Sort)과 같은 알고리즘에서 사용된다.
- 이 문제를 풀기 위해서는 2개의 리스트 A, B가 주어졌을 때 **2개의 포인터를 이용하여 각 리스트에서 처리되지 않은 원소 중 가장 작은 원소를 가리키면 된다.**
- 기본적으로 이미 정렬된 결과가 주어지므로 리스트 A와 B의 원소를 앞에서부터 확인하면 된다.
    1. 정렬된 리스트 A, B를 입력받는다.
    2. 리스트 A에서 처리되지 않은 원소 중 가장 작은 원소를 i가 가리키도록 한다.
    3. 리스트 B에서 처리되지 않은 원소 중 가장 작은 원소를 j가 가리키도록 한다.
    4. **A[i]와 B[j]중 더 작은 원소를 결과 리스트에 담는다.**
    5. 리스트 A와 B에서 더 이상 처리할 원소가 없을 때까지 반복한다.
- 결과적으로 정렬된 리스트 A, B의 데이터 개수가 각각 N, M이라고 했을 때, 이 알고리즘의 시간 복잡도는 `O(N + M)`이다.
    - 단순히 각 리스트의 모든 원소들을 한 번씩만 순회하면 되기 때문이다.

```java
static int n = 3;   // a의 원소의 개수
static int m = 4;   // b의 원소의 개수
static int[] a = {1, 3, 5};
static int[] b = {2, 4, 6, 8};

// result 변수 초기화
static int[] result = new int[n + m];

public static void main(String[] args) {
	int i = 0, j = 0, k = 0;   // a, b, result 배열의 인덱

	while (i < n || j < m) {
		if (j >= m || (i < n && a[i] <= b[j]) {
			// 만약 j의 원소가 모두 들어갔거나 a의 원소가 b의 원소보다 작은 경우
			result[k] = a[i];
			i++;
		} else {
			// 그 외의 경우
			result[k] = b[j];
			j++;
		}

		k++;
	}
}
```

- 정렬되어 있는 두 리스트의 합집합 알고리즘의 경우, 병합 정렬과 같은 일부 알고리즘에서 사용되고 있다.

### 구간 합 계산

- 구간 합 문제란 연속적으로 나열된 N개의 수가 있을 때, **특정 구간의 모든 수를 합한 값을 구하는 문제를 의미한다.**
    - 예를 들어 5개의 데이터로 구성된 수열 10, 20, 30, 40, 50이 있다고 가정했을 때, 2번째 수부터 4번째 수까지의 합은 20+30+40으로 90이 된다.
    - 부분합이랑 비슷한듯..?
- 이러한 구간 합 계산 문제는 여러 개의 쿼리로 구성되는 문제 형태로 출제되는 경우가 많다.
    - 다수의 구간에 대해서 합을 각각 구하도록 요구된다.
- 예를 들어 M개의 쿼리가 존재한다고 가정하자.
    - 각 쿼리는 L, R로 구성되며, 이는 `[left, right]`의 구간을 의미한다
    - 결과적으로 M개의 쿼리가 주어졌을 때, **모든 쿼리에 대해 구간의 합을 출력하는 문제가 전형적인 구간 합 계산 문제이다.**
- 만약 M개의 쿼리가 각각 매번 구간 합을 계산한다고 하면, 이 알고리즘은 `O(NM)`의 시간 복잡도를 가진다.
    - 왜냐하면 M개의 쿼리가 수행될 때마다 전체 리스트의 구간 합(1부터 N까지)을 모두 계산하라고 요구할 수도 있기 때문이다.
    - 이 경우 데이터의 개수가 매우 많으면 문제를 해결할 수 없다.
- 항상 알고리즘을 설계할 땐, 여러 번 사용될만한 정보는 미리 구해 저장해놓을 수록 유리하다.
    - 따라서 N개의 수에 대해서 어떤 처리를 수행한 후 **나중에 M개의 쿼리가 각각 주어질 때마다 빠르게 구간 합을 도출할 수 있도록 하면 어떨까?**
- 구간 합을 계산하기 위해 가장 많이 사용되는 기법이 바로 **접두사 합(Prefix Sum)**이다.
    - 각 쿼리에 대해 구간 합을 빠르게 계산하기 위해 **N개의 수의 위치 각각에 대해 접두사 합을  미리 구해놓으면 된다.**
    - 여기사 접두사 합이란 리스트의 맨 앞부터 특정 위치까지의 합을 구해놓은 것을 의미한다.

### 구간 합 빠르게 구하기 알고리즘

> N개의 수에 대해 접두사 합(Prefix Sum)을 계산하여 배열 P에 저장한다.
> 

> 매 M개의 쿼리 정보 `[L, R]` 를 확인할 때, 구간합은 `P[R] - P[L-1]`    **// 왜..???**
> 
- 위에서 설명한 알고리즘대로 매 쿼리가 들어왔을 때, `P[R] - P[L-1]`을 계산하면 바로 구간 합을 구할 수 있게 된다.
    - 따라서 매 쿼리당 계산 시간은 `O(1)`이 된다.
    - 결과적으로 N개의 데이터와 M개의 쿼리가 있을 때, 전체 구간 합을 모두 계산하는 작업은 `O(N + M)`이 된다.
- 다음과 같이 쿼리 3개가 있을 때 구간 합을 구하는 과정은 다음과 같다.
    - [1, 3] → P[3] - P[0]
    - [2, 5] → P[5] - P[1]
    - [3, 4] → P[4] - P[2]

```java
static int n = 5;
static int arr[] = {10, 20, 30, 40, 50};
static int[] prefixSum = new int[6];

public static void main(String[] args) {
	int sumValue = 0;
	
**// 구간합을 이렇게 계산하는 이유는?????**
	for (int i = 0; i < n; i++) {
		sumValue += arr[i];
		prefixSum[i + 1] = sumValue;
	}

	// 구간 합 계산(3번째 수부터 4번째 수까지)
	int left = 3;
	int right = 4;
	System.out.println(prefixSum[right] - prefixSum[left - 1]);
}
```

### 순열과 조합

- 경우의 수란 한 번의 시행에서 ‘일어날 수 있는 사건의 가지 수’를 의미한다.
- 순열과 조합은 파이썬3 버전 이상에서는 순열과 조합 기능을 제공하는 라이브러리를 기본으로 제공한다.
    - 자바는 그런거 없어~
- **순열(Permutation)이란 서로 다른 n개에서 r개를 선택하여 일렬로 나열**하는 것을 의미한다.
    - 이를 `nPr`이라고도 하며, 경우의 수를 계산하는 공식은 `nPr = n! / (n - r)!`이다.
    - 순열
        
        ```java
        // 매번 전체 아이템중에서 뽑는다.
        private void combination(int[] numbers, int n, int r) {
            if (r == 0) {
                results.add(numbers[bucket[0]] + numbers[bucket[1]]);
                return;
            }
            
            int lastIndex = bucket.length - r - 1;
            int smallest = 0;
            
            for (int i = smallest; i < n; i++) {
                boolean isPick = false;
        
                for (int j = 0; j < lastIndex + 1; j++) {
                    if (i == bucket[j]) {
                        isPick = true;
                        break;
                    }
                }
                
                if (!isPick) {
                    bucket[lastIndex + 1] = i;
                    combination(numbers, n, r - 1);
                }
            }
        }
        ```
        
    - 중복 순열
        
        ```java
        // 매번 전체 아이템중에서 뽑는다.
        private void combination(int[] numbers, int n, int r) {
            if (r == 0) {
                results.add(numbers[bucket[0]] + numbers[bucket[1]]);
                return;
            }
            
            int lastIndex = bucket.length - r - 1;
            int smallest = 0;   // 매번 전체에서 뽑는다.
            
            for (int i = smallest; i < n; i++) {
                bucket[lastIndex + 1] = i;
                combination(numbers, n, r - 1);
            }
        }
        ```
        
- **조합(Combination)이란 서로 다른 n개에서 순서에 상관없이 서로 다른 r개를 선택**하는 것을 의미한다.
    - 조합은 `nCr`의 형태로 표현하며, 경우의 수를 계산하는 공식은 `nCr = n! / r! x (n - r)!`이다.
    - 순열은 `{1, 2, 3}`에서 서로 다른 2개의 원소를 뽑아 나열할 때 가능한 모든 순서를 고려하지만, **조합은 순서는 고려하지 않는다.**
    - 조합 (프로그래머스 lv1: 두 개 뽑아서 더하기)
        
        ```java
        import java.util.Set;
        import java.util.TreeSet;
        import java.util.Iterator;
        
        class Solution {
            private final int PICK_NUMBER = 2;
            private Set<Integer> results;
            private int[] bucket;
            
            public int[] solution(int[] numbers) {
                results = new TreeSet<>();
                bucket = new int[PICK_NUMBER];
                
                combination(numbers, numbers.length, PICK_NUMBER);
                
                return getAnswer();
            }
            
            private void combination(int[] numbers, int n, int r) {
                if (r == 0) {
                    results.add(numbers[bucket[0]] + numbers[bucket[1]]);
                    return;
                }
                
        		// 조합이기 때문에 가장 마지막에 뽑힌 수보다 큰 수를 뽑는다.
                int lastIndex = bucket.length - r - 1;  // 가장 최근의 뽑힌 수가 저장된 위치
                int smallest = getSmallest(r, lastIndex);  // 뽑혀야하는 최소 수
                
                for (int i = smallest; i < n; i++) {
                    bucket[lastIndex + 1] = i;
                    combination(numbers, n, r - 1);
                }
            }
            
            private int getSmallest(int r, int lastIndex) {
                if (bucket.length > r) {
                    return bucket[lastIndex] + 1;
                }
                
                return 0;
            }
            
            private int[] getAnswer() {
                int[] answers = new int[results.size()];
                Iterator<Integer> iterator = results.iterator();
                int answerIndex = 0;
                
                while (iterator.hasNext()) {
                    answers[answerIndex] = iterator.next();
                    answerIndex++;
                }
                
                return answers;
            }
        }
        ```
        
    - 중복 조합
        
        ```java
        // 조합은 마지막에 뽑은 아이템보다 큰 것을 뽑았지만
        // 중복 조합은 크거나 같은 것을 뽑는다.
        
        private void combination(int[] numbers, int n, int r) {
            if (r == 0) {
                results.add(numbers[bucket[0]] + numbers[bucket[1]]);
                return;
            }
            
        		// 조합이기 때문에 가장 마지막에 뽑힌 수보다 큰 수를 뽑는다.
            int lastIndex = bucket.length - r - 1;  // 가장 최근의 뽑힌 수가 저장된 위치
            int smallest = getSmallest(r, lastIndex);  // 뽑혀야하는 최소 수
            
            for (int i = smallest; i < n; i++) {
                bucket[lastIndex + 1] = i;
                combination(numbers, n, r - 1);
            }
        }
        
        private int getSmallest(int r, int lastIndex) {
            if (bucket.length > r) {
                return bucket[lastIndex];   // 이전에 뽑았던 것과 같은 수
            }
            
            return 0;
        }
        ```
        

---

## 예제 B-1 소수 구하기

### 풀이 과정

```java
import java.util.*;
import java.io.*;

public class MyClass {
    
    private static String[] input;
    private static boolean[] isPrime;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        isPrime = new boolean[n + 1];
        
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                int j = 2;
                
                while (i * j <= n) {
                    // i의 배수를 모두 제거한다.
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }
        
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
```

### 문제 해설

- 에라토스테네스의 체 알고리즘을 이용해 해결할 수 있다.

## 예제 B-2 암호 만들기

### 풀이 과정

- 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며, 최소 한 개의 모음과 두 개의 자음으로 구성되어 있다.
- 정렬을 선호하기 때문에 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것
- 일단 입력된 알파벳을 정렬 → 뽑기
- 단, 한개의 모음(aeiou), 두 개의 자음으로 구성된 것을 검사해야
    - 어짜피 모음 아니면 자음이니 모음이 하나 이상인것만 확인

```java
import java.util.*;
import java.io.*;

public class MyClass {
    
    private static final List<String> VOWEL = Arrays.asList(new String[] { "a", "e", "i", "o", "u" });
    private static String[] input;
    private static int[] bucket;
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        int l = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        
        String[] alphabet = reader.readLine().split(" ");
        Arrays.sort(alphabet);
        
        bucket = new int[l];
        
        combination(alphabet, c, l);
    }
    
    private static void combination(String[] alphabet, int n, int r) {
        if (r == 0) {
            StringBuilder answer = new StringBuilder();
            int vowel = 0;
            
            for (int i = 0; i < bucket.length; i++) {
                if (VOWEL.contains(alphabet[bucket[i]])) {
                    vowel++;
                }
                answer.append(alphabet[bucket[i]]);
            }
            
            if (vowel >= 1) {
                System.out.println(answer);
            }

            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = 0;
        
        if (bucket.length > r) {
            smallest = bucket[lastIndex] + 1;
        }
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(alphabet, n, r - 1);
        }
    }
}
```

### 문제 해설

- 조합 알고리즘을 사용한다.