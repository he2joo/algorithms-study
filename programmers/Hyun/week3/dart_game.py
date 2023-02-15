# 점수 : 보너스 : [옵션]
# 1S : 2D* : 3T

# S -> 1, D -> 제곱 , T -> 세제곱

# * -> 점수 2배, # -> 해당점수만 -1 곱하기 (*이 적용된다)
import re

dartResult = "1D2S#10S"
# ans = 37

bonus = {"S": 1, "D": 2, "T": 3}

total_score = 0

p = re.compile('.*?[SDT][*#]?')

while dartResult:
    fragment = p.match(dartResult).group()

    if fragment[-1] not in ['*', '#']:
        fragment = fragment[:-1]
    print(fragment)

    dartResult = dartResult.replace(fragment, "", 1)

    score = int(fragment[0])
    bonused_score = pow(score, bonus[fragment[1]])
    if len(fragment) == 3:
        if fragment[2] == "*":
            total_score *= 2
            bonused_score *= 2
        else:
            bonused_score = -bonused_score

    total_score += bonused_score

