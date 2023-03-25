a, b = map(int, input().split())

# 최대공약수
# gcd(x, y) = gcd(y, x mod y) => y가 0이 되는 x가 최대공약수
def gcd(x, y):
  while y != 0:
    tmp = x % y
    x = y
    y = tmp
  return x

# 최소공배수
def lcm(x, y):
  return x * y // gcd(x, y)

print(gcd(a, b))
print(lcm(a, b))