import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 우선순위 큐라는 단어에 먼저 PQ부터 생각했는데,
// PQ로 만들면 최댓값, 최솟값 둘 중 하나는 바로 뽑을 수 없게 됨.
// 바로바로 뽑을 수 있게 덱도 생각해 봤는데, 덱은 중간에 값을 삽입 못해서 놔줬음.
// TreeMap은 자료가 항상 정렬되어 들어가니까, firstKey, lastKey 메소드로
// 값을 찾으면 쨘! 바로 찾을 수 있었다.
public class 이중우선순위큐7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int k = Integer.parseInt(br.readLine());
            // Key 입력값 / Value 해당 값이 들어있는 횟수
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("I")) {
                    int value = Integer.parseInt(st.nextToken());
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }
                else if(command.equals("D")) {
                    int direction = Integer.parseInt(st.nextToken());
                    if(map.size() == 0) continue;

                    // 중복도 세 줘야 하니, 하나일 때만 삭제하고 그게 아니면 개수를 줄인다.
                    int key = direction == -1 ? map.firstKey() : map.lastKey();
                    if(map.get(key) > 1) {
                        map.put(key, map.get(key) - 1);
                    }
                    else {
                        map.remove(key);
                    }
                }
            }

            if(map.size() == 0) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }

        System.out.println(sb);
    }
}
