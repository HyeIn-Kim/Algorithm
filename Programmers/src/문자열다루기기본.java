class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if(s.length() != 4 && s.length() != 6) answer = false;
        else {
            for(int i = 0; i < s.length(); i++) {
                if('0' <= s.charAt(i) && s.charAt(i) <= '9') continue;

                answer = false;
                break;
            }
        }
        return answer;
    }
}