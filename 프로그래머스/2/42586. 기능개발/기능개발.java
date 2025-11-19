import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // [93, 30, 55]	-> [1, 30, 5]
        Queue<Integer> expirations = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int todo = 100 - progresses[i];
            int speed = speeds[i];
            int expiration = (int) Math.ceil((double) todo / speed);
            expirations.add(expiration);
        }
        
        // [1, 30, 5] -> [2, 1]
        List<Integer> result = new ArrayList<>();
        int e = expirations.poll(); // 작업 하나 꺼내기
        int count = 1; // 동시에 배포되는 작업 수
        
        // 큐에 검사할 작업이 없을 때까지 반복 확인
        while (!expirations.isEmpty()) {
            int n = expirations.poll(); // 다음 작업 꺼내기
            if (e >= n) { // 이전 작업이 더 늦게 끝난다면
                count++; // 해당 작업은 이전 작업과 함께 배포하므로 카운트
                continue;
            }
            // 다음 작업이 더 늦게 끝난다면
            result.add(count); // 지금까지 모아둔 작업 배포하게 되므로 result에 추가
            count = 1; // 카운트 초기화
            e = n; // 
        }
        
        // 마지막에 검사한 작업도 result에 추가
        result.add(count);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}