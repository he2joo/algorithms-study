def solution(today, terms, privacies):
    period = {}
    ans = []

    t_year, t_month, t_day = map(int, today.split("."))
    today_total = t_year * 12 * 28 + t_month * 28 + t_day

    for term in terms:
        period[term.split()[0]] = int(term.split()[1])

    for idx, privacy in enumerate(privacies):
        date, key = privacy.split()

        year, month, day = map(int, date.split("."))

        month += period[key]

        privacy_total = year * 12 * 28 + month * 28 + day - 1

        if privacy_total < today_total:
            ans.append(idx + 1)

    return ans