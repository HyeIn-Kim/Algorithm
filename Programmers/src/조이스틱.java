class 조이스틱 {
    public int solution(String name) {
        int length = name.length();
        // move: 최소 이동 횟수. 처음에는 ->방향으로 쭉 간다고 가정해서 길이 - 1 만큼 이동한다.
        int move = length - 1;
        // 총 상, 하 조작 횟수
        int answer = 0;

        for(int i = 0; i < length; i++) {
            // 상, 하 움직임 계산
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 다음 이동 칸. 현재위치 + 1부터 시작
            // 연속되는 A 수만큼 센다.
            int index = i + 1;
            while(index < length && name.charAt(index) == 'A') index++;

            // 여기 공식이 진짜 이해가 안됐었는데 그림으로 하면 다음과 같다.
            // B B A A B
            // <--    <-
            // -->
            // i만큼 2번, length - index만큼 1번

            // <- 방향으로 진행했을 때
            move = Math.min(move, i * 2 + (length - index));
            // <- 였다가 -> 로 돌아와서 진행했을 때
            // B B A A B
            //         <-
            // -->     ->
            // length - index만큼 2번, i만큼 1번
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }
}