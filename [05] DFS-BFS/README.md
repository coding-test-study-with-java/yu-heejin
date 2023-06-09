## 꼭 필요한 자료구조 기초

### 탐색 (Search)

- 많은 양의 데이터 중에서 **원하는 데이터를 찾는 과정**
- 프로그래밍에서는 **그래프, 트리 등의 자료구조 안에서 탐색을 하는 문제**를 자주 다룬다.
- 대표적인 탐색 알고리즘으로 **DFS, BFS** 등을 꼽을 수 있는데, 이 두 알고리즘의 원리를 제대로 이해해야 코딩 테스트의 탐색 문제 유형을 풀 수 있다.

### 자료구조 (Data Structure)

- 데이터를 표현하고 관리하고 처리하기 위한 구조
- **스택과 큐는 자료구조의 기초 개념**으로 다음의 두 핵심적인 함수로 구성된다.
    - 삽입 (push): 데이터를 삽입한다.
    - 삭제 (pop): 데이터를 삭제한다.
- 실제로 스택과 큐를 사용할 땐 삽입과 삭제 외에도 **오버플로우와 언더플로우를 고민**해야 한다.
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
- 시간이 지나면 무한 루프로 인해 stackOverflow 예외가 발생한다.

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
    - 인접 행렬 방식은 **모든 관계를 저장하기 때문에 노드 개수가 많을수록 메모리가 불필요하게 낭비된다.**
    - 인접 리스트 방식은 연결된 정보만을 저장하기 때문에 메모리를 효율적으로 사용한다.
- 탐색 속도
    - 인접 리스트는 위와 같은 속성 때문에 **인접 행렬 방식에 비해 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느리다.**
        - 연결된 데이터를 하나씩 확인해야 하기 때문이다.
- 한 그래프에서 노드 1과 노드 7이 연결되어 있는 상황을 생각해보자.
    - 인접 행렬 방식에서는 graph[1][7]만 확인하면 되지만, 인접 리스트 방식에서는 노드 1에 대한 인접 리스트를 앞에서 부터 차례대로 확인해야 한다.
    - 특정 노드와 연결된 `모든` 인접 노드를 순회해야하는 경우, **인접 리스트 방식이 인접 행렬 방식에 비해 메모리 공간의 낭비가 적다.**

### DFS 동작 방식

- DFS는 깊이 우선 탐색 알고리즘이다.
- **특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙이 들어가서 노드를 방문한 후, 다시 돌아가 다른 경로로 탐색하는 알고리즘**이다.
- DFS는 **스택 자료구조**를 이용하며, 구체적인 동작 과정은 다음과 같다.
    1. **탐색 시작 노드를 스택에 삽입하고 방문 처리**를 한다.
    2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면, **그 인접 노드를 스택에 넣고 방문 처리를 한다.** 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
    3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
    - 여기서 방문 처리란 스택에 한 번 삽입되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미한다.
- DFS는 이름에서부터 알 수 있듯이 단순하게 **가장 깊숙이 위치하는 노드에 닿을 때까지 확인(탐색)하면 된다.**
- 또한, 일반적으로 인접한 노드 중에서 방문하지 않은 노드가 여러개 있다면 **번호가 낮은 순서부터 처리한다.**
    - 기능을 생각하면 순서와 상관없이 처리해도 되지만, 코딩 테스트에서는 번호가 낮은 순서부터 처리하도록 명시하는 경우가 있기 때문에 관행적으로 번호가 낮은 순서부터 처리하도록 구현한다.
- 깊이 우선 탐색 알고리즘은 **스택 자료구조에 기초**한다는 점에서 구현이 간단하다.
    - 실제로는 스택을 사용하지 않아도 되며, **탐색을 수행함에 있어서 데이터의 개수가 N개인 경우 O(N)의 시간이 소요된다는 특징이 있다.**
    - 또한, 스택을 사용하기 때문에 재귀를 이용하면 매우 간결하게 구현할 수 있다.

```java
public class Main {
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	// DFS
	public static void dfs(int x) {
		visited[x] = true;   // 현재 노드를 방문 처리한다.
		System.out.println(x + " ");
		
		for (int i = 0; i < graph.get(x).size(); i++) {  // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
			int y = graph.get(x).get(i);   // 해당 그래프에 연결된 노드를 get해서 y에 저장
			if (!visited[y]) dfs(y);  // 만약 해당 노드를 방문하지 않았다면 재귀
		}
	}
}
```

