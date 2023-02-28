def solution(survey, choices):
    answer = ''
    points = {'RT': 0, 'CF':0, 'JM':0, 'AN':0}
    
    #먼저 survey 와 choice를 정렬
    for i in range(len(survey)):
        if survey[i][0] > survey[i][1]:
            survey[i] = survey[i][::-1]
            choices[i] = 8 - choices[i]
            
    #survey와 choice 점수에 따라 points에 값 추가
    for i in range(len(survey)):
        if survey[i] == 'RT':
            points['RT'] = points['RT'] + choices[i] - 4
        if survey[i] == 'CF':
            points['CF'] = points['CF'] + choices[i] - 4
        if survey[i] == 'JM':
            points['JM'] = points['JM'] + choices[i] - 4
        if survey[i] == 'AN':
            points['AN'] = points['AN'] + choices[i] - 4        
    
    #points의 값에 따라 검사결과 도출
    for key in points:
        if points[key] <= 0:
            answer = answer + key[0] 
        else:
            answer = answer + key[1]

    return answer
  #Thank you Hyun.
