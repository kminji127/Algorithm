n = int(input())

result = 0

# 분해합은 n보다 항상 크다
# 1부터 n-1까지의 분해합 중에 n이 되는 최솟값 찾기
for i in range(1, n):
  d_sum = i + sum(map(int, str(i)))
  if d_sum == n:
    result = i
    break

print(result)