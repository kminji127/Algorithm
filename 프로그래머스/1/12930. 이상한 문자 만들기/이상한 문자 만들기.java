class Solution {
    public String solution(String s) {
        StringBuilder st = new StringBuilder();
        boolean toUpper = true; // 대문자인지 여부

        for (char c : s.toCharArray()) {
            // 공백 문자일 경우 그대로 이어붙이기
            if (Character.isSpaceChar(c)) {
                st.append(c);
                // 공백 문자 다음은 대문자부터 시작
                toUpper = true;
            } else {
                // 0과 짝수 인덱스는 대문자, 홀수 인덱스는 소문자로 변환
                if (toUpper) {
                    st.append(Character.toUpperCase(c));
                } else {
                    st.append(Character.toLowerCase(c));
                }
                // 대문자와 소문자를 반복하며 변환
                toUpper = !toUpper;
            }
        }

        return st.toString();
    }
}