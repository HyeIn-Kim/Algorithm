import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// union find 문제인데 값이 String이어서 살짝 고민했던 문제
// map을 써서 해결했는데, 각 String을 index에 매칭시켜놓고 int[]로 푸는 방법도 있었다!!
public class 친구네트워크4195 {
    static int F;
    static HashMap<String, String> parents;
    static HashMap<String, Integer> cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            parents = new HashMap<>();
            cnt = new HashMap<>();
            F = Integer.parseInt(br.readLine());

            for(int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String A = st.nextToken();
                String B = st.nextToken();

                sb.append(union(A, B)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static String find(String str) {
        String parent = parents.getOrDefault(str, str);
        if(parent.equals(str)) {
            parents.put(str, parent);
            return str;
        }

        String grandparent = find(parent);
        parents.put(str, grandparent);
        return grandparent;
    }

    private static int union(String A, String B) {
        String pa = find(A);
        String pb = find(B);

        if(pa.compareTo(pb) < 0) {
            parents.put(pb, pa);
            cnt.put(pa, cnt.getOrDefault(pa, 1) + cnt.getOrDefault(pb, 1));
            cnt.remove(pb);
            return cnt.get(pa);
        }
        else if(pa.compareTo(pb) > 0){
            parents.put(pa, pb);
            cnt.put(pb, cnt.getOrDefault(pb, 1) + cnt.getOrDefault(pa, 1));
            cnt.remove(pa);
            return cnt.get(pb);
        }
        else return cnt.get(pa);
    }
}
