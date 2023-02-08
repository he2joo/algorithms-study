# 지도1 지도2 동기화
# 둘중에 하나라도 벽이면 벽
# 둘다 공백이면 공백

# n -> 지도 한변 크기
# arr -> 이진수 배열 (벽 정보)
# 입력은 이진수배열로 들어온다.

#
# def solution(n, arr1, arr2):
#     answer = []
#     return answer


def dec2bin(number, n):
    bin = []
    for i in range(n):
        bin.append(number % 2)
        number //= 2
    bin.reverse()
    return bin


def solution(n, arr1, arr2):

    finished_map = []

    for i in range(n):
        map1_row = dec2bin(arr1[i], n)
        map2_row = dec2bin(arr2[i], n)
        finished_map_row = []

        for j in range(n):
            if map1_row[j] == 1 or map2_row[j] == 1:
                finished_map_row.append(1)
            else:
                finished_map_row.append(0)
        finished_map.append(finished_map_row)

    ans = []

    for y in range(n):
        ans_row = ""
        for x in range(n):
            if finished_map[y][x] == 1:
                ans_row += "#"
            else:
                ans_row += " "
        ans.append(ans_row)

    return ans
