package programmers.fia.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집_Fia {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todayDate = today.split("\\.");

        int y = Integer.parseInt(todayDate[0]) - 1999;
        int m = Integer.parseInt(todayDate[1]);
        int d = Integer.parseInt(todayDate[2]);

        int sumToday = (y * (12 * 28)) + (m * 28) + d;

        Map<String, Integer> privacyTerm = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            privacyTerm.put(t[0], Integer.parseInt(t[1]) * 28);
        }

        List<Integer> targets = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            String[] date = p[0].split("\\.");
            String yourPrivacy = p[1];

            int year = Integer.parseInt(date[0]) - 1999;
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            int sumDate = (year * (12 * 28)) + (month * 28) + day;

            if (sumToday - sumDate >= privacyTerm.get(yourPrivacy)) {
                targets.add(i + 1);
            }
        }

        int[] answer = new int[targets.size()];
        for (int i = 0; i < targets.size(); i++) {
            answer[i] = targets.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] p = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        개인정보수집_Fia fia = new 개인정보수집_Fia();
        fia.solution(today, terms, p);
    }
}
