import java.util.*;
class 소수찾기level2 {
    boolean[] visited;
    int[] selected;
    StringBuilder sb;
    HashSet<Integer> set;
    int answer;

    public int solution(String numbers) {
        answer = 0;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        selected = new int[numbers.length()];
        permutation(0, numbers.toCharArray());
        return answer;
    }

    private boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }

        return true;
    }

    private void permutation(int cnt, char[] numbers) {
        if(cnt > 0) {
            sb = new StringBuilder();
            for(int i = 0; i < cnt; i++) {
                sb.append(selected[i]);
            }

            int n = Integer.parseInt(sb.toString());
            if(!set.contains(n) && isPrime(n)) {
                set.add(n);
                answer++;
            }
        }

        if(cnt == numbers.length) return;

        for(int i = 0; i < numbers.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[cnt] = numbers[i] - '0';
            permutation(cnt + 1, numbers);
            visited[i] = false;
        }
    }
}