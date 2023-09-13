import java.util.*;

class Solution {

    /**
     * 테스트 1 〉	통과 (1.30ms, 77.8MB)
        테스트 2 〉	통과 (2.10ms, 72.5MB)
        테스트 3 〉	통과 (0.99ms, 79.4MB)
        테스트 4 〉	통과 (0.83ms, 77.2MB)
        테스트 5 〉	통과 (0.68ms, 82.8MB)
        테스트 6 〉	통과 (1.08ms, 78.1MB)
        테스트 7 〉	통과 (1.23ms, 72MB)
        테스트 8 〉	통과 (1.71ms, 77MB)
        테스트 9 〉	통과 (0.78ms, 72.4MB)
        테스트 10 〉	통과 (0.94ms, 72.1MB)
        테스트 11 〉	통과 (1.36ms, 77.8MB)
        테스트 12 〉	통과 (0.68ms, 70.5MB)
        테스트 13 〉	통과 (1.62ms, 73.1MB)
        테스트 14 〉	통과 (0.74ms, 82.8MB)
        테스트 15 〉	통과 (0.90ms, 80.2MB)
        테스트 16 〉	통과 (0.75ms, 74.1MB)
        테스트 17 〉	통과 (1.31ms, 75.4MB)
        테스트 18 〉	통과 (0.79ms, 73.5MB)
        테스트 19 〉	통과 (1.64ms, 79.9MB)
        테스트 20 〉	통과 (0.69ms, 77.5MB)
     */
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> positions = new LinkedList<>();
        
        int i = 0;
        for (int p : priorities) {
            list.add(p);
            queue.add(p);
            positions.add(i);
            i++;
        }
        
        int first = list.poll();
        
        int count = 0;
        while (!queue.isEmpty()) {
            int process = queue.poll();
            int l = positions.poll();
            
            if (process == first) {
                if (l == location) {
                    answer = count + 1;
                    break;
                }
                first = list.poll();
                count++;
            } else {
                queue.add(process);
                positions.add(l);
            }
        }

        return answer;
    }
}