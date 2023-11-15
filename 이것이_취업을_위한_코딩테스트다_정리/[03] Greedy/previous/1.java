import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// CPU Time: 0.09 sec(s), Memory: 31956 kilobyte(s)
// compiled and executed in 1.499 sec(s)
// 코드 실행 시간:                    2ms

public class MyClass {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        
        List<Integer> members = new ArrayList<>();
        
        while (st2.hasMoreTokens()) {
            members.add(Integer.parseInt(st2.nextToken()));
        }
        
        Collections.sort(members, Comparator.reverseOrder());
        
        List<List<Integer>> groups = new ArrayList<>();
        int index = 0;

        while(index < members.size()) {
            List<Integer> group = new ArrayList<>();
            int count = 0;
            
            while(count < members.get(index)) {
                group.add(members.get(index + count));
                count++;
            }

            groups.add(group);
            index += count;
        }
        
        System.out.println(groups.size());
    }
}