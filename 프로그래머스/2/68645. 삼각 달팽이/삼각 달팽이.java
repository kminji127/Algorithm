class Solution {
    // 방향 변수 선언 (아래 → 오른쪽 → 왼쪽 위 순서)
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        // 1. 삼각형을 표현하기 위한 n*n 배열 선언 (초기값: 0)
        int[][] triangle = new int[n][n];
        int entry = 1; // 배열에 넣을 숫자 (1씩 늘어남)

        // 2. 숫자는 (0,0)부터 채우기 시작
        // 현재 위치 변수
        int x = 0;
        int y = 0;
        // 현재 방향 변수
        int d = 0;

        // 3. [아래 → 오른쪽 → 왼쪽 위] 방향의 순서대로 이동하며 숫자를 채우되, 이동할 수 없으면 방향을 전환
        while (true) {
            // 현재 위치에서 숫자 채우고 1 더함
            triangle[y][x] = entry++;

            // 현재 방향으로 위치 이동
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 현재 방향으로 이동할 수 없으면 (배열 바깥 or 이미 값이 채워짐)
            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                // 방향 전환 (0 -> 1 -> 2 -> 0 -> ...)
                d = (d + 1) % 3;
                // 전환한 방향으로 위치 이동
                nx = x + dx[d];
                ny = y + dy[d];
                // 전환한 방향으로도 이동할 수 없으면 무한 루프 종료
                if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }

            // 현재 위치 업데이트
            x = nx;
            y = ny;
        }

        // 4. 숫자가 다 채워지면 2차원 배열을 1차원 배열로 바꿔서 반환
        int[] answer = new int[entry - 1]; // 마지막에 +1되고 끝났으므로 마지막으로 채워넣은 숫자는 (entry - 1)임
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}