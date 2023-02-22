numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
answer = ''
keypad = [('1','2','3'), ('4','5','6'), ('7','8','9'), ('*','0','#')]
leftHandPosition = '*'
rightHandPosition = '#'
leftCoord = []
rightCoord = []

for number in numbers:
  if number % 3 == 1:
    answer = answer + 'L'
    leftHandPosition = number
    leftCoord = findCoord(number)
  elif number % 3 == 0 and number != 0:
    answer = answer + 'R'
    rightHandPosition = number
    rightCoord = findCoord(number)
  else:
    numberCoord = findCoord(number)
    leftDistance = abs(numberCoord[0] - leftCoord[0]) + abs(numberCoord[1] - leftCoord[1])
    rightDistance = abs(numberCoord[0] - rightCoord[0]) + abs(numberCoord[1] - rightCoord[1])
    if leftDistance < rightDistance:
      answer = answer + 'L'
      leftHandPosition = number
      leftCoord = findCoord(number)
    elif leftDistance > rightDistance:
      answer = answer + 'R'
      rightHandPosition = number
      rightCoord = findCoord(number)
    else:
      if hand == 'right':
        
      
return answer




def findCoord(number):
  if number == 1:
    return [0,0]
  if number == 2:
    return [0,1]
  if number == 3:
    return [0,2]
  if number == 4:
    return [1,0]
  if number == 5:
    return [1,1]
  if number == 6:
    return [1,2]
  if number == 7:
    return [2,0]
  if number == 8:
    return [2,1]
  if number == 9:
    return [2,2]
  if number == 0:
    return [3,1]
  return
