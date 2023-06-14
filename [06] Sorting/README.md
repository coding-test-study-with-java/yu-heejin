## 기준에 따라 데이터 정렬

### 정렬 알고리즘 개요

- 정렬(Sorting)이란 **데이터를 특정한 기준에 따라서 순서대로 나열하는 것**을 말한다.
- 정렬 알고리즘으로 데이터를 정렬하면 **이진 탐색(Binary Search)이 가능**해진다.
    - **정렬 알고리즘은 이진 탐색의 전처리 과정**이기도 하다.

### 선택 정렬

```java
public class Main {
	public static void main(String[] args) {
		int n = 10;
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

		for (int i = 0; i < n; i++) {
			int minIndex = i;   // 가장 작은 원소의 인덱스
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
```

- 데이터가 무작위로 여러 개 있을 때, **이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두번째 데이터와 바꾸는 과정을 반복**한다.
- 가장 원시적인 방법으로 **매번 ‘가장 작은 것’을 선택한다는 의미**에서 **선택 정렬(Selection Sort) 알고리즘**이라고 한다.
- **가장 작은 것을 선택해서 앞으로 보내는 과정을 반복해서 수행**하면, 전체 데이터의 정렬이 이루어진다.
- swap은 특정한 리스트가 주어졌을 때 두 변수의 위치를 변경하는 작업을 의미한다.

### 선택 정렬의 시간 복잡도

- 선택 정렬은 N-1번만큼 가장 작은 수를 찾아서 맨 앞으로 보내야한다.
- 또한, 매번 가장 작은 수를 찾기 위해 비교 연산이 필요하다.
- 따라서, **빅오 표기법으로 간단히 O(N^2)으로 표현할 수 있다.**
- 보통 **반복문이 얼마나 중첩되었는지를 기준으로 간단히 시간 복잡도를 판단할 수 있다.**
    - 선택 정렬은 소스 코드 상으로 간단한 형태의 이중반복문이 사용되었다.
- 선택 정렬을 이용하는 경우 데이터의 개수가 10,000개 이상이면 정렬 속도가 급격히 느려진다.
- 선택 정렬은 다른 정렬 알고리즘에 비해 매우 비효율적이다.

### 삽입 정렬

```java
public class Main {
	public static void main(String[] args) {
			int n = 10;
      int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

			for (int i = 1; i < n; i++) {
				// i가 1부터 시작하는 이유는 0번째 데이터는 정렬되어있다고 가정하기 때문
				for (int j = i; j > 0; j--) {
					// i부터 1까지 감소하며 반복한다.
					// 한 칸씩 왼쪽으로 이동
					if (arr[j] < arr[j - 1]) {   // 만약 현재 데이터가 내 앞의 데이터보다 작으면 스왑
						int temp = arr[j];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					} else {
						break;   // 현재 데이터가 내 앞의 데이터보다 크거나 같으므로 멈춤(정렬)
					}
				}
			}

			for (int i = 0; i < n; i++) {
				System.out.println(arr[i] + " ");
			}
		}
	}
}
```

> 데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입하면 어떨까?
> 
- 삽입 정렬은 선택 정렬에 비해 실행 시간 측면에서 더욱 효율적인 알고리즘이다.
- 특히 **삽입 정렬은 필요할 때만 위치를 바꾸므로, ‘데이터가 거의 정렬되어 있을 때’ 훨씬 효율적이다.**
- 선택 정렬은 현재 데이터의 상태와 상관없이 무조건 모든 원소를 비교하고 위치를 바꾸는 반면 삽입 정렬은 그렇지 않다.
- 삽입 정렬은 **특정한 데이터를 적절한 위치에 ‘삽입’한다는 의미에서 삽입 정렬(Insertion Sort)이라고 부른다.**
- 삽입 정렬은 **특정한 데이터가 적절한 위치에 들어가기 이전에, 그 앞까지의 데이터는 이미 정렬되어 있다고 가정한다.**
    - 정렬되어 있는 데이터 리스트에서 적절한 위치를 찾은 뒤, 그 위치에 삽입된다는 점이 특징이다.
- 삽입 정렬은 특징이 있는데, **정렬이 이루어진 원소는 항상 오름차순을 유지하고 있다는 점이다.**
    - 이러한 특징 때문에 삽입 정렬에서는 특정한 데이터가 삽입될 위치를 선정할 때, **삽입될 데이터보다 작은 데이터를 만나면 그 위치에서 멈추면 된다.**
    - 특정한 데이터의 왼쪽에 있는 데이터들은 **이미 정렬된 상태**이므로, **자기보다 작은 데이터를 만났다면 더 이상 데이터를 살펴볼 필요도 없이 그 자리에 삽입되면 되는 것이다!**

