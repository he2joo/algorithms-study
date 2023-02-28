package programmers.sully.week5;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기_Sully {
    public static String solution(String[] survey, int[] choices) { // 동일한 길이
        String answer = "";
        Map<String, Integer> typeScoreMap = new HashMap<>();

        // 맵으로 표 정리
        for (int i = 0; i < survey.length; i++) {
            String first = survey[i].split("")[0]; // i+1번 질문의 "비동의" 관련 선택지
            String second = survey[i].split("")[1]; // i+1 질문의 "동의" 관련 선택지

            String type = "";
            int score = 0;

            if (choices[i] == 1) {
                // 매우 비동의
                type = first;
                score = 3;
            } else if (choices[i] == 2) {
                // 비동의
                type = first;
                score = 2;
            } else if (choices[i] == 3) {
                // 약간 비동의
                type = first;
                score = 1;
            } else if (choices[i] == 5) {
                // 약간 동의
                type = second;
                score = 1;
            } else if (choices[i] == 6) {
                // 동의
                type = second;
                score = 2;
            } else if (choices[i] == 7) {
                // 매우 동의
                type = second;
                score = 3;
            }

            typeScoreMap.put(type, score);
        }

        // 1~4 지표 비교하여 점수 누가 더 높은지 판별
        // 유형별로 카운트하고 -> if 문으로 각각 4번 비교

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
