import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너무너무 쉬운 트리 순회문제
// 순회보다 입력받는게 더 어렵다.
public class 트리순회1991 {
    static class Node {
        int value;
        int left;
        int right;

        public Node(int value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static Node[] nodes;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            nodes[value - 'A'] = new Node(value - 'A', (left == '.') ? -1 : left - 'A', (right == '.') ? -1 : right - 'A');
        }

        preorder(0);
        sb.append("\n");
        visited = new boolean[N];
        inorder(0);
        sb.append("\n");
        visited = new boolean[N];
        postorder(0);
        System.out.println(sb);
    }

    private static void preorder(int n) {
        visited[n] = true;
        sb.append((char) ('A' + n));

        if(nodes[n].left != -1 && !visited[nodes[n].left]) preorder(nodes[n].left);
        if(nodes[n].right != -1 && !visited[nodes[n].right]) preorder(nodes[n].right);
    }

    private static void inorder(int n) {
        if(nodes[n].left != -1 && !visited[nodes[n].left]) inorder(nodes[n].left);

        visited[n] = true;
        sb.append((char) ('A' + n));

        if(nodes[n].right != -1 && !visited[nodes[n].right]) inorder(nodes[n].right);
    }

    private static void postorder(int n) {
        if(nodes[n].left != -1 && !visited[nodes[n].left]) postorder(nodes[n].left);
        if(nodes[n].right != -1 && !visited[nodes[n].right]) postorder(nodes[n].right);

        visited[n] = true;
        sb.append((char) ('A' + n));
    }
}