### 삽입 정렬의 시간 복잡도

- 삽입 정렬의 시간복잡도 역시 O(N^2)
- 단, 현재 리스트의 데이터가 거의 정렬된 상태라면 매우 빠르게 동작한다.
    - 최선의 경우 O(N)
- 삽입 정렬은 비효율적이지만, 거의 정렬된 상태에서는 퀵 정렬보다 강력하다.

### 퀵 정렬

> 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸면 어떨까?
> 
- 퀵 정렬은 지금까지 배운 정렬 알고리즘 중 가장 많이 사용되는 알고리즘이다.
- **기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작**한다.
- 퀵 정렬에서는 피벗(Pivot)이 사용된다.
    - 큰 수와 작은 수를 교환할 때, 교환하기 위한 기준을 피벗이라 한다.
    - 퀵 정렬을 수행하기 전에는 피벗을 어떻게 설정할 것인지 미리 명시해야 한다.
- 피벗을 설정하고 리스트를 분할하는 방법에 따라 여러가지 방식으로 퀵 정렬을 구분한다.
    - 책에서는 가장 대표적인 분할 방식인 호어 분할(Hoare Partition)방식을 기준으로 퀵 정렬을 설명한다.

### 호어 분할 방식을 이용한 퀵 정렬

- 호어 분할 방식은 **리스트에서 첫번째 데이터를 피벗으로 정한다.**
- 피벗을 설정한 후 **왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터 피벗보다 작은 데이터를 찾은 후 큰 데이터와 작은 데이터의 위치를 서로 교환한다.**
- 퀵 정렬을 한번 수행하고 난 후, 피벗이 이동한 상태에서 왼쪽 리스트와 오른쪽 리스트를 살펴보자.
    - **피벗보다 왼쪽에 있는 데이터는 모두 피벗보다 작고, 피벗보다 오른쪽에 있는 데이터는 모두 피벗보다 크다.**
    - 이러한 상태에서 왼쪽 리스트와 오른쪽 리스트를 개별적으로 정렬시키며, 이러한 과정을 반복한다.
- 퀵 정렬은 이처럼 특정한 리스트에서 피벗을 설정하여 정렬을 수행한 후, 피벗을 기준으로 왼쪽 리스트와 오른쪽 리스트에서 다시 정렬을 수행한다.
    - 재귀 함수와 동작 원리가 같다.
- **퀵 정렬의 종료조건은 현재 리스트(정렬되지 않은 리스트)의 데이터의 개수가 1개인 경우이다.**
    - 리스트의 원소가 1개라면, 이미 정렬되어 있다고 간주하고 분할이 불가능하다.

```java
public class Main {
	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;   // 정렬되지 않은 원소의 개수가 1개인 경우 종료
		}

		int pivot = start;   // 피벗은 첫번째 원소
		int left = start + 1;  // 왼쪽
		int right = end;  // 오른쪽
		
		while (left <= right) {
			while (left <= end && arr[left] <= arr[pivot]) {
				// 왼쪽이 오른쪽보다 작거나 같고, 왼쪽 원소가 피봇 원소보다 작거나 같을 때까지 증가
				// 즉, 원소가 끝까지 가거나 피봇보다 큰 원소를 발견하면 멈춘다.
				left++;
			}

			while (right > start && arr[right] >= arr[pivot]) {
				// 오른쪽이 왼쪽보다 크고, 오른쪽 원소가 피봇 원소보다 크거나 같을 때까지 반복
				// right >= start가 아닌 이유는 피봇까지 검사할 필요가 없기 때문
				// right가 끝까지 가거나 피봇보다 작은 원소를 보면 멈춘다.
				right--;
			}

			if (left > right) {
				// 엇갈린 경우 작은 데이터와 피봇을 교체
				// 엇갈린 경우 왼쪽과 오른쪽을 바꿀 경우 피봇의 위치가 올바르지 않게 된다.
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			} else {
				// 엇갈리지 않은 경우 작은 데이터와 큰 데이터를 바꾼다.
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		// 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
	}
}
```

