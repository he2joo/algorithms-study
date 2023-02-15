# N = 스테이지 개수
# stages = [사람수, (멈춰있는 스테이지)]
#  스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

# ===============================

# result = [스테이지 실패율을 내림차순]

def solution(N, stages):
    stage_arrived = [0] * (N + 1)
    fail_cnt = [0] * (N + 1)

    for stop_stage in stages:
        if stop_stage <= N:
            fail_cnt[stop_stage] += 1
        for i in range(min(stop_stage + 1, N + 1)):
            stage_arrived[i] += 1

    fail_rate = []

    for i in range(1, N + 1):
        if stage_arrived[i] != 0:
            fail_rate.append((i, fail_cnt[i] / stage_arrived[i]))
        else:
            fail_rate.append((i, 0))

    fail_rate.sort(key=lambda x: (-x[1], x[0]))

    ans = []
    for stage_idx, _ in fail_rate:
        ans.append(stage_idx)

    return ans