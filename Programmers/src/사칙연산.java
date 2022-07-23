public class 사칙연산 {
    // 1 + 2 - 3 - 4 라는 식이 있다고 가정해보자!
    // 최대값을 찾으려면
    // 1. 1 + [2 - 3 - 4]
    // 2. [1 + 2] - [3 - 4]
    // 3. [1 + 2 - 3] - 4     []는 범위의 최대값
    // 의 3가지 식을 모두 돌아봐야 한다. 피연산자 개수 - 1개의 식 확인 필요.

    // DP[i][j] = i번째 피연산자부터 j번쨰 피연산자까지의 최대/최소값
    // 뺄셈 때문에 maxDP, minDP가 필요한데, 뺄셈의 최대값은 max - min이고 최소값은 min - max이기 때문에 min도 저장해주어야 한다.
    public static int solution(String arr[]) {
        int operandCnt = (arr.length / 2) + 1;
        int[][] maxDP = new int[operandCnt][operandCnt];
        int[][] minDP = new int[operandCnt][operandCnt];

        // 1. DP 배열 초기화
        for(int i = 0; i < operandCnt; i++) {
            for(int j = 0; j < operandCnt; j++) {
                if(i == j) {
                    maxDP[i][j] = Integer.parseInt(arr[i * 2]);
                    minDP[i][j] = Integer.parseInt(arr[i * 2]);
                }
                else {
                    maxDP[i][j] = Integer.MIN_VALUE;
                    minDP[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 2. DP 계산
        // 12 23 34
        // 123 234 순서대로 계산됨
        for(int cnt = 1; cnt < operandCnt; cnt++) {
            for(int start = 0; start < operandCnt - cnt; start++) {
                int end = start + cnt;
                for(int i = start; i < end; i++) {
                    if(arr[i * 2 + 1].equals("+")) {
                        maxDP[start][end] = Math.max(maxDP[start][end], maxDP[start][i] + maxDP[i + 1][end]);
                        minDP[start][end] = Math.min(minDP[start][end], minDP[start][i] + minDP[i + 1][end]);
                    }
                    else {
                        maxDP[start][end] = Math.max(maxDP[start][end], maxDP[start][i] - minDP[i + 1][end]);
                        minDP[start][end] = Math.min(minDP[start][end], minDP[start][i] - maxDP[i + 1][end]);
                    }
                }
            }
        }

        // maxDP[i][j]가 i부터 j번째 피연산자까지의 최대값이므로 maxDP[0][cnt-1]에 정답이 들어있다.
        return maxDP[0][operandCnt-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
    }
}