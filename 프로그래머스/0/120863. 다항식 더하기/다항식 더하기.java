class Solution {
    public String solution(String polynomial) {
        String answer = "";
        // 공백 기준 분할
        String[] arr = polynomial.split(" ");
        int variable = 0;
        int constant = 0;
        
        for (String a : arr) {
            // + 기호 제외
            if (!a.equals("+")) {
                // 변수항
                if (a.charAt(a.length() - 1) == 'x') {
                    // x 앞의 숫자만 추출
                    String num = a.replace("x", "");
                    if (num.isEmpty()) {
                        // x 앞에 숫자가 없으면 1로 계산
                        variable += 1;
                    } else {
                        variable += Integer.parseInt(a.replace("x", ""));
                    }
                } else {
                    // 상수항
                    constant += Integer.parseInt(a);
                }
            }
        }
        
        // 계수에 따른 변수항 삽입 (0보다 클 때만)
        if (variable > 1) {
            answer += String.valueOf(variable) + "x";
        } else if (variable > 0) {
            answer += "x";
        }
        
        // 상수항 삽입 (0보다 클 때만)
        if (constant > 0) {
            // 변수항이 있으면 먼저 + 추가
            if (!answer.isEmpty()) {
                answer += " + ";
            }
            answer += String.valueOf(constant);
        }
        
        return answer;
    }
}