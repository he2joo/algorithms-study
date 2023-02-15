# 점수 : 보너스 : [옵션]
# 1S : 2D* : 3T

# S -> 1, D -> 제곱 , T -> 세제곱

# * -> 점수 2배, # -> 해당점수만 -1 곱하기 (*이 적용된다)
import re

dartResult = "1D2S3T*"
# ans = 37

bonus_dict = {"S": 1, "D": 2, "T": 3}
scores = []
score_idx = 0
score_str = ""
for idx, ch in enumerate(dartResult):
    if ch.isdigit():
        score_str += ch

    elif ch in bonus_dict.keys():
        score = int(score_str)
        score_str = ""
        score = pow(score, bonus_dict[ch])
        if (idx + 1) < len(dartResult) and dartResult[idx + 1] in ["*", "#"]:
            if dartResult[idx + 1] == '*':
                score *= 2
                if score_idx > 0:
                    scores[score_idx-1] *= 2
            else:
                score = -score

        scores.append(score)
        score_idx += 1

