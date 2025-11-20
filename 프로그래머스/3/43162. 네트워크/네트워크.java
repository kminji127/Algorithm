import java.util.*;

class Solution {
    private void dfs(int[][] graph, int firstIndex, boolean[] isVisited) {        
        // 스택 생성 및 첫 탐색노드 삽입
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(firstIndex);
        
        // 탐색 진행
        while (!stack.isEmpty()) {
            // 스택에서 맨 위에 있는 원소 추출
            int nodeIndex = stack.pop();
            
            // 중복 방문여부 검사하고 방문 처리
            if (isVisited[nodeIndex]) continue;
            isVisited[nodeIndex] = true;
            
            // 다음 탐색 대상 찾기
            for (int next = 0; next < graph[nodeIndex].length; next++) {
                // 유효성 검사
                // 연결되지 않은 노드는 다음 탐색 대상에서 제외
                if (graph[nodeIndex][next] == 0) continue;
                
                // 다음 탐색 노드를 탐색 공간(스택)에 저장
                stack.push(next);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int count = 0;
        
        // 노드 방문 여부
        boolean[] isVisited = new boolean[n];
                
        // 모든 노드를 방문할 때까지 DFS -> DFS 다 돌면 카운트 1 증가
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(computers, i, isVisited);
                count++;
            }
        }
        
        return count;
    }
}