# 점수 : 보너스 : [옵션]
# 1S : 2D* : 3T

# S -> 1, D -> 제곱 , T -> 세제곱

# * -> 점수 2배, # -> 해당점수만 -1 곱하기 (*이 적용된다)

import re

def solution(dartResult):
    bonus_dict = {"S": 1, "D": 2, "T": 3}
    scores = []

    darts = re.findall('.*?[SDT][*#]?', dartResult)

    for idx, dart in enumerate(darts):
        score = int(re.search('[0-9]*', dart).group())
        bonus = re.search('[SDT]', dart).group()
        option = re.search('[*#]', dart)

        score = pow(score, bonus_dict[bonus])

        if option is not None:
            option = option.group()

            if option == '*':
                if idx > 0:
                    scores[idx-1] *= 2
                score *= 2
            else:
                score = -score

        scores.append(score)

    return sum(scores)
