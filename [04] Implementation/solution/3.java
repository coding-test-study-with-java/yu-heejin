import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        Map<Integer, int[]> arrows = new HashMap<>();
        
        // 왼쪽 방향에 안 간 곳이 있다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸 전진한다.
        // row, col, 왼쪽 방향
        arrows.put(0, new int[]{ 1, 0, 3 }); // row + 1
        arrows.put(1, new int[]{ 0, -1, 0 });  // col - 1
        arrows.put(2, new int[] { -1, 0, 1 }); // row - 1
        arrows.put(3, new int[]{ 0, 1, 2 }); // col + 1
        
        // 맵 row, col
        StringTokenizer mapToken = new StringTokenizer(reader.readLine(), " ");
        int row = Integer.parseInt(mapToken.nextToken());
        int col = Integer.parseInt(mapToken.nextToken());
        
        // 현재 위치와 바라보는 방향
        StringTokenizer positionAndArrowToken = new StringTokenizer(reader.readLine(), " ");
        int[] positionAndArrow = new int[] { 
            Integer.parseInt(positionAndArrowToken.nextToken()),
            Integer.parseInt(positionAndArrowToken.nextToken()),
            Integer.parseInt(positionAndArrowToken.nextToken()),
        };
        
        // 맵 생성
         List<String> map = new ArrayList<>();
        
        for (int i = 0; i < row; i++) {
            map.add(reader.readLine());
        }
        
        // 이동
        List<int[]> visited = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < row; i++) {
            int[] move = arrows.get(positionAndArrow[2]);
            
            if (visited.contains(move)) {
                // 왼쪽 방향에 가보지 않은 칸이 없다면 왼쪽 방향으로 회전만하고 1단계로 돌아간다.
                positionAndArrow[2] = move[2];
                continue;
            }

            if (!visited.contains(move)) {  // O(n)....
                // 가보지 않은 칸이 존재하면 왼쪽 방향으로 회전한다음 왼쪽으로 한칸 전진한다.
                positionAndArrow[0] += move[0];
                positionAndArrow[1] += move[1];
                positionAndArrow[2] = move[2];
            }
            
            if (map.get(positionAndArrow[0]).charAt(positionAndArrow[1]) == '1') {
                // 바다로 되어있는 칸의 경우 바라보는 방향을 유지한 채로 한 칸 뒤로가고 1단계로 돌아간다.
                positionAndArrow[0] -= move[0];
                positionAndArrow[1] -= move[1];
            }
            
            visited.add(move);
            count++;
        }
        
        System.out.println(count);
    }
}