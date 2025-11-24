class Solution {
    // 방향 인덱스 (하 -> 우 -> 좌상)
    private static final int[] dr = {1, 0, -1};
    private static final int[] dc = {0, 1, -1};

    public int[] solution(int n) {
        // 배열은 n행
        int[][] arr = new int[n][n];

        // 현재 위치
        int r = 0;
        int c = 0;

        // 방향 인덱스 (하 -> 우 -> 좌상 순서)
        int d = 0;

        // 넣을 숫자
        int entry = 1;

        while (true) {
            arr[r][c] = entry++;

            // 다음 방향
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 바깥이거나 이미 채워졌다면
            if (nr >= n || nr < 0 || nc >= n || nc < 0 || arr[nr][nc] != 0) {
                // 방향 전환
                d = (d + 1) % 3;
                nr = r + dr[d];
                nc = c + dc[d];
                
                // 그래도 안되면 종료
                if (nr >= n || nr < 0 || nc >= n || nc < 0 || arr[nr][nc] != 0) {
                    break;
                }
            }

            // 다음 좌표
            r = nr;
            c = nc;
        }

        int[] answer = new int[entry - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }
}