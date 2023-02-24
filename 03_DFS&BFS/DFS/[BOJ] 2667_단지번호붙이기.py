n = int(input())

area = [] # n*n 정사각형 모양의 지도
for i in range(n):
  data = list(map(int, input()))
  area.append(data)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
  global house
  # 주어진 범위를 벗어나면 종료
  if (x < 0 or y < 0 or x >= n or y >= n):
    return False
  # 현재 노드를 방문하지 않았다면
  if area[x][y] == 1:
    area[x][y] = 0 # 방문 처리
    house += 1 # 집 수 체크
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      dfs(nx, ny)
    return True # 한 묶음을 True 처리
  return False


house = 0
count = []

for i in range(n):
  for j in range(n):
    if dfs(i, j) == True: # 한 묶음이 생성되면
      count.append(house) # 집 수를 배열에 저장
      house = 0           # 다시 집 수를 초기화

print(len(count))
count.sort()
for i in count:
  print(i)