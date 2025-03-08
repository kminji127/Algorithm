class Solution {
    boolean solution(String s) {
        // 풀이 1: 문자열에서 해당 문자 제거 후 남은 문자열 길이와의 차이 (시간 복잡도: O(n))
        // 대소문자 통일 (소문자로 변경)
        s = s.toLowerCase();
        // p의 개수 = 문자열에서 p 제거 후 남은 문자열 길이와의 차이
        int pcount = s.length() - s.replace("p", "").length();
        // y의 개수 = 문자열에서 y 제거 후 남은 문자열 길이와의 차이
        int ycount = s.length() - s.replace("y", "").length();

        /*
        // 풀이 2: 문자열 순회 (시간 복잡도: O(n), 효율적인 방법)
        int pcount = 0;
        int ycount = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'P', 'p' -> pcount++;
                case 'Y', 'y' -> ycount++;
            }
        }
        */

        // p와 y의 개수 비교
        return pcount == ycount;
    }
}