class Solution {
    public int[] solution(long n) {
        // 숫자를 문자열로 변환
        String str = Long.toString(n);

        // 문자열 뒤집기
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();

        // 뒤집은 문자열을 하나씩 배열에 저장
        char[] arr = reversed.toCharArray();

        // 배열 요소를 문자열에서 정수로 변환
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] - '0'; // 아스키 코드 활용
        }
        return answer;
    }
}