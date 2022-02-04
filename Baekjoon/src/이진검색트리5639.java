import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 전위순회 후위순회는 할줄 아는데 트리를 못만들어서 힘들었던 문제
public class 이진검색트리5639 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        // 재귀로 끝까지 타고 들어가서 트리를 만들어주자!
        public void insert(int value) {
            if(value < this.value) {
                if(this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            }
            else {
                if(this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }
        }
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        sb = new StringBuilder();
        postorder(root);
        System.out.println(sb);
    }

    // 후위순회 함수
    private static void postorder(Node node) {
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.value).append("\n");
    }
}
