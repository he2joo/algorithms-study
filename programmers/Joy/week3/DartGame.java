package programmers.Joy.week3;

public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        String tmp = ""; // 점수가 10일 수도 있어서 임시저장.
        int idx = 0;
        int[] score = {0,0,0}; // 점수저장
        int answer = 0; // 최종연산

        for (int i=0;i<dartResult.length();i++){
            char ch = dartResult.charAt(i);
            switch (ch){
                // S, D, T가 나오면 tmp를 숫자변환 후 배열에 저장.
                // 인덱스 1 증가.
                case 'S' : score[idx] = Integer.parseInt(tmp);
                           tmp = "";
                           idx++;
                           break;
                case 'D' : score[idx] = Integer.parseInt(tmp);
                            score[idx] = (int)Math.pow(score[idx],2);
                            tmp = "";
                            idx++;
                            break;
                case 'T' : score[idx] = Integer.parseInt(tmp);
                            score[idx] = (int)Math.pow(score[idx],3);
                            tmp = "";
                            idx++;
                            break;
                // *, #이 나오면 (인덱스 -1)에 *2 나 *(-1)
                case '*' : if (idx>1){
                                score[idx-2] *= 2;
                            }
                            score[idx-1] *= 2;
                            break;
                case '#' : score[idx-1] *= (-1);
                            break;
                // 숫자 0~9가 나왔을 때.
                default : tmp += ch;
            }
        }
        for (int i : score){
            answer += i;
        }
        System.out.println(answer);
    }
}
