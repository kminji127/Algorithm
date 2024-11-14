// https://school.programmers.co.kr/learn/courses/30/lessons/87377

import java.util.*;

class Solution {
    // 좌표 클래스
    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 1-A. 교점 좌표 계산
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double) (a2*c1 - a1*c2) / (a1*b2 - a2*b1);

        // 좌표값이 정수가 아니면 반환하지 않음
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    // 2. 저장된 정수들에 대해 x, y 좌표의 최댓값 구하기
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x,y);
    }

    // 2. 저장된 정수들에 대해 x, y 좌표의 최솟값 구하기
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 1. 모든 직선 쌍에 대해 반복
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                // 1-A. 교점 좌표 계산
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);
                // 1-B. 정수 좌표만 계산
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        // 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
        Point maximumPoint = getMaximumPoint(points);
        Point minimumPoint = getMinimumPoint(points);

        // 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열 크기 결정
        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        // 좌표 특성 상 높이=행 크기, 너비=열 크기임에 유의
        char[][] arr = new char[height][width];

        // 모든 배열에 초기값 '.'으로 채우기
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        // 4. 2차원 배열에 별 표시
        for (Point p : points) {
            int x = (int) (p.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - p.y);
            arr[y][x] = '*';

        }

        // 5. 문자열 배열로 변환 후 반환
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
}