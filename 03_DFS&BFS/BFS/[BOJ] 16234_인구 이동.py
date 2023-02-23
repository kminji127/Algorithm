from collections import deque

n, l, r = map(int, input().split())
area = []

for _ in range(n):
  population = list(map(int, input().split()))
  area.append(population)

# 동, 남, 서, 북에 따른 이동 방향
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(x, y):
  q = deque()
  q.append((x, y))
  visited[x][y] = True
  union = [(x, y)] # 연합국 리스트
  count = area[x][y] # 연합국 인구 수

  # 큐가 빌 때까지 반복
  while q:
    x, y = q.popleft()
    # 나의 주변 위치 확인
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      # 공간을 벗어난 경우 무시
      if (nx < 0 or ny < 0 or nx >= n or ny >= n):
        continue
      if visited[nx][ny]:
        continue
      # 인구 차이가 l명 이상 r명 이하인 경우 연합국에 포함
      if l <= abs(area[nx][ny] - area[x][y]) <= r:
        visited[nx][ny] = True
        q.append((nx, ny))
        union.append((nx, ny))
        count += area[nx][ny]
    # (연합국 총 인구 수) / (연합국 수)로 인구 이동
  for i, j in union:
    area[i][j] = count // len(union)

  return len(union)


day = 0 # 인구 이동 발생한 날짜
while True:
  visited = [[False] * n for _ in range(n)]
  flag = False # 인구 이동 존재 유무
  for i in range(n):
    for j in range(n):
      if not visited[i][j]:
        if bfs(i, j) > 1:
          flag = True
  if not flag:
    break
  day += 1

print(day)