class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 == 0) {
            int start = s.length() / 2 - 1;
            answer = s.substring(start, start + 2);
        }
        else {
            int start = s.length() / 2;
            answer = s.substring(start, start + 1);
        }
        return answer;
    }
}