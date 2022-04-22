import java.util.*;

// IDE 안 쓰니까 너무 어렵다...!!
// Value 값이 따로 필요 없어서 HashSet을 사용했는데,
// HashMap이 HashSet보다 더 빠르다고 한다.
class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String phone : phone_book) set.add(phone);
        
        boolean answer = true;
        for(String s : set) {
        	// 만약 123이 접두사인지 찾으려면
        	// 1, 12, 123이라는 모든 글자가 포함되어 있는지 찾고
        	// 포함되어 있다면 false를 리턴한다.
            for(int i = 1; i < s.length(); i++) {
                if(set.contains(s.substring(0, i))) return false;
            }
        }
        
        return answer;
    }
}