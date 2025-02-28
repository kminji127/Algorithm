class Solution {
    // 방향 변수 선언 (상 -> 좌 -> 우 -> 하 순서)
    // 반대 방향을 구하기 위해 상하, 좌우의 인덱스 합이 3이 되도록 함
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    // 1-B. 인접한 곳에 다른 응시자가 있는지 검사
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            // (x, y)가 있는 방향은 제외
            if (d == exclude) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // 응시자가 있으면 true
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }

    // 1. 대기실의 (x, y) 위치에 있는 응시자의 거리두기 준수 여부
    private boolean isDistanced(char[][] room, int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // 1-A. 해당 위치의 상하좌우 탐색 (맨해튼 거리 1)
            switch (room[ny][nx]) {
                // 맨해튼 거리 1에 응시자가 있으면 거리두기 지키지 않은 것
                case 'P': return false;
                // 1-B. 빈 테이블일 경우, 인접한 곳에 다른 응시자가 있는지 검사 (맨해튼 거리 2)
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;
            }
        }
        return true;
    }

    // 대기실의 거리두기 준수 여부
    private boolean isDistanced(String[] place) {
        char[][] room = new char[place.length][];
        for (int i = 0; i < room.length; i++) {
            room[i] = place[i].toCharArray();
        }

        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                // 응시자가 있는 위치만 거리두기 검사
                if (room[y][x] != 'P') continue;
                // 1. 대기실의 모든 응시자 위치에 대해 거리두기 검사
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        // 각 대기실마다
        for (int i = 0; i < places.length; i++) {
            // 거리두기 준수 여부 검사
            if (isDistanced(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}