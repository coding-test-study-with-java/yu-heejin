## 다양한 그래프 알고리즘

### 이미 배운 내용을 훑어보자

- **크루스칼 알고리즘(Kruskal Algorithms)은 그리디 알고리즘으로 분류**되며, **위상 정렬 알고리즘(Topology Algorithms)은 앞서 배운 큐 자료구조 혹은 스택 자료구조**를 활용해야 구현할 수 있다.
- 그래프란 노드와 노드 사이에 연결된 간선의 정보를 가지고 있는 자료구조를 의미한다.
- 알고리즘 문제를 접했을 때, **‘서로 다른 개체(혹은 객체)가 연결되어 있다’는 이야기를 들으면 가장 먼저 그래프 알고리즘**을 떠올려야 한다.
    - 예를 들어, 여러 개의 도시가 연결되어 있다는 이야기를 들으면 가장 먼저 그래프 알고리즘을 떠올려야 한다.
- 그래프 자료구조 중에서 트리(Tree) 자료구조는 다양한 알고리즘에서 사용된다.
    - 9장에서 다익스트라 최단 경로 알고리즘은 우선순위 큐를 구현하기 위해서 최소 힙이나 최대 힙을 사용할 수 있었다.
    - **최소 힙은 항상 부모 노드가 자식 노드보다 크기가 작은 자료구조로서 트리 자료구조**에 속한다.
    - **트리 자료구조는 부모에서 자식으로 내려오는 계층적인 모델**에 속한다.
    - 추가적으로 트리는 전통적인 수학에서는 무방향 그래프로 간주되지만, **컴퓨터공학 분야에서는 보통 방향 그래프**라고 간주된다.
- 트리와 그래프 비교
    
    
    |  | 그래프 | 트리 |
    | --- | --- | --- |
    | 방향성 | 방향/무방향 그래프 | 방향 그래프 |
    | 순환성 | 순환 및 비순환 | 비순환 |
    | 루트 노드 존재 여부 | 루트 노드가 없음 | 루트 노드 존재 |
    | 노드간 관계성 | 부모와 자식 관계 없음 | 부모와 자식 관계 |
    | 모델의 종류 | 네트워크 모델 | 계층 모델 |
- 그래프의 구현 방법은 2가지가 존재하는데, **인접 행렬과 인접 리스트** 방식이다.
    - 인접 행렬을 이용하는 방식은 간선 정보를 저장하기 위해서 O(V^2)만큼의 메모리 공간이 필요하다.
    - 인접 리스트를 이용할 땐 간선의 개수만큼 O(E)만큼만 메모리 공간이 필요하다.
        - O(V + E)가 맞음!
    - 인접 행렬은 특정한 노드 A에서 다른 특정한 노드 B로 이어진 간선의 비용을 O(1)의 시간으로 즉시 알 수 있다는 장점이 있고, 인접 리스트를 이용할 땐 O(V)만큼의 시간이 소요된다.
- 우선순위 큐를 이용하는 **다익스트라 최단 경로 알고리즘은 인접리스트**를 이용하는 방식이다.
    - 노드의 개수가 V개일 땐 V개의 리스트를 만들어 각 노드와 연결된 모든 간선에 대한 정보를 리스트에 저장했다.
- **플로이드 워셜 알고리즘은 인접 행렬**을 이용하는 방식이다.
    - 모든 노드에 대하여 다른 노드로 가는 최소 비용을 V^2 크기의 2차원 리스트에 저장한 뒤 해당 비용을 갱신해서 최단 거리를 계산한다.
- 어떤 문제를 만나든 메모리와 시간을 염두에 두고 알고리즘을 선택해서 구현해야 한다.
    - 예를 들어 최단 경로를 찾아야 하는 문제가 출제되었을 때, 노드의 개수가 적은 경우에는 플로이드 워셜 알고리즘을 이용할 수 있다.
    - 반면, **노드와 간선의 개수가 모두 많으면 우선순위 큐를 이용하는 다익스트라 알고리즘을 이용하면 유리**하다.

### 서로소 집합

- 수학에서 서로소 집합(Disjoint Sets)이란 **공통 원소가 없는 두 집합**을 의미한다.
    - 예를 들어 집합{1, 2}와 집합{3, 4}는 서로소 관계이다.
- 서로소 집합 자료구조를 설명하려면 서로소 집합 개념이 필요하다.
    - 서로소 집합 자료구조는 **서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조**이다.
