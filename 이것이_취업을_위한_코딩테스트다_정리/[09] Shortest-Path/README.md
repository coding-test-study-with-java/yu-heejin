## 가장 빠른 길 찾기

### 가장 빠르게 도달하는 방법

- 최단 경로(Shortest Path) 알고리즘은 **말 그대로 가장 짧은 경로를 찾는 알고리즘**이다.
    - 따라서 ‘길 찾기’ 문제라고도 불린다.
- 최단 경로 문제는 보통 그래프를 이용해 표현하는데, **각 지점은 그래프에서 ‘노드’**로 표현되고, **지점간 연결된 도로는 그래프에서 ‘간선’**으로 표현된다.
- 실제 코딩 테스트에서는 최단 경로를 모두 출력하는 문제보다는 **단순히 최단 거리를 출력하도록 요구하는 문제**가 많이 출제된다.
- **다익스트라 최단 경로 알고리즘, 플로이트 워셜, 벨만 포드 알고리즘**이 최단 거리 알고리즘이다.
    - 또한, 앞서 공부한 **그리디 알고리즘과 다이나믹 프로그래밍 알고리즘**이 최단 경로 알고리즘에 그대로 적용된다.

### 다익스트라 최단 경로 알고리즘

- **다익스트라(Dijkstra) 최단 경로 알고리즘은 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘**이다.
- 다익스트라 알고리즘은 **음의 간선이 없을 때 정상적으로 작동**한다.
    - 음의 간선은 0보다 작은 값을 가지는 간선을 의미하는데, 현실 세계의 길은 음의 간선으로 표현되지 않으므 다익스트라 알고리즘은 실제로 GPS 소프트웨어의 기본 알고리즘으로 채택되곤 한다.
- 다익스트라 알고리즘은 기본적으로 **그리디 알고리즘으로 분류**된다.
    - 매번 **‘가장 비용이 적은 노드’**를 선택해서 임의의 과정을 반복하기 때문이다.
- 알고리즘의 원리를 간략히 설명하면 다음과 같다.
    1. 출발 노드를 설정한다.
    2. 최단 거리 테이블을 초기화한다.
    3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
    4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
    5. 3, 4번 과정을 반복한다.
- 다익스트라 알고리즘은 최단 경로를 구하는 과정에서 **‘각 노드에 대한 현재까지의 최단 거리’** 정보를 **항상 1차원 리스트에 저장하며 리스트를 계속 갱신한다는 특징**이 있다.
    - 이러한 1차원 리스트를 최단 거리 테이블이라고 한다.
- 매번 **현재 처리하고 있는 노드를 기준으로 주변 간선을 확인**한다.
    - 나중에 현재 처리하고 있는 노드와 인접한 노드로 도달하는 **더 짧은 경로를 찾으면 ‘더 짧은 경로도 있었네? 이제부터는 이 경로가 제일 짧은 경로야’라고 판단**하는 것이다.
    - 따라서 **‘방문하지 않은 노드 중에서 현재 최단 거리가 가장 짧은 노드를 확인’**해 그 노드에 대하여 4번 과정을 수행한다는 점에서 그리디 알고리즘으로 볼 수 있다.
- 다익스트라 알고리즘을 구현하는 방법은 2가지이다.
    1. 구현하기 쉽지만 느리게 동작하는 코드
    2. 구현하기에 조금 더 까다롭지만 빠르게 동작하는 코드
- 다익스트라 최단 경로 알고리즘에서는 **‘방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드를 선택’하는 과정**을 반복한다.
    - 이렇게 선택된 노드는 **최단 거리가 완전히 선택된 노드**이므로, **더 이상 알고리즘을 반복해도 최단 거리가 줄어들지 않는다.**
    - 다시 말해 다익스트라 알고리즘이 진행되면서 **한 단계당 하나의 노드에 대한 최단 거리를 확실히 찾는 것으로 이해할 수 있다.**
    - 따라서 사실상 **마지막 노드에 대해서는 해당 노드를 거쳐 다른 노드로 가는 경우를 확인할 필요가 없다.**

