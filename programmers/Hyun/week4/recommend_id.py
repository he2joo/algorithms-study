import re

def solution(new_id):
    # 1 대문자 -> 소문자
    new_id = new_id.lower()

    # 2 소문자, 숫자, -, _, . 빼고 모두 제거
    new_id = re.sub('[^a-z0-9-_.]', '', new_id)

    # 3 .. -> .
    while new_id.find("..") != -1:
        new_id = new_id.replace("..", ".")

    # 4 시작, 끝 . 제거
    if new_id[0] == ".":
        new_id = new_id[1:]
    if new_id and new_id[-1] == ".":
        new_id = new_id[:-1]

    # 5 new_id 가 빈 문자열이면, "a" 대입
    if not new_id:
        new_id = "a"

    # 6 new_id 길이가 16자 이상이면 15개만 가져감
    new_id = new_id[:15]
    if new_id[-1] == ".":
        new_id = new_id[:-1]

    # 7 new_id 가 2자이하면, 마지막문자를 추가
    while len(new_id) < 3:
        new_id += new_id[-1]

    return new_id