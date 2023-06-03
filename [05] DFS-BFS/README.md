## 꼭 필요한 자료구조 기초

### 탐색 (Search)

- 많은 양의 데이터 중에서 **원하는 데이터를 찾는 과정**
- 프로그래밍에서는 **그래프, 트리 등의 자료구조 안에서 탐색을 하는 문제**를 자주 다룬다.
- 대표적인 탐색 알고리즘으로 **DFS, BFS** 등을 꼽을 수 있는데, 이 두 알고리즘의 원리를 제대로 이해해야 코딩 테스트의 탐색 문제 유형을 풀 수 있다.

### 자료구조 (Data Structure)

- 데이터를 표현하고 관리하고 처리하기 위한 구조
- 스택과 큐는 자료구조의 기초 개념으로 다음의 두 핵심적인 함수로 구성된다.
    - 삽입 (push): 데이터를 삽입한다.
    - 삭제 (pop): 데이터를 삭제한다.
- 실제로 스택과 큐를 사용할 땐 삽입과 삭제 외에도 오버플로우와 언더플로우를 고민해야 한다.
    - **오버플로(overflow)는 특정한 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입 연산을 수행할 때 발생**한다.
        - 즉, 저장 공간을 벗어나 데이터가 넘쳐 흐를 때 발생한다.
    - **언더플로(underflow)는 특정한 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제 연산을 수행하면 발생**한다.

### 스택 (stack)

- 스택은 박스 쌓기에 비유할 수 있다.
- 흔히 박스는 아래에서부터 위로 차곡차곡 쌓고, 아래에 있는 박스를 치우기 위해서는 위에 있는 박스를 먼저 내려야 한다.
    - 이러한 구조를 **선입후출(FILO, First In Last Out)구조 또는 후입선출(LIFO, Last In First Out)구조**라고 한다.
- 스택을 자바 코드로 표현하면 다음과 같다.
    
    ```java
    public class Main {
    	public static void main(String[] args) {
    		Stack<Integer> stack = new Stack<>();
    
    		stack.push(5);
    		stack.push(2);
    		stack.push(3);
    		stack.push(7);
    		stack.pop();
    		stack.push(1);
    		stack.push(4);
    		stack.pop();
    
    		// stack의 최상단 원소부터 출력
    		while (!stack.empty()) {
    			System.out.println(stack.peek());  // 가장 맨 위의 원소부터 출력
    			stack.pop();   // 원소 삭제
    		}
    
    		// pop() 자체가 삭제된 요소를 반환하기 때문에 다음과 같이 작성해도 괜찮다.
    		while (!stack.empty()) {
    			System.out.println(stack.pop());
    		}
    	}
    }
    ```
    
    - 자바에서 스택을 이용하려면 `import java.util.Stack;`

### 큐 (Queue)

- 큐는 대기줄에 비유할 수 있다.
- 예를 들어 놀이공원에 입장하기 위해 줄을 설 때, 먼저 들어온 사람이 먼저 들어가게 된다.
- **나중에 온 사람일수록 나중에 들어가기 때문에 흔히 공정한 자료구조**라고 비유된다.
    - 이러한 구조를 **선입선출(FIFO, First In First Out) 구조**라고 한다.
- 큐를 자바 코드로 표현하면 다음과 같다.
    
    ```java
    public class Main {
    	public static void main(String[] args) {
    		// 자바에서 큐는 LinkedList를 활용하여 생성해야 한다.
    		Queue<Integer> queue = new LinkedList<>();   
    		
    		queue.offer(5);  // 값 추가는 add() or offer()
    		queue.offer(2);
    		queue.offer(3);
    		queue.offer(7);
    		queue.poll();  // 값 삭제는 poll() or remove()
    		queue.offer(1);
    		queue.offer(4);
    		queue.poll();
    
    		// Queue에 먼저 들어온 원소부터 출력
    		while (!queue.isEmpty()) {
    			System.out.println(queue.poll());
    		}
    
    		// 먼저 들어간 값을 참고하려면 다음과 같이 작성한다.
    		while (!queue.isEmpty()) {
    			System.out.println(queue.peek());
    			queue.poll();
    		}
    	}
    }
    ```
    
    - `add()` 메서드의 경우 삽입에 성공하면 true, 아니라면 `IllegalStateException`을 발생시킨다.
    - `poll()` 은 큐가 비어있으면 null을 반환한다.

### 재귀 함수 (Recursive Function)

- 자기 자신을 다시 호출하는 함수
- 수학 시간에 한 번씩 언급되는 프랙털(Fractal) 구조와 흡사하다.

**간단한 재귀함수 사용 예시**

```java
public class Main {
	public static void main(String[] args) {
		recursiveMethod();
	}

	private static void recursiveMethod() {
		System.out.println("나 또 왔지롱");
		recursiveMethod();
	}
}
```

- 위 프로그램을 실행하면 문자열이 무한히 출력되면서 재귀에 빠진다.
- 하지만 시간이 지나면 무한 루프로 인해 stackOverflow 예외가 발생한다.

**재귀함수 종료 조건**

