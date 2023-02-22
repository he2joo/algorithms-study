def solution(numbers, hand):  
    answer = ''
    keypad = {1:(1,1), 2:(1,2), 3:(1,3), 4:(2,1), 5:(2,2), 6:(2,3), 7:(3,1), 8:(3,2), 9:(3,3), 0:(4,2)}
    leftHandPosition = (4,1)
    rightHandPosition = (4,3)

    for number in numbers:
        if number % 3 == 1:
            answer = answer + 'L'
            leftHandPosition = keypad[number]
        elif number % 3 == 0 and number != 0:
            answer = answer + 'R'
            rightHandPosition = keypad[number]
        else:
            numberPosition = keypad[number]
            leftDistance = abs(numberPosition[0] - leftHandPosition[0]) + abs(numberPosition[1] - leftHandPosition[1])
            rightDistance = abs(numberPosition[0] - rightHandPosition[0]) + abs(numberPosition[1] - rightHandPosition[1])
            if leftDistance < rightDistance:
                answer = answer + 'L'
                leftHandPosition = keypad[number]
            elif leftDistance > rightDistance:
                answer = answer + 'R'
                rightHandPosition = keypad[number]
            elif hand == 'right':
                answer = answer + 'R'
                rightHandPosition = keypad[number]
            else:
                answer = answer + 'L'
                leftHandPosition = keypad[number]
    return answer
