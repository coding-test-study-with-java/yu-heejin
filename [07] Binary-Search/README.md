## 범위를 반씩 좁혀가는 탐색

### 순차 탐색

- 이진 탐색에 대해 알아보기 전에 가장 기본 탐색 방법인 순차 탐색에 대해 먼저 이해해야 한다.
- 순차 탐색(Sequential Search)이란 **리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법이다.**
    - 일반적으로 정렬되지 않은 리스트에서 데이터를 찾아야할 때 사용한다.
- 리스트 내에 데이터가 많아도 **시간만 충분하면 항상 원하는 데이터를 찾을 수 있다.**
- 순차 탐색은 이름처럼 순차로 데이터를 탐색한다는 의미이다.
- 순차 탐색은 매우 자주 사용되는데, 리스트에 특정 값의 원소가 있는지 체크할 때도 사용하며 리스트 자료형에서 특정한 값을 가지는 원소의 개수를 세는 count()(파이썬)메서드를 이용할 때도 내부에서 순차 탐색이 사용 된다.
    
    ```java
    public static int sequantialSearch(int n, String target, String[] arr) {
    	for (int i = 0; i < n; i++) {
    		System.out.println(arr[i]);
    		
    		if (arr[i].equals(target)) {
    			return i + 1;   // 현재 위치 반환하기
    		}
    	
    		return -1;   // 원소를 찾지 못한 경우 -1
    	}
    }
    ```
    
- 순차 탐색은 데이터 정렬 여부와 상관없이 가장 앞에 있는 원소부터 하나씩 확인해야한다는 점이 특징이다.
    - 따라서 **순차 탐색의 시간 복잡도는 O(N)이다.**

### 이진 탐색: 반으로 쪼개면서 탐색하기

- 이진 탐색(Binary Search)은 **배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.**
- 데이터가 무작위일 땐 사용할 수 없지만, **이미 정렬되어 있다면 매우 빠르게 데이터를 찾을 수 있다는 특징이 있다.**
- 이진 탐색은 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 특징이 있다.
- 이진 탐색은 위치를 나타내는 변수 3개를 사용한다.
    - 탐색하고자 하는 범위의 **시작점, 끝점, 중간점**이다.
    - **찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교**해서 원하는 데이터를 찾는게 이진 탐색 과정이다.
- 이진 탐색의 과정은 다음과 같다.
    1. 시작점과 끝점을 확인한 후 둘 사이에 중간점을 정한다.
    2. 중간점의 데이터가 8이고, 내가 찾으려는 데이터가 4이면 **중간점 이후의 값은 확인할 필요가 없으니 끝점을 중간점 바로 앞 위치로 바꾼다. (정렬)**
- 이진 탐색은 한 번 확인할 때마다 **확인하는 원소의 개수가 절반씩 줄어든다는 점에서 시간 복잡도가 O(log N)이다.**
- 이진 탐색을 구현하는 방법은 하나는 **재귀 함수를 이용**하는 방법이 있고, 다른 하나는 **단순하게 반복문을 이용**하는 방법이 있다.

### 재귀 함수로 구현한 이진 탐색

```java
public static int binarySearch(int[] arr, int target, int start, int end) {
	if (start > end) {
		return -1;  // 시작 지점이 끝 지점보다 뒤에 있으면 종료
	}

	int mid = (start + end) / 2;  // 중간 지점
	
	if (arr[mid] == target) {
		return mid;   // 중간 지점에 위치한 데이터에 찾는 데이터가 존재하면 해당 위치 반환
	} else if (arr[mid] > target) {
		return binarySearch(arr, target, start, mid - 1);  // 목표값이 현재 중간값보다 작으면 왼쪽 탐색
	}

	return binarySearch(arr, target, mid + 1, end);  // 오른쪽 탐색
}
```

### 반복문으로 구현한 이진 탐색 코드

```java
public static int binarySearch(int[] arr, int target, int start, int end) {
	while (start <= end) {
		int mid = (start + end) / 2;   // 중간지점
		
		if (arr[mid] == target) {
			return mid;   // 찾은 경우 중간점 인덱스 반환
		} else if (arr[mid] > target) {
			end = mid - 1;  // 중간지점 값보다 목표 값이 작은경우 끝점 위치를 중간지점 - 1
		} else {
			start = mid + 1;  // 중간지점 값보다 목표 값이 큰 경우 시작점 위치를 중간지점 + 1
		}
	}
	
	return -1;
}
```

### 트리 자료구조

- 이진 탐색은 **전제 조건이 데이터 정렬**이다.
    - 예를 들어 동작하는 프로그램에서 데이터를 정렬해두는 경우가 많으므로 이진 탐색을 효과적으로 사용할 수 있다.
    - 데이터베이스는 내부적으로 대용량 데이터 처리에 적합한 트리(Tree) 자료구조를 이용하여 **항상 데이터가 정렬**되어 있다.
    - 따라서 데이터베이스에서의 탐색은 이진 탐색과는 조금 다르지만, **이진 탐색과 유사한 방법을 이용해 탐색을 항상 빠르게 수행하도록 설계되어 있어 데이터가 많아도 탐색하는 속도가 빠르다.**
- 트리 자료구조는 노드와 노드의 연결로 표현하며, 여기에서 **노드는 정보의 단위로서 어떠한 정보를 가지고 있는 개체**로 이해할 수 있다.
- **트리 자료구조는 그래프 자료구조의 일종**으로, 데이터베이스 시스템이나 파일 시스템과 같은 곳에서 **많은 양의 데이터를 관리하기 위한 목적으로 사용**한다.

### 트리 자료구조 특징

