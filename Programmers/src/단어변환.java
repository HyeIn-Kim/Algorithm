import java.util.*;
public class 단어변환 {
    static class Node {
        String word;
        int cnt;

        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static boolean[] visited;

    public static int solution(String begin, String target, String[] words) {
        if(!findTargetWord(target, words)) return 0;

        visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.word.equals(target)) return node.cnt;

            for(int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                if(!isNextWord(node.word, words[i])) continue;

                visited[i] = true;
                queue.offer(new Node(words[i], node.cnt + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static boolean findTargetWord(String target, String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) return true;
        }

        return false;
    }

    private static boolean isNextWord(String curr, String next) {
        int cnt = 0;
        for(int i = 0; i < next.length(); i++) {
            if(curr.charAt(i) != next.charAt(i)) cnt++;
        }

        if(cnt == 1) return true;
        else return false;
    }
}