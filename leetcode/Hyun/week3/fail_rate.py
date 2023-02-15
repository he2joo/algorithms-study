# N = 스테이지 개수
# stages = [사람수, (멈춰있는 스테이지)]
#  스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

# ===============================

# result = [스테이지 실패율을 내림차순]

def solution(N, stages):
    fail_cnt = {}
    for i in range(1, N + 1):
        fail_cnt[i] = stages.count(i)

    denominator = len(stages)

    fail_rates = []
    for stage_idx in range(1, N + 1):
        if denominator > 0:
            current_fail_rate = fail_cnt[stage_idx] / denominator
            fail_rates.append((stage_idx, current_fail_rate))
            denominator -= fail_cnt[stage_idx]
        else:
            fail_rates.append((stage_idx, 0))

    fail_rates.sort(key=lambda x: (-x[1], x[0]))
    return [stage_idx for stage_idx, _ in fail_rates]