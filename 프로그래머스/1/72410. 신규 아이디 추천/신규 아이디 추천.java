class Solution {
    public String solution(String new_id) {
        // 1단계: 모두 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, -, _, .만 남기고 모두 제거
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

        // 3단계: 연속된 마침표는 1개로 치환
        new_id = new_id.replaceAll("\\.+", ".");

        // 4단계: 처음 또는 끝에 위치한 마침표 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열인 경우 a 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6단계: 16자 이상인 경우 앞의 15자만 남기기
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            // 끝에 위치한 마침표 제거
            new_id = new_id.replaceAll("\\.$", "");
        }

        // 7단계: 2자 이하인 경우 마지막 문자를 길이가 3이 될 때까지 반복해서 붙이기
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}