- 서로소 집합 자료구조는 union, find 두 연산으로 조작할 수 있다.
    - union(합집합) 연산은 2개의 원소가 포함된 집합을 하나의 집합으로 합치는 연산이다.
    - find(찾기) 연산은 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산이다.
- 서로소 집합 자료구조는 union-find 자료구조라고 불리기도 한다.

### 서로소 집합 자료구조

- 서로소 집합 자료구조를 구현할 땐 **트리 자료구조를 이용하여 집합을 표현**한다.
- 서로소 집합 정보(합집합 연산)가 주어졌을 때 트리 자료구조를 이용해서 집합을 표현하는 서로소 집합 계산 알고리즘은 다음과 같다.
    1. union(합집합) 연산을 확인하여, 서로 연결된 두 노드 A, B를 확인한다.
        1. A와 B의 루트 노드 A’ B’를 각각 찾는다.
        2. A’를 B’의 부모 노드로 설정한다. (B’가 A’를 가리키도록 한다.)
    2. 모든 union 연산을 처리할 때까지 1번 과정을 반복한다.
- 실제로 구현할 땐 **A’와 B’ 중에서 더 번호가 작은 원소가 부모 노드가 되도록 구현**하는 경우가 많다.
- 일반적으로 **서로소 집합을 그림으로 표현할 땐 번호가 큰 노드가 번호가 작은 노드를 간선으로 가리키도록 트리 구조를 이용**해 그림을 그리게 된다.
    - 여기서 ‘가리킨다’라는 표현은 부모 노드로 설정한다는 의미이다.
    - 즉, 트리 구조상 번호가 작은 노드가 부모가 되고, 번호가 큰 노드가 자식이 된다.
- union 연산을 토대로 그래프를 그리면 ‘연결성’으로 손쉽게 집합의 형태를 확인할 수 있다.
- union 연산을 하나씩 확인하면서 서로 다른 두 원소에 대해 합집합을 수행할 땐, **각각 루트 노드를 찾아서 더 큰 루트 노드가 더 작은 루트 노드를 가리키도록 하면 된다.**
- 알고리즘에서 유의할 점은 **union 연산을 효과적으로 수행하기 위해 부모 테이블을 항상 가지고 있어야 한다는 점이다.**
    - 또한, 루트 노드를 즉시 계산할 수 없고, **부모 테이블을 계속해서 확인하며 거슬러 올라가야 한다.**
- **서로소 집합 알고리즘으로 루트를 찾기 위해서는 재귀적으로 부모를 거슬러 올라가야 한다는 점**을 기억하라.

```java
static int v, e;
static int[] parent = new int[100001];

public static int findParent(int x) {
	// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
	if (x == parent[x]) return x;
	return findParent(parent[x]);
}

// 두 원소가 속한 집합을 합치기
public static void unionParent(int a, int b) {
	// 1. 각각의 루트 노드를 찾는다.
	a = findParent(a);
	b = findParent(b);

	// 더 작은 노드를 루트 노드로 설정한다.
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  v = sc.nextInt();
  e = sc.nextInt();

  // 부모 테이블상에서, 부모를 자기 자신으로 초기화
  for (int i = 1; i <= v; i++) {
      parent[i] = i;
  }

  // Union 연산을 각각 수행
  for (int i = 0; i < e; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      unionParent(a, b);
  }

  // 각 원소가 속한 집합 출력하기
  System.out.print("각 원소가 속한 집합: ");
  for (int i = 1; i <= v; i++) {
      System.out.print(findParent(i) + " ");
  }
  System.out.println();

  // 부모 테이블 내용 출력하기
  System.out.print("부모 테이블: ");
  for (int i = 1; i <= v; i++) {
      System.out.print(parent[i] + " ");
  }
  System.out.println();
}
```

- 각 원소가 속한 집합을 출력하면 각 원소의 루트 노드가 출력된다.
    - 해당 루트 노드가 같은 원소끼리 동일한 집합을 이룬다.
- 단, 해당 방식으로 구현할 경우 find 함수가 비효율적으로 동작한다.
    - 최악의 경우 find 함수가 모든 노드를 다 확인하기 때문에 시간 복잡도가 O(V)가 된다.
    - 이러한 find 함수를 **경로 압축(Path Compression) 기법을 적용하면 시간 복잡도를 개선**시킬 수 있다.
