#https://www.acmicpc.net/problem/1946
#그리디

import sys

test = int(sys.stdin.readline()) #총 테스트 케이스 횟수 입력
result = []
for i in range(test):
  case = int(sys.stdin.readline())
  data = []
  count = 0

  for j in range(case): #테스트 케이스 입력받기
    temp = list(map(int, sys.stdin.readline().split()))
    data.append(temp)
  data.sort(key = lambda x:x[0]) #첫번째 등수를 기준으로 오름차순 정렬

  temp = 1000001
  for j in data:
    if temp == 1:
      break
    if (j[1] < temp):
      temp = j[1]  #데이터가 정렬되어 있기에 두번째 등수만 비교하여 카운트
      count += 1
  result.append(count)

for i in result:
  print(i)