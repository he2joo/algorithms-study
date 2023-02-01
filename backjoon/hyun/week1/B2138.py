# https://www.acmicpc.net/problem/2138
# 그리디

n = int(input())
given_bulb = list(map(int, input()))
target_bulb = list(map(int, input()))

NOT_MATCHED = 1000000


def change(given, target):
    copied = given[:]
    press_count = 0

    for i in range(1, n):
        if copied[i - 1] != target[i - 1]:  # 이전 전구가 서로 다른 상태인 경우 버튼을 누른다.
            press_count += 1
            for j in range(i - 1, i + 2):
                if j < n:
                    copied[j] = 1 - copied[j]  # 전구 상태값 뒤집기

    if copied != target:  # 답을 구할 수 없는 경우
        return NOT_MATCHED
    return press_count


not_press_first_button = change(given_bulb, target_bulb)  # 첫 번째 버튼을 누르지 않은 경우

given_bulb[0] = 1 - given_bulb[0]  # 첫 번째 버튼을 누른 경우
given_bulb[1] = 1 - given_bulb[1]
press_first_button = change(given_bulb, target_bulb) + 1

ans = min(not_press_first_button, press_first_button)

if ans == NOT_MATCHED:
    print(-1)
else:
    print(ans)
