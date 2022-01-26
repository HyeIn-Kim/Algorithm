import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 구현보다 맵 입력이 더 오래걸렸던 문제
// 키 맵핑을 편하게 하려고 map 자료구조를 사용했고,
// 키의 위치, 왼손/오른손 여부를 클래스로 저장하였다.
public class ZOAC3_20436 {
    static class Key {
        int r;
        int c;
        boolean isRight;

        public Key(int r, int c, boolean isRight) {
            this.r = r;
            this.c = c;
            this.isRight = isRight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Character, Key> map = new HashMap<>();
        map.put('q', new Key(0, 0, false));
        map.put('w', new Key(0, 1, false));
        map.put('e', new Key(0, 2, false));
        map.put('r', new Key(0, 3, false));
        map.put('t', new Key(0, 4, false));
        map.put('y', new Key(0, 5, true));
        map.put('u', new Key(0, 6, true));
        map.put('i', new Key(0, 7, true));
        map.put('o', new Key(0, 8, true));
        map.put('p', new Key(0, 9, true));
        map.put('a', new Key(1, 0, false));
        map.put('s', new Key(1, 1, false));
        map.put('d', new Key(1, 2, false));
        map.put('f', new Key(1, 3, false));
        map.put('g', new Key(1, 4, false));
        map.put('h', new Key(1, 5, true));
        map.put('j', new Key(1, 6, true));
        map.put('k', new Key(1, 7, true));
        map.put('l', new Key(1, 8, true));
        map.put('z', new Key(2, 0, false));
        map.put('x', new Key(2, 1, false));
        map.put('c', new Key(2, 2, false));
        map.put('v', new Key(2, 3, false));
        map.put('b', new Key(2, 4, true));
        map.put('n', new Key(2, 5, true));
        map.put('m', new Key(2, 6, true));

        char left = st.nextToken().charAt(0);
        char right = st.nextToken().charAt(0);
        char[] input = br.readLine().toCharArray();
        int times = 0;
        for(int i = 0; i < input.length; i++) {
            Key next = map.get(input[i]);
            Key curr = next.isRight ? map.get(right) : map.get(left);
            int time = Math.abs(curr.r - next.r) + Math.abs(curr.c - next.c) + 1;
            times += time;

            if(next.isRight) right = input[i];
            else left = input[i];
        }

        System.out.println(times);
    }
}
