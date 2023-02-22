def solution(numbers, hand):
    left = {1: (0, 3), 4: (0, 2), 7: (0, 1)}
    right = {3: (2, 3), 6: (2, 2), 9: (2, 1)}
    middle = {2: (1, 3), 5: (1, 2), 8: (1, 1), 0: (1, 0)}

    left_pos = (0, 0)
    right_pos = (2, 0)

    ans = ""

    for number in numbers:
        if number in left.keys():
            ans += "L"
            left_pos = left[number]
        elif number in right.keys():
            ans += "R"
            right_pos = right[number]
        else:
            left_distance = abs(left_pos[0] - middle[number][0]) + abs(left_pos[1] - middle[number][1])
            right_distance = abs(right_pos[0] - middle[number][0]) + abs(right_pos[1] - middle[number][1])

            if left_distance > right_distance:
                ans += "R"
                right_pos = middle[number]
            elif left_distance < right_distance:
                ans += "L"
                left_pos = middle[number]
            else:
                if hand == "right":
                    ans += "R"
                    right_pos = middle[number]
                else:
                    ans += "L"
                    left_pos = middle[number]
    return ans
