import java.util.*;
public class 다리를지나는트럭 {
    static class Truck {
        int start;
        int weight;

        public Truck(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int sum = truck_weights[0];
        Queue<Truck> queue = new LinkedList<>();
        queue.offer(new Truck(time, truck_weights[0]));

        time++;
        int idx = 1;
        while(!queue.isEmpty()) {
            // 1. 다리를 빠져나간 트럭을 꺼냄
            if(queue.peek().start + bridge_length == time) {
                Truck truck = queue.poll();
                sum -= truck.weight;
            }

            // 2. 다음 트럭을 찾아서 다리에 올려놓음
            if(idx < truck_weights.length && truck_weights[idx] <= (weight - sum)) {
                queue.offer(new Truck(time, truck_weights[idx]));
                sum += truck_weights[idx++];
            }

            time++;
        }

        return time - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}