### 다익스트라 알고리즘 동작 원리

1번 노드로부터 다른 모든 노드로의 최단 거리를 계산한다고 가정하자.

1. 초기 상태에서는 다른 모든 노드로 가는 최단 거리를 ‘무한’으로 초기화 한다.
2. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택하는데, 출발 노드에서 출발 노드로의 거리는 0으로 보기 때문에 처음에는 출발 노드가 선택된다.
3. 이제 1번 노드를 거쳐 다른 노드로 가는 비용을 계산한다.
    1. 즉, **1번 노드와 연결된 모든 간선을 하나씩 확인**한다.
4. 이후 모든 단계에서도 마찬가지로 **방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택**해야 한다.
    1. 따라서 1번 노드와 가장 가까운 4번 노드가 선택된다.
    2. 이어서 4번 노드와 연결된 노드들을 방문하며 최단 경로를 갱신한다.
5. 위와 같은 과정을 반복한다.
    1. 만약 최단 거리가 같으면 일반적으로 번호가 작은 노드를 선택한다.

### 방법 1. 간단한 다익스트라 알고리즘

- 간단한 다익스트라 알고리즘은 `O(V^2)`의 시간 복잡도를 가지며, 다익스트라에 의해서 처음 고안되었던 알고리즘이다.
    - 여기서 V는 노드의 개수를 의미한다.
- 처음에 **각 노드에 대한 최단 거리를 담는 1차원 리스트**를 선언한다.
- 이후 단계마다 **‘방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택’하기 위해 매 단계마다 1차원 리스트의 모든 원소를 확인(순차 탐색)**한다.

```java
class Node {
	
	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}
}

public class Main {
	
	public static final int INF = (int) 1e9;   // 무한을 의미하는 값 10억 설정
	public static int n, m, start;  // 노드의 개수, 간선의 개수, 시작 노드 번호
	// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static boolean[] visited = new boolean[100001];  // 방문 여부 확인
	public static int[] d = new int[100001];  // 최단 거리 테이블

	// 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드의 번호를 반환
	public static int getSmallestNode() {
		int minValue = INF;
		int index = 0;

		for (int i = 1; i <= 1; i++) {
			if (d[i] < minValue && !visited[i]) {   // 만약 가장 작은 값보다 작고 방문하지 않았다면
				minValue = d[i];  // 가장 작은 값 저장
				index = i;   // 가장 작은 값의 인덱스 저장
			}
		}

		return index;
	}

	public static void dijkstra(int start) {
		// 시작 노드에 대해서 초기화
		d[start] = 0;
		visited[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			// 시작 지점과 '연결된' 노드의 인덱스 번호를 가져온다.
			// 최단 거리 테이블에 해당 인덱스에 대한 거리를 저장한다.
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		}

		// 시작 노드를 제외한 전체 n - 1개의 노드에 대해 반복한다.
		for (int i = 0; i < n - 1; i++) {
			// 현재 최단 거리 중에서 가장 짧은 거리의 노드 인덱스를 가져온다.
			int now = getSmallestNode();
			// 해당 노드를 방문한다.
			visited[now] = true;
		
			// 해당 최단 거리와 연결된 다른 노드 확인
			for (int j = 0; j < graph.get(now).size(); j++) {
				// 현재 노드를 거쳐서 다른 노드로 이동하는 거리를 구한다.
				// 현재 노드의 최단 거리 + 이어진 노드까지의 거리 = 출발지부터 이어진 노드까지의 거리
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				// 만약 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 갱신
				if (cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		// 그래프 초기화
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Node>());
		}

		// 모든 간선 정보 입력 받기
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a번 노드에서 b번 노드로 가는 비용이 c임
			graph.get(a).add(new Node(b, c));
		}

		Arrays.fill(d, INF);   // 최단 거리 테이블을 무한으로 초기화
		
		dijkstra(start);   // 다익스트라 알고리즘 수
		
		for (int i = 1; i <= n; i++) {
			if (d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}
```

### 간단한 다익스트라 알고리즘의 시간 복잡도

