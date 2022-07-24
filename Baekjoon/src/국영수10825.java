import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 국영수10825 {
    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Student> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.korean == o2.korean) {
                if(o1.english == o2.english) {
                    if(o1.math == o2.math) return o1.name.compareTo(o2.name);
                    else return o2.math - o1.math;
                }
                else return o1.english - o2.english;
            }
            else return o2.korean - o1.korean;
        });

        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Student student = pq.poll();
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }
}
