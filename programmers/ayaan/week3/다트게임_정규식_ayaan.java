package programmers.ayaan.week3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트게임_정규식_ayaan {
    public static void main(String[] args) {
        String dart = "1D2S#10S";
        int result = solution(dart);
        System.out.println(result);
    }

    public static int solution(String dartResult){
        int answer = 0;

        Pattern pattern = Pattern.compile("([0-9]{1,2})([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);

        int[] scores = new int[3];
        int turn = 0;
        while(matcher.find()){
            // matcher.group(1) - 점수
            // matcher.group(2) - 보너스
            // matcher.group(3) - 옵션
            int score = Integer.parseInt(matcher.group(1));

            String bonus = matcher.group(2);
            if(bonus.equals("D")){
                score *= score;
            } else if(bonus.equals("T")){
                score = score * score * score;
            }
            scores[turn] = score;

            String option = matcher.group(3);
            if(option.equals("*")){
                scores[turn] *= 2;
                if(turn > 0) scores[turn-1] *= 2;
            } else if(option.equals("#")){
                scores[turn] *= -1;
            }
            turn++;
        }
        answer = scores[0] + scores[1] + scores[2];
        return answer;
    }
}
