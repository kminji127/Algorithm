class Solution {
    public String[] solution(String[] quiz) {
        int len = quiz.length;
        String[] answer = new String[len];
        
        for (int i = 0; i < len; i++) {
            // 공백 기준으로 나누기
            String[] q = quiz[i].split(" ");
        
            // 숫자, 연산자로 각각 치환하여 연산 시행
            int x = Integer.parseInt(q[0]);
            int y = Integer.parseInt(q[2]);
            String operator = q[1];
            int z = Integer.parseInt(q[4]);

            int result = calculate(x, y, operator);

            // Z와 결과값 비교
            if (z == result) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        return answer;
    }
    
    private int calculate(int x, int y, String operator) {
        if (operator.equals("+")) {
            return x + y;
        } else {
            return x - y;
        }
    }
}