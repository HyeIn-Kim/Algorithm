import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경고3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");
        int[] start = new int[3];
        for(int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(":");
        int[] end = new int[3];
        for(int i = 0; i < 3; i++) {
            end[i] = Integer.parseInt(input[i]);
        }

        // 시간이 같을 경우에는 24시간을 기다려야 한다.
        if(start[0] == end[0] && start[1] == end[1] && start[2] == end[2]) {
            System.out.println("24:00:00");
            return;
        }

        // 그 외는 시간을 빼줌
        int[] result = new int[3];
        for(int i = 2; i > 0; i--) {
            result[i] = end[i] - start[i];
            if(result[i] < 0) {
                result[i] += 60;
                end[i-1]--;
            }
        }

        result[0] = end[0] - start[0];
        if(result[0] < 0) result[0] += 24;

        System.out.printf("%02d:%02d:%02d", result[0], result[1], result[2]);
    }
}
