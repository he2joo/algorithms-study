def solution(today, terms, privacies):
    
    today2 = list(map(int,today.split('.')))
    terms2 = {}
    for i in terms:
        tmp = i.split(' ')
        terms2[tmp[0]] = int(tmp[1])

    answer = []

    for i in range(len(privacies)):
        tmp = privacies[i].split(' ')
        month = terms2[tmp[1]]
        enroll = list(map(int,tmp[0].split('.')))
        enroll[2] = 28 if enroll[2]==1 else enroll[2]-1
        enroll[1] += month
        if enroll[1] > 12:
            enroll[0] += enroll[1]//12
            enroll[1] = enroll[1]%12
            
        if enroll[0] > today2[0]:
            continue
        if enroll[1] > today2[1]:
            continue
        if enroll[2] >= today2[2]:
            continue
        answer.append(i)

    return answer.sort