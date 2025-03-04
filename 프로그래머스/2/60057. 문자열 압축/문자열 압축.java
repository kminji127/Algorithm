import java.util.*;

class Solution {
    // 문자열을 length만큼 잘라서 리스트에 담음
    private List<String> split(String s, int length) {
        List<String> tokens = new ArrayList<>();
        // 0부터 length씩 증가하며
        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            // endIndex가 문자열 범위 밖이라면 문자열 끝까지로 조정
            if (endIndex > s.length()) endIndex = s.length();
            // 문자열을 startIndex에서 잘라 tokens 리스트에 추가
            tokens.add(s.substring(startIndex, endIndex));
        }
        return tokens;
    }

    // 문자열을 압축한 후의 길이
    private int compress(String s, int length) {
        StringBuilder st = new StringBuilder();
        String last = ""; // 직전에 등장한 문자열
        int count = 0; // last의 등장 횟수

        // 압축 문자열 구성
        for (String token : split(s, length)) {
            // 직전에 등장한 문자열과 같다면 등장 횟수만 증가
            if (token.equals(last)) {
                count++;
            } else {
                // 직전까지 등장한 문자열로 압축 문자열 구성
                if (count > 1) st.append(count);
                st.append(last);
                // 현재 등장한 토큰부터 다시 셀 수 있도록 last, count 업데이트
                last = token;
                count = 1;
            }
        }
        // 마지막 토큰은 last에 담긴 채 압축 문자열에 포함되지 않았으므로 이에 대한 작업 실행
        if (count > 1) st.append(count);
        st.append(last);

        // 압축 문자열 길이 반환
        return st.length();
    }


    public int solution(String s) {
        // 1. 1부터 입력한 문자열의 길이만큼 자를 문자열의 길이 설정
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressedLength = compress(s, length);
            if (compressedLength < min) {
                min = compressedLength;
            }
        }
        return min;
    }
}