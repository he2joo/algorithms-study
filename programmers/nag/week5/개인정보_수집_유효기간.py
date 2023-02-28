import datetime
from dateutil.relativedelta import relativedelta

def solution(today, terms, privacies):
    answer = []
    today = datetime.datetime.strptime(today, '%Y.%m.%d')
    termsModified = {}
    privaciesModified = []
    for string in terms:
        splitString = string.split()
        termsModified[splitString[0]] = int(splitString[1])
    for string in privacies:
        splitString = string.split()
        splitString[0] = datetime.datetime.strptime(splitString[0], '%Y.%m.%d')
        privaciesModified.append(splitString)
    print(termsModified)
    print(privaciesModified)
    
    for privacy in privaciesModified:
        comparableDate = privacy[0] + relativedelta(months = termsModified[privacies[1]])
        if today < comparableDate:
            answer.append(privacies.index(privacy) + 1)
            
    print(answer)
