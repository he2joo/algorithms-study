def solution(survey, choices):

    mbti = {'R':0,'T':0,'C':0, 'F':0,'J':0,'M':0,'A':0,'N':0,}
    point = {1:3, 2:2, 3:1, 4:0, 5:1, 6:2, 7:3}

    for i in range(len(choices)):
        str = survey[i]
        if choices[i] < 4:
            mbti[str[0]] += point[choices[i]]
        else :
            mbti[str[1]] += point[choices[i]]

    answer = ''

    answer += 'R' if mbti['R'] >= mbti['T'] else 'T'
    answer += 'C' if mbti['C'] >= mbti['F'] else 'F'
    answer += 'J' if mbti['J'] >= mbti['M'] else 'M'
    answer += 'A' if mbti['A'] >= mbti['N'] else 'N'

    return answer