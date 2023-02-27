n = int(input())
house = list(map(int, input().split()))

house.sort()
print(house[(n-1) // 2]) # 위치 인덱스의 중간값