import sys
from collections import deque

input = sys.stdin.readline
n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for i in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)


def bfs(end):
  global distance
  q = deque()
  q.append(x)
  distance[x] = 0
  while q:
    now = q.popleft()
    for i in graph[now]:
      if distance[i] == -1:
        distance[i] = distance[now] + 1 # 거리 누적
        q.append(i)
  return distance[end]


distance = [-1 for _ in range(n + 1)]
check = False

for i in range(len(distance)):
  distance[i] = bfs(i)
  if distance[i] == k:
    print(i)
    check = True

if check == False:
  print(-1)