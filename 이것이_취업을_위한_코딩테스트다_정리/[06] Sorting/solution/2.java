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