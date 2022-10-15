import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 어항정리23291 {
    static int N, K;
    static int max, min;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        list.add(new ArrayList<>());

        // 초기 어항 상태 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.get(0).add(Integer.parseInt(st.nextToken()));
        }

        // 어항 접기 시작!
        int cnt = 0;
        while(true) {
            // 1. 종료 조건인지 검사
            if(isEnd(list.get(0))) break;

            // 2. 물고기가 가장 작은 어항에 1마리씩 추가
            addFish(list.get(0));

            // 3. 맨 왼쪽 어항을 쌓는다
            stackPort();

            // 4. 반복 접기
            flipPort();

            // 5. 차이만큼 물고기 이동시키기
            moveFish();

            // 6. 납작하게 어항 재배열
            flat();

            // 7. N/2 뒤집기 2번
            halfFlip();
            halfFlip();

            moveFish();

            // 8. 납작하게 어행 재배열
            flat();

            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isEnd(ArrayList<Integer> list) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int value = list.get(i);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        if(max - min <= K) return true;
        else return false;
    }

    private static void addFish(ArrayList<Integer> list) {
        for(int i = 0; i < N; i++) {
            int value = list.get(i);
            if(value == min) list.set(i, value + 1);
        }
    }

    private static void stackPort() {
        ArrayList<Integer> temp = new ArrayList<>();
        int value = list.get(0).remove(0);
        temp.add(value);
        list.add(temp);
    }

    private static void flipPort() {
        while(true) {
            int size = list.size();
            int C = list.get(size - 1).size();
            // 바닥에 어항이 남아 있지 않으면 끝
            if(list.size() > list.get(0).size() - C) return;

            for(int c = 0; c < C; c++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int r = 0; r < size; r++) {
                    int value = list.get(r).remove(0);
                    temp.add(value);
                }
                list.add(size, temp);
            }

            for(int i = 0; i < size; i++) {
                if(!list.get(1).isEmpty()) break;
                list.remove(1);
            }
        }
    }

    private static void moveFish() {
        ArrayList<ArrayList<Integer>> next = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            next.add(new ArrayList<>());
            for(int j = 0; j < list.get(i).size(); j++) {
                next.get(i).add(list.get(i).get(j));
            }
        }

        for(int r = 0; r < list.size(); r++) {
            for(int c = 0; c < list.get(r).size(); c++) {
                for(int d = 0; d < 2; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= list.size() || nc >= list.get(nr).size()) continue;
                    int a = list.get(r).get(c);
                    int b = list.get(nr).get(nc);
                    int diff = Math.abs(a - b) / 5;
                    if(diff < 1) continue;
                    if(a > b) {
                        next.get(r).set(c, next.get(r).get(c) - diff);
                        next.get(nr).set(nc, next.get(nr).get(nc) + diff);
                    }
                    else {
                        next.get(r).set(c, next.get(r).get(c) + diff);
                        next.get(nr).set(nc, next.get(nr).get(nc) - diff);
                    }
                }
            }
        }

        list = next;
    }

    private static void flat() {
        ArrayList<ArrayList<Integer>> next = new ArrayList<>();
        next.add(new ArrayList<>());

        int size = list.get(0).size();
        for(int c = 0; c < size; c++) {
            for(int r = 0; r < list.size(); r++) {
                if(list.get(r).isEmpty()) continue;
                next.get(0).add(list.get(r).remove(0));
            }
        }

        list = next;
    }

    private static void halfFlip() {
        int N = list.get(0).size();
        int size = list.size();

        for(int i = size - 1; i >= 0; i--) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = 0; j < N/2; j++) {
                temp.add(0, list.get(i).remove(0));
            }

            list.add(temp);
        }

    }
}