[추가] **DFS를 재귀로 구현하면 컴퓨터 시스템의 동작 특성상 실제 프로그램의 수행 시간은 느려질 수 있다.** 따라서 스택 라이브러리를 이용해 시간 복잡도를 완화하는 테크닉이 필요할 때도 있다.

### BFS (Breadth First Search)

- 너비 우선 탐색
- 가까운 노드부터 탐색하는 알고리즘
- **DFS는 최대한 멀리 있는 노드를 우선으로 탐색하는 방식으로 동작**한다고 했는데, BFS는 그 반대이다.
    - 인접한 노드의 인접한 노드, 인접한 노드를 계속 탐색하기 때문에 멀리 있는 노드를 우선으로 탐색한다고 표현한 것 같다.
- BFS는 선입선출 방식인 **큐 자료구조를 이용하는 것이 정석**이다.
    - 인접한 노드를 반복적으로 큐에 넣도록 알고리즘을 작성하면, **자연스럽게 먼저 들어온 것이 먼저 나가게 되어 가까운 노드부터 탐색을 진행하게 된다.**
- BFS의 동작 방식은 다음과 같다.
    1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
    2. **큐에서 노드를 꺼내** **해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.**
    3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
- 너비 우선 탐색 알고리즘은 BFS는 **큐 자료구조에 기초**한다는 점에서 구현이 간단하다.
    - 탐색을 수행함에 있어 O(N)의 시간이 소요된다.
    - 일반적인 경우 실제 수행 시간은 DFS보다 좋은 편이다.

```java
public class Main {
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);  // 시작 노드 삽입

		visited[start] = true;

		while(!queue.isEmpty()) {   // 큐가 빌 때까지 반복
			int x = queue.poll();   // 큐에서 요소 하나 제거
			System.out.println(x + " ");
			
			for (int i = 0; i < graph.get(x).size(); i++) {  // 꺼낸 노드와 연결된 모든 노드들만큼 반복
				int y = graph.get(x).get(i);   // 꺼낸 노드와 연결된 노드 get
				if (!visited[y]) {  // 만약 해당 노드를 방문하지 않았다면
					queue.offer(y);   // 해당 노드를 큐에 추가
					visited[y] = true;
				}
			}
		}
	}
}
```

---

## 실전문제 - 음료수 얼려먹기

### 문제

- 구멍이 뚫린 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
- 구멍이 뚫려있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
- 얼음 틀의 모양이 주어질 때 생성되는 총 아이스크림의 개수는?

### 풀이 과정

- 0이 연결된 모든 공간을 찾아야한다.
- 방문하지 않은 노드 중에서 0인 공간이 있다면 거기부터 시작해서 방문한다.

```java
import java.io.*;
import java.util.*;

public class MyClass {
    private static int[][] iceFrame;
    private static int n;
    private static int m;
    
    private static boolean dfs(int x, int y) {
				if (x < 0 || x >= n || y < 0 || y >= m || iceFrame[x][y] == 1) {
				    return false;
				}
				
				iceFrame[x][y] = 1;
				
				dfs(x - 1, y);  // 상
				dfs(x + 1, y);  // 하
		    dfs(x, y - 1);  // 좌
		    dfs(x, y + 1);  // 우
		        
		    return true;
		}
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        iceFrame = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String frame = br.readLine();
            for (int j = 0; j < m; j++) {
                iceFrame[i][j] = frame.charAt(j) - '0';
            }
        }
        
        int iceCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    iceCount++;
                }
            }
        }
        
        System.out.println(iceCount);
    }
}
```

### 문제 해설

- 해당 문제는 DFS로 해결할 수 있다.
- 얼음을 얼릴 수 있는 공간이 상/하/좌/우로 연결되어 있기 때문에 그래프 형태로 모델링할 수 있다.
- 이러한 그래프 형태로 묶음을 찾는 문제는 DFS로 간단히 해결할 수 있다.

```java
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력 
    }

}
```

## 실전 문제 - 미로 탈출

### 문제

- N x M 크기의 직사각형 형태의 미로
- 처음 위치는 (1, 1)이고 미로의 출구는 (N, M)의 위치에 존재
- 괴물이 있으면 0, 괴물이 없으면 1
- 탈출하기 위해 움직여야 하는 최소 칸의 개수, 칸을 셀 땐 시작 칸과 마지막 칸을 모두 포함한다.

