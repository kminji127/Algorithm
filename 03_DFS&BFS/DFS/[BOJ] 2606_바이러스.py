node = int(input())
edge = int(input())
graph = [[] for _ in range(node + 1)]

for i in range(edge):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

def dfs(start):
  global count
  visited[start] = True
  for next_node in graph[start]:
    if not visited[next_node]:
      dfs(next_node)
      count += 1
  return count


count = 0
visited = [False] * (node + 1)
print(dfs(1))