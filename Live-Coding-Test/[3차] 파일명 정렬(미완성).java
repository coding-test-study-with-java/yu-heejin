import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] splits = new String[files.length][3];
        int splitIndex = 0;
        
        for (String name : files) {
            int firstNum = 0;
            int lastNum = 0;
            for (int i = 0; i < name.length(); i++) {
                if (Character.isDigit(name.charAt(i))) {
                    firstNum = i;
                    for (lastNum = i; Character.isDigit(name.charAt(lastNum)); lastNum++);
                    break;
                }
            }
            String header = name.substring(0, firstNum);
            String number = name.substring(firstNum, lastNum);
            String[] tail = name.substring(lastNum).split(".");
            
            System.out.println(header);
            System.out.println(number);
            System.out.println(tail);
            System.out.println("-----");
            splits[splitIndex][0] = header;
            splits[splitIndex][1] = number;
            splits[splitIndex][2] = tail[0];
        }
       Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.toLowerCase();
                String s2 = o2.toLowerCase();
                return s1.compareTo(s2);
            }
        });
        
        return files;
    }
}