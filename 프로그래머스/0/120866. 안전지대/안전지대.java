class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        // board 순회하며 안전 지역이면 카운트
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                answer += checkDanger(board, i, j);
            }
        }
        
        return answer;
    }
    
    // 안전 지역이면 1, 위험 지역이면 0 리턴
    public int checkDanger(int[][] board, int x, int y) {
        // 해당 지역과 인접 좌표들 위치 변화량
        int[][] arounds = {{0, 0}, 
                          {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                          {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        // 인접 좌표에 지뢰가 있으면 위험 지역
        for (int[] around : arounds) {
            int nx = x + around[0];
            int ny = y + around[1];
            // board의 범위를 벗어나지 않아야 함
            if (0 <= nx && nx < board.length &&
               0 <= ny && ny < board[nx].length &&
               board[nx][ny] == 1) {
                return 0;
            }
        }
        
        // 인접 좌표에 지뢰가 있으면 안전 지역
        return 1;
    }
}