- 시간 복잡도는 `O(V^2)`이다.
    - 총 `O(V)`번에 걸쳐서 최단 거리가 가장 짧은 노드를 매번 선형 탐색해야 하고, 현재 노드와 연결된 노드를 매번 일일이 확인하기 때문이다.
- 따라서 코딩 테스트의 최단 경로 문제에서 **전체 노드의 개수가 5000개 이하라면 일반적으로 이 코드로 문제를 풀 수 있을 것이다.**
    - 하지만 10000개를 넘어가는 문제라면 이 코드로는 문제를 해결하기 어려우니, ‘개선된 다익스트라 알고리즘’을 사용해야한다.

### 방법 2. 개선된 다익스트라 알고리즘

- 개선된 다익스트라 알고리즘을 사용하면 시간 복잡도가 `O(ElogV)`임을 보장한다.
    - 여기서 V는 노드의 개수이고, E는 간선의 개수를 의미한다.
- 간단한 다익스트라 알고리즘은 최단 거리가 가장 짧은 노드를 찾기 위해서 매번 최단 거리 테이블을 선형적으로(모든 원소를 앞에서부터 하나씩) 탐색해야 했다.
    - 이 과정에서만 `O(V)`의 시간이 걸렸다.
- 개선된 다익스트라 알고리즘에서는 **힙(Heap) 자료구조**를 사용한다.
    - 힙 자료구조를 이용하게 되면 **특정 노드까지의 최단 거리에 대한 정보를 힙에 담아서 처리**하므로 출발 노드로부터 가장 거리가 짧은 노드를 더욱 빠르게 찾을 수 있다.
    - 이 과정에서 선형 시간이 아닌 **로그 시간이 걸린다.**

```java
class Node implements Comparable<Node> {
	
	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return dinstance;
	}

	// 거리가 짧은 것이 높은 우선순위를 가지도록 설정
	@Override
	public int compareTo(Node other) {
		if (this.distance < other.distance) {
			return -1;
		}
		
		return 1;
	}
}

public class Main {
	
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001];

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));   // 시작 노드로 가기 위한 최단 경로는 0으로 설정, 큐에 삽입
		d[start] = 0;

		while(!pq.isEmpty()) {   // 큐가 비어있지 않다면
			Node node = pq.poll();   // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
			int dist = node.getDistance();  // 현재 노드까지의 비용
			int now = node.getIndex();   // 현재 노드의 인덱스 값
			
			if (d[now] < dist) continue;  // 현재 노드의 최단거리가 dist보다 작으면 볼 필요 없다.

			for (int i = 0; i < graph.get(now).size(); i++) {   // 현재 노드와 연결된 노드들 확인
				int cost = d[now] + graph.get(now).get(i).getDistance();  // 현재 노드를 거친 거리
				
				if (cost < d[graph.get(now).get(i).getIndex()]) {  // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		
		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}

		// 모든 간선 정보를 입력받기
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a번 노드에서 b번 노드로 가는 비용이 c라는 의미
			graph.get(a).add(new Node(b, c));
		}

		Arrays.fill(d, INF);
		
		dijkstra(start);

		for (int i = 1; i <= n; i++) {
			if (d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}	
```

- `getSmallest()`를 작성할 필요 없다.
    - 최단 거리가 가장 짧은 노드를 선택하는 과정을 다익스트라 함수 안에서 **우선순위 큐를 이용하는 방식으로 대체할 수 있기 때문이다.**

**힙 설명**

- 힙 자료구조는 **우선순위 큐(Priority Queue)를 구현하기 위해 사용하는 자료구조 중 하나**이다.
- **우선순위 큐는 우선순위가 가장 높은 데이터를 가장 먼저 삭제한다는 점이 특징**이다.
    - 이러한 우선순위 큐는 데이터를 우선순위에 따라 처리하고 싶을 때 사용한다.
