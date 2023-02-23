from collections import deque

n, m, v = map(int, input().split()) # 노드, 간선, 시작노드

graph = [[] for _ in range(n + 1)]
for i in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

for i in graph:
  i.sort()

def dfs(start):
  # 현재 노드를 방문 처리
  visited[start] = True
  print(start, end=' ')
  # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
  for i in graph[start]:
    if not visited[i]:
      dfs(i)
  

def bfs(start):
  q = deque()
  # 현재 노드를 방문 처리
  q.append(start)
  visited[start] = True
  while q:
    v = q.popleft()
    print(v, end=' ')
    # 해당 노드와 인접하고 아직 방문하지 않은 원소들을 큐에 삽입, 방문 처리
    for i in graph[v]:
      if not visited[i]:
        q.append(i)
        visited[i] = True
    

# 각 노드가 방문된 정보
visited = [False] * (n + 1)
dfs(v)
print()

visited = [False] * (n + 1)
bfs(v)