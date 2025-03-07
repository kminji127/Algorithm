class Solution {
    // 0 개수 세기
    private int countZeros(String s) {
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }

    public int[] solution(String s) {
        int binaryCount = 0; // 이진 변환 횟수
        int deletedCount = 0; // 제거한 0의 개수

        // 1이 될 때까지 반복
        while (!s.equals("1")) {
            // 문자열에서 0의 개수를 갖아서 deletedCount 업데이트
            int zeros = countZeros(s);
            deletedCount += zeros;
            // 이진 변환 횟수에 1 추가
            binaryCount++;
            // 문자열에서 0 제거 후 길이 저장 (= 1의 개수)
            int ones = s.length() - zeros;
            // 길이에 해당하는 숫자를 2진법으로 변환
            s = Integer.toString(ones, 2);
        }

        return new int[] {binaryCount, deletedCount};
    }
}