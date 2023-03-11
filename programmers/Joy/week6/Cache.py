def solution(cacheSize, cities):
    # 캐시 사이즈 = 0
    if cacheSize == 0 :
        return len(cities)*5

    cache = []

    # cities 반복
    for i in cities:
        if i in cache: # 캐시에 있을 때
            time += 1
            cache.remove(i)
            cache.append(i)
        else :
            time += 5
            if len(cache) == cacheSize:
                del cache[0]
                cache.append(i)
            else :
                cache.append(i)
    return time

# print(solution(2,["Jeju","Jeju","Jeju","Jeju","Jeju"])) 답 : 9 (중복제거 없으면 13)