- 대부분의 프로그래밍 언어에서는 우선순위 큐 라이브러리를 지원하기 때문에 일반적인 코딩 테스트 환경에서 우리가 직접 힙 자료구조부터 작성해서 우선순위 큐를 구현할 일은 없다.
- 우선순위 값을 표현할 때는 **일반적으로 정수형 자료형의 변수**가 사용된다.
    - 예를 들어, 물건 정보가 있고, 물건 정보는 물건의 가치와 물건의 무게로만 구성된다고 가정해보자
    - 그러면 모든 물건 데이터를 (가치, 물건)으로 묶어서 우선순위 큐 자료구조에 넣을 수 있다.
    - 이후에 우선순위 큐에서 물건을 꺼내게 되면, 항상 가치가 높은 물건이 먼저 나오게 된다.
    - 대부분의 프로그래밍 언어에서는 우선순위 큐 라이브러리에 데이터의 묶음을 넣으면, 첫 번째 원소를 기준으로 우선순위를 설정한다.
    - 따라서 데이터가 (가치, 물건)으로 구성된다면 ‘가치’값이 우선순위 값이 되는 것이다.
- 우선순위 큐를 구현할 땐 내부적으로 **최소 힙(Min Heap) 혹은 최대 힙(Max Heap)**을 이용한다.
    - **최소 힙을 이용하는 경우 ‘값이 낮은 데이터가 먼저 삭제’** 되며, **최대 힙을 이용하는 경우 ‘값이 큰 데이터가 먼저 삭제’**된다.
    - **다익스트라 최단 경로 알고리즘에서는 비용이 적은 노드를 우선하여 방문**하므로 **최소 힙 구조를 기반으로하는 우선순위 큐 라이브러리**를 그대로 사용하면 적합하다.
    - **자바에서는 최소 힙을 이용하여 각각 우선순위 라이브러리가 구현**되어 있다.
- 또한 **최소 힙을 최대 힙처럼 사용**하기 위해 일부러 **우선순위에 해당하는 값에 음수 부호**를 붙여서 넣었다가, 나중에 우선순위 큐에서 꺼낸 다음에 다시 음수 부호를 붙여 원래의 값으로 돌리는 방식을 사용할 수 있다.
- 우선순위 큐는 힙 자료구조 외에도 다양한 방법을 통해 구현할 수 있다.
    
    
    | 우선순위 큐 구현 방식 | 삽입 시간 | 삭제 시간 |
    | --- | --- | --- |
    | 리스트 | O(1) | O(N) |
    | 힙(Heap) | O(log N) | O(log N) |
- 데이터의 개수가 N개일 때, 힙 자료구조에 N개의 데이터를 모두 넣은 뒤 다시 모든 데이터를 꺼낸다고 가정하자.
    - 삽입 시 `O(log N)`의 연산을 N번 반복하므로 `O(Nlog N)`이고, 삭제할 때도 `O(log N)`의 연산을 N번 반복하므로 `O(Nlog N)`이다.
    - 따라서 전체 시간 복잡도 `O(Nlog N)`이 된다.
- 최소 힙을 사용하는 경우 힙에서 원소를 꺼내면 ‘가장 값이 작은 원소’가 추출되는 특징이 있으며, 파이썬의 우선순위 큐 라이브러리는 최소 힙에 기반한다는 점을 기억하자.
    - 단순히 **우선 순위 큐를 이용해서 시작 노드로부터 거리가 짧은 노드 순서대로 큐에서 나올 수 있도록 다익스트라 알고리즘을 작성하면 된다.**

### 개선된 다익스트라 알고리즘의 시간 복잡도

- 개선 알고리즘의 시간 복잡도는 `O(ElogV)`이다.
- **한 번 처리된 노드는 더 이상 처리되지 않는다.**
    - 다시 말해 **큐에서 노드를 꺼내 검사하는 반복문은 노드의 개수 V 이상의 횟수로는 반복되지 않는다.**
    - 또한, **V번 반복될 때마다 각각 자신과 연결된 간선들을 모두 확인**한다.
    - 따라서 **‘현재 우선순위 큐에서 꺼낸 노드와 연결된 다른 노드들을 확인’하는 총 횟수는 총 최대 간선의 개수만큼 연산이 수행**될 수 있다.
