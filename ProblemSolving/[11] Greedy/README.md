## 모험가 길드

- 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있다.
- 이 때 ‘최대’ 몇 개의 모험가 그룹을 만들 수 있을까?
- 여행을 떠날 수 있는 그룹 수의 최댓값을 구하라
- 공포도가 큰 사람끼리 묶으면 된다.

### 틀린 답

```java
import java.util.*;
import java.io.*;

// CPU Time: 0.10 sec(s), Memory: 32176 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
        List<Integer> fears = new ArrayList<>();
        
        while (token.hasMoreTokens()) {
            fears.add(Integer.parseInt(token.nextToken()));
        }
        
        Collections.sort(fears, Collections.reverseOrder());
        
        int person = fears.get(0);
        int count = 0;
        int group = 0;
        for (int i = 0; i < fears.size(); i++) {
            if (count == person) {
                person = fears.get(i);
                count = 0;
                group++;
            }
            count++;
        }
        
        group++;
        System.out.println(group);
    }
}
```

### 수정한 답

```java
import java.util.*;
import java.io.*;

// CPU Time: 0.09 sec(s), Memory: 31848 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fears = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
        
        while (token.hasMoreTokens()) {
            fears.add(Integer.parseInt(token.nextToken()));
        }
        
        Collections.sort(fears);
        
        int count = 0;
        int group = 0;
        for (int fear : fears) {
            count++;
            if (count >= fear) {
                group++;
                count = 0;
            }
        }
        
        System.out.println(group);
    }
}
```

### 문제 해설

- 공포도를 기준으로 **오름차순**으로 정렬
- 공포도가 가장 낮은 모험가부터 하나씩 확인하며, 그룹에 포함될 모험가의 수를 계산할 수 있다.
- 만약 **현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는 공포도보다 크거나 같다면 그룹을 결성할 수 있다.**
- **몇명의 모험가는 마을에 그대로 남아있어도 된다..!**
    - person 변수를 생각하지 않으면 쉽다.

```java
import java.util.*;

public class Main {

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int result = 0; // 총 그룹의 수
        int count = 0; // 현재 그룹에 포함된 모험가의 수

        for (int i = 0; i < n; i++) { // 공포도를 낮은 것부터 하나씩 확인하며
            count += 1; // 현재 그룹에 해당 모험가를 포함시키기
            if (count >= arrayList.get(i)) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                result += 1; // 총 그룹의 수 증가시키기
                count = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        System.out.println(result);
    }
}
```

## 곱하기 혹은 더하기

- 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 `x`, `+` 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램 작성
- **현재 숫자가 0이거나, 이전 계산값이 0이면 더해주고, 나머지는 곱해준다.**

### 틀린 답

```java
import java.util.*;
import java.io.*;

// CPU Time: 0.09 sec(s), Memory: 31624 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String numbers = reader.readLine();
        int result = 0;
        
        for (int i = 0; i < numbers.length(); i++) {
            int number = numbers.charAt(i) - '0';
            
            if (result == 0 || number == 0) {
                result += number;
            } else {
                result *= number;
            }
        }
        
        System.out.println(result);
    }
}
```

### 수정한 답

```java
import java.util.*;
import java.io.*;

// CPU Time: 0.11 sec(s), Memory: 31984 kilobyte(s)

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String numbers = reader.readLine();
        int result = 0;
        
        for (int i = 0; i < numbers.length(); i++) {
            int number = numbers.charAt(i) - '0';
            
            if (result <= 1 || number <= 1) {
                result += number;
            } else {
                result *= number;
            }
        }
        
        System.out.println(result);
    }
}
```

### 문제 해설

- 일반적으로 `+`보다는 `*`가 값을 더 크게 만든다.
- 그러나 두 수 중 하나라도 `0`이나 `1`인 경우, 곱하기보다는 더하기를 수행하는 것이 효율적이다.
    - **1을 생각 못했다….**
- 두 수 중에서 하나라도 1 이하인 경우엔 더해주고, 2 이상인 경우 곱해주면 된다.
- 현재까지의 계산 결과를 result에 담은 상태로 매 숫자에 대해 연산을 수행한다.
- result가 1 이하이거나 현재 처리하고 있는 숫자가 1 이하라면 더하기 연산을 수행하고, 그렇지 않은 경우 곱하기 연산을 수행한다.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        long result = str.charAt(0) - '0';
        
        for (int i = 1; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            }
            else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}
```

## 문자열 뒤집기

> https://www.acmicpc.net/problem/1439
> 
- 0과 1로만 이루어진 문자열 S
- 모든 숫자를 모두 같은 숫자로 만든다.
- 뒤집는 것은 1을 0으로, 0을 1로 만드는 것과 같다.
- 바꾸는 최소 횟수!
- 0으로 된 구간, 1로 된 구간을 체크한다.
- 전체를 다 바꾸는 것은 어짜피 제자리걸음이기 때문에 고려하지 않는다.

```java
import java.util.*;
import java.io.*;

// 백준 채점 결과: 메모리 - 14152kb	시간 - 132ms

public class MyClass {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[] area = { 0, 0 };
        String numbers = reader.readLine();
        int start = numbers.charAt(0) - '0';
        
        area[start]++;
        
        for (int i = 1; i < numbers.length(); i++) {
            int current = numbers.charAt(i) - '0';
            
            if (start != current) {
                area[current]++;
                start = current;
            }
        }
        
        System.out.println(Math.min(area[0], area[1]));
    }
}
```

### 문제 해설

- 전부 0으로 바꾸는 경우와 전부 1로 바꾸는 경우 중에서 더 적은 횟수를 가지는 경우를 계산하면 된다.

```java
import java.util.*;

public class Main {

    public static String str;
    public static int count0 = 0; // 전부 0으로 바꾸는 경우
    public static int count1 = 0; // 전부 1로 바꾸는 경우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 첫 번째 원소에 대해서 처리
        if (str.charAt(0) == '1') {
            count0 += 1;
        }
        else {
            count1 += 1;
        }

        // 두 번째 원소부터 모든 원소를 확인하며
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                // 다음 수에서 1로 바뀌는 경우
                if (str.charAt(i + 1) == '1') count0 += 1;
                // 다음 수에서 0으로 바뀌는 경우
                else count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
```

## 만들 수 없는 금액

- N개의 동전을 이용해 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램
- 일단 가진 동전을 오름차순으로 정렬한다.
    - 그 후, 하나씩 더해주며 비교한다.

## 무지의 먹방 라이브

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/779940ff-848a-4ddc-8f01-4afc5ebfee07/Untitled.png)