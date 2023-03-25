n = int(input())

def hanoi_tower(n, start, tmp, to):
  if n == 1:
    print(start, to) # move
  else:
    hanoi_tower(n-1, start, to, tmp)
    print(start, to) # move
    hanoi_tower(n-1, tmp, start, to)

print(2 ** n - 1) # T(n)
hanoi_tower(n, 1, 2, 3)