- 전체 다익스트라 최단 경로 알고리즘은 **E개의 원소를 우선순위 큐에 넣었다가 모두 빼내는 연산과 매우 유사**하다.
    - 앞서 힙에 N개의 데이터를 모두 넣고, 이후에 모두 뺴는 과정은 `O(NlogN)`이다.
    - 간단하게 생각하면 다익스트라 알고리즘의 시간 복잡도는 최대 E개의 간선 데이터를 힙에 넣었다가 다시 빼는 것으로 볼 수 있으므로 `O(ElogE)`이다.
    - 이때, **중복 간선을 포함하지 않는 경우 E는 항상 V^2보다 작다.**
        - 모든 노드끼리 서로 다 연결되어 있다고 할 때 간선의 개수를 약 V^2로 볼 수 있고, E는 항상 V^2 이하이기 때문이다.
    - 즉, `logE`는 `logV^2`보다 작다.
        - 이때 `O(logV^2)`는 `O(2logV)`이고, 이는 `O(logV)`이다.
        - 따라서 다익스트라 알고리즘의 전체 시간 복잡도는 `O(ElogV)`이다.
- 다익스트라 최단 경로 알고리즘은 **우선순위 큐를 이용한다는 점에서 우선순위 큐를 필요로하는 다른 문제유형과도 흡사하다는 특징**이 있다.
    - 따라서 **최단 경로를 찾는 문제를 제외하고도 다른 문제에도 두루 적용되는 소스코드 형태**라고 이해할 수 있다.
    - 예를 들어, 그래프 문제로 유명한 최소 신장 트리 문제를 풀 때에도 일부 알고리즘(Prim 알고리즘)의 구현이 다익스트라 알고리즘의 구현과 흡사하다는 특징이 있다.

### 플로이드 워셜 알고리즘

- 다익스트라 알고리즘은 **‘한 지점에서 다른 특정 지점까지의 최단 경로를 구해야하는 경우’**에 사용할 수 있는 최단 경로 알고리즘이다.
- **플로이드 워셜(Floyd-Warshall) 알고리즘은 ‘모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야하는 경우’**에 사용할 수 있는 알고리즘이다.
- 다익스트라 알고리즘은 **단계마다 최단 거리를 가지는 노드를 하나씩 반복적으로 선택**한다.
    - 그리고 해당 노드를 거쳐가는 경로를 확인하며, **최단 거리 테이블을 갱신하는 방식으로 동작**한다.
- 플로이드 워셜 알고리즘 또한 **단계마다 ‘거쳐가는 노드’를 기준으로 알고리즘을 수행**한다.
    - 하지만 **매번 방문하지 않은 노드 중에서 최단 거리를 갖는 노드를 찾을 필요가 없다는 점**이 다르다.
    - 노드의 개수가 N개일 때 **알고리즘 상으로 N번의 단계를 수행**하며, **단계마다 O(N^2)의 연산을 통해 현재 노드를 거쳐가는 모든 경로를 고려**한다.
    - 따라서 플로이드 워셜 알고리즘의 총 시간 복잡도는 `O(N^3)`이다.
- 플로이드 워셜 알고리즘은 다익스트라 알고리즘과 달리 **2차원 리스트에 최단 거리 정보를 저장한다는 특징이 있다.**
    - 모든 노드에 대하야 다른 모든 노드로 가는 최단 거리 정보를 담아야 하기 때문이다.
    - 따라서 2차원 리스트를 처리해야 하므로 N번의 단계에서 매번 `O(N^2)`의 시간이 소요된다.
- 다익스트라 알고리즘은 그리디 알고리즘인데 반해 **플로이드 워셜 알고리즘은 다이나믹 프로그래밍이라는 특징이 있다.**
    - 노드의 개수를 N이라고 할 때, **N번 만큼의 단계를 반복하며 ‘점화식에 맞게’ 2차원 리스트를 갱신**하기 때문이다.
