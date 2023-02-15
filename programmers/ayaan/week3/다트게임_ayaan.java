package programmers.ayaan.week3;

public class 다트게임_ayaan {
    public static void main(String[] args) {
        String dart = "1D2S#10S";
        int result = solution(dart);
        System.out.println(result);
    }

    public static int solution(String dartResult){
        int answer = 0;

        int[] scores = new int[3];
        int turn = 0;
        String num = "";
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(ch == 'S' || ch == 'D' || ch == 'T'){
                int score = Integer.parseInt(num);
                switch (ch){
                    case 'D':
                        score *= score;
                        break;
                    case 'T':
                        score = score * score * score;
                }
                scores[turn++] = score;
                num = "";
            } else if (ch == '*' || ch == '#') {
                switch (ch){
                    case '*':
                        scores[turn-1] *= 2;
                        if(turn > 1) scores[turn-2] *= 2;
                        break;
                    case '#':
                        scores[turn-1] *= -1;
                        break;
                }
            } else {
                num += ch;
            }
        }
        answer = scores[0] + scores[1] + scores[2];
        return answer;
    }
}
