import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            char[] input = br.readLine().toCharArray();
            int result = checkPalindrome(input);
            if(result == 2) {
                result = checkFront(input);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int checkPalindrome(char[] input) {
        int cnt = 0;
        int start = 0, end = input.length - 1;
        while(start < end) {
            if(input[start] == input[end]) {
                start++;
                end--;
            }
            else {
                cnt++;
                if(cnt > 1) break;
                end--;
            }
        }

        return cnt;
    }

    private static int checkFront(char[] input) {
        int cnt = 0;
        int start = 0, end = input.length - 1;
        while(start < end) {
            if(input[start] == input[end]) {
                start++;
                end--;
            }
            else {
                cnt++;
                if(cnt > 1) break;
                start++;
            }
        }

        return cnt;
    }
}
