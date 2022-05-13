import java.util.Arrays;
import java.util.TreeMap;

public class 이중우선순위큐 {
    public static int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String operation : operations) {
            String[] command = operation.split(" ");
            if(command[0].equals("I")) {
                int key = Integer.parseInt(command[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            else if(command[0].equals("D")) {
                if(map.size() == 0) continue;
                int key = command[1].equals("-1") ? map.firstKey() : map.lastKey();
                int value = map.get(key);
                if(value == 1) map.remove(key);
                else map.put(key, value - 1);
            }
        }

        int[] answer = new int[2];
        answer[0] = map.size() == 0 ? 0 : map.lastKey();
        answer[1] = map.size() == 0 ? 0 : map.firstKey();

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new String[] {"I 16", "D 1"}));
        System.out.println(solution(new String[] {"I 7","I 5","I -5","D -1"}));
    }
}