- 재귀 함수를 사용할 땐 **종료 조건을 꼭 명시해야한다.**
- 종료 조건을 명시하지 않으면 함수가 무한히 호출될 수 있다.
- 컴퓨터 내부에서 재귀 함수의 수행은 **스택 자료구조를 이용**한다.
    - 함수를 계속 호출했을 때 **가장 마지막에 호출한 함수가 먼저 수행을 끝내야 그 앞의 함수 호출이 종료되기 때문이다.**
- 컴퓨터의 구조 측면에서 **연속해서 호출되는 함수는 메인 메모리의 스택 공간에 적재되므로 재귀 함수는 스택 자료구조와 같다는 말은 틀린 말이 아니다.**
    - 따라서 스택 자료구조를 활용하는 상당수 알고리즘은 재귀함수를 이용해 간편하게 구현될 수 있다.
    - **DFS가 대표적인 예이다.**
- 재귀함수를 이용하는 대표적 예제로는 팩토리얼(Factorial) 문제가 있다.
    
    ```java
    public class Main {
    	private static int factorial(int n) {
    		if (n <= 1) {
    			return 1;
    		}
    
    		return factorial(n-1) * n;
    	}
    
    	public static void main(String[] args) {
    		System.out.println(factorial(5));
    	}
    }
    
    // 반복문으로 구현하면 다음과 같다.
    public class Main {
    	public static void main(String[] args) {
    		int n = 5;
    		int answer = 1;
    
    		while (n >= 1) {
    			answer *= n;
    			n--;
    		}
    
    		// for문이 좀 더 간단하다.
    		for (int i = 1; i <= n; i++) {
    			answer *= i;
    		}
    
    		System.out.println(answer);
    	}
    }
    ```
    
    - 수학적으로 0!과 1!의 값은 1로 같다는 성질을 이용하여 팩토리얼 함수는 n이 1이하가 될 때 함수를 종료하는 재귀함수의 형태로 구현할 수 있다.

**반복문에 비해 재귀가 가지는 장점**

- 재귀 함수의 코드가 좀 더 간결하다.
    - 재귀 함수가 점화식(재귀식)을 그대로 옮겼기 때문이다.
    - 수학에서 점화식은 **특정한 함수를 자신보다 더 작은 변수에 대한 함수와의 관계로 표현한 것을 의미한다.**

## 탐색 알고리즘 DFS/BFS

### DFS (Depth-First Search)

- **깊이 우선 탐색**이라고도 부르며, **그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘**
- 해당 알고리즘은 특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 다음, 다시 돌아가 다른 경로로 탐색하는 알고리즘이다.

**그래프의 기본 구조**

- 그래프는 **노드(node)와 간선(edge)**으로 표현되며, 이때 **노드를** **정점(vertex)**이라고도 말한다.
- **그래프 탐색이란 하나의 노드를 시작으로 다수의 노드를 방문하는 것**을 말한다.
    - 또한, **두 노드가 간선으로 연결되어 있다면, ‘두 노드는 인접하다(Adjacent)’**라고 표현한다.
- 프로그래밍에서 그래프는 크게 2가지 방식으로 표현할 수 있다.
    1. 인접 행렬(Adjacency Matrix): **2차원 배열**로 그래프의 연결 관계를 표현하는 방식
    2. 인접 리스트(Adjacency List): **리스트**로 그래프의 연결 관계를 표현하는 방식

**인접 행렬 방식**

```java
public class Main {
	private static final int INF = Integer.MAX_VALUE;  // 무한 초기값

	private static int[][] graph = {
		{0, 7, 5},
		{7, 0, INF},
		{5, INF, 0}
};

	public static void main(String[] args) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

- 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식
- **연결되어 있지 않은 노드끼리는 무한(infinity)의 비용**이라고 작성한다.
    - 실제 코드에서는 논리적으로 정답이 될 수 없는 큰 값 중에서 99999999, 987654321 등의 값으로 초기화하는 경우가 많다.

**인접 리스트 방식**

```java
class Node {
	private int connectedNode;   // 연결된 노드
	private int distance;   // 그 노드와의 거리

	public Node(int connectedNode, int distance) {
		this.connectedNode = connectedNode;
		this.distance = distance;
	}

	public void printNode() {
		System.out.println("( " + connectedNode + ", " + distance + " ) ");
	}
}

public class Main {
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			graph.add(new ArrayList<Node>());
		}

		graph.get(0).add(new Node(1, 7));
		graph.get(0).add(new Node(2, 5));
		
		graph.get(1).add(new Node(0, 7));
		
		graph.get(2).add(new Node(0, 5));

		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				graph.get(i).get(j).printNode();
			}

			System.out.println();
		}
	}
}
```

- 인접 리스트 방식은 모든 노드에 연결된 노드에 대한 정보를 차례대로 연결하여 저장한다.
- ‘연결 리스트’ 자료구조를 이용해 구현한다.

**인접 행렬 vs 인접 리스트**

- 메모리 측면
    - 인접 행렬 방식은 모든 관계를 저장하기 때문에 노드 개수가 많을수록 메모리가 불필요하게 낭비된다.
    - 인접 리스트 방식은 연결된 정보만을 저장하기 때문에 메모리를 효율적으로 사용한다.
- 탐색 속도
    - 인접 리스트는 위와 같은 속성 때문에 인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느리다.
        - 연결된 데이터를 하나씩 확인해야 하기 때문이다.