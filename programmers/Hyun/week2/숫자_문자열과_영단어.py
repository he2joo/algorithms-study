# "one4seveneight" -> 1478
# "23four5six7"     -> 234567
# "2three45sixseven"    -> 234567
# "123"                 -> 123

def solution(s):
    s2n = {"zero": "0", "one": "1", "two": "2", "three": "3", "four": "4", "five": "5", "six": "6", "seven": "7",
       "eight": "8", "nine": "9"}

    for str_num in s2n.keys():
        s = s.replace(str_num, s2n.get(str_num))

    return int(s)

