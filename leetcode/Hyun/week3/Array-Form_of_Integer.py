# Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
# 배열 + k 더하기

# num = [정수 배열], k = offset

class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:

        join = ''.join(map(str, num))
        return list(map(int,str((int(join) + k))))