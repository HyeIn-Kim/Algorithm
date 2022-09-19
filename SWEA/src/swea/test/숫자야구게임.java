import java.util.ArrayList;

public class 숫자야구게임 {
    class Fail {
        int[] guess;
        int strike, ball;

        public Fail(int[] guess, int strike, int ball) {
            this.guess = guess;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public final static int N = 4;

    boolean[] selected;
    int[] guess;
    ArrayList<Fail> failDatas;

    boolean isAnswer;

    public void doUserImplementation(int answer[]) {
        selected = new boolean[10];
        guess = new int[4];
        failDatas = new ArrayList<>();

        isAnswer = false;
        permutation(0, answer);
    }

    private void permutation(int cnt, int[] answer) {
        if(isAnswer) return;
        if(cnt == 4) {
            if(check()) {
                Solution.Result res = Solution.query(guess);

                if(res.strike == 4) {
                    isAnswer = true;
                    for(int i = 0; i < 4; i++) {
                        answer[i] = guess[i];
                    }

                    return;
                }

                int[] resNum = new int[4];
                for(int i = 0; i < 4; i++) {
                    resNum[i] = guess[i];
                }

                failDatas.add(new Fail(resNum, res.strike, res.ball));
            }

            return;
        }

        for(int i = 0; i < 10; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            guess[cnt] = i;
            permutation(cnt + 1, answer);
            selected[i] = false;
        }
    }

    private boolean check() {
        for(Fail failData : failDatas) {
            int strike = 0, ball = 0;
            for(int i = 0; i < 4; i++) {
                if(guess[i] == failData.guess[i]) strike++;
                else if(selected[failData.guess[i]]) ball++;
            }

            if(strike != failData.strike || ball != failData.ball) return false;
        }

        return true;
    }
}