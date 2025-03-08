class Solution {
    public boolean solution(String s) {
        // 문자열의 길이가 4 또는 6이고, 숫자로만 구성되어 있는지

        /*
        // 방법 1: 내장 라이브러리 활용
        if (s.length() != 4 && s.length() != 6) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
        */

        // 방법 2: 정규 표현식
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}