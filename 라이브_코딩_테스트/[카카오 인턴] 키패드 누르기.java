import java.util.*;

class Solution {

    /**
     * 테스트 1 〉	통과 (0.02ms, 74.3MB)
        테스트 2 〉	통과 (0.05ms, 80.2MB)
        테스트 3 〉	통과 (0.04ms, 75.8MB)
        테스트 4 〉	통과 (0.03ms, 72MB)
        테스트 5 〉	통과 (0.06ms, 77.5MB)
        테스트 6 〉	통과 (0.04ms, 74MB)
        테스트 7 〉	통과 (0.05ms, 74.5MB)
        테스트 8 〉	통과 (0.07ms, 83.3MB)
        테스트 9 〉	통과 (0.05ms, 73.7MB)
        테스트 10 〉	통과 (0.06ms, 68.9MB)
        테스트 11 〉	통과 (0.05ms, 74.7MB)
        테스트 12 〉	통과 (0.05ms, 72.4MB)
        테스트 13 〉	통과 (0.09ms, 74.6MB)
        테스트 14 〉	통과 (0.14ms, 78.1MB)
        테스트 15 〉	통과 (0.22ms, 76.3MB)
        테스트 16 〉	통과 (0.24ms, 78.3MB)
        테스트 17 〉	통과 (0.34ms, 79.6MB)
        테스트 18 〉	통과 (0.36ms, 73.4MB)
        테스트 19 〉	통과 (0.30ms, 77.8MB)
        테스트 20 〉	통과 (0.42ms, 76.8MB)
     */
    
    private final int[][] KEYPAD_POSITION = {
        {0, 0}, // 1
        {1, 0}, // 2
        {2, 0}, // 3
        {0, 1}, // 4
        {1, 1}, // 5
        {2, 1}, // 6
        {0, 2}, // 7
        {1, 2}, // 8
        {2, 2}, // 9
        {0, 3}, // *
        {1, 3}, // 0
        {2, 3} // #
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] left = KEYPAD_POSITION[9];
        int[] right = KEYPAD_POSITION[11];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                left = KEYPAD_POSITION[numbers[i] - 1];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                right = KEYPAD_POSITION[numbers[i] - 1];
            } else { // 가운데 열의 숫자 2, 5, 8, 0 처리
                int leftDistance = getManhattanDistance(left, KEYPAD_POSITION[numbers[i] - 1]);
                int rightDistance = getManhattanDistance(right, KEYPAD_POSITION[numbers[i] - 1]);

                if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = KEYPAD_POSITION[numbers[i] - 1];
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = KEYPAD_POSITION[numbers[i] - 1];
                } else { // 거리가 같을 때
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = KEYPAD_POSITION[numbers[i] - 1];
                    } else {
                        answer.append("R");
                        right = KEYPAD_POSITION[numbers[i] - 1];
                    }
                }
            }

        }
        
        return answer.toString();
    }
    
    // |x1 - x2| + |y1 - y2|
    private int getManhattanDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}