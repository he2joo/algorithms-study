def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        temp1 = arr1[i]
        temp2 = arr2[i]
        tempString = ''
        for k in range(n):
            if temp1 % 2 == 0 and temp2 % 2 == 0:
                tempString = ' ' + tempString 
                temp1 //= 2
                temp2 //= 2
            else: 
                tempString = '#' + tempString 
                temp1 //= 2
                temp2 //= 2
        answer.append(tempString)

    return(answer)                    
                    
    