- 경로 압축은 **find 함수를 재귀적으로 호출한 뒤에 부모 테이블 값을 갱신**하는 기법이다.
    - 기존 find 함수를 다음과 같이 변경하면 된다.
        
        ```java
        // 특정 원소가 속한 집합을 찾기
        public static int findParent(int x) {
          // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
          if (x == parent[x]) return x;
          return parent[x] = findParent(parent[x]);
        }
        ```
        
        - 위와 같이 함수를 수정하면 **각 노드에 대해 find 함수를 호출한 이후, 해당 노드의 루트 노드가 바로 부모 노드가 된다.**
    - 결과적으로 경로 압축 기법을 사용하면 루트 노드에 더욱 빠르게 접근할 수 있다는 점에서 기존의 기본적인 알고리즘과 비교했을 때 시간 복잡도가 개선된다.

### 서로소 집합 알고리즘의 시간 복잡도

- 경로 압축 방법을 적용한 시간 복잡도는 O(V + M(1 + log_(2-M/V)V))라고 알려져 있다.

### 서로소 집합을 활용한 사이클 판별

- **서로소 집합은 무방향 그래프 내에서의 사이클을 판별**할 때 사용할 수 있다는 특징이 있다.
    - 참고로 **방향 그래프에서의 사이클 여부는 DFS를 이용하여 판별**할 수 있다.
- union연산은 **그래프에서의 간선**으로 표현될 수 있다.
    - 따라서 간선을 하나씩 확인하면서 두 노드가 포함되어 있는 집합을 합치는 과정을 반복하는 것만으로도 사이클을 판별할 수 있다.
- 과정은 다음과 같다.
    1. 각 간선을 확인하며 두 노드의 루트 노드를 확인한다.
    2. **루트 노드가 서로 같다면 사이클이 발생**한 것이다.
- 그래프에 포함되어 있는 모든 간선에 대해 1번 과정을 반복한다.

```java
static int v, e;
static int[] parent = new int[100001];

public static int findParent(int x) {
	if (x == parent[x]) return x;
	return parent[x] = findParent(parent[x]);
}

public static void unionParent(int a, int b) {
	a = findParent(a);
	b = findParent(b);
		
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	v = sc.nextInt();
	e = sc.nextInt();

	// 부모를 자기 자신으로 우선 초기화
	for (int i = 1; i <= v; i++) {
		parent[i] = i;
	}

	boolean cycle = false;

	for (int i = 0; i < e; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 사이클이 발생한 경우 종료
		if (findParent(a) == findParent(b)) {
			cycle = true;
			break;
		}

		// 사이클이 발생하지 않았다면 union
		else {
			unionParent(a, b);
		}
	}

	if (cycle) {
	  System.out.println("사이클이 발생했습니다.");
	}
	else {
	  System.out.println("사이클이 발생하지 않았습니다.");
	}
}
```

### 신장 트리

- 신장 트리는 그래프 알고리즘 문제로 자주 출제된다.
- 신장 트리(Spanning Tree)란 **하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프**를 의미한다.
    - 이 때 **모든 노드가 포함되어 서로 연결되면서 사이클이 존재하지 않는다는 조건은 트리의 성립 조건**이기도 한다.
    - 따라서 이러한 그래프를 신장 트리라고 부르는 것이다.

### 크루스칼 알고리즘

- 우리는 다양한 문제 상황에서 가능한 최소한의 비용으로 신장 트리를 찾아야할 때가 있다.
- 이처럼 신장 트리 중에서 **최소 비용으로 만들 수 있는 신장 트리를 찾는 알고리즘을 ‘최소 신장 트리 알고리즘’**이라고 한다.
- 대표적인 최소 신장 트리 알고리즘으로는 크루스칼 알고리즘(Kruskal Algorithm)이 있다.
    - **크루스칼 알고리즘을 사용하면 가장 적은 비용으로 모든 노드를 연결**할 수 있는데, 크루스칼 알고리즘은 **그리디 알고리즘**으로 분류된다.
    - 먼저 **모든 간선에 대하여 정렬을 수행**한 후 가장 **거리가 짧은 간선부터 집합에 포함**시키면 된다.
- 구체적인 알고리즘은 다음과 같다.
    1. 간선 데이터를 비용에 따라 **오름차순으로 정렬**한다.
    2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인한다.
        1. **사이클이 발생하지 않는 경우 최소 신장 트리에 포함**시킨다.
        2. 사이클이 발생하는 경우 최소 신장 트리에 포함시키지 않는다.
    3. 모든 간선에 대해 2번의 과정을 반복한다.
