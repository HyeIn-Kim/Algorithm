import java.util.*;
class 단속카메라 {
    public int solution(int[][] routes) {
        // o1, o2는 routes의 요소 하나인 int[] 형태로 들어온다.
        // 진출 시점을 기준으로 정렬한다.
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int camera = -30001;
        int answer = 0;
        for(int[] route : routes) {
            // 현재 카메라 위치가 진입 시점보다 뒤에 있으면 이 카메라로 해당 차량을 확인할 수 없다.
            // 카메라를 진출 시점에 1개 설치한다!
            if(camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }
}