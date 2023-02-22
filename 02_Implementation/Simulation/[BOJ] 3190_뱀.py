n = int(input()) # 보드의 크기
board = [[0] * (n + 1) for _ in range(n + 1)] # n*n 보드 0으로 초기화

k = int(input()) # 사과 개수
for i in range(k):
  x, y = map(int, input().split()) # 사과의 위치
  board[x][y] = 1 # 사과의 위치에 1 저장

l = int(input()) # 뱀의 방향 전환 정보
dir_info = [] # 방향 회전 정보
for i in range(l):
  x, c = input().split() # 방향 전환하는 시간
  dir_info.append((int(x), c))

# 동, 남, 서, 북에 따른 이동 방향
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, change):
  if change == "L":
    direction = (direction - 1) % 4
  else:
    direction = (direction + 1) % 4
  return direction

time = 0 # 소요된 시간
x, y = 1, 1 # 현재 위치
board[x][y] = 2 # 뱀이 위치한 곳은 2로 저장
c_dir = 0 # 현재 방향
index = 0 # 다음에 회전할 정보
q = [(x, y)] # 뱀이 차지하고 있는 위치 정보 (꼬리가 앞쪽)

while True:
  time += 1
  nx = x + dx[c_dir]
  ny = y + dy[c_dir]

  if (nx > n or ny > n or nx < 1 or ny < 1 or board[nx][ny] == 2):
    break

  if (board[nx][ny] == 0): # 사과가 없으면
    board[nx][ny] = 2 # 이동 후
    q.append((nx, ny)) # 위치 기록
    px, py = q.pop(0) # 꼬리 제거
    board[px][py] = 0 # 이전 위치 0으로 바꿈
  elif (board[nx][ny] == 1): # 사과가 있으면
    board[nx][ny] = 2 # 이동 후
    q.append((nx, ny)) # 위치 기록

  x, y = nx, ny
  if (index < l and time == dir_info[index][0]):
    c_dir = turn(c_dir, dir_info[index][1])
    index += 1

print(time)