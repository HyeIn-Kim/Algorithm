import java.util.HashMap;

// 그동안 문제를 많이 풀었다고 생각했는데
// IDE 안 쓰니까 처음부터 다시 준비하는 기분이다.
// 이 문제는 분명 조합 규칙이 있을 거라고 생각했는데 안 보여서 20분 정도 고민했다.
// 각 종류마다 안 입는 경우를 추가해서 경우의 수를 구하면 되는 거였다.
// 모자 2 x 눈장식 1이라면, 안 입는 경우를 더해서 3 x 2를 하고 -1을 해 주면 답을 구할 수 있다.
// -1을 하는 이유: 모자도 안쓰고 x 눈장식도 안하는 경우를 제외하기 위함 (문제에서 적어도 1개는 입어야 된다고 했으므로)
// 각 종류마다 hashmap에 모아서 계산했고, 처음에는 <String, ArrayList> 형으로 저장할 뻔 했는데
// 잘 생각해보니 옷 이름은 필요 없고 개수만 필요한거라 <String 옷 종류, Integer 옷 개수> 이렇게 만들었다.
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}