import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        
        for(String c : completion) {
            int cnt = map.get(c);
            if(cnt == 1) map.remove(c);
            else map.put(c, map.get(c) - 1);
        }

        String answer = "";
        for(String m : map.keySet()) {
            answer = m;
        }
        
        return answer;
    }
}