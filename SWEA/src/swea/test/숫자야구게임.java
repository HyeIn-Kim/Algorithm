package swea.test;

import java.util.Arrays;
import java.util.HashSet;

public class 숫자야구게임 {
    public final static int N = 4;

    Solution.Result prevRes;
    int[] prev;

    boolean[] selected;
    boolean[] notAnswer;
    int[] strikes;

    boolean isFirst;
    boolean isAnswer;

    HashSet<String> queries;

    public void doUserImplementation(int guess[]) {
        selected = new boolean[10];
        notAnswer = new boolean[10];
        strikes = new int[4];
        for(int i = 0; i < 4; i++) {
            strikes[i] = -1;
        }

        prevRes = null;
        prev = new int[4];

        isFirst = true;
        isAnswer = false;
        queries = new HashSet<>();
        permutation(0, new int[4], guess);
    }

    private void saveResult(Solution.Result res, int[] guess) {
        prevRes = res;
        for(int i = 0; i < 4; i++) {
            prev[i] = guess[i];
        }
    }

    private void permutation(int cnt, int guess[], int[] answer) {
        if(isAnswer) return;
        if(cnt == 4) {
            if(queries.contains(Arrays.toString(guess))) return;

            Solution.Result res = Solution.query(guess);
            queries.add(Arrays.toString(guess));
//            System.out.println(Arrays.toString(notAnswer));
//            System.out.println(Arrays.toString(strikes));
//            System.out.println(Arrays.toString(guess) + " " + res.strike + " " + res.ball);
//            System.out.println(res.strike + " " + res.ball);

            // 정답을 찾았을 경우 종료
            if(res.strike == 4) {
                for(int i = 0; i < 4; i++) {
                    answer[i] = guess[i];
                }
                isAnswer = true;
                return;
            }

            // 스트라이크, 볼이 없는 경우: 정답이 아니므로 제외한다.
            if(res.strike == 0 && res.ball == 0) {
                for(int i = 0; i < 4; i++) {
                    notAnswer[guess[i]] = true;
                }
            }

            if(isFirst) {
                isFirst = false;
                // 현재 숫자와 결과를 저장
                saveResult(res, guess);
                return;
            }

            // 스트라이크 증가: 현재 숫자 스트라이크 기록
            if(prevRes.strike < res.strike) {
                int strikeCnt = 0;
                int idx = 0;
                for(int i = 0; i < 4; i++) {
                    if(prev[i] != guess[i]) {
                        strikeCnt++;
                        idx = i;
                    }
                }

                if(strikeCnt == 1) {
                    strikes[idx] = guess[idx];
                }
                else return;

                // 볼 개수가 같은 경우, 이전 숫자는 정답이 아님
                if(prevRes.ball == res.ball) {
                    for(int i = 0; i < 4; i++) {
                        if(prev[i] != guess[i]) {
                            notAnswer[prev[i]] = true;
                            break;
                        }
                    }
                }

                // 볼 개수가 줄어든 경우, 이전 숫자는 볼
            }

            // 스트라이크 증가: 이전 숫자 스트라이크 기록
            if(prevRes.strike > res.strike) {
                int strikeCnt = 0;
                int idx = 0;
                for(int i = 0; i < 4; i++) {
                    if(prev[i] != guess[i]) {
                        strikeCnt++;
                        idx = i;
                    }
                }

                if(strikeCnt == 1) {
                    strikes[idx] = prev[idx];
                }
                else return;

                // 볼 개수가 같은 경우, 이전 숫자는 정답이 아님
                if(prevRes.ball == res.ball) {
                    for(int i = 0; i < 4; i++) {
                        if(prev[i] != guess[i]) {
                            notAnswer[prev[i]] = true;
                            break;
                        }
                    }
                }

                // 볼 개수가 늘어난 경우, 현재 숫자는 볼
            }

            // 현재 숫자와 결과를 저장
            saveResult(res, guess);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(selected[i]) continue;
            if(notAnswer[i]) continue;

            if(strikes[cnt] > -1) {
                selected[strikes[cnt]] = true;
                guess[cnt] = strikes[cnt];
                permutation(cnt + 1, guess, answer);
            }
            else {
                selected[i] = true;
                guess[cnt] = i;
                permutation(cnt + 1, guess, answer);
                selected[i] = false;
            }
        }

        permutation(cnt + 1, guess, answer);
    }
}