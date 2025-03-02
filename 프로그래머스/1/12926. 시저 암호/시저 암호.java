class Solution {
    // 문자 c를 n만큼 밀기
    private char push(char c, int n) {
        // 알파벳이 아닌 경우 그대로 반환
        if (!Character.isAlphabetic(c)) return c;

        // 알파벳의 순서를 저장
        // 첫 번째 알파벳인 A와 a의 순서를 기준으로 0 ~ 26까지임
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;

        // n만큼 밀었을 때의 알파벳의 순서를 저장
        // Z의 position = 25 -> Z+1=26 -> 26%26=0 -> A의 position
        position = (position + n) % ('Z' - 'A' + 1);

        // n만큼 밀었을 때의 문자 반환
        return (char) (offset + position);
    }
    
    public String solution(String s, int n) {
        StringBuilder st = new StringBuilder();
        // 문자열의 모든 문자에 대해
        for (char c : s.toCharArray()) {
            // n만큼 밀기
            st.append(push(c, n));
        }
        return st.toString();
    }
}