- 각 단계에서 **해당 노드를 거쳐가는 경우**를 고려한다.
    - 예를 들어 1번 노드에 대해서 확인할 땐 **1번 노드를 중간에 거쳐 지나가는 모든 경우를 고려**하면 된다.
    - 정확히는 A → 1번 노드 → B로 가는 비용을 확인한 후 최단 거리를 갱신한다.
    - 이를테면 현재 최단 거리 테이블에서 A번 노드에서 B번 노드로 이동하는 비용이 3으로 기록되어 있을 때, A번 노드에서 1번 노드를 거쳐 B번 노드로 이동하는 비용이 2라는 것이 밝혀지면, A번 노드에서 B번 노드로 이동하는 비용을 2로 갱신하는 것이다.
- 따라서 알고리즘에서는 현재 확인하고 있는 노드를 제외하고 N - 1개의 노드 중에서 서로 다른 노드 (A, B) 쌍을 선택한다.
    - 이후에 A → 1번노드 → B로 가는 비용을 확인한 뒤 최단 거리를 갱신한다.
- 구체적인 점화식은 다음과 같다.
    
    $Dab = min(Dab, Dak + Dkb)$
    
    - 따라서 전체적으로 3중 반복문을 이용하여 이 점화식에 따라 최단 거리 테이블을 갱신하면 된다.
    - 위 점화식을 말로 풀어 설명하자면, **‘A에서 B로 가는 최소 비용’**과 **‘A에서 K를 거쳐 B로 가는 비용’**을 비교하여 **더 작은 값으로 갱신**하겠다는 것이다.

```java
public static final int INF = (int) 1e9;
public static int n, m;   // 노드의 개수, 간선의 개수
public static int[][] graph = new int[501][501];

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	n = sc.nextInt();
	m = sc.nextInt();

	// 최단거리 테이블을 모두 무한으로 초기화
	for (int i = 0; i < 501; i++) {
		Arrays.fill(graph[i], INF);
	}

	// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
	for (int a = 1; a <= n; a++) {
		for (int b = 1; b <= n; b++) {
			if (a == b) graph[a][b] = 0;
		}
	}
	/* 위 코드를 이렇게 바꿀 수 있을 것 같음
	for (int a = 1; a <= n; a++) {
		graph[a][a] = 0;
	}
	*/

	// 각 간선에 대한 정보를 입력받아 그 값으로 초기화
	for (int i = 0; i < m; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		graph[a][b] = c;
	}

	// 점화식에 따라 플로이드 워셜 알고리즘 수행
	for (int k = 1; k <= n; k++) {   // 거쳐가는 노드
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
			}
		}
	}

	// 수행된 결과를 출력
	for (int a = 1; a <= n; a++) {
		for (int b = 1; b <= n; b++) {
			if (graph[a][b] == INF) {
				System.out.print("INFINITY ");
			} else {
				System.out.print(graph[a][b] + " ");
			}
		}
		System.out.println();
	}
}
```

---

## 실전 문제 1 - 미래 도시

### 풀이 과정

- 공중 미래도시는 1번부터 N번까지의 회사가 있음
    - 특정 회사끼리는 서로 도로를 통해 연결되어 있다.
    - 회사끼리 연결되어있는 도로를 이용
    - 연결된 회사는 양방향으로 이동 가능하다.
    - 정확히 1만큼의 시간으로 이동할 수 있다.
- 방문 판매원 A는 현재 1번 회사에 위치해 있으며, X번 회사에 방문하고자 한다.
- 소개팅 상대는 K번 회사에 존재한다.
    - X번 회사에 가서 물건 팔기 전에 먼저 소개팅 상대의 회사에 찾아가 함께 커피를 마실 예정이다. (1 → K → X)

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                    1ms

public class MyClass {
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        
        int n = Integer.parseInt(tokenizer.nextToken());   // 회사 개수
        int m = Integer.parseInt(tokenizer.nextToken());   // 경로의 개수
        int[][] map = new int[n + 1][n + 1];
        
