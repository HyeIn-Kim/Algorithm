// 완탐이라길래 당연히 for문이나 재귀로 푸는 건줄 알았는데
// 도저히 못하겠어서 수학적인 풀이를 봄. (이쪽이 더 빠르기도 하고)
class Solution {
    public int solution(String word) {
        String dict = "AEIOU";
        // 점화식 f(n) = f(n-1) * 5 ^ n
        // 글자 하나가 변할 때 넘어가는 번호 수
        int[] rate = {781, 156, 31, 6, 1};

        // A가 1이 아니라 index 0부터 시작해서 길이만큼 초기값을 해줘야 함.
        int answer = word.length();
        for(int i = 0; i < word.length(); i++) {
            answer += rate[i] * dict.indexOf(word.charAt(i));
        }
        
        return answer;
    }
}