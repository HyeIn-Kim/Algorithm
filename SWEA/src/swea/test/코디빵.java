package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 코디빵 {
    static class Person {
        int r, c;
        int k;
        int m;

        public Person( int r, int c, int k, int m) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.m = m;
        }
    }

    static class Move {
        int t;
        int n;

        public Move(int t, int n) {
            this.t = t;
            this.n = n;
        }
    }

    static class Event {
        int t;
        int event;
        int r, c;
        int m;
        int k;

        public Event(int t, int event, int r, int c, int m, int k) {
            this.t = t;
            this.event = event;
            this.r = r;
            this.c = c;
            this.m = m;
            this.k = k;
        }
    }

    static int N, Q;
    // set, map을 사용하는 데에 너무 집중해서 항상 set, map에 객체를 넣어서 갱신하다가 어려워했었는데,
    // 생각해 보니까 객체 배열로 관리한 다음에 set에는 index만 넣어서 관리하면 편한 거였다!!!
    // 사람(빵 개수, 가진 돈)과 이벤트(편의점, 땅근)을 관리하는 객체 배열
    static Person[] people;
    static Event[] events;

    // 현재 편의점/땅근을 갈 수 있는 사람을 treeSet으로 정렬
    // Priority Queue와 같지만 treeSet이 오버헤드가 조금 더 많으므로
    // 기본적으로는 PQ를 사용하되, 중간에 있는 요소를 꺼내야 할 경우에는 treeSet으로 정렬하자!
    static TreeSet<Integer> pStore;
    static TreeSet<Integer> pCarrot;
    // 이동 중인 사람을 저장하는 PQ. 시간 순서대로 나온다.
    static PriorityQueue<Move> moving;
    // 현재 편의점에 남아 있는 빵을 저장하는 PQ. 빵 개수가 많은 순서대로 나온다.
    static PriorityQueue<Integer> store;

    static final int STORE = 1;
    static final int CARROT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            // 사람 입력
            people = new Person[N];
            // sort 함수 내에서는 객체 속성만 접근할 수 있을 줄 알았는데 생각해 보니까 전역변수도 됐던 것이다..
            pStore = new TreeSet<>((o1, o2) -> {
                int dist1 = Math.abs(people[o1].r) + Math.abs(people[o1].c);
                int dist2 = Math.abs(people[o2].r) + Math.abs(people[o2].c);
                if(dist1 == dist2) {
                    if(people[o1].c == people[o2].c) return people[o1].r - people[o2].r;
                    else return people[o1].c - people[o2].c;
                }
                else return dist1 - dist2;
            });
            pCarrot = new TreeSet<>((o1, o2) -> {
                if(people[o1].m == people[o2].m) return o1 - o2;
                else return people[o2].m - people[o1].m;
            });
            moving = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                // 처음엔 집에 있으니까 모든 사람을 집에 넣어줌
                people[i] = new Person(r, c, 0, m);
                pStore.add(i);
                pCarrot.add(i);
            }

            events = new Event[Q + 1];
            for(int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int event = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                if(event == CARROT) {
                    int m = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    events[i] = new Event(t, event, r, c, m, k);
                }
                else events[i] = new Event(t, event, 0, 0, 0, k);
            }

            // 편의점에 빵 입고 -> 방금 도착한 사람 반영 -> 모든 사람들과 빵을 매칭 -> 땅근거래 이므로
            // 거래1 -> 거래2 사이의 모든 집에 돌아오는 사람들과 빵을 매칭시켜주기 위해
            // Q에 마지막 사람을 넣어줌.
            // 여기서 실수했던 게, 시간이 다 흘렀다고 문제가 끝나는 게 아니라 모든 사람이 집에 돌아올 때까지여서
            // 종료 시간을 max 시간인 1000000000로 하면 사람들이 집에 못 돌아온다. 넉넉하게 잡아준다.
            events[Q] = new Event(2000000000, 0, 0, 0, 0, 0);
            // 시간 순서대로 정렬
            Arrays.sort(events, (o1, o2) -> o1.t - o2.t);

            store = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i = 0; i < Q; i++) {
                switch(events[i].event) {
                    case STORE: {
                        // 편의점 빵 입고
                        store.offer(events[i].k);
                        // 집에 사람 돌려보내고, 편의점 빵을 배분한다.
                        checkStore(events[i].t, events[i + 1].t);
                        break;
                    }
                    case CARROT: {
                        // 편의점이 더 우선되기 때문에 당근 거래가 발생한 순간 편의점 빵이 들어왔는지를 검사
                        checkStore(events[i].t, events[i].t + 1);
                        // 땅근 거래
                        tradeCarrot(events[i]);
                        // 거래 성사 이후 다음 이벤트까지 빵 배분
                        checkStore(events[i].t + 1, events[i + 1].t);
                        break;
                    }
                }
            }

            // 출력
            sb.append("#" + testCase);
            for(Person p : people) {
                sb.append(" " + p.k);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 편의점에서 빵을 살 수 있는지 체크하고, 살 수 있다면 빵을 나눠줌
    private static void checkStore(int currTime, int endTime) {
        // 마지막 이벤트일 때 return
        if(currTime >= endTime) return;

        // 이 while문에서는 모든 사람들이 endTime까지 집에 돌아올 때마다 편의점 빵을 배분하게 된다.
        while(true) {
            // 현재 시간까지 집에 돌아온 사람들을 돌려보냄
            while(!moving.isEmpty() && moving.peek().t == currTime) {
                Move m = moving.poll();
                pStore.add(m.n);
                pCarrot.add(m.n);
            }

            // 집에 있는 모든 사람들과 편의점 빵을 매칭시켜줌
            while(!store.isEmpty() && !pStore.isEmpty()) {
                int idx = pStore.pollFirst();
                pCarrot.remove(idx);
                int dist = getDist(people[idx].r, people[idx].c, 0, 0);
                people[idx].k += store.poll();
                moving.add(new Move(currTime + (dist * 2), idx));
            }

            // 이동 중인 사람이 없거나 다음 이벤트에 집에 돌아온다면 종료
            if(moving.isEmpty() || moving.peek().t >= endTime) return;
            // 다음에 집에 돌아오는 시간으로 갱신
            currTime = moving.peek().t;
        }
    }

    private static void tradeCarrot(Event e) {
        // 편의점에 빵이 남아있을 경우 땅근거래 취소
        if(!store.isEmpty()) return;
        // 집에 아무도 없을 경우 땅근거래 취소
        if(pCarrot.isEmpty()) return;

        int idx = pCarrot.first();
        // 빵을 살 돈이 부족하면 땅근거래 취소
        if(people[idx].m < e.m) return;
        // 땅근거래 성사
        people[idx].k += e.k;
        people[idx].m -= e.m;

        // 다음에 집에 올 시간을 계산해서 돌려보냄
        int dist = getDist(people[idx].r, people[idx].c, e.r, e.c);
        moving.add(new Move(e.t + (dist * 2), idx));
        pCarrot.pollFirst();
        pStore.remove(idx);
    }

    private static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}