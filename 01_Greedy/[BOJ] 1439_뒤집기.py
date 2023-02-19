s = input()

group0 = 0
group1 = 0

if s[0] == '0':
  group0 += 1
else:
  group1 += 1

for i in range(1, len(s)):
  # 숫자가 바뀌는 순간 집단의 개수로 하나 체크
  if s[i-1] != s[i]:
    if s[i] == '0':
      group0 += 1
    else:
      group1 += 1
      

# 연속된 0의 집단과 연속된 1의 집단 중 더 작은 집단의 개수
print(min(group0, group1))