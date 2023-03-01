def solution(survey, choices):
    one = {"R": 0, "T": 0}
    two = {"C": 0, "F": 0}
    three = {"J": 0, "M": 0}
    four = {"A": 0, "N": 0}

    choices = [i - 4 for i in choices]

    survey_type = []

    for surv in survey:
        if surv[0] in one.keys():
            survey_type.append(one)
        elif surv[0] in two.keys():
            survey_type.append(two)
        elif surv[0] in three.keys():
            survey_type.append(three)
        elif surv[0] in four.keys():
            survey_type.append(four)


    for i in range(len(survey)):
        if choices[i] <= 0:
            survey_type[i][survey[i][0]] += choices[i] * -1
        else:
            survey_type[i][survey[i][1]] += choices[i]

    ans = ""
    if one["R"] >= one["T"]:
        ans += "R"
    else:
        ans += "T"

    if two["C"] >= two["F"]:
        ans += "C"
    else:
        ans += "F"

    if three["J"] >= three["M"]:
        ans += "J"
    else:
        ans += "M"

    if four["A"] >= four["N"]:
        ans += "A"
    else:
        ans += "N"

    return ans