        // 최단 거리 테이블을 99999로 초기화한다.
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], 99999);
        }
        
        // 자기 자신은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }
        
        // 초기화
        for (int i = 1; i <= m; i++) {
            StringTokenizer company = new StringTokenizer(reader.readLine(), " ");
            
            int a = Integer.parseInt(company.nextToken());
            int b = Integer.parseInt(company.nextToken());
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        // 플로이드 워셜
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }
        
        String[] xk = reader.readLine().split(" ");

        int x = Integer.parseInt(xk[0]);
        int k = Integer.parseInt(xk[1]);
        
        int result = map[1][k] + map[k][x];
        
        if (result > 99999) {
            System.out.println(-1);
        } else {
            System.out.println(map[1][k] + map[k][x]);
        }
    }
}
```

### 문제 해설

- 전형적인 플로이드 워셜 알고리즘 문제이다.
- 문제에서 N의 범위가 100 이하로 매우 한정적이다.
    - 따라서 구현이 간단한 플로이드 워셜 알고리즘을 이용하는 것이 유리하다.

```java
import java.util.*;

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 거쳐 갈 노드(X), 최종 목적지 노드(K)
    public static int n, m, x, k;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A와 B가 서로에게 가는 비용은 1이라고 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        int distance = graph[1][k] + graph[k][x];

        // 도달할 수 없는 경우, -1을 출력
        if (distance >= INF) {
            System.out.println(-1);
        }
        // 도달할 수 있다면, 최단 거리를 출력
        else {
            System.out.println(distance);
        }
    }
}
```

## 실전 문제 2 - 전보

### 풀이 과정

- N개의 도시, 보내고자 하는 메시지가 있는 경우 다른 도시로 전보를 보내 다른 도시로 해당 메세지를 전송할 수 있다.
- X → Y 로 전보를 보내려면 통로가 있어야한다.
- 시작 지점이 C, C에서 출발해서 연결되는 도시 수 출력

```java
import java.util.*;
import java.io.*;

// 코드 실행 시간:                   57ms

public class MyClass {
    
    private static List<ArrayList<Node>> map = new ArrayList<>();
    private static int[] distance;

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int dist = node.distance;
            int now = node.index;
            
            if (distance[now] < dist) continue;
            
            for (int i = 0; i < map.get(now).size(); i++) {
                int time = distance[now] + map.get(now).get(i).distance;
                
                if (time < distance[map.get(now).get(i).index]) {
                    distance[map.get(now).get(i).index] = time;
                    queue.offer(new Node(map.get(now).get(i).index, time));
                }
            }
        }
    }
    
    private static int[] getCountAndTotalTime(int start) {
        // 연결된 도시들 중에서 가장 큰 시간
        int totalTime = map.get(start).get(0).distance;
        
        for (int i = 1; i < map.get(start).size(); i++) {
            int time = map.get(start).get(i).distance;
            
            if (time > totalTime) {
                totalTime = time;
            }
        }
        
        return new int[] { map.get(start).size(), totalTime };
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nmc = reader.readLine().split(" ");
        
        int n = Integer.parseInt(nmc[0]);
        int m = Integer.parseInt(nmc[1]);
        int c = Integer.parseInt(nmc[2]);
        
        distance = new int[n + 1];
        
        Arrays.fill(distance, 99999);
        
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < m; i++) {
            String[] connectedInformation = reader.readLine().split(" ");
            
            int city = Integer.parseInt(connectedInformation[0]);
            int connectedCity = Integer.parseInt(connectedInformation[1]);
            int time = Integer.parseInt(connectedInformation[2]);
            
            map.get(city).add(new Node(connectedCity, time));
        }
        
        dijkstra(c);
        
        int[] result = getCountAndTotalTime(c);
        
        System.out.println(result[0] + " " + result[1]);
    }
    
    static class Node implements Comparable<Node> {
        
        int index;
        int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }
}
```

### 문제 해설

```java
import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    public static int n, m, start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    public static int[] d = new int[30001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용 
            int now = node.getIndex(); // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            // X번 노드에서 Y번 노드로 가는 비용이 Z라는 의미
            graph.get(x).add(new Node(y, z));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 도달할 수 있는 노드의 개수
        int count = 0;
        // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 시작 노드는 제외해야 하므로 count - 1을 출력
        System.out.println((count - 1) + " " + maxDistance);
    }
}
```