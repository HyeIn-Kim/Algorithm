import java.util.*;
class N으로표현 {
    static HashSet<Integer>[] set;
    static boolean isFind;
    public static int solution(int N, int number) {
        set = new HashSet[9];
        isFind = false;

        for(int i = 0; i < 9; i++) {
            set[i] = new HashSet<Integer>();
        }

        set[1].add(N);

        if(N == number) return 1;

        // 처음에는 노트에다가 1, 2, 3, 4... 하면서 직접 경우를 계산해 봤었는데,
        // N이 계속 바뀌니까 답이 안 나왔다.
        // 풀이 보니까 숫자로 하는게 아니라 숫자 1개 ~ 8개까지로 각각 계산하는 거였다.
        // 아이디어 엄청나다고 생각했다!!
        for(int i = 2; i < 9; i++) {
            getNumbers(i, N, number);

            if(isFind) return i;
        }

        return -1;
    }

    private static void getNumbers(int idx, int N, int number) {
        for(int i = 1; i <= idx/2; i++) {
            addSet(idx, i, idx - i, number);
            addSet(idx, idx - i, i, number);

            if(isFind) return;
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < idx; j++) sb.append(N);
        set[idx].add(Integer.parseInt(sb.toString()));
        if(Integer.parseInt(sb.toString()) == number) isFind = true;
    }

    private static void addSet(int origin, int idxA, int idxB, int number) {
        for(Integer a : set[idxA]) {
            for(Integer b: set[idxB]) {
                if(a + b == number) {
                    isFind = true;
                    return;
                }
                set[origin].add(a + b);
                if(a - b == number) {
                    isFind = true;
                    return;
                }
                set[origin].add(a - b);
                if(a * b == number) {
                    isFind = true;
                    return;
                }
                set[origin].add(a * b);
                if(a != 0 && b != 0) {
                    if(a / b == number) {
                        isFind = true;
                        return;
                    }
                    set[origin].add(a / b);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
        System.out.println(solution(1, 1121));
    }
}