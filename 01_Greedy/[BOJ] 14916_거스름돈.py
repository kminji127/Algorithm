n = int(input())
count = 0

# https://devjeong.com/algorithm/algorithm-4/
# 2원씩 거스르다가 5로 나누어 떨어지면 5원을 거스른다
while (n > 0):
  if n % 5 == 0:
    count += n // 5
    break
  else:
    n -= 2
    count += 1

if n < 0:
  print(-1)
else:
  print(count)