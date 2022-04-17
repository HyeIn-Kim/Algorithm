import java.util.*;
class 메뉴리뉴얼 {
    HashMap<String, Integer> map;
    int max;
    TreeSet<String> set;
    char[] selected;

    public String[] solution(String[] orders, int[] course) {
        set = new TreeSet<>();

        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            max = 0;
            for(int j = 0; j < orders.length; j++) {
                char[] order = orders[j].toCharArray();
                selected = new char[course[i]];
                combination(0, 0, order, course[i]);
            }

            if(max < 2) continue;
            for(String key : map.keySet()) {
                int value = map.get(key);
                if(value == max) set.add(key);
            }
        }

        String[] answer = new String[set.size()];
        int idx = 0;
        for(String value : set) {
            answer[idx++] = value;
        }
        return answer;
    }

    private void combination(int start, int cnt, char[] order, int length) {
        if(cnt == length) {
            char[] temp = Arrays.copyOf(selected, length);
            Arrays.sort(temp);

            String key = String.valueOf(temp);
            int value = map.getOrDefault(key, 0) + 1;
            max = Math.max(max, value);
            map.put(key, value);
            return;
        }

        for(int i = start; i < order.length; i++) {
            selected[cnt] = order[i];
            combination(i + 1, cnt + 1, order, length);
        }
    }
}