- 크루스칼 알고리즘의 핵심 원리는 **가장 거리가 짧은 간선부터 차례대로 집합에 추가하면 된다.**
    - 단, 사이클을 발생시키는 간선은 제외하고 연결한다.
    - 최소 신장 트리에 포함되어 있는 간선의 비용만 모두 더하면 그 값이 최종 비용에 해당한다.

```java
class Edge implements Comparable<Edge> {
	
	private int distance;
	private int nodeA;
	private int nodeB;

	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
	  return this.distance;
}

	public int getNodeA() {
	  return this.nodeA;
	}
	
	public int getNodeB() {
	  return this.nodeB;
	}
	
	// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Edge other) {
	  if (this.distance < other.distance) {
	      return -1;
	  }
	  return 1;
	}
}

public class Main {
	
	static int v, e;
	static int[] parent = new int[100001];
	// 모든 간선을 담을 리스트와 최종 비용을 담을 변수
	static ArrayList<Edge> edges = new ArrayList<>();
	static int result = 0;

	// 특정 원소가 속한 집합을 찾기
  public static int findParent(int x) {
      // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
      if (x == parent[x]) return x;
      return parent[x] = findParent(parent[x]);
  }

  // 두 원소가 속한 집합을 합치기
  public static void unionParent(int a, int b) {
      a = findParent(a);
      b = findParent(b);

      if (a < b) parent[b] = a;
      else parent[a] = b;
  }

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    v = sc.nextInt();
    e = sc.nextInt();

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (int i = 1; i <= v; i++) {
        parent[i] = i;
    }

    // 모든 간선에 대한 정보를 입력 받기
    for (int i = 0; i < e; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cost = sc.nextInt();
        edges.add(new Edge(cost, a, b));
    }

    // 간선을 비용순으로 정렬
    Collections.sort(edges);

    // 간선을 하나씩 확인하며
    for (int i = 0; i < edges.size(); i++) {
        int cost = edges.get(i).getDistance();
        int a = edges.get(i).getNodeA();
        int b = edges.get(i).getNodeB();
        // 사이클이 발생하지 않는 경우에만 집합에 포함
        if (findParent(a) != findParent(b)) {
            unionParent(a, b);
            result += cost;
        }
    }

    System.out.println(result);
}
```

### 크루스칼 알고리즘의 시간 복잡도

- 크루스칼 알고리즘은 간선의 개수가 E개일 때 O(ElogE)의 시간 복잡도를 가진다.

### 위상 정렬

- 위상 정렬(Topology Sort)은 정렬 알고리즘의 일종이다.
- **순서가 정해져있는 일련의 작업을 차례대로 수행**해야 할 때 사용할 수 있는 알고리즘이다.
- **방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열**하는 것이다.
- 현실 세계에서 위상 정렬을 수행하게 되는 전형적인 예시로는 ‘선수 과목을 고려한 학습 순서 설정’을 들 수 있다.
- 위상 정렬 알고리즘을 자세히 살펴보기 전에, 먼저 진입 차수(Indegree)를 알아야한다.
    - **진입 차수란 특정한 노드로 들어오는 간선의 개수를 말한다.**
- 주어진 방향에서 위상 정렬을 수행하는 알고리즘은 다음과 같다.
    1. **진입차수가 0인 노드를 큐에 넣는다.**
    2. 큐가 빌 때까지 다음의 과정을 반복한다.
        1. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
        2. 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
- 이 때 **모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재한다고 판단**할 수 있다.

```java
static int v, e;
static int[] indegree = new int[100001]
static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

public static void topologySort() {
	ArrayList<Integer> result = new ArrayList<>();  // 알고리즘 수행 결과를 담을 리스트
	Queue<Integer> q = new LinkedList<>();
	
	// 처음 시작할 때는 진입 차수가 0인 노드를 큐에 삽입
	for (int i = 1; i <= v; i++) {
		if (indegree[i] == 0) {
			q.offer(i);
		}
	}

	while (!q.isEmpty()) {
		int now = q.poll();
		result.add(now);
	
		// 해당 원소와 연결된 노드들의 진입 차수에서 1 빼기
		for (int i = 0; i < graph.get(now).size(); i++) {
			indegree[graph.get(now).get(i)] -= 1;
			// 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
			if (indegree[graph.get(now).get(i)] == 0) {
				q.offer(graph.get(now).get(i));
			}
		}
	}

	// 위상 정렬을 수행한 결과 출력
	for (int i = 0; i < result.size(); i++) {
	    System.out.print(result.get(i) + " ");
	}
}

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); // 정점 A에서 B로 이동 가능
            // 진입 차수를 1 증가
            indegree[b] += 1;
        }

        topologySort();
    }
}
```

