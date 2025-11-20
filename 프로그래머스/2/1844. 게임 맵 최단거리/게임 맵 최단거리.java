import java.util.*;

class Solution {
    
    // 현재 위치를 객체로 정의
    private class Location {
        final int x;
        final int y;
        final int step; // 지금까지 움직인 칸 수
        
        private Location(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    // x, y좌표 움직임 정의 (상하좌우)
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {        
        int h = maps.length;    // 높이 (y축)
        int w = maps[0].length; // 너비 (x축)
        
        // 방문 여부
        boolean[][] isVisited = new boolean[h][w];
        
        // 큐 생성 및 첫 탐색노드 삽입
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1));
        
        // 현재 노드를 방문 처리
        isVisited[0][0] = true;
        
        // 탐색 진행
        while (!queue.isEmpty()) {
            // 큐에서 맨 앞(제일 먼저 넣은) 원소 추출
            Location nodeIndex = queue.poll();
            // System.out.println(nodeIndex.x + " " + nodeIndex.y);

            // 현재 상태를 이용하는 로직 처리
            if (nodeIndex.y == h - 1 && nodeIndex.x == w - 1) { // 목표 위치에 도달했을 때
                // 지금까지 센 칸수 리턴
                return nodeIndex.step;
            }

            // 다음 탐색 대상 찾기 => 동서남북 위치 순회
            for (int d = 0; d < 4; d++) {
                int nx = nodeIndex.x + dx[d];
                int ny = nodeIndex.y + dy[d];
                
                // 범위 검사 => 맵을 벗어나지 않는지
                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

                // 유효성 검사 => 맵의 좌표가 길(1)인지
                if (maps[ny][nx] != 1) continue;

                // 중복 방문여부 검사
                if (isVisited[ny][nx]) continue;
                
                // 방문 처리
                isVisited[ny][nx] = true;

                // 인접 노드들을 탐색 공간(큐)에 추가
                queue.add(new Location(nx, ny, nodeIndex.step + 1));
            }
        }
            
        // 길이 없으면 -1 리턴
        return -1;
    }
}