import java.util.*;
public class 디스크컨트롤러 {
    static class Work {
        int start;
        int time;

        public Work(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        PriorityQueue<Work> waits = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

        waits.offer(new Work(jobs[0][0], jobs[0][1]));
        int idx = 1;
        int end = jobs[0][0];
        int sum = 0;

        while(!waits.isEmpty()) {
            Work work = waits.poll();
            end += work.time;
            sum += end - work.start;

            while(idx < jobs.length && jobs[idx][0] <= end) {
                waits.offer(new Work(jobs[idx][0], jobs[idx++][1]));
            }

            if(idx < jobs.length && waits.isEmpty()) {
                end = jobs[idx][0];
                waits.offer(new Work(jobs[idx][0], jobs[idx++][1]));
            }
        }

        return sum / jobs.length;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][] {{0, 10}, {4, 10}, {15, 2}, {5, 11}}));
//        System.out.println(solution(new int[][] {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
    }
}