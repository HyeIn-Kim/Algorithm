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
    static Person[] people;
    static Event[] events;

    static TreeSet<Integer> pStore;
    static TreeSet<Integer> pCarrot;
    static PriorityQueue<Move> moving;
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

                people[i] = new Person(r, c, 0, m);
                pStore.add(i);
                pCarrot.add(i);
            }

            events = new Event[Q];
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

            Arrays.sort(events, (o1, o2) -> o1.t - o2.t);

            store = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i = 0; i < Q; i++) {
                switch(events[i].event) {
                    case STORE: {
                        store.offer(events[i].k);

                        break;
                    }
                    case CARROT: { break; }
                }
            }

            // 출력

            Arrays.sort(people, (o1, o2) -> o2.k - o1.k);
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
        // 지금까지 집에 온 사람들의 목록을 갱신
        while(!moving.isEmpty()) {
            Move m = moving.peek();
            if(m.t <= endTime) {
                moving.poll();
                pStore.add(m.n);
                pCarrot.add(m.n);
            }
        }

        // 빵을 나눠줌
        while(!store.isEmpty() && !pStore.isEmpty()) {
            int idx = pStore.pollFirst();
            int dist = getDist(people[idx].r, people[idx].c, 0, 0);
            people[idx].k += store.poll();
            moving.add(new Move(currTime + (dist * 2), idx);
        }
    }

    private static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