### 풀이 과정

- [https://velog.io/@tsi0521/미로-최단-경로-DFS-와-BFS-비교](https://velog.io/@tsi0521/%EB%AF%B8%EB%A1%9C-%EC%B5%9C%EB%8B%A8-%EA%B2%BD%EB%A1%9C-DFS-%EC%99%80-BFS-%EB%B9%84%EA%B5%90)
- 최단 경로는 BFS가 상당히 유리하다고 한다.

```java
import java.io.*;
import java.util.*;

// 코드 실행 시간:                   73ms

class MazePosition {
    int x;
    int y;
    
    public MazePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MyClass {
    // 상하좌우 탐색
    private static final int[] MOVE_X = { -1, 1, 0, 0 };
    private static final int[] MOVE_Y = { 0, 0, -1, 1 };
    
    private static int[][] maze;
    private static int n, m;
    
    // 갈 수 있는 공간인지 체크
    private static boolean isBoundary(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }
        
        if (maze[x][y] == 0) {
            return true;
        }
        
        return false;
    }
    
    private static int bfs(int x, int y) {
        Queue<MazePosition> queue = new LinkedList<>();
        
        // 출발 지점 insert
        // queue에 삽입 후 방문 처리를 한다.
        queue.offer(new MazePosition(0, 0));
        maze[0][0] = 1;

        while (!queue.isEmpty()) {
            MazePosition position = queue.poll();  // 방문 처리된 큐를 꺼낸다.
            System.out.println("( " + position.x + ", " + position.y + " ) => ");

            for (int i = 0; i < 4; i++) {
                // 상하좌우를 탐색하여 방문하지 않은 인접 노드를 모두 큐에 삽입 후 방문 처리
                int nextX = position.x + MOVE_X[i];
                int nextY = position.y + MOVE_Y[i];
                
                if (!isBoundary(nextX, nextY) && maze[nextX][nextY] == 1) {
                    queue.offer(new MazePosition(nextX, nextY));
                    maze[nextX][nextY] = maze[position.x][position.y] + 1;  // 원래 위치에서 +1 (거리 계산)
                }
            }
        }
        
        return maze[n-1][m-1];
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        
        maze = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String mazeLine = br.readLine();
            
            for (int j = 0; j < m; j++) {
                maze[i][j] = mazeLine.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs(0, 0));
    }
}

// 출력결과
( 0, 0 ) => 
( 1, 0 ) => 
( 0, 0 ) => 
( 1, 1 ) => 
( 1, 2 ) => 
( 0, 2 ) => 
( 1, 3 ) => 
( 1, 4 ) => 
( 0, 4 ) => 
( 1, 5 ) => 
( 2, 5 ) => 
( 3, 5 ) => 
( 4, 5 ) => 
( 3, 4 ) => 
( 4, 4 ) => 
( 3, 3 ) => 
( 4, 3 ) => 
( 3, 2 ) => 
( 4, 2 ) => 
( 3, 1 ) => 
( 4, 1 ) => 
( 3, 0 ) => 
( 4, 0 ) =>
```

- [https://nack1400.tistory.com/entry/AlgorithmJava-알고리즘-자바-미로의-최단거리-통로-BFS-코딩테스트-DFS-BFS-미로찾기-최단경로](https://nack1400.tistory.com/entry/AlgorithmJava-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%9E%90%EB%B0%94-%EB%AF%B8%EB%A1%9C%EC%9D%98-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC-%ED%86%B5%EB%A1%9C-BFS-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-DFS-BFS-%EB%AF%B8%EB%A1%9C%EC%B0%BE%EA%B8%B0-%EC%B5%9C%EB%8B%A8%EA%B2%BD%EB%A1%9C)

### 문제 해설

- BFS를 이용했을 때 매우 효과적으로 해결할 수 있다.
    - BFS는 시작 지점에서 가까운 노드부터 차례대로 그래프의 모든 노드를 탐색하기 때문이다.
- (1, 1) 지점에서부터 BFS를 수행하여 **모든 노드의 값에 거리 정보를 넣으면 된다.**
    - 즉, **출발지로부터 얼마나 떨어진 거리**인지 해당 노드에 넣어준다.
- **노드 값이 1이면 아직 방문하지 않은 장소이다.**