1. 트리는 **부모 노드와 자식 노드의 관계**로 표현된다.
2. 트리의 최상단 노드를 **루트 노드**라고 한다.
3. 트리의 최하단 노드를 **단말 노드**라고 한다.
4. 트리에서 일부를 떼어내도 트리구조이며, 이를 **서브 트리**라고 한다.
5. 트리는 파일 시스템과 같이 **계층적이고 정렬된 데이터를 다루기 적합**하다.

→ 정리하자면 큰 데이터를 처리하는 소프트웨어는 **대부분 데이터를 트리 자료구조로 저장해서 이진 탐색과 같은 탐색 기법을 이용해 빠르게 탐색 가능**하다.

### 이진 탐색 트리

- 트리 자료구조 중에서 가장 간단한 형태가 이진 탐색 트리이다.
- 이진 탐색 트리란 **이진 탐색이 동작할 수 있도록 고안된 효율적인 탐색이 가능한 자료구조**이다.
- 이진 탐색 트리의 특징은 다음과 같다.
    1. 부모 노드보다 왼쪽 자식 노드가 작다.
    2. 부모 노드보다 오른쪽 자식 노드가 크다.
    
    → 즉 정리하면 **왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드**
    
- 이진 탐색 트리에 데이터를 넣고 빼는 방법은 알고리즘보다는 자료구조에 가까우며, 이진 탐색 트리 자료구조를 구현하도록 요구하는 문제는 출제 빈도가 낮은 편이다.

### 이진 탐색 트리 데이터 조회 과정

1. 이진 탐색은 루트 노드부터 방문한다.
2. 만약 내가 찾고자 하는 값이 루트 노드보다 크면 오른쪽으로, 작으면 왼쪽으로 간다.
3. 2번의 과정을 반복하면서 데이터를 찾는다.
4. 만약 자식 노드가 없을 때까지 원소를 찾지 못했다면 이진 탐색 트리에 원소가 없는 것이다.

### 빠르게 입력받기

- 이진 탐색 문제는 입력 데이터가 많거나 탐색 범위가 매우 넓은 편이다.
    - 예를 들어 데이터의 개수가 1000만개를 넘어가거나 탐색 범위의 크기가 1000억 이상이라면 이진 탐색 알고리즘을 의심해야 한다.
- 단, 입력 데이터의 개수가 많은 문제에 동작이 느린 함수를 사용하면 동작 속도가 느려 시간 초과로 오답 판정을 받을 수 있다.

---

## 실전 문제 1 - 부품 찾기

### 풀이 과정

- 원래 있던 부품 N개, 손님이 요청한 부품 M개 → 가게 안에 부품이 모두 있는지 확인

```java
import java.util.*;
import java.io.*;

public class MyClass {
    private static final String[] RESULTS = { "yes", "no" };
    
    private static int binarySearch(List<Integer> arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (arr.get(mid) == target) {
                return mid;
            }
            
            if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        String[] tempMyParts = reader.readLine().split(" ");
        
        int m = Integer.parseInt(reader.readLine());
        String[] tempNeededParts = reader.readLine().split(" ");
        
        List<Integer> myParts = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            myParts.add(Integer.parseInt(tempMyParts[i]));
        }
        
        Collections.sort(myParts);   // 정렬하는거 까먹지말것!
        
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int result = binarySearch(myParts, Integer.parseInt(tempNeededParts[i]), 0, n - 1);
            
            if (result != -1) {
                results.add(RESULTS[0]);
            } else {
                results.add(RESULTS[1]);
            }
        }
        
        System.out.println(results);
    }
}
```

### 문제 해설

```java
import java.util.*;

public class Main {

    // 이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1; 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N(가게의 부품 개수)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 이진 탐색을 수행하기 위해 사전에 정렬 수행
        Arrays.sort(arr);

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            int result = binarySearch(arr, targets[i], 0, n - 1);
            if (result != -1) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }

}
```

- 이진 탐색뿐만 아니라 계수 정렬의 개념을 이용해 풀 수도 있다.
    
    ```java
    import java.util.*;
    
    public class Main {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // N(가게의 부품 개수)
            int n = sc.nextInt();
            int[] arr = new int[1000001];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr[x] = 1;
            }
    
            // M(손님이 확인 요청한 부품 개수)
            int m = sc.nextInt();
            int[] targets = new int[n];
            for (int i = 0; i < m; i++) {
                targets[i] = sc.nextInt();
            }
    
            // 손님이 확인 요청한 부품 번호를 하나씩 확인
            for (int i = 0; i < m; i++) {
                // 해당 부품이 존재하는지 확인
                if (arr[targets[i]] == 1) {
                    System.out.print("yes ");
                }
                else {
                    System.out.print("no ");
                }
            }
        }
    
    }
    ```
    
- 또한, 이러한 문제는 단순히 특정한 수가 한 번이라도 등장했는지를 검사하면 되기 때문에 집합 자료형을 이용해 문제를 풀 수도 있다.
    
    ```java
    import java.util.*;
    
    public class Main {
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            // N(가게의 부품 개수)
            int n = sc.nextInt();
            // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                s.add(x);
            }
    
            // M(손님이 확인 요청한 부품 개수)
            int m = sc.nextInt();
            int[] targets = new int[n];
            for (int i = 0; i < m; i++) {
                targets[i] = sc.nextInt();
            }
    
            // 손님이 확인 요청한 부품 번호를 하나씩 확인
            for (int i = 0; i < m; i++) {
                // 해당 부품이 존재하는지 확인
                if (s.contains(targets[i])) {
                    System.out.print("yes ");
                }
                else {
                    System.out.print("no ");
                }
            }
        }
    
    }
    ```
    
    - `HashSet.contains()`의 시간복잡도는 O(1)이다.