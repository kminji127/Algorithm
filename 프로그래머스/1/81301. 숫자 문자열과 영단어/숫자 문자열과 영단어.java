class Solution {
    // 영단어 문자열 배열 구성 (인덱스 = 영단어 숫자 값)
    private static final String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        // 영단어 배열을 순회하며 입력 문자열에 나오는 모든 영단어를 숫자로 치환
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }
        // 정수로 변환
        return Integer.parseInt(s);
    }
}