### 위상 정렬의 시간 복잡도

- 위상 정렬의 시간 복잡도는 O(V+E)이다.
- 차례대로 모든 노드를 확인하면서 해당 노드에서 출발하는 간선을 차례대로 제거해야 한다,

---

## 실전 문제 1 - 팀 결성

### 풀이 과정

- 학생들에게 0번부터 N번까지의 번호를 부여
- 처음에는 모든 학생들이 서로 다른 팀으로 구분되어 N+1개의 팀 존재
- 팀 합치기 연산은 두 팀을 합치는 연산 = union (0)
- 같은 팀 여부 확인은 특정한 두 학생이 같은 팀에 속하는지 확인하는 연산 = find (1)

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                    3ms

public class MyClass {
    
    private static final int UNION = 0;
    private static final int FIND = 1;
    
    private static String[] input;
    private static int[] parent;
    
    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = findParent(parent[x]);
    }
    
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            
            int operation = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            
            if (operation == UNION) {
                unionParent(a, b);
            } else {
                int rootA = findParent(a);
                int rootB = findParent(b);
                
                if (rootA == rootB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
```

### 문제 해설

- 전형적인 서로소 집합 알고리즘 문제

```java
import java.util.*;

public class Main {

    // 노드의 개수(N)와 연산의 개수(M)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 각 연산을 하나씩 확인 
        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 합집합(Union) 연산인 경우
            if (oper == 0) {
                unionParent(a, b);
            }
            // 찾기(Find) 연산인 경우
            else if (oper == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
}
```

## 실전 문제 2 - 도시 분할 계획

### 풀이 과정

- 마을은 N개의 집과 그 집을 연결하는 M개의 길로 이루어져 있다.
- 어느 방향으로든지 다닐 수 있는 편한 길 (무방향), 유지비(비용) 존재
- 마을을 두개의 분리된 마을로 분할(union), 분할된 집들은 서로 연결(신장?)
- 최소신장과 union사용
- 두개로 나눈 후 최소 신장이어야함
- 즉, 최소 신장 트리를 구한 후 그 중 가장 큰 간선을 제거하면 둘로 나뉘어진다!

```java
import java.util.*;
import java.io.*;

// (백준 기준) 메모리 325064KB, 시간 1740ms

class House implements Comparable<House> {
    
    private int me;
    private int connectedHouse;
    private int cost;
    
    public House(int me, int connectedHouse, int cost) {
        this.me = me;
        this.connectedHouse = connectedHouse;
        this.cost = cost;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getMe() {
        return me;
    }
    
    public int getConnectedHouse() {
        return connectedHouse;
    }
    
    @Override
    public int compareTo(House other) {
        return this.cost - other.cost;
    }
}

public class MyClass {
    
    private static String[] input;
    private static int[] parent;
    private static List<House> houses;
    
    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = findParent(parent[x]);
    }
    
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        parent = new int[n + 1];
        houses = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            houses.add(new House(a, b, c));
        }
        
        Collections.sort(houses);   // 오름차순 정렬
        
        int result = 0;
        int max = 0;
        
        for (int i = 0; i < houses.size(); i++) {
            int cost = houses.get(i).getCost();
            int me = houses.get(i).getMe();
            int connectedHouse = houses.get(i).getConnectedHouse();
            
            if (findParent(me) != findParent(connectedHouse)) {
                unionParent(me, connectedHouse);
                result += cost;
                max = cost;
            }
        }
        
        System.out.println(result - max);
    }
}
```

### 문제 해설

- 최소한의 비용으로 2개의 신장 트리로 분할해야 한다.
- 크루스칼 알고리즘으로 최소 신장 트리를 찾은 후, **최소 신장 트리를 구성하는 간선 중 가장 비용이 큰 간선을 제거한다.**

```java
import java.util.*;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화
    // 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            // 비용순으로 정렬하기 위해서 튜플의 첫 번째 원소를 비용으로 설정
            edges.add(new Edge(cost, a, b));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);
        int last = 0; // 최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선

        // 간선을 하나씩 확인하며
        for (int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result - last);
    }
}
```

## 실전 문제 3 - 커리큘럼

### 풀이 과정

- 일단 위상정렬 사용
- 동시에 여러 강의를 들을 수 있다.
    - 같은 계층에 있는 강의는 동시에 들으면 된다.
- 강의는 1번부터 n번까지 정해져있고, 입력값도 순서대로