![Untitled](https://github.com/coding-test-study-with-java/yu-heejin/assets/96467030/f2eb8182-ce32-4a26-91e4-eea7dc8d3e53)

### 퀵 정렬의 시간 복잡도

- 선택 정렬과 삽입 정렬의 시간 복잡도는 O(N^2)
- 퀵 정렬의 시간 복잡도는 O(NlogN)
    - 그러나 최악의 경우 시간 복잡도가 O(N^2)이다.
- 데이터가 무작위로 입력되는 경우 퀵 정렬은 빠르게 동작하지만, 이미 데이터가 정렬되어 있는 경우에는 매우 느리게 동작한다.
    - 삽입 정렬은 데이터가 정렬되어 있는 경우 빠르게 동작하는데, 이와 반대되는 알고리즘이라고 볼 수 있다.

### 계수 정렬

- 계수 정렬(Count Sort) 알고리즘은 **특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠른 정렬 알고리즘이다.**
- 모든 데이터가 양의 정수인 상황을 가정할 때, 데이터의 개수가 N, 데이터 중 최댓값이 K일 때, 계수 정렬은 최악의 경우에도 수행시간이 **O(N + K)**이다.
- 그러나 계수 정렬은 **데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용할 수 있다.**
    - 데이터의 값이 무한한 범위를 가지는 실수형 데이터의 경우는 불가능하다.
    - 일반적으로 가장 큰 데이터와 가장 작은 데이터의 차이가 1,000,000을 넘지 않은 경우 효과적으로 사용할 수 있다.
- **가장 큰 데이터와 가장 작은 데이터의 차이가 너무 크다면 계수 정렬은 사용할 수 없다.**
    - 계수 정렬이 이러한 특징을 가지는 이유는 **계수 정렬을 이용할 땐 모든 범위를 담을 수 있는 크기의 리스트(배열)를 선언해야 하기 때문이다.**
    - 예를 들어 가장 큰 데이터와 가장 작은 데이터의 차이가 1,000,000이라면, 총 1,000,001개의 데이터가 들어갈 수 있는 리스트를 초기화 해야한다.
    - **만약 들어온 데이터가 1, 1000 두 수 인데 계수 정렬을 사용하면 1부터 1001까지 불필요한 배열을 선언해야 한다.**
- 계수 정렬은 앞서 다루었던 3가지 정렬 알고리즘처럼 직접 데이터의 값을 비교한 뒤 위치를 비교하며 정렬하는 방식(비교 기반의 정렬 알고리즘)이 아니다.
- 계수 정렬은 일반적으로 **별도의 리스트를 선언하고 그 안에 정렬에 대한 정보를 담는다는 특징이 있다.**
- 계수 정렬은 먼저 **가장 큰 데이터와 가장 작은 데이터의 범위가 모두 담길 수 있도록 하나의 리스트를 생성한다.**
    - 그 후 데이터를 하나씩 확인하며 **데이터의 값과 동일한 인덱스의 데이터를 1씩 증가시키면 계수 정렬이 완료된다.**
- 결과적으로 **리스트에는 각 데이터가 몇 번 등장했는지 그 횟수가 기록된다.**

```java
import java.util.*;

public class Main {
	
    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
    	
        int n = 15;
        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
				// 이 방법은 자바 초기화 방법에 따라 다르니 **명시적으로 0으로 초기화하는 것이 좋다!!!!**
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스의 값 증가
        }

        for (int i = 0; i <= MAX_VALUE; i++) { // 배열에 기록된 정렬 정보 확인
            for (int j = 0; j < cnt[i]; j++) {
                System.out.print(i + " "); // 띄어쓰기를 기준으로 등장한 횟수만큼 인덱스 출력
            }
        }
    }

}
```

### 계수 정렬의 시간 복잡도

- 계수 정렬의 시간 복잡도는 O(N + K)이다.
- 계수 정렬은 앞에서부터 데이터를 하나씩 확인하면서 리스트에서 적절한 인덱스 값을 1씩 증가시킬 뿐 아니라 추후에 리스트의 각 인덱스에 해당하는 값들을 확인할 때 데이터 중 최댓값의 크기만큼 반복을 수행해야 한다.

### 계수 정렬의 공간 복잡도

- 계수 정렬은 심각한 비효율성을 초래할 수도 있다.
- 항상 사용할 수 있는 정렬 알고리즘은 아니며, **동일한 값을 가지는 데이터가 여러개 등장할 때 적합하다.**
    - 반면 앞서 설명한 퀵 정렬은 일반적인 경우에서 평균적으로 빠르게 동작하기 때문에 데이터의 특성을 파악하기 어렵다면 퀵 정렬을 이용하는 것이 유리하다.
- 정리하자면 **계수 정렬은 데이터의 크기가 한정되어 있고 데이터의 크기가 많이 중복되어 있을수록 유리하며 항상 사용할 수는 없다.**
- 계수 정렬의 공간 복잡도는 O(N+K)이다.

---

## 실전 문제 - 위에서 아래로

### 풀이 과정

- 퀵소트를 사용하여 정렬
- 오름차순이 아닌 내림차순임을 기억하라.

```java
import java.util.*;
import java.io.*;

// 오름차순이 아니라 내림차순임을 기억하라
// 퀵소트를 사용하여 정렬
// 코드 실행 시간:                   23ms
public class MyClass {
    private static void quickSort(ArrayList<Integer> numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int pivot = start;
        int left = start + 1;
        int right = end;
        
        while (left <= right) {
            while (left <= end && numbers.get(left) >= numbers.get(pivot)) {
                left++;
            }
            
            while (right > start && numbers.get(right) < numbers.get(pivot)) {
                right--;
            }
            
            if (left > right) {
                int temp = numbers.get(pivot);
                numbers.set(pivot, numbers.get(right));
                numbers.set(right, temp);
            } else {
                int temp = numbers.get(left);
                numbers.set(left, numbers.get(right));
                numbers.set(right, temp);
            }
        }
        
        quickSort(numbers, start, right - 1);
        quickSort(numbers, right + 1, end);
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        
        System.out.println("before: " + numbers);
        
        quickSort(numbers, 0, n - 1);
        
        System.out.println("after: " + numbers);
    }
}
```

### 해설

- Arrays.sort 내장 라이브러리를 사용했다.

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
```

## 성적이 낮은 순서로 학생 출력하기

### 풀이 과정

- 동명이인이 들어올걸 생각해서 TreeMap은 사용하지 않음(쓰면 쉬운데……………)
- 10만개의 데이터 → 계수정렬?
    - 그냥.. sorting 햇슈

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                    5ms

class Student implements Comparable<Student> {
    String name;
    int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    @Override
    public int compareTo(Student student) {
        return this.score - student.score;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
    
public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] nameAndScore = reader.readLine().split(" ");
            students.add(new Student(nameAndScore[0], Integer.parseInt(nameAndScore[1])));
        }
        
        Collections.sort(students);
        
        System.out.println(students);
    }
}
```

### 문제 해설

```java
import java.util.*;

class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();

        // N명의 학생 정보를 입력받아 리스트에 저장
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
```

## 두 배열의 원소 교체

### 풀이 과정

- 두 개의 배열은 같은 크기(N개)의 배열로 이루어져 있다.
- 배열의 원소는 모두 자연수이다.
- 바꿔치기 연산은 배열 A에 있는 원소와 배열 B에 있는 원소를 골라서 두 원소를 서로 바꾼다.
- 배열 A의 모든 원소의 합이 최대가 되도록 하는 것이 목표
    - → **즉 B의 가장 큰 원소와 A의 가장 작은 원소를 바꿔치기한다.**

```java
import java.util.*;
import java.io.*;
    
public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        String[] aScores = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A.add(Integer.parseInt(aScores[i]));
        }
        
        String[] bScores = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            B.add(Integer.parseInt(bScores[i]));
        }
        
        Collections.sort(A);
        Collections.sort(B, Comparator.reverseOrder());
        
        for (int i = 0; i < k; i++) {
            int a = A.get(i);
            int b = B.get(i);
            
            A.set(i, b);
            B.set(i, a);
        }
        
        int sum = A.stream().mapToInt(Integer::intValue).sum();
        
        System.out.println(sum);
    }
}
```

### 문제 해설

- **배열 A의 가장 작은 원소가 배열 B의 가장 큰 원소보다 작을 때에만 교체해야한다!!!!!!**

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 K를 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 A의 모든 원소를 입력받기
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // 배열 B의 모든 원소를 입력받기
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 배열 A는 오름차순 정렬 수행
        Arrays.sort(a);
        // 배열 B는 내림차순 정렬 수행
        Arrays.sort(b, Collections.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 K번 비교 
        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                // 두 원소를 교체
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            // A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
            else break;
        }

        // 배열 A의 모든 원소의 합을 출력
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }
        System.out.println(result);
    }

}
```