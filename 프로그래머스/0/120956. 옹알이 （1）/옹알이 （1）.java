class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble : babbling) {
            if (isSpeakable(babble)) answer++;
        }
        return answer;
    }
    
    private boolean isSpeakable(String babble) {
        String ba = "";
        String[] babbleArr = babble.split("");
        // 단어를 순회하며 리스트에 속하는지 확인
        for (String b : babbleArr) {
            ba += b;
            // 리스트에 속하면 초기화
            if (ba.equals("aya") || ba.equals("ye") || ba.equals("woo") || ba.equals("ma")) {
                ba = "";
            }
        }
        
        // ba에 남은 문자가 없으면 모두 발음 가능, 아니면 불가
        return ba.isEmpty();
    }
}