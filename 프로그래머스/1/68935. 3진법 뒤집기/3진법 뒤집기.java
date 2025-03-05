class Solution {
    public int solution(int n) {
        // 3진법으로 변환
        String str = Integer.toString(n, 3);
        // 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        // 10진법으로 변환
        return Integer.valueOf(reversed, 3);
    }
}