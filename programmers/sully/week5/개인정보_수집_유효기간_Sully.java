package programmers.sully.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 개인정보_수집_유효기간_Sully {
    // today: 오늘
    // terms[]: 약관의 유효기간
    // privacies[]: 수집된 개인정보
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        // today 뽑아내기 (.으로 분리)
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);

        // terms 뽑아내기 (알파벳 분리)
        Map<String, Integer> termsMap = new HashMap<>();
        String[] termsType = new String[terms.length];
        int[] termsPeriod = new int[terms.length];
        for (int i = 0; i < terms.length; i++) {
            termsType[i] = terms[i].substring(0, 1);
            termsPeriod[i] = Integer.parseInt(terms[i].substring(1, terms.length));
            termsMap.put(termsType[i], termsPeriod[i]);
        }

        // privacy 뽑아내기 (1차: 알파벳 분리, 2차: .으로 분리)
        String[] privacyType = new String[terms.length];
        String[] privacyTmpDate = new String[terms.length];
        int[] privacyYear = new int[terms.length]; // 2000 ~ 2022 년
        int[] privacyMonth = new int[terms.length]; // 1 ~ 12 달
        int[] privacyDay = new int[terms.length]; // 1 ~ 28 일
        for (int i = 0; i < terms.length; i++) {
            privacyTmpDate[i] = terms[i].substring(0, terms.length - 1);
            privacyYear[i] = Integer.parseInt(privacyTmpDate[i].split("\\.")[0]);
            privacyMonth[i] = Integer.parseInt(privacyTmpDate[i].split("\\.")[1]);
            privacyDay[i] = Integer.parseInt(privacyTmpDate[i].split("\\.")[2]);

            privacyType[i] = terms[i].substring(terms.length - 1, terms.length);
        }
        privacyTmpDate = null; // 이제 넌 쓸 일 없음

        // 약관에 따라 Value 값을 뽑아내고 -> Day 수가 28일인 것까지 생각 -> 날짜 변경
        for (int i = 0; i < terms.length; i++) {
            // Type (Key) 겹치면 -> Value 더해줘야지
            if (termsMap.containsKey(privacyType[i])) {
                // 유효기간 몇 달인지
                int monthPeriod = termsMap.get(privacyType[i]);

                // 이제 모든 달이 28일인 것을 이용하여 계속 더해주면 되는데..
                // 반복문으로
                // 일: 28일까지, 월: 12월까지, 년: 2022년까지
                // 하나하나씩 증가해주는 방식으로 해볼까?
                int tmpPrivacyDay = privacyDay[i];
                int tmpPrivacyMonth = privacyMonth[i];
                int tmpPrivacyYear = privacyYear[i];
                while (monthPeriod != 0) {
                    tmpPrivacyDay--;
                    if (tmpPrivacyDay == 0) {
                        tmpPrivacyMonth++;
                    }

                    if (tmpPrivacyMonth == 12) {
                        tmpPrivacyYear++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                "2022.05.19",
                new String[]{"A6", "B12", "C3"},
                new String[]{"2021.05.02A", "2021.07.01B", "2022.02.19C", "2022.02.20C"}
        )));
    }
}
